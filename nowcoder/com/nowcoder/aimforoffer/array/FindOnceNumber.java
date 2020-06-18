/**FindOnceNumber.java
 * com.nowcoder.aimforoffer.array
 * TODO
 * һ�����������������������֮�⣬���������ֶ����������Ρ�
 * ��д�����ҳ�������ֻ����һ�ε����֡�
 * @author liar
 * 2020��6��18�� ����9:40:59
 * @version 1.0
 */
package com.nowcoder.aimforoffer.array;

import java.util.*;

public class FindOnceNumber {

	//num1,num2�ֱ�Ϊ����Ϊ1�����顣��������
	//��num1[0],num2[0]����Ϊ���ؽ��
	public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length < 2)
        	return;
        
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < array.length; i++)
			if(!set.add(array[i]))
				set.remove(array[i]);
		
        Iterator iterator = set.iterator();
        num1[0] = (Integer)iterator.next();
        num2[0] = (Integer)iterator.next();  	
    }
	
	public void FindNumsAppearOnceXor(int [] array,int num1[] , int num2[]) {
        //����λ�����N���Ӷȣ�1�ռ�Ľⷨ���ص���������㡰��ͬΪ0������Ϊ1��������
		if(array == null || array.length < 2)
        	return;
        
		//ע�⵽xor���и�С���ԣ���0 xor X = X�����κ�����0���õ���ֵ����������
		//���Բ���Ҫ���⸳ֵ����ʼֵ��0�ͺ�
        int sum = 0;
        for (int i = 0; i < array.length; i++)
        	sum ^= array[i];
			
		int flag = sum & (-sum); //����ȡ�����͵���ͷ�0λ
		//ע�⵽���������ǲ���ȵģ�������ǵ�������϶�����0
		num1[0] = 0; num2[0] = 0;  //�Է���һ�Ȱѷ���ֵ����
		for (int i = 0; i < array.length; i++) {
			if((array[i] & flag) == 0)
				num1[0] ^= array[i];
			else 
				num2[0] ^= array[i];
		}
    }
	
}
