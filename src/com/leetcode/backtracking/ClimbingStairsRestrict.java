/**
 * 小杰参加的华为笔试题
 * 给出一个楼梯的阶数N，每一次都可以爬1、2、3、...N阶，
 * 但是要求每次爬的阶数不能与前两次中的任何一次相等。输出最后所有的爬楼梯的方法
 */
package com.leetcode.backtracking;

import java.util.ArrayList;

public class ClimbingStairsRestrict {

	public static int n = 1;
	public static long counter = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for(n = 1;n < 20;n++ ){
//			ArrayList<Integer> list = new ArrayList<Integer>();
//			list.add(0); list.add(0);
//			dfs(list, 0);
//			
//			System.out.println("n = " + n + " results = " + counter);
//			counter = 0;
//		}
		
		n = 42;
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0); list.add(0);
		dfs(list, 0);
		
		System.out.println("n = " + n + " results = " + counter);

	}
	
	public static void dfs(ArrayList<Integer> list, int sum){
		if(sum == n){
			counter++;
//			printList(list);
			return;
		}			
			
		int temp1 = list.get(list.size() - 1);
		int temp2 = list.get(list.size() - 2);
		
		for (int i = 1; i <= n; i++) {
			if(i == temp1 || i == temp2)
				continue;
			if (sum + i <= n) {
				list.add(i);	dfs(list, sum + i); list.remove(list.size() - 1);
			}else {
				break;
			}
		}
		
	}
	
	public static void printList(ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}
	
	
	//汪珙的dp解法
//	int ClimbingStairsRestrict(int n){
//		//dp[i][j] 爬i楼梯阶数,最后一步为j的总走法数
//		vector<vector<int>> dp(n+1,vector<int>(n+1,0));
//		//等价与Java语法
//		//int[][] dp = new int[n+1][n+1];
//		
//		for (int i = 1; i <= n; i++){
//			//i为当前需要爬的楼梯阶数
//			for (int j = 1; j <= i; j++){
//				if(i==j){
//					dp[i][j]+=1;
//					break;
//				}
//				//只回退一步 //这里的注释“只回退一步”是什么意思？？
//				if(j!=i-j){
//					dp[i][i-j]+=1;
//				}
//				//j为最后一步
//				int sum=0;
//				//dp[i][j] 爬i楼梯阶数,最后一步为j的总走法数
//				for(int k=1;k<=i-j;k++) 
//				{
//					if(j!=k)//k为上一步的走的阶数所以需要排除
//						for (int w = 1; w <= i-j-k; w++)
//						{
//							//w为倒数第二步走的阶数
//							if(j!=w)
//								sum+=dp[i-j-k][w];
//						}
//				}
//				dp[i][j]=sum;
//			}
//		}
//
//		int sum=0;
//		for(int i=1;i<=n;i++)
//		{
//			sum+=dp[n][i];
//		}
//		return sum;
//	}


}
