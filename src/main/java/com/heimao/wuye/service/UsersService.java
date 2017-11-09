package com.heimao.wuye.service;

import java.util.List;

import com.heimao.wuye.entity.Users;

/**
 * 
 * @author wuyeheimao
 * @time   2017年9月27日 下午1:09:32
 */
public interface UsersService {

    List<Users> getAll();
	
	Users find(Long id);

	void insert(Users user);

	void update(Users user);

	void delete(Long id);
	
	Users isExist(String name, String password);
}
