package com.qf.minchang.entity;


/**
 * cartItemʵ����
 * @author MinChang
 * */
public class CartItem {
	
	private int num;//ͳ��
	private Goods goods;//goods����
	
	
	
	public CartItem(int num, Goods goods) {
		super();
		this.num = num;
		this.goods = goods;
	}
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	@Override
	public String toString() {
		return "CartItem [num=" + num + ", goods=" + goods + "]";
	}
	

}