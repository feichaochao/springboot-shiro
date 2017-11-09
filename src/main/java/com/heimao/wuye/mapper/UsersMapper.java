package com.heimao.wuye.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.heimao.wuye.entity.Users;



/**
 * 
 * @author wuyeheimao
 * @time   2017年9月27日 下午1:08:54
 */
public interface UsersMapper {
	
	List<Users> getAll();
	
	Users find(Long id);

	void insert(Users user);

	void update(Users user);

	void delete(Long id);

	Users isExist(@Param("name")String name, @Param("password")String password);

}