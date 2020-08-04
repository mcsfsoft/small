package com.qf.minchang.service;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import com.qf.minchang.dao.OrderDao;
import com.qf.minchang.dao.OrderDaoImpl;
import com.qf.minchang.entity.CartItem;


/**
 * @author Minchang
 * service层实现类 计算用
 * */
public class OrderServiceImpl implements OrderService {

	@Override
	public boolean addOrder(int uid, int aid, Map cart) {
		// TODO Auto-generated method stub
		Collection values=cart.values();//
		Iterator it=values.iterator();
		int sum=0;
		while(it.hasNext()) {
			CartItem item=(CartItem) it.next();
			sum+=(item.getNum())*(item.getGoods().getPrice());//总金额
		}
		OrderDao dao=new OrderDaoImpl();
		boolean b=dao.insert2OrderSql( uid,aid,sum,cart);
		return b;
	}
	
}
