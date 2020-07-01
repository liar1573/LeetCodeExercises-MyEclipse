/**IndexRob2.java
 * com.leetcode.dp
 * TODO LC 213����ҽ��������档��������Ϊѭ�����飬����Ҫ�����һ�������Ӱ���һ�����ꡣ
 * @author liar
 * 2020��7��1�� ����7:55:27
 * @version 1.0
 */
package com.leetcode.dp;


public class IndexRob2 {
	public int rob(int[] nums) {
		if(nums.length == 0)  return 0;
		if(nums.length == 1)  return nums[0];
		
        int max1 = subRob(nums, 1, nums.length - 1);
        int max2 = subRob(nums, 0, nums.length - 2);
        
        return (max1 > max2) ? max1 : max2;
    }
	
	public int subRob(int[] nums,int start, int end) {
        if(start > end) return 0;//��Ч����	
        if(start == end) return nums[start];
        int result = nums[start];
        
        int pre = 0, current = nums[start];
        for(int i = start + 1; i < end; i++){
        	int temp = Math.max(pre + nums[i], current);
        	result = Math.max(temp, result);
        	pre = current;
        	current = temp;
        }    
        return result;
    }
	
	
}
