/**CoinChange2.java
 * com.leetcode.dp
 * TODO
 * 给定不同面额的硬币和一个总金额。
 * 写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
 * @author liar
 * 2020年6月22日 上午9:13:48
 * @version 1.0
 */
package com.leetcode.dp;

import java.util.Arrays;

public class CoinChange2 {
	public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        
        //注意到模式2的遍历模式跟模式1的差别有点大
        
        for (int coin : coins) {//这里把coin放到了外层循环，模式1中coin处于内层循环
			for (int x = coin; x < amount + 1; x++)
				dp[x] += dp[x - coin]; 
		}
        
        
//        for (int i = 1; i < dp.length; i++) {
//			for (int j = 0; j < coins.length; j++) {
//				if(i == coins[j])
//					dp[i] = 1; 
//			}
//		}
        
        
        return dp[amount];
    }
	
	public int changeMode1(int amount, int[] coins) {
		//注意到这里有一堆非法情况，这次没有考虑也通过了
		//比如amount=0，数组为空，coins.length = 0这类的
		
		//顺便回顾一下第一种情况是如何解决的
        int[] dp = new int[amount + 1];
        //由于情况1只需要求最小硬币数量，初始化只要设定为amount+1即可（因为最小硬币金额是1
        Arrays.fill(dp, amount + 1); 
        dp[0] = 0;
        
        for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < coins.length; j++) {
				if(i - coins[j] >= 0 )
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1); 
			}
		}
        
        
        return (dp[amount] < amount + 1)? dp[amount]: -1;
    }
}
