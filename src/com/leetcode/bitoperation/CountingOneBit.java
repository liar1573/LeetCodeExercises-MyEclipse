/**CountingOneBit.java
 * com.leetcode.bitoperation
 * LC 191
 * Write a function that takes an unsigned integer and return the number of '1' bits it has 
 * (also known as the Hamming weight).
 * 第一次听到海明权重这个概念
 * 
 * LC 231，判断输入是否为2的整数幂
 * 
 * LC 338，求连续递增序列数字的1的位数，有简便方法可以通过二进制下标递推实现
 * @author liar
 * 2020年3月28日 上午9:52:26
 * @version 1.0
 */
package com.leetcode.bitoperation;


public class CountingOneBit {

	/**
	 * @Description: TODO
	 * @para: @param args
	 * @return: void
	 * @throws: @param args
	 * @author: liar
	 * @date: 2020年3月28日 上午9:52:26
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountingOneBit testCountingOneBit = new CountingOneBit();
//		System.out.print(testCountingOneBit.hammingWeight(-1));
//		System.out.print(testCountingOneBit.hammingWeightImproved(-1));
		System.out.print(testCountingOneBit.isPowerOfTwo(-31));
		
	}
	
	public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {//对于Java的32位int，这里需要判断32次
			if (1 == (n & 1)) {
				count++;
			}
			//好像不能直接用n>>1;必须要赋值一下
			//n>>1;
			n = n>>1;
		}
		return count;
	}

	public int hammingWeightImproved(int n) {
        int count = 0;
        while (0 != n) {
			n = n & (n - 1);
			count++;
		}
		return count;
	}

	public boolean isPowerOfTwo(int n) {
		if (n <= 0) {
			return false;
		}
        return (n == (n & (-n)));
	}
	
	public int[] countBits(int num) {
       int[] result = new int[num + 1];
       //这里下标从0或者1开始都可以，i=0时操作结果不变
       for (int i = 1; i < result.length; i++) {
    	   result[i] = result[i & (i-1)] + 1; 
	   }
       
       return result;
	}
	
}
