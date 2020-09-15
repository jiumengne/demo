package com.demo.operation.service.impl;

import com.common.base.ResponseDTO;
import com.demo.operation.dto.UserDTO;
import com.demo.operation.dto.UserRoleDTO;
import com.demo.operation.mapper.UserRoleMapper;
import com.demo.operation.vo.UserRoleVo;
import com.demo.operation.vo.UserVo;
import com.demo.operation.mapper.UserMapper;
import com.demo.operation.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public ResponseDTO addUser(UserDTO user) {
        //参数检查
        //使用正则表达式检查
        List<String> errorLst = new ArrayList<>();
        validatedUser(user,errorLst);
        //业务检查
        //手机号不可以重复
        UserDTO userDTO = userMapper.findByUserMobile(user.getUserMobile());
        if (userDTO != null) {
            errorLst.add("该手机号已注册！");
        }

        if (errorLst.size() > 0) {
            return new ResponseDTO().error(String.join(";", errorLst));
        }

        userMapper.addUser(user);
        return new ResponseDTO().ok();
    }

    @Override
    public ResponseDTO updateUser(UserDTO user) {
        List<String> errorLst = new ArrayList<>();
        validatedUser(user,errorLst);

        //业务检查
        //手机号不可以重复
        UserDTO userDTO = userMapper.findByUserMobile(user.getUserMobile());
        if (userDTO != null) {
            if(userDTO.getId()!= user.getId()){
                errorLst.add("该手机号已注册！");
            }
        }

        if (errorLst.size() > 0) {
            return new ResponseDTO().error(String.join(";", errorLst));
        }

        userMapper.updateUser(user);
        return new ResponseDTO().ok();
    }

    @Override
    public ResponseDTO selectUserPage(UserVo vo) {
        PageHelper.startPage(vo.getPage(),vo.getLimit());
        List<UserDTO> list=userMapper.selectUserPage(vo);
        PageInfo pageInfo = new PageInfo(list);
        return  new ResponseDTO().ok(pageInfo);
    }

    @Override
    public ResponseDTO selectUserById(String id) {
        UserDTO dto = userMapper.findById(id);
        if (dto == null){
            return  new ResponseDTO().fail("数据过期，请刷新重试！");
        }
        return  new ResponseDTO().ok(dto);
    }

    @Override
    public ResponseDTO deleteUser(String id) {
        userMapper.deleteById(id);
        return new ResponseDTO().ok();
    }

    @Override
    public ResponseDTO bindUserRole(UserRoleVo vo) {
        //检查现有关系是否存在
        UserRoleDTO mapper = userRoleMapper.findByUserRole(vo);
        if(mapper != null){
            return  new ResponseDTO().fail("该关系已绑定！");
        }
        userRoleMapper.bindUserRole(vo);
        return  new ResponseDTO().ok();
    }

    @Override
    public ResponseDTO unbindUserRole(Integer id) {
        userRoleMapper.unbindUserRole(id);
        return new ResponseDTO().ok();
    }

    /**
     *
     * @Description 参数校验
     * @param user
     * @param errorLst
     */
    public void validatedUser(UserDTO user,List<String> errorLst){
        String phoneRegex = "^(((13[0-9])|(14[579])|(15([0-3]|[5-9]))|(16[6])|(17[0135678])|(18[0-9])|(19[89]))\\d{8})$";
        if (!StringUtils.isEmpty(user.getUserMobile())) {
            if (!Pattern.matches(phoneRegex, user.getUserMobile())) {
                errorLst.add("用户手机号格式错误！");
            }
        }

        String emailRegex = "\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}";
        if (!StringUtils.isEmpty(user.getUserEmail())) {
            if (!Pattern.matches(emailRegex, user.getUserEmail())) {
                errorLst.add("用户邮箱格式错误！");
            }
        }
    }
}
