package com.demo.operation.dto;

import com.common.base.BaseDTO;
import lombok.Data;

@Data
public class RoleDTO extends BaseDTO {

    private Integer id;

    //角色名称
    private String roleName;
}
