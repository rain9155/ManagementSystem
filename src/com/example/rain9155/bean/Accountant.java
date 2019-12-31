package com.example.rain9155.bean;

public class Accountant extends Employee {

	public int workDays; // 会计人员这个月的出勤天数

	public Accountant(String name, int age) {
		super(name, age);
		this.pos = "会计员";
	}


}
