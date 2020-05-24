/**SortColors.java
 * com.leetcode.sort
 * TODO
 * LC75��������ɫ���顣int[]��ֻ��0��1��2����ֵ��Ӧ������ɫ����Ҫ���䰴����������
 *���˶����Ҫ�󣬲�����ʹ�����ÿ��������������Ҫ�����һ�α���ͬʱʹ�ó����ռ䡣
 * @author liar
 * 2020��5��24�� ����10:04:28
 * @version 1.0
 */
package com.leetcode.sort;


public class SortColors {
	
	public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length-1);
    }
	
	private void quickSort(int[] arr, int low, int high) {

		if (low < high) {
			// ��Ѱ��׼���ݵ���ȷ����
			int index = getIndex(arr, low, high);

			// ���е�����index֮ǰ��֮������������ͬ�Ĳ���ʹ��������������
			//quickSort(arr, 0, index - 1);//�����˵�Ǳ���0Ӧ�û���low
			quickSort(arr, low, index - 1); 
			quickSort(arr, index + 1, high);
		}

	}

	private int getIndex(int[] arr, int low, int high) {
		// ��׼����
		int tmp = arr[low];
		while (low < high) {
			// ����β��Ԫ�ش��ڵ��ڻ�׼����ʱ,��ǰŲ��highָ��
			while (low < high && arr[high] >= tmp) {
				high--;
			}
			// �����βԪ��С��tmp��,��Ҫ���丳ֵ��low
			arr[low] = arr[high];
			// ������Ԫ��С�ڵ���tmpʱ,��ǰŲ��lowָ��
			while (low < high && arr[low] <= tmp) {
				low++;
			}
			// ������Ԫ�ش���tmpʱ,��Ҫ���丳ֵ��high
			arr[high] = arr[low];

		}
		// ����ѭ��ʱlow��high���,��ʱ��low��high����tmp����ȷ����λ��
		// ��ԭ���ֿ��Ժ������֪��lowλ�õ�ֵ������tmp,������Ҫ��tmp��ֵ��arr[low]
		arr[low] = tmp;
		return low; // ����tmp����ȷλ��
	}
	
	
	 public void sortColorsDijkstra(int[] nums) {
		 //Dijkstra 3-way partitioning
	        int i = 0;
	        int lt = 0;
	        int gt = nums.length - 1;
			
			// ___________________________________________________
			// |     <1     |     =1     |          |     >1     |
			// �C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C
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
