/**ContainerWithMostWater.java
 * com.leetcode.array
 * TODO
 * 11. Container With Most Water装水最多的区域
 * 类似短板效应
 * 据说是面试常见题目，学习到了双指针解法感觉很厉害的样子
 * @author liar
 * 2020年5月16日 上午10:06:24
 * @version 1.0
 */
package com.leetcode.array;

/**
 * @author liar
 *
 */
public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		if(height.length <=1 )
			return 0;
        int result = 0;
        int startIndex = 0, endIndex = height.length - 1;
        
        while (startIndex < endIndex) {
			int temp = (endIndex - startIndex) * Math.min(height[startIndex], height[endIndex]);
			result = (temp > result) ? temp: result;
			if (height[startIndex] < height[endIndex]) {
				startIndex++;
			} else {
				endIndex--;
			}
		}

		return result;
    }
}
