package com.leetcode;
import java.lang.reflect.Array;

/**LargestSubArray.java
 * 
 * TODO
 * @author liar
 * 2020年1月27日 下午4:07:53
 * @version 1.0
 */

/**
 * @author liar
 *
 */
public class LargestSubArray {

	static final int NUM = 4;
	static boolean[] array = new boolean[NUM];
	static int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//	static int[] nums = {0,3,-2,4};	
//	static int[] nums = {2,0,-2,4};
//	static int[] nums = {-1,-2,-9,-6};	
	
	
	/**
	 * @Description: TODO
	 * @para: @param args
	 * @return: void
	 * @throws: @param args
	 * @author: liar
	 * @date: 2020年1月27日 下午4:07:54
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		array[0] = true;
		//首值赋值为true，全部为false都不取没意义
		System.out.println(dynamicProgramming());
		
		
		
	}
	
	public int workout(int index) {

			
		return 0;
	}
	
	public static int dynamicProgramming() {
		int[][] dp = new int[nums.length+1][2];
		
//		if (nums[0] > 0) {
//			dp[0][0] = nums[0];
//		}else {
//			dp[0][1] = nums[0];
//		}//这个逻辑第一位出现0也没关系
		//后面试了下初始值好像不能置0，否则会乘到最后一直都是0
		//dp[0][0] = 1;dp[0][1] = 1;
		//第一次dp[0][1] = -1结果不对，改成1试试？？
		//后来发现1也不行，参考答案使用第一个元素将两者都赋值
		dp[0][0] = nums[0];dp[0][1]=nums[0];
		int temp = nums[0];
		
		for (int i = 0; i < nums.length-1; i++) {
			int x = i % 2;
			int y = (i+1)%2;
			
			dp[y][0] = Math.max(Math.max(dp[x][0] * nums[i+1], dp[x][1] * nums[i+1]), nums[i+1]);
			dp[y][1] = Math.min(Math.min(dp[x][0] * nums[i+1], dp[x][1] * nums[i+1]), nums[i+1]);
			temp = Math.max(temp, dp[y][0]);
			
//			dp[i+1][0] = Math.max(Math.max(dp[i][0] * nums[i+1], dp[i][1] * nums[i+1]), nums[i+1]);
//			dp[i+1][1] = Math.min(Math.min(dp[i][0] * nums[i+1], dp[i][1] * nums[i+1]), nums[i+1]);
//			temp = Math.max(temp, dp[i+1][0]);

		}
		
		for (int i = 0; i < nums.length-1; i++) {
//			int a = dp[i][0] * nums[i+1]; int b = dp[i][1] * nums[i+1];
//			dp[i+1][0] = (a > b)?a:b;
//			dp[i+1][0] = (dp[i+1][0] > nums[i+1])?dp[i+1][0]:nums[i+1];
//			
//			dp[i+1][1] = (a < b)?a:b;
//			dp[i+1][1] = (dp[i+1][1] < nums[i+1])?dp[i+1][1]:nums[i+1];
//			temp = (temp > dp[i+1][0])?temp:dp[i+1][0];
					
//			dp[i+1][0] = Math.max(Math.max(dp[i][0] * nums[i+1], dp[i][1] * nums[i+1]), nums[i+1]);
//			dp[i+1][1] = Math.min(Math.min(dp[i][0] * nums[i+1], dp[i][1] * nums[i+1]), nums[i+1]);
//			temp = Math.max(temp, dp[i+1][0]);

		}
		
		
	//参考方法调用了max、min函数，但是省去了正负的判断，总体逻辑看上去简单了不少	
//		for (int i = 0; i < nums.length-1; i++) {
//			if (nums[i] > 0) {//这个逻辑中间位出现0不知道是否会对最终结果有影响
//				
//				dp[i+1][0] = dp[i][0] * nums[i+1];
//				dp[i+1][1] = dp[i][1] * nums[i+1];
//				
//				dp[i+1][0] = Math.max(Math.max(dp[i][0] * nums[i+1], dp[i][1] * nums[i+1]), nums[i+1]);
//				dp[i+1][1] = Math.max(Math.max(dp[i][0] * nums[i+1], dp[i][1] * nums[i+1]), nums[i+1]);
//			}else {
//				//需要一个暂存变量
//				//并不需要啊，之前看错了？？
//				dp[i+1][0] = dp[i][1] * nums[i+1]; 
//				dp[i+1][1] = dp[i][0] * nums[i+1];
//			}
//			//nums中出现0好像要特殊处理，在dp[i][0]中设置1才行，否则结果可能会出问题
//			
//			if (dp[i+1][0] > temp) {
//				temp = dp[i+1][0];
//			}
//		}
		
		print2dArray(dp);
		
		return temp;
	}

	
	static void print2dArray(int[][] arr){
		for (int i = 0; i < nums.length; i++) {
			System.out.print(arr[i][0] + "   ");
		}
		System.out.println();
		
		for (int i = 0; i < nums.length; i++) {
			System.out.print(arr[i][1] + "   ");
		}
		
	}
	
}
