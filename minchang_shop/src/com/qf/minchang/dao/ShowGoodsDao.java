package com.qf.minchang.dao;

import java.util.List;

import com.qf.minchang.entity.Goods;
import com.qf.minchang.entity.GoodsType;
import com.qf.minchang.entity.ShowGoods;

public interface ShowGoodsDao {

	List<ShowGoods> findThingAll();

	List<GoodsType> findShowGoods(String name, String pudbate);

	List<GoodsType> finType();

}
