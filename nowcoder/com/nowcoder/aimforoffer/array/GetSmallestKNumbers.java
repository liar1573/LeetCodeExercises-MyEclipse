/**GetSmallestKNumbers.java
 * com.nowcoder.aimforoffer.array
 * TODO
 * ����n���������ҳ�������С��K��������������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,��
 * @author liar
 * 2020��6��17�� ����2:57:20
 * @version 1.0
 */
package com.nowcoder.aimforoffer.array;

import java.util.ArrayList;

public class GetSmallestKNumbers {
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(k <= 0 || input == null || input.length == 0 || k > input.length)
        	return result; //����OJ�ύ��ʾ��k >n��ʱ�����ҲҪ���ؿռ���
        
        partQuickSort(input, 0, input.length - 1, k);
        for (int i = 0; i < k; i++)
        	result.add(input[i]);
        
        return result;
    }
	
	public static void partQuickSort(int[] nums, int low, int high,int k) {
		//Ϊ����СK���������ⲿ�ֿ���
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
		//�����γ��ԣ��ο���ǰ�ıʼ�
		int pivotValue = nums[left];
		int low = left,high = right;
		while(low < high){
			//������ѡ��һ������ʱ�����ر����Ӵ����ֵ��С�����Ϳ��Խ������λ�ÿ�ȱ������
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
