/**FindTheDuplicateNumber.java
 * com.leetcode.array
 * TODO
 * LC 287���ҵ������е��ظ����ֵ�����
 * Ȼ���������Ŀ���������е��鷳��Ҫ��ֻ��ʹ�ó����ռ䣬��hashSet��ҪN�Ŀռ�
 * ͬʱ���ﻹ���ӵ������в������޸�����ֵ����ʱ����ҪС��N^2
 * ����Ϣ���޶���ֻ��1���ظ�����,�������鳤�Ⱥͳ�����ֵ�����Ʒ�Χ
 * @author liar
 * 2020��6��1�� ����10:05:00
 * @version 1.0
 */
package com.leetcode.array;


public class FindTheDuplicateNumber {
	public int findDuplicateSlowFast(int[] nums) {
        int slow = 0,fast = 0;
		do{
			slow = nums[slow];
			fast = nums[nums[fast]];
		}while(slow != fast);
        slow = 0;
        while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
                
        return slow;
    }
	
	public int findDuplicateBinarySearch(int[] nums) {
		
        int n = nums.length;
        int l = 0, r = n - 1, ans = -1;
        //l��r�����±�ָ�룬ans�����ս��
        //��˵�����±�l��1��ʼû�����𣿣����������±�ʱ��0��ʼ��
        //���������ֶ��ĳ���0��ҲAC�ˣ������ǿ��ǵ��ظ������������ڵڶ�λ�Ż����2�Σ����Ե�0λ�������ˣ�
        //�����о�����ȥl=0��ͳһ���������һЩ
        while (l <= r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; ++i) { //��һ��for�����ʲô��ע�⵽�����Ǵ��±�0��ʼ��
            	//�������ˣ���������ͳ�����λ�õ�cntֵ��Ҳ����cnt[mid]�Ĵ�С
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) { //���cnt[mid] <= mid��˵����������ұ���Ҫ��������
                l = mid + 1;
            } else {//���cnt[mid] > mid��˵��
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;

    }

	   public int findDuplicateBitOperate(int[] nums) {
	        int n = nums.length, ans = 0;
	        int bit_max = 31;
	        while (((n - 1) >> bit_max) == 0) {
	            bit_max -= 1;
	        }//�����while���ʲô����
	        //����nums����Ϊ5��n-1��Ϊ4��(n - 1) >> 31  ����������n-1�����Ҫʹ�ö��ٸ�������λ��ʾ
	        
	        for (int bit = 0; bit <= bit_max; ++bit) {
	            int x = 0, y = 0;
	            for (int i = 0; i < n; ++i) {
	                if ((nums[i] & (1 << bit)) != 0) {
	                    x += 1;
	                }//����ͳ��nums��ÿһλ�ϵ�1�����˶��ٴ�
	                if (i >= 1 && ((i & (1 << bit)) != 0)) {
	                    y += 1;
	                }//һ��ͳ��[1,n]������ÿһλ�ϵ�1�����˶��ٴ�
	            }
	            if (x > y) {//���x > y����ʾnums�����ظ������֣����¸�λ��1�����������ˣ���Ҫ�����ֵ�ۼ�����
	                ans |= 1 << bit;
	            }
	        }
	        return ans;
	    }

	
}
