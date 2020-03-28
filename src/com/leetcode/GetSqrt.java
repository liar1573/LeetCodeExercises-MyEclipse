/**GetSqrt.java
 * com.leetcode
 * LC 69 返回正整数的平方根的整数部分
 * @author liar
 * 2020年3月25日 下午5:49:46
 * @version 1.0
 */
package com.leetcode;


public class GetSqrt {

	/**
	 * @Description: TODO
	 * @para: @param args
	 * @return: void
	 * @throws: @param args
	 * @author: liar
	 * @date: 2020年3月25日 下午5:49:46
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetSqrt testGetSqrt = new GetSqrt();
		System.out.print(testGetSqrt.mySqrt(2147395599));
	}
	
	
	public int mySqrt(long x) {
		//题目提到x guaranteed to 正数，负数没意义
		long low = 0; long high = x;
//		int precision = 1;
//		while ((high - low) > precision) {
		while (high > low) {
			long mid = (low + high) / 2;
			//这里中点类型设置为int时应该会导致迭代更快收敛，但是解的精度不高
			//对于本题特定返回整数部分的情况可以这样处理
			if (mid * mid == x) {
				return (int)mid;
			}
			if(mid * mid  > x){
				high = mid - 1;
			}else {
				low = mid + 1;
			}
		}
		
        //return low;
        //当返回low时，3-2,5-3,7-2??
		//return high;
		//单纯返回high也不行，会在边界值交界处有一个小的误差导致数值还是差1。。
		//可以稍微添加一点操作判断一下
		return (low * low > x) ? (int)low - 1 : (int)low; 
//		if (low * low > x) {
//			return low - 1;
//		}else {
//			return low;
//		}//加了这个略显多余的小判断结果就完全正常了
		//没想到第一次提交居然超时了-2147395599。。应该是有不少方法可以缩短搜索边界的//比如对大部分数字而言，都有sqrt(x) < x/2 
		//						  2147483647
		//突然想到这个数字会不会超过int上限了？？之前有遇到过int要换成long才可以的情况
		//果然是尼玛又超过最大范围了，那么题设中的参数类型int x完全就写错了。。。
		//改完参数类型正常
		
		
    }
	
	
//	public int mySqrt(int x) {
//		//题目提到x guaranteed to 正数，负数没意义
//		int low = 0; int high = x;
////		int precision = 1;
////		while ((high - low) > precision) {
//		while (high > low) {
//			int mid = (low + high) / 2;
//			//这里中点类型设置为int时应该会导致迭代更快收敛，但是解的精度不高
//			//对于本题特定返回整数部分的情况可以这样处理
//			if (mid * mid == x) {
//				return mid;
//			}
//			if(mid * mid  > x){
//				high = mid - 1;
//			}else {
//				low = mid + 1;
//			}
//		}
//		
//        //return low;
//        //当返回low时，3-2,5-3,7-2??
//		//return high;
//		//单纯返回high也不行，会在边界值交界处有一个小的误差导致数值还是差1。。
//		//可以稍微添加一点操作判断一下
//		return (low * low > x) ? low - 1 : low; 
////		if (low * low > x) {
////			return low - 1;
////		}else {
////			return low;
////		}//加了这个略显多余的小判断结果就完全正常了
//		//没想到第一次提交居然超时了-2147395599。。应该是有不少方法可以缩短搜索边界的
//		//						  2147483647
//		//突然想到这个数字会不会超过int上限了？？之前有遇到过int要换成long才可以的情况
//		//果然是尼玛又超过最大范围了，那么题设中的参数类型int x完全就写错了。。。
//		//比如对大部分数字而言，都有sqrt(x) < x/2 
//		
//    }

}
