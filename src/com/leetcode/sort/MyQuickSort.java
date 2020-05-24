/**MyQuickSort.java
 * com.leetcode.sort
 * TODO
 * 自己复习手动实现一遍快排
 * 在上边界high的处理时一开始遇到了一点问题。后来同一设置初始调用使用arr.length-1，递归过程中都使用high就正常了
 * @author liar
 * 2020年5月24日 上午10:58:54
 * @version 1.0
 */
package com.leetcode.sort;


public class MyQuickSort {
	public static void main(String[] args){
		int[] arr = {7,2,5,3,1,4,6};
		quickSort(arr, 0, arr.length - 1);
		for (int i : arr) {
			System.out.println(i);
		}
	}
	
	public static void quickSort(int[] arr, int low, int high) {
		//这里high参数直接用length，函数内部再减1好了，这样感觉调用起来更方便一些
		if(low < high){
			int pivot = partition(arr, low, high);
			quickSort(arr, low, pivot - 1);
			quickSort(arr, pivot + 1,  high);
		}
		//第一次运行结果有点问题，好像是边界处理的原因？？high-1？
		//果然是边界问题，这里递归时上边界high-1的处理太多了，导致有些边界地方没有操作到
		//还是老老实实的递归调用的时候都用high，只有函数入口是用len-1好了
	}
	
	public static int partition(int[] arr, int low, int high) {
		int temp = arr[low];
		while(low < high){
			while(arr[high] > temp && low < high)
				high--;
			arr[low] = arr[high];
			while(arr[low] < temp && low < high)
				low++;
			arr[high] = arr[low];
		}
		arr[low] = temp;
		return low;
	}
}
