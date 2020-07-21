/**MinimumPathSum.java
 * com.leetcode.dp
 * TODO
 * 64. Minimum Path Sum (Medium)
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * @author liar
 * 2020年7月21日 下午12:04:03
 * @version 1.0
 */
package com.leetcode.dp;


public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		//默认需要维度m,n >= 1，否则没有意义
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
		//将空间复杂度从m*n降到m
		//默认需要维度m,n >= 1，否则没有意义
		int m = grid.length, n = grid[0].length;
		
		int[] dp = new int[n];
		dp[0] = grid[0][0];
		for (int i = 1; i < n; i++) 
			//dp[i] = dp[i-1] + grid[i][0];
			dp[i] = dp[i-1] + grid[0][i];
		//注意到这里行列更换下标的时候一开始初始化有点问题。。
		
		
		for (int i = 1; i < m; i++) {
			dp[0] = dp[0] + grid[i][0];
			for (int j = 1; j < n; j++) {
				dp[j] = Math.min(dp[j - 1] + grid[i][j], dp[j] + grid[i][j]); 
			}
			
		}
		

		return dp[n - 1];
    }
	
	public int minPathSumOnItself(int[][] grid) {
		//将空间复杂度从m*n降到常数
		//直接操作更改grid数组，就不需要额外空间了。。
		//默认需要维度m,n >= 1，否则没有意义
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
