package com.heimao.wuye.mapper;



import java.util.List;

import com.heimao.wuye.entity.Role;
import com.heimao.wuye.util.MyMapper;

public interface RoleMapper extends MyMapper<Role> {
    public List<Role> queryRoleListWithSelected(Integer id);
}