/**IncreasingPoker.java
 * com.nowcoder.aimforoffer.string
 * TODO 判断有四张大小王可以任意变换的扑克牌中，任意抽五张能否构成顺子
 * @author liar
 * 2020年6月15日 下午8:15:36
 * @version 1.0
 */
package com.nowcoder.aimforoffer.string;

import java.util.Arrays;

public class IncreasingPoker {
	public boolean isContinuous(int[] numbers) {
		Arrays.sort(numbers);
		int zeroCount = 0;//统计有几个0（大小王）
		//这里就不再自己判断输入合法性了，默认输入都是合法的
		for (int i = 0; i < numbers.length; i++)
			if(numbers[i] == 0)
				zeroCount++;
		
		int increaseCount = 1;//统计上升序列长度
		int temp = 1;
		for(int i = numbers.length - 1;i >= zeroCount + 1; i--){
			if(numbers[i] - numbers[i-1] == 1){
				temp++;
				increaseCount = (temp > increaseCount) ? temp: increaseCount;
			}else {
				temp = 1;
			}
		}
		//不对，这样好像有中途断开但是可以用0填补的情况没有考虑到,即非0序列并不一定要是连续的
		
		
		//突然想到似乎累计求差可以解决,5-3 + 3-1 = 4
		// 0 0 1 3 5
		//如果能成顺子，非零值的累计差应该为2 * zeroCount
		//不行，也不好做。。
		
		
		
		return (zeroCount + increaseCount == numbers.length);
    }

	public boolean isContinuousExample(int[] numbers) {
		//三条判断：1.min - max < 5（除0以外） 2.除0以外不能有重复数字  3.长度为5
		if(numbers.length != 5)
			return false;
		
		Arrays.sort(numbers);
		int zeroCount = 0;//统计有几个0（大小王）
		//这里就不再自己判断输入合法性了，默认输入都是合法的
		for (int i = 0; i < numbers.length; i++){
			if(numbers[i] != 0)
				break;
			else
				zeroCount++;
		}
		
		if(numbers[numbers.length - 1] - numbers[zeroCount] >= 5)
			return false;
		
		for (int i = zeroCount; i < numbers.length - 1; i++) 
			if(numbers[i] == numbers[i+1] )
				return false;
		
		return true;
	}
}
