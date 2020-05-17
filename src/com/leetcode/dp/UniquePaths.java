/**UniquePaths.java
 * com.leetcode.dp
 * TODO
 * 62. Unique Paths �����һ��DP��Ŀ�������¡������ߵ��Թ��У������յ�������߷�����
 * 63. Unique Paths II  ��΢������һ�¼����ϰ��ֻ��Ҫ��һ���ж����������߼���������
 * @author liar
 * 2020��5��17�� ����10:12:57
 * @version 1.0
 */
package com.leetcode.dp;


public class UniquePaths {
	public static void main(String[] args) {
		UniquePaths test = new UniquePaths();
		System.out.println(test.uniquePathsDP(3, 2));
		
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length,n = obstacleGrid[0].length;//��������ظ�������
		int[][] dp = new int[m][n];
		
		for (int i = 0; i < m; i++){
			if(obstacleGrid[i][0] != 1)
				dp[i][0] = 1;
			else
				break; //ע�⵽������������ϰ���������ȫ�����ɵ�����0
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
        //�����������ʽ�Ľⷨ
		//���ӷ�ĸ��Ӣ���е���д��дup��down���ˡ���
		//�����C(m+n-2,n-1)
		long up = 1,down = 1,temp = 1;
//		for (int i = m; i <= m+n-2; i++)
//			up *= i;
//		for (int i = 1; i <= n-1; i++)
//			down *= i;
		
		
		for (int i = m,j = 1; i <= m+n-2; i++,j++) {
		//for (int i = m,j = 1; i <= m+n-2 && j <= n-1; i++,j++) {
			temp = temp * i / j; 
			//�˳�ͬʱ���У������е㵣�Ļ᲻������޷��������������
		}
		
		//���ӳ��ȣ�(m+n-2) - (n-1) = m-1
		//��ĸ�ĳ��ȣ�(n-1)
//		if(m > n){//���Ӹ�������Ҫ�ٲ���һЩ����
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
		//�����DP�ⷨ
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
