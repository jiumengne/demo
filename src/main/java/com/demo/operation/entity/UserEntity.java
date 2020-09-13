package com.demo.operation.entity;

import com.common.base.RequestDTO;
import lombok.Data;

@Data
public class UserEntity extends RequestDTO {
    //用户姓名
    private String userName;

    //用户年龄
    private Integer userAge;

    //手机号
   private String userMobile;

    //邮箱
    private String userEmail;
}