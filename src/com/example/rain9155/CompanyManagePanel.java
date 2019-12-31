package com.example.rain9155;


import com.example.rain9155.bean.*;
import com.example.rain9155.db.DbHelper;
import com.microsoft.sqlserver.jdbc.StringUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class CompanyManagePanel extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L; // 自动生成的序列化，为了保持版本的兼容性，可以不写，但会有警告

    JFrame panelParent;

	JLabel addNameLabel = new JLabel("姓名：");
	JTextField addNameField = new JTextField(10);
	JLabel addAgeLabel = new JLabel("年龄");
	JTextField addAgeField = new JTextField(10);
	JLabel addPosLabel = new JLabel("职位");
	JComboBox<String> addPosBox = new JComboBox<>(new String[]{
            Constant.ACCOUNTANT,
            Constant.MANAGER,
            Constant.SELL
    });
	JLabel addManageLabel = new JLabel("管理方向");
	JComboBox<String> addManageBox = new JComboBox<>(new String[]{
            Constant.ACCOUNTANT,
            Constant.SELL
    });
	JLabel addSellLabel = new JLabel("销售额");
    JTextField addSellField = new JTextField(10);
    JLabel addWorkLabel = new JLabel("出勤天数");
    JTextField addWorkField = new JTextField(10);
    JButton addEmployee = new JButton("登记员工");

    JLabel modifyIdLabel = new JLabel("员工ID：");
    JTextField modifyIdField = new JTextField(10);
    JLabel modifySomeLabel = new JLabel("修改的属性");
    JComboBox<String> modifySomeBox = new JComboBox<>(new String[]{
            Constant.LABEL_NAME,
            Constant.LABEL_AGE,
    });
    JLabel modifyToLabel = new JLabel("修改值为：");
    JTextField modifyToField = new JTextField(10);
    JButton modifyHimButton = new JButton("修改员工");


	JLabel removeIdLabel = new JLabel("员工ID：");
	JTextField removeIdField = new JTextField(10);
	JButton removeHimButton = new JButton("删除单个员工");
    JButton removeThemButton = new JButton("删除所有员工");


	JLabel queryNameLabel = new JLabel("姓名：");
	JTextField queryNameField = new JTextField(10);
    JLabel queryPosLabel = new JLabel("职位");
    JComboBox<String> queryPosBox = new JComboBox<>(new String[]{
            Constant.ACCOUNTANT,
            Constant.MANAGER,
            Constant.SELL
    });
	JButton queryHimButton = new JButton("查询单个员工");
    JButton queryThemButton = new JButton("查询所有员工");

	JLabel showLabel = new JLabel("<html><font color=blue>显示区域</font></html>");
	Box showBox;

	DbHelper dbHelper = new DbHelper(); // 初始化CompanyList类

	public CompanyManagePanel() {

		JPanel panel01 = new JPanel(); // panel01是一个父面板
		panel01.setLayout(new BoxLayout(panel01, BoxLayout.Y_AXIS)); // 定义panel01的布局为BoxLayout，BoxLayout为垂直排列
		panel01.add(Box.createVerticalStrut(10)); // 加入一个不可见的 Strut，从而对顶部留出一定的空间
		JPanel panel01_02 = new JPanel(); // panel01_02也是一个子面板，用来放置box1
		Box box1 = Box.createHorizontalBox(); // 创建一个从左到右显示其组件的box1，用来水平放置输入框和按钮
		panel01_02.setLayout(new BoxLayout(panel01_02, BoxLayout.X_AXIS)); //定义panel01_02的布局为BoxLayout，BoxLayout为水平排列
		panel01_02.add(box1); // 把box1放入panel01_02中
		box1.add(addNameLabel); // 把输入框和按钮等控件放入box1中
		box1.add(addNameField);
		box1.add(addAgeLabel);
		box1.add(addAgeField);
        box1.add(addPosLabel);
        box1.add(addPosBox);
        box1.add(addManageLabel);
        box1.add(addManageBox);
        box1.add(addSellLabel);
        box1.add(addSellField);
        box1.add(addWorkLabel);
        box1.add(addWorkField);
        panel01.add(Box.createVerticalStrut(10));
        panel01.add(panel01_02); // 把panel01_02放入panel01中
        panel01.add(Box.createVerticalStrut(10));
        panel01.add(addEmployee);
		panel01.add(Box.createVerticalStrut(20)); // 加入一个不可见的 Strut，从而对底部留出一定的空间
        addWorkField.setEditable(true);
        addManageBox.setEnabled(false);
        addSellField.setEditable(false);

        JPanel panel02 = new JPanel();
        panel02.setLayout(new BoxLayout(panel02, BoxLayout.Y_AXIS));
        panel02.add(Box.createVerticalStrut(10));
        JPanel panel02_02 = new JPanel();
        Box box2 = Box.createHorizontalBox();
        panel02_02.setLayout(new BoxLayout(panel02_02, BoxLayout.X_AXIS));
        panel02_02.add(box2);
        box2.add(modifyIdLabel);
        box2.add(modifyIdField);
        box2.add(modifySomeLabel);
        box2.add(modifySomeBox);
        box2.add(modifyToLabel);
        box2.add(modifyToField);
        panel02.add(Box.createVerticalStrut(10));
        panel02.add(panel02_02);
        panel02.add(Box.createVerticalStrut(10));
        panel02.add(modifyHimButton);
        panel02.add(Box.createVerticalStrut(20));

		JPanel panel03 = new JPanel();
		panel03.setLayout(new BoxLayout(panel03, BoxLayout.Y_AXIS));
		panel03.add(Box.createVerticalStrut(10));
		JPanel panel03_02 = new JPanel();
		Box box3 = Box.createHorizontalBox();
        panel03_02.setLayout(new BoxLayout(panel03_02, BoxLayout.X_AXIS));
        panel03_02.add(box3);
		box3.add(removeIdLabel);
		box3.add(removeIdField);
        panel03.add(Box.createVerticalStrut(10));
        panel03.add(panel03_02);
        panel03.add(Box.createVerticalStrut(10));
        JPanel panel02_03 = new JPanel();
        panel02_03.setLayout(new BoxLayout(panel02_03, BoxLayout.X_AXIS));
        panel02_03.add(removeHimButton);
        panel02_03.add(removeThemButton);
        panel03.add(panel02_03);
        panel03.add(Box.createVerticalStrut(20));


		JPanel panel04 = new JPanel();
		panel04.setLayout(new BoxLayout(panel04, BoxLayout.Y_AXIS));
		panel04.add(Box.createVerticalStrut(10));
		JPanel panel04_02 = new JPanel();
		Box box4 = Box.createHorizontalBox();
		panel04_02.setLayout(new BoxLayout(panel04_02, BoxLayout.X_AXIS));
		panel04_02.add(box4);
		box4.add(queryNameLabel);
		box4.add(queryNameField);
        box4.add(queryPosLabel);
        box4.add(queryPosBox);
        panel04.add(Box.createVerticalStrut(10));
        panel04.add(panel04_02);
        panel04.add(Box.createVerticalStrut(10));
        JPanel panel04_03 = new JPanel();
        panel04_03.setLayout(new BoxLayout(panel04_03, BoxLayout.X_AXIS));
        panel04_03.add(queryHimButton);
        panel04_03.add(queryThemButton);
        panel04.add(panel04_03);
		panel04.add(Box.createVerticalStrut(20));

        JPanel panel06 = new JPanel();
        panel06.setLayout(new BoxLayout(panel06, BoxLayout.Y_AXIS));
		panel06.add(Box.createVerticalStrut(10));
		JPanel panel06_01 = new JPanel();
		panel06_01.add(showLabel);
		JPanel panel06_02 = new JPanel();
		showBox = Box.createVerticalBox();
		panel06_02.setLayout(new BoxLayout(panel06_02, BoxLayout.X_AXIS));
		panel06_02.add(showBox);
		panel06.add(panel06_01);
		panel06.add(panel06_02);
		panel06.add(Box.createVerticalStrut(20));

		// 创建 panelContainer
		JPanel panelContainer = new JPanel();
		panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.Y_AXIS));
		panelContainer.add(panel01);
		panelContainer.add(panel02);
		panelContainer.add(panel03);
		panelContainer.add(panel04);
		panelContainer.add(panel06);

		//窗口
        panelParent = new JFrame("公司人员信息管理系统");
		panelParent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置用户在此窗体上发起"close"，时默认执行关闭操作
		panelContainer.setOpaque(true); // 设置控件是否透明的，true表示不透明
		panelParent.setSize(new Dimension(1000, 600)); // 设置窗体大小，宽1000，高500
		panelParent.setContentPane(panelContainer); // 设置panelContainer为内容面板
		panelParent.setVisible(true); // 设置窗体可见性，true为可见
		panelParent.setResizable(true); // 设置窗体拉伸，false为不允许
        panelParent.pack();

		// 对每个按钮添加监听器
		addEmployee.addActionListener(this);
		removeHimButton.addActionListener(this);
		removeThemButton.addActionListener(this);
		modifyHimButton.addActionListener(this);
		queryHimButton.addActionListener(this);
		queryThemButton.addActionListener(this);
		addPosBox.addItemListener(e -> {
            String select = (String) addPosBox.getSelectedItem();
            if(select.equals(Constant.ACCOUNTANT)){
                addWorkField.setEditable(true);
                addManageBox.setEnabled(false);
                addSellField.setEditable(false);
            }else if(select.equals(Constant.MANAGER)){
                addWorkField.setEditable(false);
                addManageBox.setEnabled(true);
                addSellField.setEditable(false);
            }else if(select.equals(Constant.SELL)){
                addWorkField.setEditable(false);
                addManageBox.setEnabled(false);
                addSellField.setEditable(true);
            }
        });

        showAllMessage();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 添加
		if (e.getSource() == addEmployee) {
			String name = addNameField.getText();
			String age = addAgeField.getText();
			String pos = (String) addPosBox.getSelectedItem();
			String mange = (String) addManageBox.getSelectedItem();
			String sellNum = addSellField.getText();
			String workDays = addWorkField.getText();
            if (name.isEmpty()) {
                showDialog("名字不能为null！");
            } else if(!StringUtils.isInteger(age)){
                showDialog("请输入正确的年龄！");
            }else if(addWorkField.isEditable() && !StringUtils.isInteger(workDays)){
                showDialog("请输入正确的出勤天数！");
            }else if(addSellField.isEditable() && !StringUtils.isInteger(sellNum)){
                showDialog("请输入正确的销售额！");
            }else {
                Employee employee;
                if(Constant.ACCOUNTANT.equals(pos)){
                    Accountant accountant = new Accountant(name, Integer.valueOf(age));
                    accountant.workDays = Integer.valueOf(workDays);
                    employee = accountant;
                }else if(Constant.MANAGER.equals(pos)){
                    Manager manager = new Manager(name, Integer.valueOf(age));
                    manager.manage = mange;
                    employee = manager;
                }else {
                    Seller seller = new Seller(name, Integer.valueOf(age));
                    seller.salesNum = Integer.valueOf(sellNum);
                    employee = seller;
                }
                if(dbHelper.add(employee)){
                    showDialog("登记成功！");
                }else {
                    showDialog("登记失败！");
                }
                showAllMessage();
            }
		}

        // 修改人员
        if (e.getSource() == modifyHimButton) {
            String id = modifyIdField.getText();
            String select = (String) modifySomeBox.getSelectedItem();
            String colName;
            String modifyTo = modifyToField.getText();
            if(id.isEmpty()){
                showDialog("id不能为null！");
                return;
            }
            if(Constant.LABEL_NAME.equals(select)){
                if(modifyTo.isEmpty()){
                    showDialog("修改名字不能为null！");
                    return;
                }
                colName = "name";
            }else {
                if(!StringUtils.isInteger(modifyTo)){
                    showDialog("请输入正确的年龄！");
                    return;
                }
                colName = "age";
            }
            if(dbHelper.modify(id, colName, modifyTo)){
                showDialog("修改成功！");
            }else {
                showDialog("修改失败！");
            }
            showAllMessage();
        }


        // 删除
		if (e.getSource() == removeHimButton) {
			String id = removeIdField.getText();
			if(id.isEmpty()) {
                showDialog("id不能为null！");
                return;
			}
            if(dbHelper.remove(id)){
                showDialog("删除" + id +"信息成功！");
            }else {
                showDialog("删除" + id +"信息失败！");
            }
            showAllMessage();
		}
		if(e.getSource() == removeThemButton){
		    if(dbHelper.removeAll()){
		        showDialog("删除所有员工信息成功！");
            }else {
                showDialog("删除失败！");
            }
            showAllMessage();
        }


		// 查询
		if (e.getSource() == queryHimButton) {
			String name = queryNameField.getText();
			String pos = (String) queryPosBox.getSelectedItem();
			if (name.isEmpty()) {
                showDialog("名字不能为null！");
                return;
			}
            Vector<Vector<String>> ret = dbHelper.query(name, pos);
            if(ret.size() < 2){
                showDialog("查无此人！");
            }
            Vector<String> title = ret.remove(0);
            title.add("salary");
            if(!ret.isEmpty()){//计算员工工资
                Vector<String> vector = ret.get(0);
                String num = vector.get(vector.size() - 1);
                if(!StringUtils.isInteger(num)){
                   num = "0";
                }
                String salary = String.valueOf(
                        Employee.getSalary(pos, Integer.valueOf(num))
                );
                vector.add(salary);
            }
            JTable table = new JTable(ret, title);
            showBox.removeAll();
            showBox.add(new JScrollPane(table));
            panelParent.validate();
		}
		if (e.getSource() == queryThemButton) {
		    showAllMessage();
        }
	}

    private void showAllMessage() {
        Vector<Vector<String>> ret = dbHelper.queryAll();
        showBox.removeAll();
        if(ret.size() < 2){
            showDialog("没有任何员工信息！请登记");
        }else {
            Vector<String> title = ret.remove(0);
            JTable table = new JTable(ret, title);
            showBox.add(new JScrollPane(table));
        }
        panelParent.validate();
        panelParent.pack();
    }

    private void showDialog(String mes) {
        JOptionPane.showMessageDialog(null, mes);
    }

    public static void main(String[] args) {
		new CompanyManagePanel();
	}

}