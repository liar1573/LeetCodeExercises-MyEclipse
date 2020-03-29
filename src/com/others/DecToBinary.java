/**DecToBinary.java
 * com.others
 * TODO
 * @author liar
 * 2020��3��22�� ����5:09:01
 * @version 1.0
 */
package com.others;

import java.util.LinkedList;
import java.util.List;

/**
 * ���Ͽ�����һ���׺��Ʊ��Ա���⣬���Ѷ�Ӧ�������ͷ���
 * ���������Լ�һ��ʼ��������ˡ�����
* ����һ������������Ķ�����
* 4   //����
* 100 //���
*/
public class DecToBinary {

	/**
	 * @Description: TODO
	 * @para: @param args
	 * @return: void
	 * @throws: @param args
	 * @author: liar
	 * @date: 2020��3��22�� ����5:09:01
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int input = -9;
//		DecToBinary testDecToBinary = new DecToBinary();
//		LinkedList<Integer> result = testDecToBinary.decToBin(input);
//		testDecToBinary.showList(result);
		
		long input = 10;
		DecToBinary testDecToBinary = new DecToBinary();
		//LinkedList<Long> result = testDecToBinary.decToBinUpdate(input);
		LinkedList<Character> result = testDecToBinary.decToBinBit(input);
		testDecToBinary.showList(result);
		
		//���Ը����ĳ�����ȡ��
//		System.out.println(input % 2);
//		System.out.println(input / 2);
		//�����ĳ����غ��������Ǹ��ģ�����������΢�е��鷳
	}

	public LinkedList<Integer> decToBin(int input) {
		//ԭ����ֻҪ��ͣ�Ķ�2ȡģ��ȥ��ĩβ����
		//�Ӹ�Ч�ĽǶȿ��ǣ������λ��������ܸ���
		//�ο�����ʹ��ArrayList����Ž��
		//���˸о�����Queue����Stack�����ʸ�����һЩ��������һЩ�±�ת������
		LinkedList<Integer> result = new LinkedList<Integer>();
		if (0 == input) {
			result.add(0);
			return result;
		}
		
		//����Ǹ�����֪���Ƿ���Ҫ���⴦��һ�£���
		//����߼���������û�����
		//��Ŀ��û��˵�������ķ�Χ����
		boolean minusFlag = false;//���ڴ������ı�־λ
		if (input < 0) {
			minusFlag = true;
			input = -input;
			//���ڸ���ֱ��ת��Ϊ�����������������ǰ���λ�ٻ��ɸ���
		}
		
		
		while (input != 0) {
			int mode = input % 2;
			input /= 2;
			result.add(mode);
		}
		
		if (minusFlag) {
			result.set(result.size() - 1, -(result.getLast()));
		}
		
		return result;
	}
	
	public LinkedList<Long> decToBinUpdate(long input) {
		//ע�⵽ʾ��������������long����Χ����
		//����2����ͨ��λ��������Ч�ʸ���
		//���������ض���2���ƣ�ȡ�����Ҳ������λ����ʵ��
		
		//ͬʱ����ʾ����һ��bug������������Ϊ0ʱ�᷵��һ���յ�����ʵ����Ӧ�÷���{0}��
		LinkedList<Long> result = new LinkedList<Long>();
		if (0 == input) {
			result.add((long) 0);
			return result;
		}
		
		long binaryFlag = 1;//�����־��������λ�������ж�ĩβ��1����0��
		
		boolean minusFlag = false;//���ڴ������ı�־λ
		if (input < 0) {
			minusFlag = true;
			input = -input;
			//���ڸ���ֱ��ת��Ϊ�����������������ǰ���λ�ٻ��ɸ���
		}
		
		while (input != 0) {
			
//			if ((input&binaryFlag) != 0) {
//				result.add((long) 1);
//			}
//			result.add(0); ԭ������ʵ���߼������⣬�޸�֮���������	
			result.add((long) (input&binaryFlag));
			input = input >> 1;
		}
		
		if (minusFlag) {
			result.set(result.size() - 1, -(result.getLast()));
		}
		
		return result;
		
	}
	
	public LinkedList<Character> decToBinBit(long input){
		LinkedList<Character> result = new LinkedList<Character>();
		//������Java long��64λ����[-2^63,2^63-1]�����Χ�е�̫����һ���ò�������
		//Ĭ�ϸ�λ0����ʾ����
		//��ʵ�����뵽result������ʵ������ռ��ֵ��ֻ�Ǵ洢0-1�����Ʒ��ţ�������Ҫ��long����
		//����С����ֵ���ͻ�����String���;Ϳ�����
		do {
			if (1 == (input & 1)) {
				result.add('1');
			}else {
				result.add('0');
			}
			input = input >>> 1;
			//ע�������㷨���ص��Ƕ����Ʋ��� ���������ķ���λһ����1
		} while (input != 0);
		
		return result;
	}
	
	private void showList(LinkedList inputList) {
		while (0 != inputList.size()) {
			System.out.print(inputList.removeLast());
		}
	}
	
}
