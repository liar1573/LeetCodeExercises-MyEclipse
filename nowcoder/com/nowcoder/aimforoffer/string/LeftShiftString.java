/**LeftShiftString.java
 * com.nowcoder.aimforoffer.string
 * TODO
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * @author liar
 * 2020年6月16日 上午11:38:32
 * @version 1.0
 */
package com.nowcoder.aimforoffer.string;

import java.util.Arrays;

public class LeftShiftString {
	public static void main(String[] args) {
		for (int i = 0; i < 7; i++) {
			System.out.println(i);
			System.out.println(LeftRotateString("abcXYZdef", i));
		}
		
	}
	
	public static String LeftRotateString(String str,int n) {
        if(str == null || str.length() <= 1)
        	return str;
        
        n = n % str.length();
        char[] arr = str.toCharArray();
        char[] temp = Arrays.copyOf(arr, n);
        //偷个懒不自己for循环写了
        for (int i = 0; i < arr.length - n; i++)
			arr[i] = arr[n + i]; 
		for (int i = 0; i < n; i++)
			arr[arr.length - n + i] = temp[i];
		
        
        //直接在原数组上操作感觉很难。。
//        for (int i = 0; i < n; i++) {
//			char temp = arr[i];
//			arr[i] = arr[arr.length - n + i];
//			arr[arr.length - n + i] = temp;
//		}
        
        return new String(arr);       
    }
	
	//同时也可以使用两轮旋转在原字符串上进行操作。
	//第一轮先整体选择
	//第二轮先选择前len-N的部分选择，再选择后N的部分选择
	
}
