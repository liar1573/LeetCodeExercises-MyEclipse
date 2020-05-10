/**StockStrategyWithCD.java
 * com.leetcode.dp
 * TODO
 * 309  ���״������ޣ�������������Ʊʱ��һ���޷����루CD=1��
 * @author liar
 * 2020��5��10�� ����9:53:31
 * @version 1.0
 */
package com.leetcode.dp;


public class StockStrategyWithCD {
	public int maxProfit(int[] prices) {
        //Ȼ���ο����еıʼǣ����ִ���������û�䣬���ǰ������ʱ���i-1������i-2
		//ֻ������i-2��ʱ����ܻ�Խ����Ҫ���⴦��һ��
		if(prices.length <=1)
        	return 0;
		
		int[] dp = new int[2];
		dp[1] = -prices[0];
		int dpPre = 0; //����������������ʱ������i-2���������Ҫ��������һ����ʱ����������
		
		for (int i = 1; i < prices.length; i++) {
			int tempValue = dp[0];
        	dp[0] = Math.max(dp[0], dp[1] + prices[i]);
        	dp[1] = Math.max(dp[1], dpPre - prices[i]);
        	dpPre = tempValue;//����ΪʲôҪ��dpPre��ֵtemp����û̫��������
		}
		
		return dp[0];		
    }
}
