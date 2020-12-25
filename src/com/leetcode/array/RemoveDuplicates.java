/**
 * LC26.删除排序数组中的重复项，要求原地删除（只允许使用常量空间而不能额外申请数组）。
 */
package com.leetcode.array;


public class RemoveDuplicates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int removeDuplicates(int[] nums) {
		if(nums.length <= 1)
			return nums.length;
		
		int slow = 1;
		
		for (int fast = 1; fast < nums.length; fast++) {
			if(nums[fast] != nums[fast - 1]){
				nums[slow] = nums[fast];
				slow++;
			}	
		}
		
//		return (slow + 1); //注意下标与元素格式之间的关系
		return slow; 
    }

}
