/**IndexRob.java
 * com.leetcode.dp
 * TODO
 * 198. ��ҽ��� ����ȡ�����������±�Ľ�Ǯ
 * @author liar
 * 2020��7��1�� ����1:09:01
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

}
