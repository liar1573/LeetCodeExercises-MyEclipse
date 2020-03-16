package com.leetcode;
/**GreedyStock.java
 * 
 * TODO
 * @author liar
 * 2020年2月6日 下午8:31:20
 * @version 1.0
 */

/**
 * @author liar
 *
 */
public class GreedyStock {

	/**
	 * @Description: TODO
	 * @para: @param args
	 * @return: void
	 * @throws: @param args
	 * @author: liar
	 * @date: 2020年2月6日 下午8:31:20
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {7,1,5,3,6,4};
//		int[] prices = {7};
		System.out.println(greedy(prices));
	}
	
	public static int greedy(int[] prices){
		int profit = 0;int temp = prices[0];
		
		for (int i = 1; i < prices.length; i++) {
			if (temp < prices[i]) {
				profit += (prices[i] - temp);
				if (i+1 < prices.length) {
					temp = prices[i+1];
					i++;
				}
			} else {
				temp = prices[i];
			}
		}
		
		return profit;
	}
	
	

}
