package com.example.rain9155.bean;

/**
 * 销售人员
 */
public class Seller extends Employee {

	public int salesNum;//销售人员的销售额

	public Seller(String name, int age) {
		super(name, age);
		this.pos = "销售员";
	}

}
