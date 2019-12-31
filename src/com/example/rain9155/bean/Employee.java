package com.example.rain9155.bean;

/**
 * 公司的抽象基类：员工
 */
public class Employee {

	static int BASE_SALARY = 3000;//员工基本工资为3000人民币

	public String id; // 员工编号
	public String name; // 员工姓名
	public int age;//年龄
	public String pos;//职位

	Employee(String name, int age) {
		this.name = name;
		this.age = age;
		this.id = Long.toHexString(System.currentTimeMillis());
	}

    /**
     * 返回这个员工的工资
     * @param pos 员工职位
     * @param factor 计算因子
     */
	public static int getSalary(String pos, int factor){
		if(Constant.MANAGER.equals(pos)){
            //经理的工资是固定工资18000
            return BASE_SALARY + 10000;
        }else if(Constant.ACCOUNTANT.equals(pos)){
            //会计的工资 = 基本工资 + 这个月的出勤天数 * 100
            return BASE_SALARY + factor * 100;
        }else if(Constant.SELL.equals(pos)){
            //销售人员的工资 = 基本工资 + 它销售额的30%
            return (int) (BASE_SALARY + factor * 0.03);
        }else {
		    return Integer.MIN_VALUE;
        }
	}

	@Override
	public String toString() {
		return "Employee[id = " + id
				+ ", name = " + name
				+ ", age = " + age
				+ ", pos = " + pos + "]";
	}
}
