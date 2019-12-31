package com.example.rain9155.bean;

/**
 * 经理
 */
public class Manager extends Employee {

	public String manage;//管理方向

	public Manager(String name, int age) {
		super(name, age);
		this.pos = "经理";
	}

}
