/**RadixCombination.java
 * com.others
 * 网易官方教程某年的笔试真题
 * 第三题：进制组合问题
小明编程将输入数字N分别转换为X进制（假定5进制）和Y进制（假定2进制）之后进行输出，结果由于疏忽输出时两个进制之间没有增加空格分隔全部连在了一起，例如“232110011001”
要求：根据输出的连续字符串，确定输入的数字N
 * @author liar
 * 2020年4月1日 下午3:50:29
 * @version 1.0
 */
package com.others;


public class RadixCombination {

	/**
	 * @Description: TODO
	 * @para: @param args
	 * @return: void
	 * @throws: @param args
	 * @author: liar
	 * @date: 2020年4月1日 下午3:50:29
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String testString = "1234";
		String testString2 = "120100011";
//		char[] arr = testString.toCharArray();
//		int[] intArr = new int[4];
//		for (int i = 0; i < intArr.length; i++) {
//			intArr[i] = arr[i] - '0';
//		}
//		for (int i : intArr) {
//			System.out.println(i);
//		}
		RadixCombination test = new RadixCombination();
//		System.out.println(test.getOriginalNumber(testString2));
		System.out.println(test.sample(testString2, 5, 2));
		
		

	}
	
	private int getOriginalNumber(String numberString) {
		//不太清楚题设条件，暂时不考虑非法情况好了（即String长度最小为2）
		//某人高进制在前、低进制在后（这个会影响二分之后的方向进行）
		int result = 0;
		for (int i = 1; i <= (numberString.length() / 2); i++) {
			if (getRadixValue(5, numberString.substring(0, i)) == getRadixValue(2, numberString.substring(i, numberString.length()))) {
				result = getRadixValue(5, numberString.substring(0, i));
				break;
			}
		}
		
		return result;
	}

	private int getRadixValue(int radix, String numberString) {
		//又想到个问题，如果X进制为大于10的进展，字符表达上可能会遇到不匹配问题。。
		//比如16进制的A、B、C这种。。
		int result = 0;
		char[] arr = numberString.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			//这里一开始其实不想用Math.pow函数的，但是如果不用的话又要特殊讨论
			//0次幂很麻烦。。
			result += (arr[i] - '0') * (int)Math.pow(radix, arr.length - i -1);
		}
		
		return result;
	}

	private int sample(String numberString, int radixX, int radixY) {
		//参考答案，这里的解法更巧妙
		//没想到居然还有方法可以从高位到低位累加计算值的
		//原来一直以为只有知道位数和基数之后才能从左往右计算值
		int a = 0, b = 0, k = 1;
		//a和b分别代表左右两个进制数的累加和
		for (int i = 0, j = numberString.length(); i < j; ) {
			//注意到下面取值用的是--j，所以初值直接用的len
			if (a <= b) {
				a = a * radixX + (numberString.charAt(i++) - '0'); 
			} else {
				//这里没使用Math.pow函数，通过临时遍历k=1进行了累乘也很巧妙
				b = b + (numberString.charAt(--j) - '0') * k;
				k *= radixY;
			}
		}
		
		return a;
	}
}
