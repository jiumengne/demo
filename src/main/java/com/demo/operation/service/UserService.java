package com.demo.operation.service;

import com.common.base.ResponseDTO;
import com.demo.operation.dto.UserDTO;
import com.demo.operation.entity.UserEntity;

public interface UserService {

    ResponseDTO addUser(UserDTO user);

    ResponseDTO updateUser(UserDTO user);

    ResponseDTO selectUserPage(UserEntity entity);

    ResponseDTO selectUserById(String id);

    ResponseDTO deleteUser(String id);
}
