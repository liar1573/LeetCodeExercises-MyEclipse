/**
 * 20200927
 * LC 343 ������� �е��Ѷ�
 * ����һ�������� n��������Ϊ���������������ĺͣ���ʹ��Щ�����ĳ˻���󻯡� 
 * ��������Ի�õ����˻���
 */
package com.leetcode.dp;


public class IntegerBreak {
	
	public static void main(String[] args) {
		IntegerBreak test = new IntegerBreak();
		System.out.println(test.integerBreak(10));
		
		
	}
	
	public int integerBreak(int n) {
		int[] dp = new int[n+1];
		
		dp[1] = 0;dp[2] = 1;
		for (int i = 3; i < dp.length; i++) {
			int max = 1;
//			for (int j = i - 1; j >= (i + 2)/2; j--) {
			for (int j = i - 1; j >= 1; j--) {
				int temp = Math.max(j * (i - j), j * dp[i - j]);
				max = (temp > max) ? temp : max;
			}
			dp[i] = max;
		}
		
		return dp[n];
    }
	
	public int integerBreakImprove2(int n) {
		int[] dp = new int[n+1];
		
		dp[1] = 0;dp[2] = 1;
		for (int i = 3; i < dp.length; i++) {
			int temp1 = Math.max(2 * (i-2), 3 * (i - 3));
			int temp2 = Math.max(2 * dp[i-2], 3 * dp[i-3]);
			dp[i] = (temp1 > temp2) ? temp1 : temp2;
		}
		
		return dp[n];
    }
	
	public int integerBreakMath(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int quotient = n / 3;
        int remainder = n % 3;
        if (remainder == 0) {
            return (int) Math.pow(3, quotient);
        } else if (remainder == 1) {
            return (int) Math.pow(3, quotient - 1) * 4;
        } else {
            return (int) Math.pow(3, quotient) * 2;
        }
    }
}
