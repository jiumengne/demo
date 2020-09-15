package com.demo.operation.controller;

import com.common.base.ResponseDTO;
import com.demo.operation.dto.RoleDTO;
import com.demo.operation.service.RoleService;
import com.demo.operation.vo.RoleVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(value = "角色操作")
@RestController
@RequestMapping("/role")
@Slf4j
public class RoleController {
    @Resource
    private RoleService roleService;

    @PostMapping("/addRole")
    @ApiOperation("新增用户")
    private ResponseDTO addRole(RoleDTO role){
        ResponseDTO responseDTO= roleService.addRole(role);
        return responseDTO;
    }

    @PostMapping("/updateRole")
    @ApiOperation("修改用户")
    private ResponseDTO updateRole(RoleDTO role){
        ResponseDTO responseDTO= roleService.updateRole(role);
        return responseDTO;
    }

    @PostMapping("/pageRole")
    @ApiOperation("分页查询用户")
    private ResponseDTO selectRolePage(RoleVo entity){
        ResponseDTO responseDTO= roleService.selectRolePage(entity);
        return responseDTO;
    }

    @GetMapping("/selectRoleById")
    @ApiOperation("根据ID查询用户")
    private ResponseDTO selectRoleById(String id){
        ResponseDTO responseDTO= roleService.selectRoleById(id);
        return responseDTO;
    }

    @GetMapping("/deleteRole")
    @ApiOperation("删除用户")
    private ResponseDTO deleteRole(String id){
        ResponseDTO responseDTO= roleService.deleteRole(id);
        return responseDTO;
    }
}
