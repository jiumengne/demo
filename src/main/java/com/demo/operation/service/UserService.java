package com.demo.operation.service;

import com.common.base.ResponseDTO;
import com.demo.operation.dto.UserDTO;
import com.demo.operation.vo.UserRoleVo;
import com.demo.operation.vo.UserVo;

public interface UserService {

    ResponseDTO addUser(UserDTO user);

    ResponseDTO updateUser(UserDTO user);

    ResponseDTO selectUserPage(UserVo vo);

    ResponseDTO selectUserById(String id);

    ResponseDTO deleteUser(String id);

    ResponseDTO bindUserRole(UserRoleVo vo);

    ResponseDTO unbindUserRole(Integer id);
}
