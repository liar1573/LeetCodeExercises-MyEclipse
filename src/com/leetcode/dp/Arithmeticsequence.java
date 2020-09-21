/**
 * LC413.�Ȳ����л���-�еȡ����ظ��������г��ȴ���3�ĵȲ����е����У������ص�����
 */
package com.leetcode.dp;


public class Arithmeticsequence {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int numberOfArithmeticSlices(int[] A) {
		//ʱ��N���ռ�N�汾
		if(A.length <= 2) return 0;
		
		int[] dp = new int[A.length];
		int sum = 0;
		int diff = A[1] - A[0], diffCount = 1;
		
		for (int i = 2; i < A.length; i++) {
			if (A[i] - A[i-1] == diff) {
				diffCount++;
				if(diffCount >= 2){
					dp[i] = dp[i-1] + 1;
					sum += dp[i];
				}
			} else {
				diff = A[i] - A[i-1];
				diffCount = 1;
			}
		}
		
		return sum;
    }
	
	public int numberOfArithmeticSlicesConstant(int[] A) {
		//ʱ��N���ռ�1�汾
		if(A.length <= 2) return 0;
		
//		int[] dp = new int[A.length];
		int dp1 = 0, dp2 = 0;
		int sum = 0;
		int diff = A[1] - A[0], diffCount = 1;
		
		for (int i = 2; i < A.length; i++) {
			if (A[i] - A[i-1] == diff) {
				diffCount++;
				if(diffCount >= 2){
					dp2 = dp1 + 1;
					sum += dp2;
					dp1 = dp2;
//					dp[i] = dp[i-1] + 1;
//					sum += dp[i];
				}
			} else {
				diff = A[i] - A[i-1];
				diffCount = 1;
				dp1 = 0;
			}
		}
		return sum;
    }

}
