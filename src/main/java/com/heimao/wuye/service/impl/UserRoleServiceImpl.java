package com.heimao.wuye.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.heimao.wuye.entity.UserRole;
import com.heimao.wuye.service.UserRoleService;

import tk.mybatis.mapper.entity.Example;

/**
 * 
 */
@Service
public class UserRoleServiceImpl extends BaseService<UserRole> implements UserRoleService {


    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public void addUserRole(UserRole userRole) {
        //删除
        Example example = new Example(UserRole.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userid",userRole.getUserid());
        mapper.deleteByExample(example);
        //添加
        String[] roleids = userRole.getRoleid().split(",");
        for (String roleId : roleids) {
            UserRole u = new UserRole();
            u.setUserid(userRole.getUserid());
            u.setRoleid(roleId);
            mapper.insert(u);
        }

    }
}
