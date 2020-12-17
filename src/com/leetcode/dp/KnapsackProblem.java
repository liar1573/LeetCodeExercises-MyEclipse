/**
 * 背包问题汇总
 */
package com.leetcode.dp;

/**
 * @author liar-pc
 *
 */
public class KnapsackProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] weight = {2,2,6,5,4};
		int[] value =  {6,3,5,4,6};
		int maxWeight = 10; //当target=10的时候，返回值为15，解集为{{2,6},{2,3},{4,6}}
		KnapsackProblem test = new KnapsackProblem();
		System.out.println(test.bag01(weight, value, maxWeight));
		
	}
	
	int bag01(int[] weight, int[] value, int maxWeight){
		//为了避免无意义的讨论，默认元素非空，最大质量要求大于0
		int[][] dp = new int[weight.length][maxWeight + 1];
		//其中 dp[i][j] 表示前 i 件物品体积/质量不超过 j 的情况下能达到的最大价值
		
		//下标为0位置的初始化
		if(weight[0] <= maxWeight){
			for (int j = weight[0]; j <= maxWeight; j++) {
				dp[0][j] = value[0]; 
			}
		}
			dp[0][weight[0]] = value[0];
		
		for (int i = 1; i < dp.length; i++) {
			//for (int j = 1; j < dp[0].length; j++) {
				for (int j = 1; j < dp[0].length; j++) {
				if(weight[i] <= j){
					dp[i][j] = (dp[i-1][j] > (dp[i-1][j - weight[i]] + value[i]))? dp[i-1][j]: (dp[i-1][j - weight[i]] + value[i]); 
				}else {
					dp[i][j] = dp[i-1][j]; 
				}
			}
		}
		
		//for(j) {for(i)}  再一次通过实际编码确认，循环index和weight的嵌套顺序没有影响
		
		return dp[weight.length - 1][maxWeight];
	}
	
	
}
