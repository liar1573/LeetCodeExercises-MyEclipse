/**DuplicateNumberInArray2.java
 * com.nowcoder.aimforoffer.array
 * @author liar
 * 剑指-确定指定范围内的数组中是否有重复数字（可以不止一个），如果没有返回false，如果有则返回true并以duplication[0]返回任意重复数字即可。
 * 在没有额外限制条件下，最简单粗暴的方法可以直接对原数组快排，然后遍历数组找重复元素，时间NlogN，空间为1。
 * 评论区还看到一个利用下标特性直接在原数组上操作标记的，时间可以达到N，空间为1.
 * 2020年6月10日 上午9:42:26
 * @version 1.0
 */
package com.nowcoder.aimforoffer.array;

import java.util.Arrays;

public class DuplicateNumberInArray2 {
	public boolean duplicate(int numbers[],int length,int [] duplication) {
		//使用快排直接处理原数组
	    boolean result = false;
	    if(length <= 1)  return result;
	    
	    Arrays.sort(numbers);
	    //先直接使用原数组排序，不需要额外空间
	    //如果想不破坏现场，只需要复制一个备份即可
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
		//评论区最高赞解法，也是直接操作了原数组，时间只需要N
		boolean result = false;
	    if(length <= 1)  return result;
	    for (int i = 0; i < length; i++) {
			int index = numbers[i];
			//这里把数值值取出来当下标值用
			if(index >= length)
				index -= length; //这里为什么要对index减去len？
			//注意到这里数组numbers中的值即当做下标来用，又当做数值来进行比较，容易搞混
			//由于做下标处理时不允许发生下标溢出，所以每次要判断index，并在溢出是减去len
			//但是注意到这里index只是下标值的一个备份，不影响numbers中本身的数值，
			//所以仍然可以用于比较 >= len 从而找到重复的值
			if(numbers[index] >= length){
				result = true;
				duplication[0] = index;
			}
			numbers[index] += length;
		}
	        
	    return result;
	}
	
}
