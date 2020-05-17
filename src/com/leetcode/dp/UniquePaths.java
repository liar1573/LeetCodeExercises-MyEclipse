/**UniquePaths.java
 * com.leetcode.dp
 * TODO
 * 62. Unique Paths 经典的一道DP题目，求向下、向右走的迷宫中，到达终点的所有走法数量
 * 63. Unique Paths II  稍微变形了一下加了障碍物，只需要加一个判断其他部分逻辑基本不变
 * @author liar
 * 2020年5月17日 上午10:12:57
 * @version 1.0
 */
package com.leetcode.dp;


public class UniquePaths {
	public static void main(String[] args) {
		UniquePaths test = new UniquePaths();
		System.out.println(test.uniquePathsDP(3, 2));
		
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length,n = obstacleGrid[0].length;//避免后面重复长代码
		int[][] dp = new int[m][n];
		
		for (int i = 0; i < m; i++){
			if(obstacleGrid[i][0] != 1)
				dp[i][0] = 1;
			else
				break; //注意到这里如果遇到障碍，则后面的全部不可到达变成0
		}
		for (int i = 0; i < n; i++){
			if(obstacleGrid[0][i] != 1)
				dp[0][i] = 1;
			else
				break;
		}
		
		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++){
				if(obstacleGrid[i][j] == 1)
					dp[i][j] = 0;
				else
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		
		return dp[m-1][n-1];
    }
	
	public int uniquePathsCombi(int m, int n) {
        //利用组合数公式的解法
		//分子分母的英文有点难写，写up、down好了。。
		//组合数C(m+n-2,n-1)
		long up = 1,down = 1,temp = 1;
//		for (int i = m; i <= m+n-2; i++)
//			up *= i;
//		for (int i = 1; i <= n-1; i++)
//			down *= i;
		
		
		for (int i = m,j = 1; i <= m+n-2; i++,j++) {
		//for (int i = m,j = 1; i <= m+n-2 && j <= n-1; i++,j++) {
			temp = temp * i / j; 
			//乘除同时进行，就是有点担心会不会出现无法整除的情况。。
		}
		
		//分子长度：(m+n-2) - (n-1) = m-1
		//分母的长度：(n-1)
//		if(m > n){//分子更长，需要再补乘一些数据
//			for (; i <= m+n-2; i++) 
//				temp *= i;
//		}else {
//			for (; j <= n-1; j++) {
//				temp /= j;
//			}
//		}
		
		return (int)(temp);	
		//
    }

	public int uniquePathsDP(int m, int n) {
		//经典的DP解法
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++)
			dp[i][0] = 1;
		for (int i = 0; i < n; i++)
			dp[0][i] = 1;
		
		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++)
				dp[i][j] = dp[i-1][j] + dp[i][j-1];  
		
		return dp[m-1][n-1];
	}
}
