/**StockStrategy2.java
 * com.leetcode.dp
 * TODO
 * LC-122，股票系列问题，交易次数不限的情况（好像是可以用贪心）
 * @author liar
 * 2020年5月9日 上午10:25:04
 * @version 1.0
 */
package com.leetcode.dp;


public class StockStrategy2 {
	public int maxProfitDP(int[] prices) {
        if(prices.length <=1)
        	return 0;
        //这里至少要排除prices.len=0的情况，否则赋初始值会越界
        
        int[][] dp = new int[2][2];
        //由于这里可以用贪心，所以基本上不需要记录前面的状态，只需要两个变量即可
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
        	//试了下这里好像不太方便直接用纯粹的贪心，还是得用dp迭代
        	dp[i % 2][0] = Math.max(dp[(i- 1) % 2][0], dp[(i- 1) % 2][1] + prices[i]);
        	dp[i % 2][1] = Math.max(dp[(i- 1) % 2][1], dp[(i- 1) % 2][0] - prices[i]);
        	//这里只是用2个变量是不是不够用啊。。
        	//确实，感觉至少要2*2=4的遍历才能完整记录不会丢失
        	
//			if(prices[i] < prices[i+1])
//				dp[1] = -prices[i];
//			
//			if (prices[i] > prices[]) {
//				
//			}
		}
        
        
        
        return (dp[0][0] > dp[1][0]) ? dp[0][0] : dp[1][0]; // 最后手头上肯定是没有股票的
    }
	
	public int maxProfitDPImproved(int[] prices) {
		//DP解法的优化写法，在for循环中使用临时变量，去掉麻烦的%2操作
		if(prices.length <=1)
        	return 0;
		
		int[] dp = new int[2];
		dp[1] = -prices[0];
		for (int i = 1; i < prices.length; i++) {
        	//试了下这里好像不太方便直接用纯粹的贪心，还是得用dp迭代
			int tempValue = dp[0];
        	dp[0] = Math.max(dp[0], dp[1] + prices[i]);
        	dp[1] = Math.max(dp[1], tempValue - prices[i]);
		}
		
		return dp[0];
	}

	public int maxProfitGreedy(int[] prices) {
		//搜了下评论区这道题确实是有贪心解法的，不过理解起来稍微绕一点
		//比如[0,3,5]的例子，虽然看上去好像是0的时候买入3的时候就卖了，
		//但是由于每一段都会结算(i+1)-i，所以最终总和与0买入5卖出的时候是一样的
		int profit = 0;

		for(int i=0; i<prices.length-1; i++){
		    if(prices[i+1] > prices[i])
		        profit += (prices[i+1] - prices[i]);		  
		}

		return profit;
	}
}
