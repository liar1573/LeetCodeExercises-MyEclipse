package com.leetcode;
import java.lang.reflect.Array;

/**LargestSubArray.java
 * 
 * TODO
 * @author liar
 * 2020��1��27�� ����4:07:53
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
	 * @date: 2020��1��27�� ����4:07:54
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		array[0] = true;
		//��ֵ��ֵΪtrue��ȫ��Ϊfalse����ȡû����
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
//		}//����߼���һλ����0Ҳû��ϵ
		//���������³�ʼֵ��������0�������˵����һֱ����0
		//dp[0][0] = 1;dp[0][1] = 1;
		//��һ��dp[0][1] = -1������ԣ��ĳ�1���ԣ���
		//��������1Ҳ���У��ο���ʹ�õ�һ��Ԫ�ؽ����߶���ֵ
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
		
		
	//�ο�����������max��min����������ʡȥ���������жϣ������߼�����ȥ���˲���	
//		for (int i = 0; i < nums.length-1; i++) {
//			if (nums[i] > 0) {//����߼��м�λ����0��֪���Ƿ������ս����Ӱ��
//				
//				dp[i+1][0] = dp[i][0] * nums[i+1];
//				dp[i+1][1] = dp[i][1] * nums[i+1];
//				
//				dp[i+1][0] = Math.max(Math.max(dp[i][0] * nums[i+1], dp[i][1] * nums[i+1]), nums[i+1]);
//				dp[i+1][1] = Math.max(Math.max(dp[i][0] * nums[i+1], dp[i][1] * nums[i+1]), nums[i+1]);
//			}else {
//				//��Ҫһ���ݴ����
//				//������Ҫ����֮ǰ�����ˣ���
//				dp[i+1][0] = dp[i][1] * nums[i+1]; 
//				dp[i+1][1] = dp[i][0] * nums[i+1];
//			}
//			//nums�г���0����Ҫ���⴦����dp[i][0]������1���У����������ܻ������
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
