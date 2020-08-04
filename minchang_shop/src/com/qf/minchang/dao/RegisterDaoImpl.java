package com.qf.minchang.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qf.minchang.entity.User;
import com.qf.minchang.utils.JDBCUtils;

public class RegisterDaoImpl extends JDBCUtils implements RegisterDao {

	@Override
	public List<User> findUser(String username) {
		// TODO Auto-generated method stub
		List<User> list=new ArrayList<>();
		super.getConnection();
		try {
			String sql="Select * from tb_user";
			super.stmt=super.conn.prepareStatement(sql);
		//	System.out.println("´«Öµ2:"+username);
		//	stmt.setString(1, username);
			rs=stmt.executeQuery();
			while(rs.next()) {
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setGender(rs.getString("gender"));
				user.setFlag(rs.getInt("flag"));
				user.setRole(rs.getInt("role"));
				user.setCode(rs.getString("code"));
				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		
		return null;
	}

	@Override
	public int add(String username, String password, String email, String gender) {
		// TODO Auto-generated method stub
		super.getConnection();

		try {
			String sql="insert into tb_user (username,password,email,gender,flag,role,code)values(?,?,?,?,?,?,?)";
			super.stmt=super.conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setString(3, email);
			stmt.setString(4, gender);
			stmt.setInt(5, 1);
			stmt.setInt(6, 1);
			stmt.setString(7, "");
			int a=stmt.executeUpdate();
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

}
