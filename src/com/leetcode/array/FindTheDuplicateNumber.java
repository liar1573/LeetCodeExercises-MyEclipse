/**FindTheDuplicateNumber.java
 * com.leetcode.array
 * TODO
 * LC 287，找到数组中的重复出现的数字
 * 然而这里的题目限制条件有点麻烦，要求只能使用常数空间，而hashSet需要N的空间
 * 同时这里还附加的条件有不允许修改数组值，且时间需要小于N^2
 * 好消息是限定了只有1个重复数字,而且数组长度和出现数值有限制范围
 * @author liar
 * 2020年6月1日 下午10:05:00
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
        //l和r是上下标指针，ans是最终结果
        //话说这里下标l从1开始没问题吗？？明明数组下标时从0开始的
        //这里试着手动改成了0，也AC了（可能是考虑到重复的数字至少在第二位才会出现2次，所以第0位就跳过了）
        //不过感觉还是去l=0更统一更容易理解一些
        while (l <= r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; ++i) { //这一步for是想干什么？注意到这里是从下标0开始的
            	//看明白了，这里是想统计这个位置的cnt值，也就是cnt[mid]的大小
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) { //如果cnt[mid] <= mid，说明结果还在右边需要继续查找
                l = mid + 1;
            } else {//如果cnt[mid] > mid，说明
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
	        }//这里的while想干什么？？
	        //假设nums长度为5，n-1则为4，(n - 1) >> 31  好像是想求n-1最多需要使用多少个二进制位表示
	        
	        for (int bit = 0; bit <= bit_max; ++bit) {
	            int x = 0, y = 0;
	            for (int i = 0; i < n; ++i) {
	                if ((nums[i] & (1 << bit)) != 0) {
	                    x += 1;
	                }//依次统计nums中每一位上的1出现了多少次
	                if (i >= 1 && ((i & (1 << bit)) != 0)) {
	                    y += 1;
	                }//一次统计[1,n]区间中每一位上的1出现了多少次
	            }
	            if (x > y) {//如果x > y，表示nums中有重复的数字，导致该位上1的数量更多了，需要把这个值累加起来
	                ans |= 1 << bit;
	            }
	        }
	        return ans;
	    }

	
}
