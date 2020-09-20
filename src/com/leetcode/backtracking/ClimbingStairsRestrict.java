/**
 * С�ܲμӵĻ�Ϊ������
 * ����һ��¥�ݵĽ���N��ÿһ�ζ�������1��2��3��...N�ף�
 * ����Ҫ��ÿ�����Ľ���������ǰ�����е��κ�һ����ȡ����������е���¥�ݵķ���
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
	
	
	//�����dp�ⷨ
//	int ClimbingStairsRestrict(int n){
//		//dp[i][j] ��i¥�ݽ���,���һ��Ϊj�����߷���
//		vector<vector<int>> dp(n+1,vector<int>(n+1,0));
//		//�ȼ���Java�﷨
//		//int[][] dp = new int[n+1][n+1];
//		
//		for (int i = 1; i <= n; i++){
//			//iΪ��ǰ��Ҫ����¥�ݽ���
//			for (int j = 1; j <= i; j++){
//				if(i==j){
//					dp[i][j]+=1;
//					break;
//				}
//				//ֻ����һ�� //�����ע�͡�ֻ����һ������ʲô��˼����
//				if(j!=i-j){
//					dp[i][i-j]+=1;
//				}
//				//jΪ���һ��
//				int sum=0;
//				//dp[i][j] ��i¥�ݽ���,���һ��Ϊj�����߷���
//				for(int k=1;k<=i-j;k++) 
//				{
//					if(j!=k)//kΪ��һ�����ߵĽ���������Ҫ�ų�
//						for (int w = 1; w <= i-j-k; w++)
//						{
//							//wΪ�����ڶ����ߵĽ���
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
