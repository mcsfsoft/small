package com.qf.minchang.entity;

import java.util.Date;

public class Goods {
	private int id;
	private String name;
	private String pubdate;
	private String picture;
	private int price;
	private int star;
	private String intro;
	
	

	public Goods(String intro,int id,String name, String pubdate, String picture, int price, int star) {
		super();
		this.id=id;
		this.name = name;
		this.pubdate = pubdate;
		this.picture = picture;
		this.price = price;
		this.star = star;
		this.intro=intro;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPubdate() {
		return pubdate;
	}
	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", pubdate=" + pubdate + ", picture=" + picture + ", price="
				+ price + ", star=" + star + ", intro=" + intro + "]";
	}
	
}
