/**SumAndProduct.java
 * com.nowcoder.aimforoffer.array
 * TODO
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
输出描述:
对应每个测试案例，输出两个数，小的先输出。
 * @author liar
 * 2020年6月16日 下午9:41:40
 * @version 1.0
 */
package com.nowcoder.aimforoffer.array;

import java.util.ArrayList;

public class SumAndProduct {
	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(array == null || array.length < 2)
        	return result;
        
        int low = 0,high = array.length-1;
        while (low < high) {
			if(array[low] + array[high] == sum){
				result.add(array[low]);
				result.add(array[high]);
				break;
			}else if (array[low] + array[high] < sum) {
				low++;
			}else {
				high--;
			}		
		}
        
        return result;
    }
}
