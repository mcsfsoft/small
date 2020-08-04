package com.qf.minchang.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qf.minchang.entity.Goods;
import com.qf.minchang.entity.GoodsType;
import com.qf.minchang.entity.ShowGoods;
import com.qf.minchang.utils.JDBCUtils;

public class ShowGoodsDaoImpl  extends JDBCUtils implements ShowGoodsDao{

	@Override
	public List<ShowGoods> findThingAll() {
		// TODO Auto-generated method stub
		super.getConnection();
		List<ShowGoods> list=new ArrayList<>();
		try {
			String sql="Select t1.id,t1.name,t1.level,t2.name,t1.parent from tb_goods_type as t1 join tb_goods_type as t2 on t1.level=t2.parent ";
			super.stmt=super.conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()) {
				ShowGoods goods=new ShowGoods();
				goods.setId(rs.getInt(1));
				goods.setName(rs.getString(2));
				goods.setLevel(rs.getInt(3));
				goods.setName2(rs.getString(4));
				goods.setParent(rs.getInt(5));
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
	public List<GoodsType> findShowGoods(String name, String pudbate) {
		// TODO Auto-generated method stub
		List<GoodsType> list=new ArrayList<>();
		super.getConnection();
		
		try {//where t1.name=? and pubdate=?
			String sql="select t1.name,t1.price,t1.pubdate,t2.name from tb_goods as t1 inner join tb_goods_type as t2  on t1.typeid=t2.id ";
			super.stmt=super.conn.prepareStatement(sql);
/*			stmt.setString(1, name);
			stmt.setString(2,pudbate);*/
			rs=stmt.executeQuery();
			while(rs.next()) {
				GoodsType goods=new GoodsType();
				goods.setName(rs.getString(1));
				goods.setPrice(rs.getInt(2));
				goods.setPudbate(rs.getString(3));
				goods.setTypename(rs.getString(4));
				list.add(goods);
			}
			for(GoodsType list1:list) {
				System.out.println(list1);
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
	public List<GoodsType> finType() {
		// TODO Auto-generated method stub
		super.getConnection();
		List<GoodsType> list=new ArrayList<>();
		try {
			String sql="Select name from tb_goods_type";
			super.stmt=super.conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()) {
				GoodsType gt=new GoodsType();
				gt.setTypename(rs.getString("name"));
				list.add(gt);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	






}
