package com.qf.minchang.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qf.minchang.entity.Address;
import com.qf.minchang.utils.JDBCUtils;

public class AddressDaoImpl extends JDBCUtils implements AddressDao {
	/**
	 * @author MinChang
	 * µÿ÷∑≤È—Ø
	 * 
	 * */
	@Override
	public List<Address> findAddressByUid(int id) {
		// TODO Auto-generated method stub
		List<Address> list=new ArrayList<>();
		super.getConnection();
		
		try {
			String sql="Select * from tb_address where id=?";
			super.stmt=super.conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs=stmt.executeQuery();
			while(rs.next()) {
				Address as=new Address();
				as.setId(rs.getInt("id"));
				as.setDetail(rs.getString("detail"));
				as.setLevel(rs.getInt("level"));
				as.setName(rs.getString("name"));
				as.setUid(rs.getInt("uid"));
				as.setPhone(rs.getString("phone"));
				list.add(as);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int UserfindIdByName(String username) {
		// TODO Auto-generated method stub
		super.getConnection();
		
		try {
			String sql="Select id from tb_user where username=";
			super.stmt=super.conn.prepareStatement(sql);
			stmt.setString(1, username);
			rs=stmt.executeQuery();
			while(rs.next()) {
				int a=rs.getInt("id");
				return a;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateAddressInfo(String name, String phone, String detail,int uid) {
		// TODO Auto-generated method stub
		super.getConnection();

		try {
			String sql="INSERT INTO  tb_address (name,phone,detail,uid)values(?,?,?,?)";
			super.stmt=super.conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, phone);
			stmt.setString(3, detail);
			stmt.setInt(4, uid);
			int a=stmt.executeUpdate();
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		
		
		return 0;
	}

}
