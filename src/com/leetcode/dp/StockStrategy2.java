/**StockStrategy2.java
 * com.leetcode.dp
 * TODO
 * LC-122����Ʊϵ�����⣬���״������޵�����������ǿ�����̰�ģ�
 * @author liar
 * 2020��5��9�� ����10:25:04
 * @version 1.0
 */
package com.leetcode.dp;


public class StockStrategy2 {
	public int maxProfitDP(int[] prices) {
        if(prices.length <=1)
        	return 0;
        //��������Ҫ�ų�prices.len=0����������򸳳�ʼֵ��Խ��
        
        int[][] dp = new int[2][2];
        //�������������̰�ģ����Ի����ϲ���Ҫ��¼ǰ���״̬��ֻ��Ҫ������������
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
        	//�������������̫����ֱ���ô����̰�ģ����ǵ���dp����
        	dp[i % 2][0] = Math.max(dp[(i- 1) % 2][0], dp[(i- 1) % 2][1] + prices[i]);
        	dp[i % 2][1] = Math.max(dp[(i- 1) % 2][1], dp[(i- 1) % 2][0] - prices[i]);
        	//����ֻ����2�������ǲ��ǲ����ð�����
        	//ȷʵ���о�����Ҫ2*2=4�ı�������������¼���ᶪʧ
        	
//			if(prices[i] < prices[i+1])
//				dp[1] = -prices[i];
//			
//			if (prices[i] > prices[]) {
//				
//			}
		}
        
        
        
        return (dp[0][0] > dp[1][0]) ? dp[0][0] : dp[1][0]; // �����ͷ�Ͽ϶���û�й�Ʊ��
    }
	
	public int maxProfitDPImproved(int[] prices) {
		//DP�ⷨ���Ż�д������forѭ����ʹ����ʱ������ȥ���鷳��%2����
		if(prices.length <=1)
        	return 0;
		
		int[] dp = new int[2];
		dp[1] = -prices[0];
		for (int i = 1; i < prices.length; i++) {
        	//�������������̫����ֱ���ô����̰�ģ����ǵ���dp����
			int tempValue = dp[0];
        	dp[0] = Math.max(dp[0], dp[1] + prices[i]);
        	dp[1] = Math.max(dp[1], tempValue - prices[i]);
		}
		
		return dp[0];
	}

	public int maxProfitGreedy(int[] prices) {
		//�����������������ȷʵ����̰�Ľⷨ�ģ��������������΢��һ��
		//����[0,3,5]�����ӣ���Ȼ����ȥ������0��ʱ������3��ʱ������ˣ�
		//��������ÿһ�ζ������(i+1)-i�����������ܺ���0����5������ʱ����һ����
		int profit = 0;

		for(int i=0; i<prices.length-1; i++){
		    if(prices[i+1] > prices[i])
		        profit += (prices[i+1] - prices[i]);		  
		}

		return profit;
	}
}
