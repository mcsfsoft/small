package com.qf.minchang.dao;

import java.sql.SQLException;
import java.util.List;

import com.qf.minchang.entity.User;

public interface LoginDao {
	public User findUserNameById(String username);//获取用户名
	public Boolean password(String username,String password);//获取用户名对应的密码
}
