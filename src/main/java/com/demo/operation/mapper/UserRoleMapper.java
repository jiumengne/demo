package com.demo.operation.mapper;

import com.demo.operation.dto.UserDTO;
import com.demo.operation.dto.UserRoleDTO;
import com.demo.operation.vo.UserRoleVo;
import com.demo.operation.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRoleMapper {

    int bindUserRole(UserRoleVo vo);

    int unbindUserRole(Integer id);

    UserRoleDTO findByUserRole(UserRoleVo vo);
}
