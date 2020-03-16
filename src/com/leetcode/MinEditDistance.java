package com.leetcode;
//LeetCode 72

public class MinEditDistance {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//说起来之前一直都在用static静态方法测试
		//其实好像有个叫JUnit的类用来测试会方便很多
		//pycharm、idea工具也有类似的模块测试功能
		System.out.println(minDistance("horse","ros"));
		
	}
	
	
	 public static int minDistance(String word1, String word2) {
		 //null在本题完全没有意义，不够还是处理一下好了
		 if (null == word1 || null == word1) {
			return 0;
		}
		 
		 //仿照示例，把长度专门用变量表示，后面看着会简洁很多
		 int m = word1.length();
		 int n = word2.length();		 
		 int[][] dp = new int[m+1][n+1]; 
		 //示例python代码通过将数组尺寸设置为dp[m+1,n+1]，很巧妙的避开了对字符长度为0的特殊讨论，是代码简洁了很多
		 //注意到这里长度设置为m+1,n+1一举两得，即能避免额外长度为0的判断，又能使下标与长度对其增强可读性
		 
		 
		 //java int数组印象中是自动初始化为0的，这里偷个懒试试
		 for (int i = 0; i < m+1; i++) {
			dp[i][0] = i; //目标为空的情况可以全部删掉原有的
		}
		 for (int i = 0; i < n+1; i++) {
			dp[0][i] = i; //源为空的情况可以对照目标依次添加
		}
		 
		 //多注意+1等边界问题
		 for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (word1.charAt(i-1) == word2.charAt(j-1)) {
					//注意到dp的长度加了1，但是string的规格并没有变，需要减1对齐
					dp[i][j] = dp[i-1][j-1]; 
				}else {
//					int tempValue = (dp[i-1][j] < dp[i][j-1]) ? dp[i-1][j] + 1: dp[i][j-1] + 1;
//					dp[i][j] = (tempValue < dp[i-1][j-1]) ? tempValue + 1 : dp[i-1][j-1] + 1 ;
					//一开始这里给temp多加了一个1导致结果多了1.
					//搞清楚+1究竟要加在哪加几个
					int tempValue = (dp[i-1][j] < dp[i][j-1]) ? dp[i-1][j]: dp[i][j-1];
					dp[i][j] = (tempValue < dp[i-1][j-1]) ? tempValue + 1 : dp[i-1][j-1] + 1 ;
				}
			}
		}
		 		 
		 return dp[m][n];
	 }
}
