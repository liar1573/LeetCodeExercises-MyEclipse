/**SpecialSum.java
 * com.nowcoder.aimforoffer.others
 * TODO
 * ��1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case
 * �ȹؼ��ּ������ж���䣨A?B:C����
 * @author liar
 * 2020��6��14�� ����10:33:32
 * @version 1.0
 */
package com.nowcoder.aimforoffer.others;


public class SpecialSum {
	 public int Sum_Solution(int n) {
		 //ʹ��power
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
