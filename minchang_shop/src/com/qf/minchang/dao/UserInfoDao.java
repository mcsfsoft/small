package com.qf.minchang.dao;

import java.util.List;

import com.qf.minchang.entity.User;

public interface UserInfoDao {
	public List<User> findAll(String username,String gender);//��Ա����
	public List<User> findInvalidUser();//��Ч��Ա
	public int deleteById(int id);
}
