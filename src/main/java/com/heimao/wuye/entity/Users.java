package com.heimao.wuye.entity;

import java.io.Serializable;

public class Users implements Serializable {

  

    private Long id;
    private String name;
    private String password;
    private String description;
    
    
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Users(Long id, String name, String password, String description) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.description = description;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


  
}
