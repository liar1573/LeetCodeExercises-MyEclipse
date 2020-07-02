/**IndexRob.java
 * com.leetcode.dp
 * TODO
 * 198. 打家劫舍 不能取出两个连续下标的金钱
 * @author liar
 * 2020年7月1日 下午1:09:01
 * @version 1.0
 */
package com.leetcode.dp;


public class IndexRob {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3,1};
		IndexRob test = new IndexRob();
		System.out.println(test.rob(arr));
	}
	
	public int rob(int[] nums) {
        if(nums.length == 0)  return 0;

        //int[] dp = new int[nums.length + 1];
        //dp[1] = nums[0];
        int pre = 0, current = nums[0];
        int result = nums[0];
        for(int i = 1; i < nums.length; i++){
        	int temp = Math.max(pre + nums[i], current);
            //dp[i + 1] = Math.max(dp[i - 1] + nums[i], dp[i]);
            //result = Math.max(dp[i+1], result);
        	result = Math.max(temp, result);
        	pre = current;
        	current = temp;
        }

        return result;
    }
	
	public int dfsRob(int[] nums, int index) {
		if(index >= nums.length)  return 0;
		if(index >= nums.length - 1)  return nums[nums.length - 1];
		
		int max1 = dfsRob(nums, index + 1);
		int max2 = dfsRob(nums, index + 2) + nums[index];
		
		return (max1 > max2) ? max1 : max2;
	}
	
	public int dfsRobWithMemo(int[] nums, int index, int[] memo) {
		if(index >= nums.length)  return 0;
		if(index >= nums.length - 1){
			memo[index] = nums[nums.length - 1];
			return nums[nums.length - 1];
		}
		
		if(memo[index] >= 0)
			return memo[index];
		
		
		int max1 = dfsRobWithMemo(nums, index + 1, memo);
		int max2 = dfsRobWithMemo(nums, index + 2, memo) + nums[index];
		
		memo[index] = (max1 > max2) ? max1 : max2;
		return memo[index];
	}

}
