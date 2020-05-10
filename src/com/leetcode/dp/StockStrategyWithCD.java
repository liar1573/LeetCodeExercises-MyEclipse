/**StockStrategyWithCD.java
 * com.leetcode.dp
 * TODO
 * 309  交易次数不限，不过刚卖出股票时下一天无法买入（CD=1）
 * @author liar
 * 2020年5月10日 上午9:53:31
 * @version 1.0
 */
package com.leetcode.dp;


public class StockStrategyWithCD {
	public int maxProfit(int[] prices) {
        //然而参考大佬的笔记，发现处理框架依旧没变，就是把买入的时候的i-1换成了i-2
		//只不过在i-2的时候可能会越界需要特殊处理一下
		if(prices.length <=1)
        	return 0;
		
		int[] dp = new int[2];
		dp[1] = -prices[0];
		int dpPre = 0; //这里由于买入计算的时候会出现i-2的情况，需要额外增加一个临时变量方便编程
		
		for (int i = 1; i < prices.length; i++) {
			int tempValue = dp[0];
        	dp[0] = Math.max(dp[0], dp[1] + prices[i]);
        	dp[1] = Math.max(dp[1], dpPre - prices[i]);
        	dpPre = tempValue;//这里为什么要对dpPre赋值temp？？没太看懂。。
		}
		
		return dp[0];		
    }
}
