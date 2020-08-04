package com.qf.minchang.entity;

import java.util.Date;

public class UserGoods {
	private String picture;
	private String name;
	private int star;
	private Date pudbate;
	private int price;
	private int num;
	private int sum;
	public UserGoods() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserGoods(String picture, String name, int star, Date pudbate, int price, int num, int sum) {
		super();
		this.picture = picture;
		this.name = name;
		this.star = star;
		this.pudbate = pudbate;
		this.price = price;
		this.num = num;
		this.sum = sum;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public Date getPudbate() {
		return pudbate;
	}
	public void setPudbate(Date pudbate) {
		this.pudbate = pudbate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	@Override
	public String toString() {
		return "UserGoods [picture=" + picture + ", name=" + name + ", star=" + star + ", pudbate=" + pudbate
				+ ", price=" + price + ", num=" + num + ", sum=" + sum + "]";
	}
	
	
}
