/**StringReduce.java
 * com.others
 * ���׹ٷ��̳�ĳ��ı�������
 * �ַ�����д
��Ŀ������
���������ַ���ȫ���Ǵ�дӢ����ĸ�������������M����M>=4�������ֵ�˳�����ڵĴ�д��ĸ������дΪ������ĸ-β��ĸ������ʽ
�������룺XYZABCDMMM    �����XYZA-DMMM
 * @author liar
 * 2020��4��1�� ����11:54:46
 * @version 1.0
 */
package com.others;


public class StringReduce {

	/**
	 * @Description: TODO
	 * @para: @param args
	 * @return: void
	 * @throws: @param args
	 * @author: liar
	 * @date: 2020��4��1�� ����11:54:46
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private String reduceString(String inputString) {
		int M = 4;
		int count = 1; //����ͳ��������ĸ���ֵĸ���
		char[] arr = inputString.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if ((i+1 < arr.length) && (arr[i+1] - arr[i] == 1)) {
					count++;//�����ĸ�����������ۼ�count
				} else {//�����ƶ�iָ�룬��count��1
					i = j;
					count = 1;
					break;
				}
			}
			
//			if (condition) {
//				
//			}
			
			
		}
		
		
		return "";
	}

}
