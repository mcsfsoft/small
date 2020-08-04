package com.qf.minchang.dao;

import java.util.List;

import com.qf.minchang.entity.User;

public interface RegisterDao {

	public List<User> findUser(String username);
	public int add(String username,String password,String email,String gender);

}
