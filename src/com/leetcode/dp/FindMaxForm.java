/**
 * 
 */
package com.leetcode.dp;


public class FindMaxForm {
	public int findMaxForm(String[] strs, int m, int n) {
		int[][][] dp = new int[strs.length][m+1][n+1];
		int[][] nums = getZeroOneNums(strs);
		//i=0，第一个元素似乎还是得自己手动赋初始值
		
		for (int i = nums[0][0]; i < dp[0].length; i++) {
			for (int j = nums[0][1]; j < dp[0][0].length; j++) {
				dp[0][i][j] = 1; 
			}
		}
		
		
//		for (int i = 0; i < dp.length; i++) {
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				for (int k = 0; k < dp[0][0].length; k++) {
					if(nums[i][0] <= j && nums[i][1] <= k){
						dp[i][j][k] = (dp[i-1][j][k] > (dp[i-1][j - nums[i][0]][k - nums[i][1]] + 1)) 
						? dp[i-1][j][k] :  (dp[i-1][j - nums[i][0]][k - nums[i][1]] + 1);
					}
					else {
						dp[i][j][k] = dp[i-1][j][k];	
					}
				}
			}
		}
				
		return dp[strs.length - 1][m][n];
    }
	
	
	public int[][] getZeroOneNums(String[] strs) {
		int[][] nums = new int[strs.length][2];
		for (int index = 0; index < strs.length; index++) {
			int zeros = 0;
			for (int i = 0; i < strs[index].length(); i++) {
				if(strs[index].charAt(i) == '0')
					zeros++;
			}
			nums[index][0] = zeros;
			nums[index][1] = strs[index].length() - zeros;
		}
				
		return nums;
    }
	
	//官方的写法简洁了很多
	public int findMaxFormSample(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s: strs) {
            int[] count = countzeroesones(s);
            for (int zeroes = m; zeroes >= count[0]; zeroes--)
                for (int ones = n; ones >= count[1]; ones--)
                    dp[zeroes][ones] = Math.max(1 + dp[zeroes - count[0]][ones - count[1]], dp[zeroes][ones]);
        }
        return dp[m][n];
    }
    public int[] countzeroesones(String s) {
        int[] c = new int[2];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i)-'0']++;
        }
        return c;
    }
	
}
