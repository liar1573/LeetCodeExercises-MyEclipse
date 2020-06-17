/**GetSmallestKNumbers.java
 * com.nowcoder.aimforoffer.array
 * TODO
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * @author liar
 * 2020年6月17日 下午2:57:20
 * @version 1.0
 */
package com.nowcoder.aimforoffer.array;

import java.util.ArrayList;

public class GetSmallestKNumbers {
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(k <= 0 || input == null || input.length == 0 || k > input.length)
        	return result; //根据OJ提交提示，k >n的时候好像也要返回空集合
        
        partQuickSort(input, 0, input.length - 1, k);
        for (int i = 0; i < k; i++)
        	result.add(input[i]);
        
        return result;
    }
	
	public static void partQuickSort(int[] nums, int low, int high,int k) {
		//为求最小K个数的特殊部分快排
		if(low >= high)
			return;

		int pivot = partion(nums, low, high);
		if(pivot == k-1){
			return;
		}else if (pivot < k-1) {
			partQuickSort(nums, pivot + 1, high, k);
		}else {
			partQuickSort(nums, low, pivot - 1, k);
		}
		
	}
	
	public static int partion(int[] nums, int left, int right) {
		//第三次尝试，参考以前的笔记
		int pivotValue = nums[left];
		int low = left,high = right;
		while(low < high){
			//当中轴选第一个数的时候，来回遍历从大的数值往小遍历就可以解决中轴位置空缺问题了
			while (nums[high] > pivotValue && high > low)
				high--;
			nums[low] = nums[high];
			while(nums[low] <= pivotValue && low < high)
				low++;
			nums[high] = nums[low];
		}
		nums[low] = pivotValue;
		return low;
	}
	
}
