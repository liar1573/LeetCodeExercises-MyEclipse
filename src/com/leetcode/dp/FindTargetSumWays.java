/**
 * 
 */
package com.leetcode.dp;


public class FindTargetSumWays {
	public int findTargetSumWaysDFS(int[] nums, int S) {
		return dfs(nums, S, 0); 
	}
	
	int dfs(int[] nums, int S, int index){
		if(index == nums.length)
			return ((S == 0)? 1: 0);
		
		return dfs(nums, S - nums[index], index + 1) + dfs(nums, S + nums[index], index + 1);
	}
	
	
	public int findTargetSumWays(int[] nums, int S) {
		
		int sum = 0;
		for (int i = 0; i < nums.length; i++)
			sum += nums[i];	
		if(S > sum ||((S + sum) & 1) == 1)
			return 0;
		
//		if((sum & 1) == 1)
//			return 0;//如果无法被2整除肯定不存在
		sum = (sum + S)/2;
//		if(sum > max)
//			return 0;//nums中有数值太大无法分割
//		if(sum == max)
//			return 1; //仅有唯一的解
		//由于nums数组中运行含有任意个0，而0值的存在不会改变综合但是会影响方法数量，所以sum==max的时候也不能唯一确定ans=1了
		
		
		int[] dp = new int[sum + 1];
//		dp[nums[0]] = 1; dp[0] = 1;
		dp[0] = 1;
		//这里不能再对dp[nums[0]]赋初始值了，因为sum的上限sum = (sum + S)/2有可能会比 nums[0]要小
//		for (int i = 1; i < nums.length; i++) {
		//同时i的下标也需要从0开始，而不能从1开始了
		for (int i = 0; i < nums.length; i++) {
//			for (int j = sum; j > 0; j--) {
			for (int j = sum; j >= nums[i]; j--) {
				dp[j] = dp[j] + dp[j - nums[i]];   
			}
		}
		return dp[sum];
	}
	
	public int findTargetSumWaysLC(int[] nums, int S) {
		//LC官方的解法，其实也挺好理解的
        int[] dp = new int[2001];
        dp[nums[0] + 1000] = 1;
        dp[-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            int[] next = new int[2001];
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[sum + 1000] > 0) {
                    next[sum + nums[i] + 1000] += dp[sum + 1000];
                    next[sum - nums[i] + 1000] += dp[sum + 1000];
                }
            }
            dp = next;
        }
        return S > 1000 ? 0 : dp[S + 1000];
    }
	
	
}
