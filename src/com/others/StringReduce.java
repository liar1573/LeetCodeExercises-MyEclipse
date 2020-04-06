/**StringReduce.java
 * com.others
 * 网易官方教程某年的笔试真题
 * 字符串缩写
题目描述：
假设输入字符串全部是大写英文字母，如果有连续的M个（M>=4）按照字典顺序相邻的大写字母，则缩写为“首字母-尾字母”的形式
例如输入：XYZABCDMMM    输出：XYZA-DMMM
 * @author liar
 * 2020年4月1日 上午11:54:46
 * @version 1.0
 */
package com.others;


public class StringReduce {

	/**
	 * @Description: TODO
	 * @para: @param args
	 * @return: void
	 * @throws: @param args
	 * @author: liar
	 * @date: 2020年4月1日 上午11:54:46
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private String reduceString(String inputString) {
		int M = 4;
		int count = 1; //用于统计连续字母出现的个数
		char[] arr = inputString.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if ((i+1 < arr.length) && (arr[i+1] - arr[i] == 1)) {
					count++;//如果字母连续增长就累加count
				} else {//否则移动i指针，且count清1
					i = j;
					count = 1;
					break;
				}
			}
			
//			if (condition) {
//				
//			}
			
			
		}
		
		
		return "";
	}

}
