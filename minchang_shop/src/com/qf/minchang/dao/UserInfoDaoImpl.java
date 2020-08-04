package com.qf.minchang.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qf.minchang.entity.User;
import com.qf.minchang.utils.JDBCUtils;

public class UserInfoDaoImpl extends JDBCUtils implements UserInfoDao {

	@Override
	public List<User> findAll(String username,String gender) {
		// TODO Auto-generated method stub
			super.getConnection();
			List<User> list=new ArrayList<>();
			try {
				//where username like \"%\"?\"%\" and gender=\"%\"?\"%\""
				String sql="SELECT * FROM tb_user where username like \"%\"?\"%\" and gender like \"%\"?\"%\"";
				super.stmt=super.conn.prepareStatement(sql);
				if(username!=null) {
//				where username like \"%\"?\"%\" and gender=\"%\"?\"%\"
					stmt.setString(1, username);
				}else {
					stmt.setString(1, null);
				}
				if(gender!=null) {
					stmt.setString(2, gender);
				}else {
					stmt.setString(2, null);
				}
				System.out.println(sql);
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
				for(User lists:list) {
					System.out.println(lists);
				}
				return list;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return null;
	}

	@Override
	public List<User> findInvalidUser() {//无效
		// TODO Auto-generated method stub
		super.getConnection();
		List<User> list=new ArrayList<>();
		try {
			String sql="SELECT * FROM tb_user where flag=?";
			super.stmt=super.conn.prepareStatement(sql);
			stmt.setInt(1, 2);
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
			System.out.println("无效会员:");
			for(User users:list) {
				System.out.println("user:"+users);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		super.getConnection();
		try {
			String sql="Delete from tb_user where id=?";
			super.stmt=super.conn.prepareStatement(sql);
			stmt.setInt(1, id);
			System.out.println("sql:"+id);
			int a=stmt.executeUpdate();
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}
	
}
