/**ArrayMultiply.java
 * com.nowcoder.aimforoffer.array
 * TODO
 * ��ָ-����һ���Ĺ��򹹽��˻����飨�и����ĵ����������ǲ�����ʹ�ó�����
 * @author liar
 * 2020��6��7�� ����10:34:17
 * @version 1.0
 */
package com.nowcoder.aimforoffer.array;

import java.util.Arrays;

public class ArrayMultiply {
	public int[] multiplyBF(int[] A) {
		//�����ⷨţ��Ҳ����AC��Ч��������
		int[] result = new int[A.length];
		if(A.length == 0)  return result;
		Arrays.fill(result, 1);
		
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < i; j++) 
				result[i] *= A[j];
			for (int j = i+1; j < result.length; j++)
				result[i] *= A[j];		
		}
		
		
		return result;
    }
	
	
	public int[] multiply(int[] A) {
		int[] result = new int[A.length];
		if(A.length == 0)  return result;
		result[0] = 1;
		
		for (int i = 1; i < result.length; i++)
			result[i] = result[i-1] * A[i-1]; 
		
		int temp = 1;//A[A.length - 1];
		for (int i = result.length - 2; i >= 0; i--) {
			temp *= A[i+1];
			result[i] *= temp;
		}	
		
		return result;
    }
}
