package com.qf.minchang.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qf.minchang.entity.Goods;
import com.qf.minchang.utils.JDBCUtils;

public class GoodsDaoImpl extends JDBCUtils implements GoodsDao {

	@Override
	public List<Goods> findThingByName(String name) {
		// TODO Auto-generated method stub
		List<Goods> list=new ArrayList<>();
		super.getConnection();
		
		try {// 
			String sql="Select * from tb_goods where name like \"%\"?\"%\"";
			super.stmt=super.conn.prepareStatement(sql);
			if(name!=null) {
				stmt.setString(1,name);
			}
			System.out.println("name:"+name);
			rs=stmt.executeQuery();
			while(rs.next()) {
				Goods goods=new Goods();
				goods.setId(rs.getInt("id"));
				goods.setName(rs.getString("name"));
				goods.setPubdate(rs.getString("pubdate"));
				goods.setPicture(rs.getString("picture"));
				goods.setPrice(rs.getInt("price"));
				goods.setStar(rs.getInt("star"));
				goods.setIntro(rs.getString("Intro"));
				list.add(goods);
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
	public Goods FindGoodsById(int id) {
		// TODO Auto-generated method stub
		super.getConnection();
		
		try {
			String sql="Select * from tb_goods where id=?";
			super.stmt=super.conn.prepareStatement(sql);
			super.stmt.setInt(1, id);
			rs=stmt.executeQuery();
			while(rs.next()) {
				Goods goods=new Goods();
				goods.setId(rs.getInt("id"));
				goods.setName(rs.getString("name"));
				goods.setPubdate(rs.getString("pubdate"));
				goods.setPicture(rs.getString("picture"));
				goods.setPrice(rs.getInt("price"));
				goods.setStar(rs.getInt("star"));
				goods.setIntro(rs.getString("Intro"));
				return goods;
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}

		return null;
	}

	@Override
	public int updateGoodsFile(String name, String typeid, String pubdate, String price, String star,
			String intro) {
		// TODO Auto-generated method stub
		super.getConnection();
		
		try {
			String sql="insert into tb_goods (name,typeid,pubdate,price,star) values (?,?,?,?,?)";
			super.stmt=super.conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, typeid);
			stmt.setString(3, pubdate);
			stmt.setString(4, price);
			stmt.setString(5, star);
			int a=stmt.executeUpdate();
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
