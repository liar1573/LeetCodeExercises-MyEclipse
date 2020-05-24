/**MyQuickSort.java
 * com.leetcode.sort
 * TODO
 * �Լ���ϰ�ֶ�ʵ��һ�����
 * ���ϱ߽�high�Ĵ���ʱһ��ʼ������һ�����⡣����ͬһ���ó�ʼ����ʹ��arr.length-1���ݹ�����ж�ʹ��high��������
 * @author liar
 * 2020��5��24�� ����10:58:54
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
		//����high����ֱ����length�������ڲ��ټ�1���ˣ������о���������������һЩ
		if(low < high){
			int pivot = partition(arr, low, high);
			quickSort(arr, low, pivot - 1);
			quickSort(arr, pivot + 1,  high);
		}
		//��һ�����н���е����⣬�����Ǳ߽紦���ԭ�򣿣�high-1��
		//��Ȼ�Ǳ߽����⣬����ݹ�ʱ�ϱ߽�high-1�Ĵ���̫���ˣ�������Щ�߽�ط�û�в�����
		//��������ʵʵ�ĵݹ���õ�ʱ����high��ֻ�к����������len-1����
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
