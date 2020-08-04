package com.qf.minchang.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qf.minchang.entity.User;
import com.qf.minchang.utils.JDBCUtils;

public class LoginDaoImpl extends JDBCUtils implements LoginDao{
		
	public User findUserNameById(String username) {
		// TODO Auto-generated method stub
		super.getConnection();
		try {
			String sql="SELECT * FROM tb_user where username=?";
			super.stmt=super.conn.prepareStatement(sql);
			stmt.setString(1, username.toString());
			rs=stmt.executeQuery();
			while(rs.next()) {
				User user=new User();
				user.setUsername(rs.getString("username"));
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setGender(rs.getString("gender"));
				user.setCode(rs.getString("code"));
				user.setFlag(rs.getInt("flag"));
				user.setPassword(rs.getString("password"));
				if("admin".equals(rs.getString("username"))) {
					
					user.setRole(0);
				}
				else {
					user.setUsername(rs.getString("username"));
					user.setRole(1);
				}
				return user;
			}

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return null;
	}
	

	public Boolean password(String username,String password) {
		// TODO Auto-generated method stub
		User user=new User();
		Boolean flag=true;
		super.getConnection();
		String sql="Select password from tb_user where username=?";
		try {
			super.stmt=super.conn.prepareStatement(sql);
			stmt.setString(1, username);
			rs=stmt.executeQuery();
			while(rs.next()) {
				 if(password.equals(rs.getString(1))) {
					 flag= true;
				 }else {
					 flag=false;
				 }
			}
			return flag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return flag;
	}
	
	

}
