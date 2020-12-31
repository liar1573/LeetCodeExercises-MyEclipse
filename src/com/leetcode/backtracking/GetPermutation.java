/**
 * LC60.排列序列。给定一个正整数n和一个序号k，返回[1,2,...,n]构成的全排列中，升序排列的第k个排列
 */
package com.leetcode.backtracking;
import java.util.*;

public class GetPermutation {
	List<Integer> tempList = new ArrayList<Integer>();
	List<Integer> ansList;
	int count = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetPermutation test = new GetPermutation();
		System.out.println(test.getPermutationOverTime(5, 119));
	}
	
	public String getPermutationOverTime(int n, int k) {
		
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++)
			nums[i] = i + 1; 
		
		dfs(nums, k);
		
		char[] charArr = new char[ansList.size()];
		for (int i = 0; i < charArr.length; i++){
			int tempInt = ansList.get(i);
//			charArr[i] = (char) tempInt;
			charArr[i] = (char) (tempInt + 48);
		}
		return new String(charArr);
//		return new String((int[])tempList.toArray());
    }
	
   public void dfs(int[] nums, int k) {
        if(tempList.size() == nums.length){
            count++;
            return;
        }       
        //if (count == k)	return;//感觉第一次判断返回的位置出了问题
  
        //使用了list.contains来判断是否出现了重复的元素。
        for (int i = 0; i < nums.length; i++) {
//        	if (count == k)  return;
            if(tempList.contains(nums[i]))
                continue;
            tempList.add(nums[i]);
            dfs(nums, k);
            if (count == k){
            	ansList = new ArrayList<Integer>(tempList);
            	return;
            }
            tempList.remove(tempList.size() - 1);
        }
    }
	
   //官方基于排列的数学性质的解法
   public String getPermutationExample(int n, int k) {
       int[] factorial = new int[n];
       factorial[0] = 1;
       for (int i = 1; i < n; ++i) {
           factorial[i] = factorial[i - 1] * i;
       }//首先求出全排列序列


       --k;
       StringBuffer ans = new StringBuffer();
       int[] valid = new int[n + 1];
       Arrays.fill(valid, 1);
       for (int i = 1; i <= n; ++i) {
           int order = k / factorial[n - i] + 1;
           for (int j = 1; j <= n; ++j) {//这里记录元素是否使用过的valid数组是如何工作的呢？
               order -= valid[j]; //这个减法是什么意思？？
               	//看了评论区大佬的注释搞懂了，原来这里的order是表示当前元素处于当前剩余序列1,2,...n中的第几个的位置
               //由于会一直从1,2,...,n序列中动态取出数字，所以数字的位置并不是跟自身值一定相等的
               //比如序列[3,4,5]，虽然第一个元素值为3，但是它在当前序列中是第一个，所以其order=1，这个计数方法感觉非常巧妙
               //不过预计使用ArrayList这样集合也可以达到类似的动态查找消去的效果
               if (order == 0) {
                   ans.append(j);
                   valid[j] = 0;
                   break;
               }
           }
           k %= factorial[n - i];
       }
       return ans.toString();
   }
   
   public String getPermutationOther(int n, int k) {
	   //基于迭代调用getNext的方法
	   int[] nums = new int[n];
	   for (int i = 0; i < nums.length; i++)
		   nums[i] = i+1; 
		
	   while (k > 1) {
		 nextPermutation(nums);  
		 k--;
	   }
	   char[] chars = new char[n];
	   for (int i = 0; i < chars.length; i++)
		   chars[i] = (char) (nums[i] + 48); 
		
	   return new String(chars);
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
}
