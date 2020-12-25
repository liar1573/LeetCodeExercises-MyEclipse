/**
 * LC26.ɾ�����������е��ظ��Ҫ��ԭ��ɾ����ֻ����ʹ�ó����ռ�����ܶ����������飩��
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
		
//		return (slow + 1); //ע���±���Ԫ�ظ�ʽ֮��Ĺ�ϵ
		return slow; 
    }

}
