package com.qf.minchang.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.qf.minchang.entity.CartItem;
import com.qf.minchang.entity.Detail;
import com.qf.minchang.entity.Orders;
import com.qf.minchang.entity.UserDetails;
import com.qf.minchang.entity.UserGoods;
import com.qf.minchang.utils.JDBCUtils;



/**@author MinChang
 * 
 * 写入数据库
 * 事务
 * */
public class OrderDaoImpl extends JDBCUtils implements OrderDao {

	@Override
	public boolean insert2OrderSql(int uid, int aid, int sum, Map cart) {
		// TODO Auto-generated method stub
		Iterator it = cart.values().iterator();
		try {
			String oid=UUID.randomUUID().toString();
			super.getConnection();
			conn.setAutoCommit(false);//关闭sql的自动提交功能
			//向订单状态表插入  iduuid  uid用户id  money总金额   status订单状态  time订单时间 aid 收货地址序号
			String sql1="Insert into tb_order (id,uid,money,status,time,aid) values(?,?,?,?,?,?)";
			super.stmt=super.conn.prepareStatement(sql1);
			stmt.setString(1, oid);
			stmt.setInt(2, uid);
			stmt.setInt(3, sum);
			stmt.setString(4, "待处理");
			stmt.setDate(5, new java.sql.Date(new java.util.Date().getTime()));
			stmt.setInt(6,aid);
			stmt.executeUpdate();
			//向订单deal
			String sql2="Insert into tb_orderdetail(oid,pid,num,money) values(?,?,?,?)";
			super.stmt=super.conn.prepareStatement(sql2);
			while(it.hasNext()) {
				CartItem item = (CartItem)it.next();
				stmt.setString(1, oid);
				stmt.setInt(2, item.getGoods().getId());
				stmt.setInt(3, item.getNum());
				stmt.setInt(4, item.getGoods().getPrice());
				stmt.executeUpdate();
			}
				conn.commit();//提交事务
			return true;
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				try {
					conn.rollback();//回滚事务
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return false;
	}

	@Override
	public List<Detail> findOrdersByUid(int uid) {//生成总金额
		// TODO Auto-generated method stub
		super.getConnection();
		List<Detail> list=new ArrayList<>();
		try {
			String sql="Select t1.id,t1.money,t1.status,t1.time,t2.detail from tb_order as t1 inner join tb_address as t2 on t1.aid=t2.id where t1.uid= ? ";
			super.stmt=super.conn.prepareStatement(sql);
			stmt.setInt(1, uid);
			rs=stmt.executeQuery();
			while(rs.next()){
				Detail de=new Detail();
				de.setId(rs.getString(1));
				de.setMoney(rs.getInt(2));
				de.setStatus(rs.getString(3));
				de.setTime(rs.getDate(4));
				de.setAddress(rs.getString(5));
				list.add(de);
			}
		/*	for(Detail li:list) { 有东西 正确
				System.out.println("order!:"+li);
			}*/
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
	public UserDetails findDetailsByOId(String oid) {
		// TODO Auto-generated method stub
		super.getConnection();
		
		try {
			String sql="select t1.id,t1.time,t2.name, t2.phone,t2.detail,t1.money,t1.aid from tb_order as t1 inner join tb_address as t2 on t1.uid=t2.uid where t1.id=?";
			super.stmt=super.conn.prepareStatement(sql);
			stmt.setString(1, oid);
			rs=stmt.executeQuery();
			while(rs.next()) {
				UserDetails ud=new UserDetails();
				ud.setOid(rs.getString(1));
				ud.setTime(rs.getDate(2));
				ud.setName(rs.getString(3));
				ud.setPhone(rs.getString(4));
				ud.setDetails(rs.getString(5));
				ud.setMoney(rs.getInt(6));
				ud.setAid(rs.getInt(7));
				return ud;
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
	public List<UserGoods> findGoodsByOId(String oid) {
		// TODO Auto-generated method stub
		super.getConnection();
		List<UserGoods> list=new ArrayList<>();
		try {
			String sql="SELECT t1.picture,t1.name,t1.star,t1.pubdate,t1.price,t2.num FROM tb_goods AS t1 INNER JOIN tb_orderdetail AS t2 ON t1.id=t2.pid WHERE  t2.oid=?";
			super.stmt=super.conn.prepareStatement(sql);
			stmt.setString(1, oid);
			rs=stmt.executeQuery();
			while(rs.next()) {
				UserGoods ug=new UserGoods();
				ug.setPicture(rs.getString(1));
				ug.setName(rs.getString(2));
				ug.setStar(rs.getInt(3));
				ug.setPudbate(rs.getDate(4));
				ug.setPrice(rs.getInt(5));
				ug.setNum(rs.getInt(6));
				ug.setSum((rs.getInt(6))*(rs.getInt(5)));
				list.add(ug);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
