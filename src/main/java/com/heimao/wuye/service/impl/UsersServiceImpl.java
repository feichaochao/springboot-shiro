package com.heimao.wuye.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.heimao.wuye.entity.Users;
import com.heimao.wuye.mapper.UsersMapper;
import com.heimao.wuye.service.UsersService;

/**
 * 
 * @author wuyeheimao
 * @time   2017年9月27日 下午1:09:39
 */
@Service
public class UsersServiceImpl implements UsersService{

	private static final Logger logger = LoggerFactory.getLogger(UsersServiceImpl.class);
	@Autowired
	private UsersMapper userMapper;
	
	@Override
	public List<Users> getAll() {
		
		return userMapper.getAll();
	}

	@Override
	public Users find(Long id) {
		return userMapper.find(id);
	}

	@Override
	public void insert(Users user) {
		userMapper.insert(user);
		
	}

	@Override
	public void update(Users user) {
		userMapper.update(user);
		
	}

	@Override
	public void delete(Long id) {
		userMapper.delete(id);
		
	}

	@Override
	public Users isExist(String name, String password) {
		
		return userMapper.isExist(name,password);
	}

}
