/**SumAndProduct.java
 * com.nowcoder.aimforoffer.array
 * TODO
 * ����һ����������������һ������S���������в�����������ʹ�����ǵĺ�������S��
 * ����ж�����ֵĺ͵���S������������ĳ˻���С�ġ�
�������:
��Ӧÿ�����԰����������������С���������
 * @author liar
 * 2020��6��16�� ����9:41:40
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
