package com.demo.operation.controller;

import com.common.base.ResponseDTO;
import com.demo.operation.dto.UserDTO;
import com.demo.operation.entity.UserEntity;
import com.demo.operation.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(value = "用户操作")
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/addUser")
    @ApiOperation("新增用户")
    private ResponseDTO addUser(UserDTO user){
        ResponseDTO responseDTO= userService.addUser(user);
        return responseDTO;
    }

    @PostMapping("/updateUser")
    @ApiOperation("修改用户")
    private ResponseDTO updateUser(UserDTO user){
        ResponseDTO responseDTO= userService.updateUser(user);
        return responseDTO;
    }

    @PostMapping("/pageUser")
    @ApiOperation("分页查询用户")
    private ResponseDTO selectUserPage(UserEntity entity){
        ResponseDTO responseDTO= userService.selectUserPage(entity);
        return responseDTO;
    }

    @GetMapping("/selectUserById")
    @ApiOperation("根据ID查询用户")
    private ResponseDTO selectUserById(String id){
        ResponseDTO responseDTO= userService.selectUserById(id);
        return responseDTO;
    }

    @GetMapping("/deleteUser")
    @ApiOperation("删除用户")
    private ResponseDTO deleteUser(String id){
        ResponseDTO responseDTO= userService.deleteUser(id);
        return responseDTO;
    }
}
