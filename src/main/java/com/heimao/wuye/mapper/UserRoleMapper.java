package com.heimao.wuye.mapper;



import java.util.List;

import com.heimao.wuye.entity.UserRole;
import com.heimao.wuye.util.MyMapper;

public interface UserRoleMapper extends MyMapper<UserRole> {
    public List<Integer> findUserIdByRoleId(Integer roleId);
}