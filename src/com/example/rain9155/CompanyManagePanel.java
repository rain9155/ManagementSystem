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

	private static final long serialVersionUID = 1L; // �Զ����ɵ����л���Ϊ�˱��ְ汾�ļ����ԣ����Բ�д�������о���

    JFrame panelParent;

	JLabel addNameLabel = new JLabel("������");
	JTextField addNameField = new JTextField(10);
	JLabel addAgeLabel = new JLabel("����");
	JTextField addAgeField = new JTextField(10);
	JLabel addPosLabel = new JLabel("ְλ");
	JComboBox<String> addPosBox = new JComboBox<>(new String[]{
            Constant.ACCOUNTANT,
            Constant.MANAGER,
            Constant.SELL
    });
	JLabel addManageLabel = new JLabel("������");
	JComboBox<String> addManageBox = new JComboBox<>(new String[]{
            Constant.ACCOUNTANT,
            Constant.SELL
    });
	JLabel addSellLabel = new JLabel("���۶�");
    JTextField addSellField = new JTextField(10);
    JLabel addWorkLabel = new JLabel("��������");
    JTextField addWorkField = new JTextField(10);
    JButton addEmployee = new JButton("�Ǽ�Ա��");

    JLabel modifyIdLabel = new JLabel("Ա��ID��");
    JTextField modifyIdField = new JTextField(10);
    JLabel modifySomeLabel = new JLabel("�޸ĵ�����");
    JComboBox<String> modifySomeBox = new JComboBox<>(new String[]{
            Constant.LABEL_NAME,
            Constant.LABEL_AGE,
    });
    JLabel modifyToLabel = new JLabel("�޸�ֵΪ��");
    JTextField modifyToField = new JTextField(10);
    JButton modifyHimButton = new JButton("�޸�Ա��");


	JLabel removeIdLabel = new JLabel("Ա��ID��");
	JTextField removeIdField = new JTextField(10);
	JButton removeHimButton = new JButton("ɾ������Ա��");
    JButton removeThemButton = new JButton("ɾ������Ա��");


	JLabel queryNameLabel = new JLabel("������");
	JTextField queryNameField = new JTextField(10);
    JLabel queryPosLabel = new JLabel("ְλ");
    JComboBox<String> queryPosBox = new JComboBox<>(new String[]{
            Constant.ACCOUNTANT,
            Constant.MANAGER,
            Constant.SELL
    });
	JButton queryHimButton = new JButton("��ѯ����Ա��");
    JButton queryThemButton = new JButton("��ѯ����Ա��");

	JLabel showLabel = new JLabel("<html><font color=blue>��ʾ����</font></html>");
	Box showBox;

	DbHelper dbHelper = new DbHelper(); // ��ʼ��CompanyList��

	public CompanyManagePanel() {

		JPanel panel01 = new JPanel(); // panel01��һ�������
		panel01.setLayout(new BoxLayout(panel01, BoxLayout.Y_AXIS)); // ����panel01�Ĳ���ΪBoxLayout��BoxLayoutΪ��ֱ����
		panel01.add(Box.createVerticalStrut(10)); // ����һ�����ɼ��� Strut���Ӷ��Զ�������һ���Ŀռ�
		JPanel panel01_02 = new JPanel(); // panel01_02Ҳ��һ������壬��������box1
		Box box1 = Box.createHorizontalBox(); // ����һ����������ʾ�������box1������ˮƽ���������Ͱ�ť
		panel01_02.setLayout(new BoxLayout(panel01_02, BoxLayout.X_AXIS)); //����panel01_02�Ĳ���ΪBoxLayout��BoxLayoutΪˮƽ����
		panel01_02.add(box1); // ��box1����panel01_02��
		box1.add(addNameLabel); // �������Ͱ�ť�ȿؼ�����box1��
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
        panel01.add(panel01_02); // ��panel01_02����panel01��
        panel01.add(Box.createVerticalStrut(10));
        panel01.add(addEmployee);
		panel01.add(Box.createVerticalStrut(20)); // ����һ�����ɼ��� Strut���Ӷ��Եײ�����һ���Ŀռ�
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

		// ���� panelContainer
		JPanel panelContainer = new JPanel();
		panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.Y_AXIS));
		panelContainer.add(panel01);
		panelContainer.add(panel02);
		panelContainer.add(panel03);
		panelContainer.add(panel04);
		panelContainer.add(panel06);

		//����
        panelParent = new JFrame("��˾��Ա��Ϣ����ϵͳ");
		panelParent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �����û��ڴ˴����Ϸ���"close"��ʱĬ��ִ�йرղ���
		panelContainer.setOpaque(true); // ���ÿؼ��Ƿ�͸���ģ�true��ʾ��͸��
		panelParent.setSize(new Dimension(1000, 600)); // ���ô����С����1000����500
		panelParent.setContentPane(panelContainer); // ����panelContainerΪ�������
		panelParent.setVisible(true); // ���ô���ɼ��ԣ�trueΪ�ɼ�
		panelParent.setResizable(true); // ���ô������죬falseΪ������
        panelParent.pack();

		// ��ÿ����ť��Ӽ�����
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
		// ���
		if (e.getSource() == addEmployee) {
			String name = addNameField.getText();
			String age = addAgeField.getText();
			String pos = (String) addPosBox.getSelectedItem();
			String mange = (String) addManageBox.getSelectedItem();
			String sellNum = addSellField.getText();
			String workDays = addWorkField.getText();
            if (name.isEmpty()) {
                showDialog("���ֲ���Ϊnull��");
            } else if(!StringUtils.isInteger(age)){
                showDialog("��������ȷ�����䣡");
            }else if(addWorkField.isEditable() && !StringUtils.isInteger(workDays)){
                showDialog("��������ȷ�ĳ���������");
            }else if(addSellField.isEditable() && !StringUtils.isInteger(sellNum)){
                showDialog("��������ȷ�����۶");
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
                    showDialog("�Ǽǳɹ���");
                }else {
                    showDialog("�Ǽ�ʧ�ܣ�");
                }
                showAllMessage();
            }
		}

        // �޸���Ա
        if (e.getSource() == modifyHimButton) {
            String id = modifyIdField.getText();
            String select = (String) modifySomeBox.getSelectedItem();
            String colName;
            String modifyTo = modifyToField.getText();
            if(id.isEmpty()){
                showDialog("id����Ϊnull��");
                return;
            }
            if(Constant.LABEL_NAME.equals(select)){
                if(modifyTo.isEmpty()){
                    showDialog("�޸����ֲ���Ϊnull��");
                    return;
                }
                colName = "name";
            }else {
                if(!StringUtils.isInteger(modifyTo)){
                    showDialog("��������ȷ�����䣡");
                    return;
                }
                colName = "age";
            }
            if(dbHelper.modify(id, colName, modifyTo)){
                showDialog("�޸ĳɹ���");
            }else {
                showDialog("�޸�ʧ�ܣ�");
            }
            showAllMessage();
        }


        // ɾ��
		if (e.getSource() == removeHimButton) {
			String id = removeIdField.getText();
			if(id.isEmpty()) {
                showDialog("id����Ϊnull��");
                return;
			}
            if(dbHelper.remove(id)){
                showDialog("ɾ��" + id +"��Ϣ�ɹ���");
            }else {
                showDialog("ɾ��" + id +"��Ϣʧ�ܣ�");
            }
            showAllMessage();
		}
		if(e.getSource() == removeThemButton){
		    if(dbHelper.removeAll()){
		        showDialog("ɾ������Ա����Ϣ�ɹ���");
            }else {
                showDialog("ɾ��ʧ�ܣ�");
            }
            showAllMessage();
        }


		// ��ѯ
		if (e.getSource() == queryHimButton) {
			String name = queryNameField.getText();
			String pos = (String) queryPosBox.getSelectedItem();
			if (name.isEmpty()) {
                showDialog("���ֲ���Ϊnull��");
                return;
			}
            Vector<Vector<String>> ret = dbHelper.query(name, pos);
            if(ret.size() < 2){
                showDialog("���޴��ˣ�");
            }
            Vector<String> title = ret.remove(0);
            title.add("salary");
            if(!ret.isEmpty()){//����Ա������
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
            showDialog("û���κ�Ա����Ϣ����Ǽ�");
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