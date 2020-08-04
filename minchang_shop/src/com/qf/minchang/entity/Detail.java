package com.qf.minchang.entity;

import java.util.Date;

public class Detail {
	private String id;
	private int money;
	private String status;
	private Date time;
	private  String address;
	public Detail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Detail(String id, int money, String status, Date time, String address) {
		super();
		this.id = id;
		this.money = money;
		this.status = status;
		this.time = time;
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Detail [id=" + id + ", money=" + money + ", status=" + status + ", time=" + time + ", address="
				+ address + "]";
	}
	
	

}
