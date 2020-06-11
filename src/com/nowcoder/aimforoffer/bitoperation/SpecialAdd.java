/**SpecialAdd.java
 * com.nowcoder.aimforoffer.bitoperation
 * TODO
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * 核心思想是使用异或运算、xor、(java中操作符为~)实现不带进位的加法，再使用&运算求得进位情况之后进行组合操作。
 * （自己有个写法是逐位比较判断的，结果正确但是流程太麻烦了）
 * @author liar
 * 2020年6月10日 下午3:29:08
 * @version 1.0
 */
package com.nowcoder.aimforoffer.bitoperation;


public class SpecialAdd {
	public static void main(String[] args) {
		System.out.println(Add(-1, 2));
	}
	
	public static int AddSample(int num1,int num2) {
		while (num2 != 0) {//这里的判断条件是什么意思？？
			int temp = num1 ^ num2;
			num2 = (num1 & num2) << 1;
			num1 = temp;
		}
		
		return num1;
	}
	
	
	public static int Add(int num1,int num2) {
        int result = num1 ^ num2;
        
        boolean flag = false;//进位标志
        int bit = 1; //用于做与运算求各个为的数字
        for (int i = 0; i < 32; i++) {
			//java中int一共有32位
        	//注意到这里不允许用加法，所以依次取出再加起来也是不允许的
        	//必须先整体操作一次，然后再逐步位调整
        	if((result & bit) != 0){//如果xor结果为1，则原来是1-0或者0-1
        		if(flag)//如果有进位
        			result = (result & (~bit));
        	}else {//如果xor的结果为0，则原来的结果为0-0或者1-1
//        		System.out.println("异或结果为0");
				if (flag) {//如果有进位
					result = result | bit;
					if ((num1 & bit) == 0) 
						flag = false;
				} else {//无进位
					if ((num1 & bit) != 0)
						flag = true;
				}
			}
        	bit = bit << 1;
		}
        
        
        return result;
    }
}
