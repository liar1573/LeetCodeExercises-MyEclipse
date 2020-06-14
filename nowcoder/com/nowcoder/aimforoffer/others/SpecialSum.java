/**SpecialSum.java
 * com.nowcoder.aimforoffer.others
 * TODO
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case
 * 等关键字及条件判断语句（A?B:C）。
 * @author liar
 * 2020年6月14日 上午10:33:32
 * @version 1.0
 */
package com.nowcoder.aimforoffer.others;


public class SpecialSum {
	 public int Sum_Solution(int n) {
		 //使用power
		 int result = (int) Math.pow(n, 2);
		 result += n;
		 result = result >> 1;
		 return result;
	 }
	 
	 public int Sum_SolutionExample(int n) {
		 int sum = n;
		 boolean flag = (n > 0) && ((sum += Sum_Solution(n-1)) > 0);
		 return sum;
	 }
}
