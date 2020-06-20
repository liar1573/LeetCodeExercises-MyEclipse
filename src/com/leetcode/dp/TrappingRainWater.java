/**TrappingRainWater.java
 * com.leetcode.dp
 * TODO
 * LC42，经典接雨水问题
 * @author liar
 * 2020年6月20日 上午9:32:49
 * @version 1.0
 */
package com.leetcode.dp;

public class TrappingRainWater {
	public static void main(String[] args) {
		int[] height = {2,0,2};
		TrappingRainWater test = new TrappingRainWater();
		System.out.println(test.trapDP(height));
	}
	
	public int trapDP(int[] height) {
        int result = 0;
        if(height == null || height.length <= 2)
        	return result;
        
        int[] leftMax = new int[height.length];
        //leftMax[i]表示第i个砖块左边的砖块最高高度
        int[] rightMax = new int[height.length];
        
        //leftMax最左边和rightMax最右边的值需要特殊处理，固定赋值0
        for (int i = 1; i < height.length; i++) 
			leftMax[i] = (height[i-1] > leftMax[i-1]) ? height[i-1]: leftMax[i-1];
			//leftMax[i] = (height[i] > leftMax[i-1]) ? height[i]: leftMax[i-1]; 
		for (int i = height.length - 2; i >= 0; i--) 
			rightMax[i] = (height[i+1] > rightMax[i+1]) ? height[i+1]: rightMax[i+1];
        //注意到这里leftMax、rightMax的初始化用到了DP的思想
		
		for (int i = 0; i < height.length; i++) {
			int temp = Math.min(leftMax[i], rightMax[i]) - height[i];
			result += (temp > 0)? temp : 0;
		}	
			
        return result;
	}

	public int trapTwoPointer(int[] height) {
		int left = 0, right = height.length - 1;
		//左右双指针
		int result = 0;
		int leftMax = 0, rightMax = 0;
		while (left < right) {
			if(height[left] < height[right]){
				//Java中的问号表达式没办法像C++中这么通用，得改一下语法格式
				if(height[left] >= leftMax)//这里的等号感觉应该是不必须的，带不带都一样
					leftMax = height[left];
				else
					result += (leftMax - height[left]);
				left++;
			}else {
				if(height[right] >= rightMax)
					rightMax = height[right];
				else
					result += (rightMax - height[right]);
				right--;
			}
		}
		
		return result;
	}
}
