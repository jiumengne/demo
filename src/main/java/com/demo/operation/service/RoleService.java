package com.demo.operation.service;

import com.common.base.ResponseDTO;
import com.demo.operation.dto.RoleDTO;
import com.demo.operation.vo.RoleVo;

public interface RoleService {

    ResponseDTO addRole(RoleDTO user);

    ResponseDTO updateRole(RoleDTO user);

    ResponseDTO selectRolePage(RoleVo vo);

    ResponseDTO selectRoleById(String id);

    ResponseDTO deleteRole(String id);
}
