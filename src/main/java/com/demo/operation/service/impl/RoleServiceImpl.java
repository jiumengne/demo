package com.demo.operation.service.impl;

import com.common.base.ResponseDTO;
import com.demo.operation.dto.RoleDTO;
import com.demo.operation.mapper.RoleMapper;
import com.demo.operation.service.RoleService;
import com.demo.operation.vo.RoleVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;
    
    @Override
    public ResponseDTO addRole(RoleDTO role) {
        RoleDTO dto = roleMapper.findByRoleName(role.getRoleName());
        if(dto != null){
            return new ResponseDTO().error("角色名称重复！");
        }

        roleMapper.addRole(role);
        return new ResponseDTO().ok();
    }

    @Override
    public ResponseDTO updateRole(RoleDTO role) {
        RoleDTO dto = roleMapper.findByRoleName(role.getRoleName());
        if(dto != null){
            if(!dto.getId().equals(role.getId())){
                return new ResponseDTO().error("角色名称重复！");
            }
        }

        roleMapper.updateRole(role);
        return new ResponseDTO().ok();
    }

    @Override
    public ResponseDTO selectRolePage(RoleVo vo) {
        PageHelper.startPage(vo.getPage(),vo.getLimit());
        List<RoleDTO> list=roleMapper.selectRolePage(vo);
        PageInfo pageInfo = new PageInfo(list);
        return  new ResponseDTO().ok(pageInfo);
    }

    @Override
    public ResponseDTO selectRoleById(String id) {
        RoleDTO dto = roleMapper.findById(id);
        if (dto == null){
            return  new ResponseDTO().fail("数据过期，请刷新重试！");
        }
        return  new ResponseDTO().ok(dto);
    }

    @Override
    public ResponseDTO deleteRole(String id) {
        roleMapper.deleteById(id);
        return  new ResponseDTO().ok();
    }
}
