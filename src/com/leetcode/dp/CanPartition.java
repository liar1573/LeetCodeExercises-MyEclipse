/**
 * LC416，分割等和子集。这道题某种程度上可以看做是0-1背包问题的一个变形
 */
package com.leetcode.dp;


public class CanPartition {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CanPartition test = new CanPartition();
		int[] arr = {2,2,3,5}; 
		
		System.out.println(test.canPartitionNSpace(arr));

	}
	
	 public boolean canPartition(int[] nums) {
        if(nums.length < 2)
            return false;
        int sum = 0;
        int maxNum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            maxNum = (maxNum > nums[i]) ? maxNum: nums[i];
        }
        if((sum & 1) == 1)
            return false;
        sum = sum / 2;
        if(maxNum > sum)
        	return false;
        if(maxNum == sum)
        	return true;

        boolean[][] dp = new boolean[nums.length][sum + 1];
        for(int i = 0; i < nums.length; i++)
            dp[i][0] = true;
      //前方有maxNum的判断，这里就不需要担心nums[0]越界了
        // if(nums[0] < nums.length)
        //     dp[0][nums[0]] = true;

         for(int i = 1; i < dp.length; i++){
             for(int j = 1; j < dp[0].length; j++){
                 if(nums[i] <= j)
                     dp[i][j] = (dp[i - 1][j - nums[i]])||(dp[i - 1][j]);
                 else
                     dp[i][j] = dp[i - 1][j];
             }
         }
//        for(int j = 1; j < dp[0].length; j++){
//            for(int i = 1; i < dp.length; i++){
//                if(nums[i] <= j)
////                    dp[i][j] = (dp[i][j - nums[i]])||(dp[i - 1][j]); 
         		//妈个鸡，逐行调试了半天，发现是自己DP转移式中间有一个下标-1给弄掉了，所以数值每次都差一点。。。
//                	dp[i][j] = (dp[i - 1][j - nums[i]])||(dp[i - 1][j]);
//                else
//                    dp[i][j] = dp[i-1][j];
//            }
//        }

        return dp[nums.length - 1][sum];
	}
	 
	 public boolean canPartitionNSpace(int[] nums) {
		 if(nums.length < 2)
	            return false;
	        int sum = 0;
	        int maxNum = 0;
	        for(int i = 0; i < nums.length; i++){
	            sum += nums[i];
	            maxNum = (maxNum > nums[i]) ? maxNum: nums[i];
	        }
	        if((sum & 1) == 1)
	            return false;
	        sum = sum / 2;
	        if(maxNum > sum)
	        	return false;
	        if(maxNum == sum)
	        	return true;

	        boolean[] dp = new boolean[sum + 1];
	        dp[0] = true;dp[nums[0]] = true;
	        //后面看了一下，只需要初始化dp[0]即可，dp[0][nums[0]]可以从下标0自动推导

	         for(int i = 1; i < nums.length; i++){
        	//  for(int j = 1; j < dp.length; j++){
                for (int j = sum; j >= 1; j--) {   	 
	                 if(nums[i] <= j)
	                     dp[j] = (dp[j - nums[i]])||(dp[j]);
	                 else
	                     dp[j] = dp[j];
	             }
	         }

	        return dp[sum];
	 }
}
