/**DuplicateNumberInArray2.java
 * com.nowcoder.aimforoffer.array
 * @author liar
 * ��ָ-ȷ��ָ����Χ�ڵ��������Ƿ����ظ����֣����Բ�ֹһ���������û�з���false��������򷵻�true����duplication[0]���������ظ����ּ��ɡ�
 * ��û�ж������������£���򵥴ֱ��ķ�������ֱ�Ӷ�ԭ������ţ�Ȼ������������ظ�Ԫ�أ�ʱ��NlogN���ռ�Ϊ1��
 * ������������һ�������±�����ֱ����ԭ�����ϲ�����ǵģ�ʱ����ԴﵽN���ռ�Ϊ1.
 * 2020��6��10�� ����9:42:26
 * @version 1.0
 */
package com.nowcoder.aimforoffer.array;

import java.util.Arrays;

public class DuplicateNumberInArray2 {
	public boolean duplicate(int numbers[],int length,int [] duplication) {
		//ʹ�ÿ���ֱ�Ӵ���ԭ����
	    boolean result = false;
	    if(length <= 1)  return result;
	    
	    Arrays.sort(numbers);
	    //��ֱ��ʹ��ԭ�������򣬲���Ҫ����ռ�
	    //����벻�ƻ��ֳ���ֻ��Ҫ����һ�����ݼ���
	    //int[] copy = Arrays.copyOf(numbers, numbers.length);
	    for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] == numbers[i-1]) {
				result = true;
				duplication[0] = numbers[i];
				break;
			}
		}	    
	    
	    return result;
    }
	
	public boolean duplicateExample(int numbers[],int length,int [] duplication) {
		//����������޽ⷨ��Ҳ��ֱ�Ӳ�����ԭ���飬ʱ��ֻ��ҪN
		boolean result = false;
	    if(length <= 1)  return result;
	    for (int i = 0; i < length; i++) {
			int index = numbers[i];
			//�������ֵֵȡ�������±�ֵ��
			if(index >= length)
				index -= length; //����ΪʲôҪ��index��ȥlen��
			//ע�⵽��������numbers�е�ֵ�������±����ã��ֵ�����ֵ�����бȽϣ����׸��
			//�������±괦��ʱ���������±����������ÿ��Ҫ�ж�index����������Ǽ�ȥlen
			//����ע�⵽����indexֻ���±�ֵ��һ�����ݣ���Ӱ��numbers�б������ֵ��
			//������Ȼ�������ڱȽ� >= len �Ӷ��ҵ��ظ���ֵ
			if(numbers[index] >= length){
				result = true;
				duplication[0] = index;
			}
			numbers[index] += length;
		}
	        
	    return result;
	}
	
}
