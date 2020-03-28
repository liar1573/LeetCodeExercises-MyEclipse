/**CountingOneBit.java
 * com.leetcode.bitoperation
 * LC 191
 * Write a function that takes an unsigned integer and return the number of '1' bits it has 
 * (also known as the Hamming weight).
 * ��һ����������Ȩ���������
 * 
 * LC 231���ж������Ƿ�Ϊ2��������
 * 
 * LC 338�������������������ֵ�1��λ�����м�㷽������ͨ���������±����ʵ��
 * @author liar
 * 2020��3��28�� ����9:52:26
 * @version 1.0
 */
package com.leetcode.bitoperation;


public class CountingOneBit {

	/**
	 * @Description: TODO
	 * @para: @param args
	 * @return: void
	 * @throws: @param args
	 * @author: liar
	 * @date: 2020��3��28�� ����9:52:26
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountingOneBit testCountingOneBit = new CountingOneBit();
//		System.out.print(testCountingOneBit.hammingWeight(-1));
//		System.out.print(testCountingOneBit.hammingWeightImproved(-1));
		System.out.print(testCountingOneBit.isPowerOfTwo(-31));
		
	}
	
	public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {//����Java��32λint��������Ҫ�ж�32��
			if (1 == (n & 1)) {
				count++;
			}
			//������ֱ����n>>1;����Ҫ��ֵһ��
			//n>>1;
			n = n>>1;
		}
		return count;
	}

	public int hammingWeightImproved(int n) {
        int count = 0;
        while (0 != n) {
			n = n & (n - 1);
			count++;
		}
		return count;
	}

	public boolean isPowerOfTwo(int n) {
		if (n <= 0) {
			return false;
		}
        return (n == (n & (-n)));
	}
	
	public int[] countBits(int num) {
       int[] result = new int[num + 1];
       //�����±��0����1��ʼ�����ԣ�i=0ʱ�����������
       for (int i = 1; i < result.length; i++) {
    	   result[i] = result[i & (i-1)] + 1; 
	   }
       
       return result;
	}
	
}
