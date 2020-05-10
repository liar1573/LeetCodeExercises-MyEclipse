/**StockStrategyWithFee.java
 * com.leetcode.dp
 * TODO
 * 714 ���״������ޣ�����ÿ������ʱ��Ҫ֧��fee��������
 * @author liar
 * 2020��5��10�� ����9:56:08
 * @version 1.0
 */
package com.leetcode.dp;


public class StockStrategyWithFee {
	public int maxProfit(int[] prices, int fee) {
		//�����ѵĻ��о�ֻ��Ҫ��dpת��������Ʊʱ�������Ѽ�������
        if(prices.length <=1)
        	return 0;
        
        int[] dp = new int[2];
        dp[1] = -prices[0];
        
        for (int i = 1; i < prices.length; i++) {
			int tempValue = dp[0];
			dp[0] = Math.max(dp[0], dp[1] + prices[i] - fee);
			dp[1] = Math.max(dp[1], tempValue - prices[i]); 
		}
        
        return dp[0];
    }
	
	public int maxProfitGreedy(int[] prices, int fee) {
		//������̰����һ�£������Լ��ֶ��Ƶ���ʱ������С���
		//ȷʵ����[1,3,2,8,4,9]  2  �Ľ��������
		int profit = 0;

		for(int i=0; i<prices.length-1; i++){
		    if(prices[i+1] - fee > prices[i])
		        profit += (prices[i+1] - fee - prices[i]);		  
		}

		return profit;
	}
}
