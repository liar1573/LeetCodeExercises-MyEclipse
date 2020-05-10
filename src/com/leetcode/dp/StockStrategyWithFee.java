/**StockStrategyWithFee.java
 * com.leetcode.dp
 * TODO
 * 714 交易次数不限，但是每次卖出时需要支付fee的手续费
 * @author liar
 * 2020年5月10日 上午9:56:08
 * @version 1.0
 */
package com.leetcode.dp;


public class StockStrategyWithFee {
	public int maxProfit(int[] prices, int fee) {
		//手续费的话感觉只需要在dp转移卖出股票时把手续费减掉即可
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
		//尝试用贪心试一下，不过自己手动推导的时候好像不行。。
		//确实对于[1,3,2,8,4,9]  2  的结果有问题
		int profit = 0;

		for(int i=0; i<prices.length-1; i++){
		    if(prices[i+1] - fee > prices[i])
		        profit += (prices[i+1] - fee - prices[i]);		  
		}

		return profit;
	}
}
