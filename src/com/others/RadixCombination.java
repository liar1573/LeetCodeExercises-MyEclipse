/**RadixCombination.java
 * com.others
 * ���׹ٷ��̳�ĳ��ı�������
 * �����⣺�����������
С����̽���������N�ֱ�ת��ΪX���ƣ��ٶ�5���ƣ���Y���ƣ��ٶ�2���ƣ�֮�����������������������ʱ��������֮��û�����ӿո�ָ�ȫ��������һ�����硰232110011001��
Ҫ�󣺸�������������ַ�����ȷ�����������N
 * @author liar
 * 2020��4��1�� ����3:50:29
 * @version 1.0
 */
package com.others;


public class RadixCombination {

	/**
	 * @Description: TODO
	 * @para: @param args
	 * @return: void
	 * @throws: @param args
	 * @author: liar
	 * @date: 2020��4��1�� ����3:50:29
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String testString = "1234";
		String testString2 = "120100011";
//		char[] arr = testString.toCharArray();
//		int[] intArr = new int[4];
//		for (int i = 0; i < intArr.length; i++) {
//			intArr[i] = arr[i] - '0';
//		}
//		for (int i : intArr) {
//			System.out.println(i);
//		}
		RadixCombination test = new RadixCombination();
//		System.out.println(test.getOriginalNumber(testString2));
		System.out.println(test.sample(testString2, 5, 2));
		
		

	}
	
	private int getOriginalNumber(String numberString) {
		//��̫���������������ʱ�����ǷǷ�������ˣ���String������СΪ2��
		//ĳ�˸߽�����ǰ���ͽ����ں������Ӱ�����֮��ķ�����У�
		int result = 0;
		for (int i = 1; i <= (numberString.length() / 2); i++) {
			if (getRadixValue(5, numberString.substring(0, i)) == getRadixValue(2, numberString.substring(i, numberString.length()))) {
				result = getRadixValue(5, numberString.substring(0, i));
				break;
			}
		}
		
		return result;
	}

	private int getRadixValue(int radix, String numberString) {
		//���뵽�����⣬���X����Ϊ����10�Ľ�չ���ַ�����Ͽ��ܻ�������ƥ�����⡣��
		//����16���Ƶ�A��B��C���֡���
		int result = 0;
		char[] arr = numberString.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			//����һ��ʼ��ʵ������Math.pow�����ģ�����������õĻ���Ҫ��������
			//0���ݺ��鷳����
			result += (arr[i] - '0') * (int)Math.pow(radix, arr.length - i -1);
		}
		
		return result;
	}

	private int sample(String numberString, int radixX, int radixY) {
		//�ο��𰸣�����Ľⷨ������
		//û�뵽��Ȼ���з������ԴӸ�λ����λ�ۼӼ���ֵ��
		//ԭ��һֱ��Ϊֻ��֪��λ���ͻ���֮����ܴ������Ҽ���ֵ
		int a = 0, b = 0, k = 1;
		//a��b�ֱ���������������������ۼӺ�
		for (int i = 0, j = numberString.length(); i < j; ) {
			//ע�⵽����ȡֵ�õ���--j�����Գ�ֱֵ���õ�len
			if (a <= b) {
				a = a * radixX + (numberString.charAt(i++) - '0'); 
			} else {
				//����ûʹ��Math.pow������ͨ����ʱ����k=1�������۳�Ҳ������
				b = b + (numberString.charAt(--j) - '0') * k;
				k *= radixY;
			}
		}
		
		return a;
	}
}
