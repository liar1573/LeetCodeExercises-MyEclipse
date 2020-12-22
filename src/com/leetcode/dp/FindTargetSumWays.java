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
//			return 0;//����޷���2�����϶�������
		sum = (sum + S)/2;
//		if(sum > max)
//			return 0;//nums������ֵ̫���޷��ָ�
//		if(sum == max)
//			return 1; //����Ψһ�Ľ�
		//����nums���������к��������0����0ֵ�Ĵ��ڲ���ı��ۺϵ��ǻ�Ӱ�췽������������sum==max��ʱ��Ҳ����Ψһȷ��ans=1��
		
		
		int[] dp = new int[sum + 1];
//		dp[nums[0]] = 1; dp[0] = 1;
		dp[0] = 1;
		//���ﲻ���ٶ�dp[nums[0]]����ʼֵ�ˣ���Ϊsum������sum = (sum + S)/2�п��ܻ�� nums[0]ҪС
//		for (int i = 1; i < nums.length; i++) {
		//ͬʱi���±�Ҳ��Ҫ��0��ʼ�������ܴ�1��ʼ��
		for (int i = 0; i < nums.length; i++) {
//			for (int j = sum; j > 0; j--) {
			for (int j = sum; j >= nums[i]; j--) {
				dp[j] = dp[j] + dp[j - nums[i]];   
			}
		}
		return dp[sum];
	}
	
	public int findTargetSumWaysLC(int[] nums, int S) {
		//LC�ٷ��Ľⷨ����ʵҲͦ������
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
