package com.qf.minchang.dao;

import java.util.List;
import java.util.Map;

import com.qf.minchang.entity.Detail;
import com.qf.minchang.entity.Orders;
import com.qf.minchang.entity.UserDetails;
import com.qf.minchang.entity.UserGoods;

public interface OrderDao {

	public boolean insert2OrderSql(int uid, int aid, int sum, Map cart);
	public List<Detail>  findOrdersByUid(int uid);

	public UserDetails findDetailsByOId(String oid);
	public List<UserGoods> findGoodsByOId(String oid);
}
