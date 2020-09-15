package com.demo.operation.mapper;

import com.demo.operation.dto.RoleDTO;
import com.demo.operation.dto.RoleDTO;
import com.demo.operation.vo.RoleVo;
import com.demo.operation.vo.RoleVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {

    int addRole(RoleDTO Role);

    int updateRole(RoleDTO Role);

    RoleDTO findById(@Param("id") String id);

    RoleDTO findByRoleName(String roleName);

    List<RoleDTO> selectRolePage(RoleVo vo);

    int deleteById(String id);
}
