/**
 * LC413.等差数列划分-中等。返回给定数组中长度大于3的等差数列的数列（可以重叠）。
 */
package com.leetcode.dp;


public class Arithmeticsequence {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int numberOfArithmeticSlices(int[] A) {
		//时间N，空间N版本
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
		//时间N，空间1版本
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
