package com.qf.minchang.dao;

import java.util.List;

import com.qf.minchang.entity.Goods;

public interface GoodsDao {

	List<Goods> findThingByName(String name);

	Goods FindGoodsById(int id);

	int updateGoodsFile(String name, String typeid, String pubdate, String price, String star, String intro);
	
}
