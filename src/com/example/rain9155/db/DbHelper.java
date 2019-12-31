package com.example.rain9155.db;


import com.example.rain9155.bean.*;

import java.sql.*;
import java.util.Vector;

public class DbHelper {

	private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=company;";
	private static final String TABLE_EMPLOYEE = "employee";
    private static final String TABLE_ACCOUMT = "accountant";
    private static final String TABLE_MANAGER = "manager";
    private static final String TABLE_SELLER = "seller";

    static {
		try {
			//1、加载驱动
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("找不到驱动");
		}
	}

	/**
	 *  添加员工
	 * @param employee 要添加的员工
	 */
	public boolean add(Employee employee) {
        String sql1 = "insert into "
                + TABLE_EMPLOYEE + "(id, name, age, pos)"
                + "values('" + employee.id + "', '" + employee.name + "', " + employee.age + ", '" + employee.pos + "');";
        if(!updateInternal(sql1)){
            return false;
        }
	    String sql2;
		if(employee instanceof Accountant){
            Accountant accountant = (Accountant) employee;
            sql2 = "insert into "
                    + TABLE_ACCOUMT + "(id, workDays)"
                    + "values('" + employee.id + "', " + accountant.workDays + ");";

		}else if(employee instanceof Seller){
            Seller seller = (Seller) employee;
            sql2 = "insert into "
                    + TABLE_SELLER + "(id, salesNum)"
                    + "values('" + employee.id + "', " + seller.salesNum + ");";
		}else {
            Manager manager = (Manager) employee;
            sql2 = "insert into "
                    + TABLE_MANAGER + "(id, manage)"
                    + "values('" + employee.id  + "', '" + manager.manage + "');";
        }
        return updateInternal(sql2);
	}

    /**
     * 修改某个员工的名字
     * @param id 员工id
     * @param col 修改的属性列
     * @param modifyTo 修改值
     */
    public boolean modify(String id, String col, String modifyTo) {
        String sql = "update " + TABLE_EMPLOYEE
                + " set " + col + " = '" + modifyTo + "' "
                + "where id = '" + id + "';";
        return updateInternal(sql);
    }

	/**
	 * 查询所有员工信息
	 */
	public Vector<Vector<String>> queryAll() {
		String sql = "select employee.id, employee.name, employee.age, employee.pos, manager.manage, accountant.workDays, seller.salesNum"
                + " from " + TABLE_EMPLOYEE
                + " left join " + TABLE_ACCOUMT + " on employee.id = accountant.id"
                + " left join " + TABLE_SELLER + " on employee.id = seller.id"
                + " left join " + TABLE_MANAGER +" on  employee.id = manager.id";
        return queryInternal(sql);
	}


    /**
     * 通过名字查询员工个人信息
     * @param name 员工名字
     * @param pos 员工职位
     */
    public Vector<Vector<String>> query(String name, String pos) {
        String sql;
        if(Constant.ACCOUNTANT.equals(pos)){
           sql = "select employee.id, employee.name, employee.age, accountant.workDays"
                   + " from " + TABLE_EMPLOYEE + ", " + TABLE_ACCOUMT
                   + " where name = '" + name + "' and employee.id = accountant.id";
        }else if(Constant.MANAGER.equals(pos)){
            sql = "select employee.id, employee.name, employee.age, manager.manage"
                    + " from " + TABLE_EMPLOYEE + ", " + TABLE_MANAGER
                    + " where name = '" + name + "' and employee.id = manager.id";
        }else {
            sql = "select employee.id, employee.name, employee.age, seller.salesNum"
                    + " from " + TABLE_EMPLOYEE + ", " + TABLE_SELLER
                    + " where name = '" + name + "' and employee.id = seller.id";
        }
        return queryInternal(sql);
    }

    /**
     * 删除所有员工
     */
    public boolean removeAll() {
        String sql = "delete from " + TABLE_EMPLOYEE;
        return updateInternal(sql);
    }

    /**
     * 根据名字删除一个员工
     * @param id 员工id
     */
    public boolean remove(String id) {
        String sql = "delete from " + TABLE_EMPLOYEE + " where id = '" + id + "';";
        return updateInternal(sql);
    }


    private boolean updateInternal(String sql) {
        System.out.println(sql);
        try(
            Connection connection = getConnection();
            Statement statement = connection.createStatement()
        ){
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Vector<Vector<String>> queryInternal(String sql) {
        System.out.println(sql);
        Vector<Vector<String>> ret = new Vector<>();
        try(// 2、连接数据库
            Connection connection = getConnection();
            // 3、建立Statement对象
            Statement statement = connection.createStatement();
            // 执行数据库查询语句
            ResultSet resultSet = statement.executeQuery(sql)
        ){
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int colCount = resultSetMetaData.getColumnCount();
            //取出列标题
            Vector<String> title = new Vector<>(colCount);
            for(int i = 0; i < colCount; i++){
                String colName = resultSetMetaData.getColumnName(i + 1);
                title.add(colName);
            }
            ret.add(title);
            //取出每行数据
            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                for(int i = 0; i < colCount; i++){
                    vector.add(resultSet.getString(i + 1));
                }
                ret.add(vector);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }


    private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, "rain9155", "123456");
	}
}
