package com.qf.minchang.entity;

public class GoodsType {
	private String name;
	private int price;
	private String pudbate;
	private String typename;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPudbate() {
		return pudbate;
	}
	public void setPudbate(String pudbate) {
		this.pudbate = pudbate;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public GoodsType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GoodsType(String name, int price, String pudbate, String typename) {
		super();
		this.name = name;
		this.price = price;
		this.pudbate = pudbate;
		this.typename = typename;
	}
	@Override
	public String toString() {
		return "GoodsType [name=" + name + ", price=" + price + ", pudbate=" + pudbate + ", typename=" + typename + "]";
	}
	
	
}
