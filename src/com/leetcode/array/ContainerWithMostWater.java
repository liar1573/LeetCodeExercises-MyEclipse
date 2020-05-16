/**ContainerWithMostWater.java
 * com.leetcode.array
 * TODO
 * 11. Container With Most Waterװˮ��������
 * ���ƶ̰�ЧӦ
 * ��˵�����Գ�����Ŀ��ѧϰ����˫ָ��ⷨ�о�������������
 * @author liar
 * 2020��5��16�� ����10:06:24
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
