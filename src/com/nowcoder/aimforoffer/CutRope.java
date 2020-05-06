/**CutRope.java
 * com.nowcoder.aimforoffer
 * TODO
 * 牛客-剑指offer-切割绳子返回最大长度乘积
 * @author liar
 * 2020年5月6日 上午10:47:53
 * @version 1.0
 */
package com.nowcoder.aimforoffer;

import java.util.Arrays;

public class CutRope {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int length = 5;
//		int m = 2;
////		double dm = m;
//		double result = length / (double) m;
//		System.out.println(result);
//		CutRope test = new CutRope();
//		for (int i = 2; i < 20; i++) {
//			System.out.println("绳子长度为:  " + i + "  ,最大乘积为:  " + test.findMaxPartNumber(i));
//		}
		long result =1;
		for (int i = 0; i < 20; i++) {
			result *= 3;
		}
		System.out.println(result);
	}
	
	public int findMaxPartNumber(int ropeLength) {
		//通过暴力搜索确认绳子段数设置相对于长度的关系
		//自己猜测的情况应该是等于floor(sqrt(length))
		//int partNumber = 2;//m最小为2
		int max = 1;
		int maxParts = 2;//记录一下最大分段数用于调试
		for (int m = 2; m < ropeLength; m++) {
			//次循环中的i表示m
			//m最小为2，最大为 length(其实分割成全1也没意义，乘积太小了)
			if (cutRopeBruteForce(ropeLength, m) > max) {
				max = cutRopeBruteForce(ropeLength, m);
				maxParts = m;
			}
			//max = (max > cutRopeBruteForce(ropeLength, m))? max: cutRopeBruteForce(ropeLength, m);
		}
		
		System.out.println("最大分段数为: " + maxParts);
		return max;
	}
	
	public int cutRopeBruteForce(int ropeLength, int m) {
		//当长度为l，段数为m的时候，如果没均分除尽的情况要如何处理？？
		int[] arr = new int[m];
//		int[] arr = new int[ropeLength];
		//通过调试发现这里向下取整/m不行，需要向上取整
		int rest = ropeLength % m;
		//对m的余数按照顺序，给arr中的每个数字分配1，理论上是不会越界的
		//为什么第一次条用就越界了。。
		
		//逐行debug之后发现这里arr忘记赋初始值了。。
		Arrays.fill(arr, ropeLength/m);
		
		for (int i = 0; i < rest; i++) {
			arr[i] +=1; 
		}
		int result = 1;
		for (int i = 0; i < arr.length; i++) {
			result *= arr[i];
		}
		return result;
	}
	
	public int cutRopeGreedyExample(int target) {
		//来着评论区的大佬思路，自己想了半天没确定思路。。
		if(target == 2)
			return 1;
		if(target == 3)
			return 2;
		//上面两个是特例
		
		int number = target / 3;
		int rest = target % 3;
		int result = 1;
		if (rest == 0) {//序列中全部是3
			for (int i = 0; i < number; i++) 
				result *= 3;
			return result;
		} else if (rest == 1) {//序列中需要有两个2
			for (int i = 0; i < number-1; i++) 
				result *= 3;
			return result * 4;
		} else {
			for (int i = 0; i < number; i++) 
				result *= 3;
			return 2 * result;
		}
	}
	
}
