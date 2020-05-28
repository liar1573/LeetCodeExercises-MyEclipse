/**DoublePower.java
 * com.nowcoder.aimforoffer
 * TODO
 * ����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η��� 
 * ��֤base��exponent��ͬʱΪ0
 * �����뵽���еݹ�ⷨ�����ŽⷨΪ�����λ�����Ľⷨ�� 
 * @author liar
 * 2020��5��28�� ����9:29:18
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
		if(base == 1)	return 1;  //base=1�����Ҳ��һ�ַǳ���������һ��ʼû�뵽�����Լ��ٺܶ����
		
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
		//�����㷨40������һ�ֽ��Žⷨ
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
		//base=1�����Ҳ��һ�ַǳ���������һ��ʼû�뵽�����Լ��ٺܶ����
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
