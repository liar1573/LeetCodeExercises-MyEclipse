/**CutRope.java
 * com.nowcoder.aimforoffer
 * TODO
 * ţ��-��ָoffer-�и����ӷ�����󳤶ȳ˻�
 * @author liar
 * 2020��5��6�� ����10:47:53
 * @version 1.0
 */
package com.nowcoder.aimforoffer;

import java.util.Arrays;

public class CutRope {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int length = 5;
//		int m = 2;
////		double dm = m;
//		double result = length / (double) m;
//		System.out.println(result);
//		CutRope test = new CutRope();
//		for (int i = 2; i < 20; i++) {
//			System.out.println("���ӳ���Ϊ:  " + i + "  ,���˻�Ϊ:  " + test.findMaxPartNumber(i));
//		}
		long result =1;
		for (int i = 0; i < 20; i++) {
			result *= 3;
		}
		System.out.println(result);
	}
	
	public int findMaxPartNumber(int ropeLength) {
		//ͨ����������ȷ�����Ӷ�����������ڳ��ȵĹ�ϵ
		//�Լ��²�����Ӧ���ǵ���floor(sqrt(length))
		//int partNumber = 2;//m��СΪ2
		int max = 1;
		int maxParts = 2;//��¼һ�����ֶ������ڵ���
		for (int m = 2; m < ropeLength; m++) {
			//��ѭ���е�i��ʾm
			//m��СΪ2�����Ϊ length(��ʵ�ָ��ȫ1Ҳû���壬�˻�̫С��)
			if (cutRopeBruteForce(ropeLength, m) > max) {
				max = cutRopeBruteForce(ropeLength, m);
				maxParts = m;
			}
			//max = (max > cutRopeBruteForce(ropeLength, m))? max: cutRopeBruteForce(ropeLength, m);
		}
		
		System.out.println("���ֶ���Ϊ: " + maxParts);
		return max;
	}
	
	public int cutRopeBruteForce(int ropeLength, int m) {
		//������Ϊl������Ϊm��ʱ�����û���ֳ��������Ҫ��δ�����
		int[] arr = new int[m];
//		int[] arr = new int[ropeLength];
		//ͨ�����Է�����������ȡ��/m���У���Ҫ����ȡ��
		int rest = ropeLength % m;
		//��m����������˳�򣬸�arr�е�ÿ�����ַ���1���������ǲ���Խ���
		//Ϊʲô��һ�����þ�Խ���ˡ���
		
		//����debug֮��������arr���Ǹ���ʼֵ�ˡ���
		Arrays.fill(arr, ropeLength/m);
		
		for (int i = 0; i < rest; i++) {
			arr[i] +=1; 
		}
		int result = 1;
		for (int i = 0; i < arr.length; i++) {
			result *= arr[i];
		}
		return result;
	}
	
	public int cutRopeGreedyExample(int target) {
		//�����������Ĵ���˼·���Լ����˰���ûȷ��˼·����
		if(target == 2)
			return 1;
		if(target == 3)
			return 2;
		//��������������
		
		int number = target / 3;
		int rest = target % 3;
		int result = 1;
		if (rest == 0) {//������ȫ����3
			for (int i = 0; i < number; i++) 
				result *= 3;
			return result;
		} else if (rest == 1) {//��������Ҫ������2
			for (int i = 0; i < number-1; i++) 
				result *= 3;
			return result * 4;
		} else {
			for (int i = 0; i < number; i++) 
				result *= 3;
			return 2 * result;
		}
	}
	
}
