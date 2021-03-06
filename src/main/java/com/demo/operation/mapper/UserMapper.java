package com.demo.operation.mapper;

import com.demo.operation.dto.UserDTO;
import com.demo.operation.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    int addUser(UserDTO user);

    int updateUser(UserDTO user);

    UserDTO findById(@Param("id") String id);

    UserDTO findByUserMobile(String userMobile);

    List<UserDTO> selectUserPage(UserVo entity);

    int deleteById(String id);
}
