/**SpecialAdd.java
 * com.nowcoder.aimforoffer.bitoperation
 * TODO
 * дһ������������������֮�ͣ�Ҫ���ں������ڲ���ʹ��+��-��*��/����������š�
 * ����˼����ʹ��������㡢xor��(java�в�����Ϊ~)ʵ�ֲ�����λ�ļӷ�����ʹ��&������ý�λ���֮�������ϲ�����
 * ���Լ��и�д������λ�Ƚ��жϵģ������ȷ��������̫�鷳�ˣ�
 * @author liar
 * 2020��6��10�� ����3:29:08
 * @version 1.0
 */
package com.nowcoder.aimforoffer.bitoperation;


public class SpecialAdd {
	public static void main(String[] args) {
		System.out.println(Add(-1, 2));
	}
	
	public static int AddSample(int num1,int num2) {
		while (num2 != 0) {//������ж�������ʲô��˼����
			int temp = num1 ^ num2;
			num2 = (num1 & num2) << 1;
			num1 = temp;
		}
		
		return num1;
	}
	
	
	public static int Add(int num1,int num2) {
        int result = num1 ^ num2;
        
        boolean flag = false;//��λ��־
        int bit = 1; //�����������������Ϊ������
        for (int i = 0; i < 32; i++) {
			//java��intһ����32λ
        	//ע�⵽���ﲻ�����üӷ�����������ȡ���ټ�����Ҳ�ǲ������
        	//�������������һ�Σ�Ȼ������λ����
        	if((result & bit) != 0){//���xor���Ϊ1����ԭ����1-0����0-1
        		if(flag)//����н�λ
        			result = (result & (~bit));
        	}else {//���xor�Ľ��Ϊ0����ԭ���Ľ��Ϊ0-0����1-1
//        		System.out.println("�����Ϊ0");
				if (flag) {//����н�λ
					result = result | bit;
					if ((num1 & bit) == 0) 
						flag = false;
				} else {//�޽�λ
					if ((num1 & bit) != 0)
						flag = true;
				}
			}
        	bit = bit << 1;
		}
        
        
        return result;
    }
}
