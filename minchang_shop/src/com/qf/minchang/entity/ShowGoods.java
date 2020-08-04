package com.qf.minchang.entity;

public class ShowGoods {
	private int id;
	private String name;
	private int level;
	private int parent;
	private String name2;
	public ShowGoods() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShowGoods(int id, String name, int level, int parent, String name2) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
		this.parent = parent;
		this.name2 = name2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	@Override
	public String toString() {
		return "ShowGoods [id=" + id + ", name=" + name + ", level=" + level + ", parent=" + parent + ", name2=" + name2
				+ "]";
	}
	
	

	
}
