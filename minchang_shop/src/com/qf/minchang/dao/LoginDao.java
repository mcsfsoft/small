package com.qf.minchang.dao;

import java.sql.SQLException;
import java.util.List;

import com.qf.minchang.entity.User;

public interface LoginDao {
	public User findUserNameById(String username);//��ȡ�û���
	public Boolean password(String username,String password);//��ȡ�û�����Ӧ������
}
