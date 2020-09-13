package com.demo.operation.dto;

import com.common.base.BaseDTO;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserDTO extends BaseDTO {
    //数据主键
    private Integer id;

    //用户姓名
    private String userName;

    //用户年龄
    private Integer userAge;

    //手机号
    //使用者注解检查
     private String userMobile;

    //邮箱
    private String userEmail;
}
