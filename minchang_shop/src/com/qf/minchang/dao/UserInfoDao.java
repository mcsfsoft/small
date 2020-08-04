package com.qf.minchang.dao;

import java.util.List;

import com.qf.minchang.entity.User;

public interface UserInfoDao {
	public List<User> findAll(String username,String gender);//会员管理
	public List<User> findInvalidUser();//无效会员
	public int deleteById(int id);
}
