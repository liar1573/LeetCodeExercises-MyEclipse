package com.leetcode;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//	Input: coins = [1, 2, 5], amount = 11 Output: 3
//			Explanation: 11 = 5 + 5 + 1
	
    public int coinChange(int[] coins, int amount) {
        //首先需要检查参数的合法性
    	//conis[]长度大于0（内部值均为正数），amount>0(等于0是否有意义？)
    	if ((null == coins)||(0 == coins.length)||(amount < 0)) {
			return -1;
		}
    	if (0 == amount) {
			return 0;//想了想amount=0好像也是合理的
		}//发现后来补充的解法不能amount = 0这种特殊情况包含进去
    	//对amount=0时一定会返回-1（其实amount=0时返回0应该就可以了）
    	
    	
    	int over = amount + 1;
    	//结合本题题设用来设置数值的上限并最后判断方案是否存在
    	int dp[] = new int[over];//为了保持下标与数值含义对齐+1
    	for (int i = 1; i < dp.length; i++) {
			dp[i] = over; 
		}
    	dp[0] = 0;
    	
    	for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i >= coins[j]) {
					dp[i] = (dp[i] < (dp[i - coins[j]] + 1)) ? dp[i] : (dp[i - coins[j]] + 1); 
				}
			}
		}
    	
    	return (dp[amount] < over) ? dp[amount]: -1;
    }
    
    public int recurrentChange(int[] coins, int amount) {
    	for (int i = 0; i < coins.length; i++) {
			if (amount < coins[i]) {//剩余金额小于当前面值，直接跳过
				continue;
			} else if (amount == coins[i]) {//刚好等于当前金额，返回一个硬币
				return 1;
			} else {//剩余金额大于当前面值，进行拆分
				return recurrentChange(coins, amount - coins[i]) + 1;
			}
		}
    	//但是单纯这样写好像没有记录最小值的功能
    	//而且这个递归写的有点乱，返回值太多了。。。
    	//从上到下的递归感觉有点问题
    	
    	return -1;
	}

}
