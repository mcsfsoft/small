package com.qf.minchang.entity;

import java.util.Date;

/**
 * @author Minchang
 * 个人订单详情
 * */
public class UserDetails {
	private String oid;
	private Date time;
	private String name;
	private String phone;
	private String details;
	private int money;
	private int aid;
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public UserDetails(String oid, Date time, String name, String phone, String details, int money, int aid) {
		super();
		this.oid = oid;
		this.time = time;
		this.name = name;
		this.phone = phone;
		this.details = details;
		this.money = money;
		this.aid = aid;
	}
	@Override
	public String toString() {
		return "UserDetails [oid=" + oid + ", time=" + time + ", name=" + name + ", phone=" + phone + ", details="
				+ details + ", money=" + money + ", aid=" + aid + "]";
	}
	
}
