package com.example.rain9155.bean;

/**
 * ��˾�ĳ�����ࣺԱ��
 */
public class Employee {

	static int BASE_SALARY = 3000;//Ա����������Ϊ3000�����

	public String id; // Ա�����
	public String name; // Ա������
	public int age;//����
	public String pos;//ְλ

	Employee(String name, int age) {
		this.name = name;
		this.age = age;
		this.id = Long.toHexString(System.currentTimeMillis());
	}

    /**
     * �������Ա���Ĺ���
     * @param pos Ա��ְλ
     * @param factor ��������
     */
	public static int getSalary(String pos, int factor){
		if(Constant.MANAGER.equals(pos)){
            //����Ĺ����ǹ̶�����18000
            return BASE_SALARY + 10000;
        }else if(Constant.ACCOUNTANT.equals(pos)){
            //��ƵĹ��� = �������� + ����µĳ������� * 100
            return BASE_SALARY + factor * 100;
        }else if(Constant.SELL.equals(pos)){
            //������Ա�Ĺ��� = �������� + �����۶��30%
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
