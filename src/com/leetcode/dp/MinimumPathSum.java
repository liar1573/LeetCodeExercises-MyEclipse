/**MinimumPathSum.java
 * com.leetcode.dp
 * TODO
 * 64. Minimum Path Sum (Medium)
 * ����һ�������Ǹ������� m x n �������ҳ�һ�������Ͻǵ����½ǵ�·����ʹ��·���ϵ������ܺ�Ϊ��С��
 * @author liar
 * 2020��7��21�� ����12:04:03
 * @version 1.0
 */
package com.leetcode.dp;


public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		//Ĭ����Ҫά��m,n >= 1������û������
		int m = grid.length, n = grid[0].length;
		
		int[][] dp = new int[m][n];
		dp[0][0] = grid[0][0];
		for (int i = 1; i < m; i++) 
			dp[i][0] = dp[i-1][0] + grid[i][0];
		for (int i = 1; i < n; i++)
			dp[0][i] = dp[0][i-1] + grid[0][i]; 
		
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = Math.min(dp[i-1][j] + grid[i][j], dp[i][j-1] + grid[i][j]); 
			}
		}
		
		return dp[m-1][n-1];
    }
	
	public int minPathSumON(int[][] grid) {
		//���ռ临�Ӷȴ�m*n����m
		//Ĭ����Ҫά��m,n >= 1������û������
		int m = grid.length, n = grid[0].length;
		
		int[] dp = new int[n];
		dp[0] = grid[0][0];
		for (int i = 1; i < n; i++) 
			//dp[i] = dp[i-1] + grid[i][0];
			dp[i] = dp[i-1] + grid[0][i];
		//ע�⵽�������и����±��ʱ��һ��ʼ��ʼ���е����⡣��
		
		
		for (int i = 1; i < m; i++) {
			dp[0] = dp[0] + grid[i][0];
			for (int j = 1; j < n; j++) {
				dp[j] = Math.min(dp[j - 1] + grid[i][j], dp[j] + grid[i][j]); 
			}
			
		}
		

		return dp[n - 1];
    }
	
	public int minPathSumOnItself(int[][] grid) {
		//���ռ临�Ӷȴ�m*n��������
		//ֱ�Ӳ�������grid���飬�Ͳ���Ҫ����ռ��ˡ���
		//Ĭ����Ҫά��m,n >= 1������û������
		int m = grid.length, n = grid[0].length;
		for (int i = 1; i < m; i++) 
			grid[i][0] = grid[i-1][0] + grid[i][0];
		for (int i = 1; i < n; i++)
			grid[0][i] = grid[0][i-1] + grid[0][i];
		
		for (int i = 1; i < m; i++) 
			for (int j = 1; j < n; j++) 
				grid[i][j] = Math.min(grid[i - 1][j] + grid[i][j], grid[i][j - 1] + grid[i][j]); 
			
		return grid[m - 1][n - 1];
    }
	
	
}
