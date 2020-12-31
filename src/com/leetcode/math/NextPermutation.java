/**
 * 
 */
package com.leetcode.math;


public class NextPermutation {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextPermutation test = new NextPermutation();
		int[] arr = {1,3,2};
		test.nextPermutation(arr);
	}
	
	public void nextPermutation(int[] nums) {
		if(nums.length <= 1)
			return;
		
		int small = 0;
		for (int i = nums.length - 2; i >= 0 ; i--) { //注意到这里虽然有两层for，但是每一层都有break，所以复杂度仍为N
			if(nums[i] < nums[i+1]){
				for (int j = nums.length - 1; j > i ; j--) {
					if(nums[j] > nums[i]){
						swap(nums, i, j);
						break;
					}
				}
				small = i+1;
				break;
			}
		}
		reverseArray(nums, small, nums.length - 1);
    }
	
	public void reverseArray(int[] nums, int left, int right) {
		int len = right - left + 1;
		//for (int i = left; i < len / 2; i++) { 一开始下标又出了小问题。。。
//			int temp = nums[i];
//			nums[i] = nums[right - i];
//			nums[right - i] = temp; 
//		}
		for (int i = 0; i < len / 2; i++) {
			int temp = nums[left + i];
			nums[left + i] = nums[right - i];
			nums[right - i] = temp; 
		}
	}
	

	
	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}//JDK内置的Collections.swap(array, j, i);可以实现交换操作，不过自己写一个也还好
	
	//官方实现翻转的代码看起来很简洁
    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
