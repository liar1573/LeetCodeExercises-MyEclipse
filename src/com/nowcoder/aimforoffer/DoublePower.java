/**DoublePower.java
 * com.nowcoder.aimforoffer
 * TODO
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。 
 * 保证base和exponent不同时为0
 * 容易想到的有递归解法，最优解法为结合移位操作的解法。 
 * @author liar
 * 2020年5月28日 上午9:29:18
 * @version 1.0
 */
package com.nowcoder.aimforoffer;


public class DoublePower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double base = 2.0;
		System.out.println(1/ base);
	}
	
	public double Power(double base, int exponent) {
		if(base == 0)  return 0;
		if(exponent == 0)  return 1;
		if(base == 1)	return 1;  //base=1的情况也是一种非常特殊的情况一开始没想到，可以减少很多计算
		
		if(exponent < 0){
			exponent = -exponent;
			base = 1 / base;
		}
		
		return dfs(base, exponent);
	}
	
	public double dfs(double base, int exponent) {
		if(exponent == 1)
			return base;
		
//		if ((exponent & 1) == 1) {
//			return dfs(base, exponent / 2) * dfs(base, exponent / 2 + 1);
//		} else {
//			return dfs(base, exponent / 2) * dfs(base, exponent / 2);
//		}
		//来自算法40讲的另一种较优解法
		if ((exponent & 1) == 1) {
			return base * dfs(base, exponent - 1);
		} else {
			return dfs(base * base, exponent / 2);
		}
		
	}

	
	public double PowerExample(double base, int exponent) {
		if(base == 0)  return 0;
		if(exponent == 0)  return 1;
		if(base == 1)	return 1;  
		//base=1的情况也是一种非常特殊的情况一开始没想到，可以减少很多计算
		if(exponent < 0){
			exponent = -exponent;
			base = 1 / base;
		}
		
		double result = 1.0;
		while (exponent > 0) {
			if((exponent & 1) == 1)
				result *= base;
			base *= base;
			exponent = exponent >> 1;
		}
		return result;
	}
}
