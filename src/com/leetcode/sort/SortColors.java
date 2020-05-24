/**SortColors.java
 * com.leetcode.sort
 * TODO
 * LC75，排序颜色数组。int[]中只有0、1、2三种值对应三种颜色。需要将其按照升序排列
 *给了额外的要求，不允许使用内置库的排序函数。而且要求最好一次遍历同时使用常数空间。
 * @author liar
 * 2020年5月24日 上午10:04:28
 * @version 1.0
 */
package com.leetcode.sort;


public class SortColors {
	
	public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length-1);
    }
	
	private void quickSort(int[] arr, int low, int high) {

		if (low < high) {
			// 找寻基准数据的正确索引
			int index = getIndex(arr, low, high);

			// 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
			//quickSort(arr, 0, index - 1);//这里据说是笔误，0应该换成low
			quickSort(arr, low, index - 1); 
			quickSort(arr, index + 1, high);
		}

	}

	private int getIndex(int[] arr, int low, int high) {
		// 基准数据
		int tmp = arr[low];
		while (low < high) {
			// 当队尾的元素大于等于基准数据时,向前挪动high指针
			while (low < high && arr[high] >= tmp) {
				high--;
			}
			// 如果队尾元素小于tmp了,需要将其赋值给low
			arr[low] = arr[high];
			// 当队首元素小于等于tmp时,向前挪动low指针
			while (low < high && arr[low] <= tmp) {
				low++;
			}
			// 当队首元素大于tmp时,需要将其赋值给high
			arr[high] = arr[low];

		}
		// 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
		// 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
		arr[low] = tmp;
		return low; // 返回tmp的正确位置
	}
	
	
	 public void sortColorsDijkstra(int[] nums) {
		 //Dijkstra 3-way partitioning
	        int i = 0;
	        int lt = 0;
	        int gt = nums.length - 1;
			
			// ___________________________________________________
			// |     <1     |     =1     |          |     >1     |
			// –––––––––––––––––––––––––––––––––––––––––––––––––––
			//              lt           i          gt
	        while (i <= gt) {
	            if (nums[i] < 1) { // nums[i] == 0
	                swap(nums, lt, i);
	                lt++;
	                i++;
	            } else if (nums[i] > 1) { // nums[i] == 2
	                swap(nums, i, gt);
	                gt--;
	            } else { // nums[i] == 1
	                i++;
	            }
	        }
	    }

	    private void swap(int[] a, int i, int j) {
	        int temp = a[i];
	        a[i] = a[j];
	        a[j] = temp;
	    }
}
