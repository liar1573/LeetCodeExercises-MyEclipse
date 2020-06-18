/**FindOnceNumber.java
 * com.nowcoder.aimforoffer.array
 * TODO
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 * @author liar
 * 2020年6月18日 上午9:40:59
 * @version 1.0
 */
package com.nowcoder.aimforoffer.array;

import java.util.*;

public class FindOnceNumber {

	//num1,num2分别为长度为1的数组。传出参数
	//将num1[0],num2[0]设置为返回结果
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
        //利用位运算的N复杂度，1空间的解法，重点是异或运算“相同为0，相异为1”的特性
		if(array == null || array.length < 2)
        	return;
        
		//注意到xor还有个小特性，即0 xor X = X，即任何数与0异或得到的值还是他本身
		//所以不需要额外赋值，初始值置0就好
        int sum = 0;
        for (int i = 0; i < array.length; i++)
        	sum ^= array[i];
			
		int flag = sum & (-sum); //用于取得异或和的最低非0位
		//注意到有两个数是不相等的，因此他们的异或结果肯定不是0
		num1[0] = 0; num2[0] = 0;  //以防万一先把返回值清零
		for (int i = 0; i < array.length; i++) {
			if((array[i] & flag) == 0)
				num1[0] ^= array[i];
			else 
				num2[0] ^= array[i];
		}
    }
	
}
