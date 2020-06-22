/**CoinChange2.java
 * com.leetcode.dp
 * TODO
 * ������ͬ����Ӳ�Һ�һ���ܽ�
 * д��������������Դճ��ܽ���Ӳ�������������ÿһ������Ӳ�������޸��� 
 * @author liar
 * 2020��6��22�� ����9:13:48
 * @version 1.0
 */
package com.leetcode.dp;

import java.util.Arrays;

public class CoinChange2 {
	public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        
        //ע�⵽ģʽ2�ı���ģʽ��ģʽ1�Ĳ���е��
        
        for (int coin : coins) {//�����coin�ŵ������ѭ����ģʽ1��coin�����ڲ�ѭ��
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
		//ע�⵽������һ�ѷǷ���������û�п���Ҳͨ����
		//����amount=0������Ϊ�գ�coins.length = 0�����
		
		//˳��ع�һ�µ�һ���������ν����
        int[] dp = new int[amount + 1];
        //�������1ֻ��Ҫ����СӲ����������ʼ��ֻҪ�趨Ϊamount+1���ɣ���Ϊ��СӲ�ҽ����1
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
