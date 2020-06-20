/**TrappingRainWater.java
 * com.leetcode.dp
 * TODO
 * LC42���������ˮ����
 * @author liar
 * 2020��6��20�� ����9:32:49
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
        //leftMax[i]��ʾ��i��ש����ߵ�ש����߸߶�
        int[] rightMax = new int[height.length];
        
        //leftMax����ߺ�rightMax���ұߵ�ֵ��Ҫ���⴦���̶���ֵ0
        for (int i = 1; i < height.length; i++) 
			leftMax[i] = (height[i-1] > leftMax[i-1]) ? height[i-1]: leftMax[i-1];
			//leftMax[i] = (height[i] > leftMax[i-1]) ? height[i]: leftMax[i-1]; 
		for (int i = height.length - 2; i >= 0; i--) 
			rightMax[i] = (height[i+1] > rightMax[i+1]) ? height[i+1]: rightMax[i+1];
        //ע�⵽����leftMax��rightMax�ĳ�ʼ���õ���DP��˼��
		
		for (int i = 0; i < height.length; i++) {
			int temp = Math.min(leftMax[i], rightMax[i]) - height[i];
			result += (temp > 0)? temp : 0;
		}	
			
        return result;
	}

	public int trapTwoPointer(int[] height) {
		int left = 0, right = height.length - 1;
		//����˫ָ��
		int result = 0;
		int leftMax = 0, rightMax = 0;
		while (left < right) {
			if(height[left] < height[right]){
				//Java�е��ʺű��ʽû�취��C++����ôͨ�ã��ø�һ���﷨��ʽ
				if(height[left] >= leftMax)//����ĵȺŸо�Ӧ���ǲ�����ģ���������һ��
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
