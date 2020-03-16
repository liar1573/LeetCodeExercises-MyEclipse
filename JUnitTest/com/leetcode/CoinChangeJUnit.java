package com.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class CoinChangeJUnit {
	
	@Test
	public void coinChange(int[] coins, int amount) {
		CoinChange cc = new CoinChange();
		int[] test = {1,2,5};
//		cc.coinChange(test, 11);
//		System.out.println(cc.coinChange(test, 11));
		assertEquals(3, cc.coinChange(test, 11));
	}
}
