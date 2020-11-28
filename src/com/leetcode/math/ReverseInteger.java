/**
 * LC7��������ת������һ�� 32λ���з���������������������ÿλ�ϵ����ֽ��з�ת������֡�������123��Ҫ���321.
 */
package com.leetcode.math;


public class ReverseInteger {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testInt = 123;
		ReverseInteger test = new ReverseInteger();
		System.out.println(test.reverse(testInt));
	}
	
	public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
	
	
//	public int reverse(int x) {
//		int ans = 0, lastFlag = 0;
//		int pre = 0; //���ڴ洢ǰһ��ֵ�ж��Ƿ����
//		boolean positive = true;
//		if (x < 0) {
//			positive = false;
//			x = -x;
//		}
//		
//		lastFlag = x % 10;
//		x = x / 10;
//		ans = ans + lastFlag;
//		
//		while (x > 0) {
//			lastFlag = x % 10;
//			x = x / 10;
//			ans = ans * 10;
//			ans = ans + lastFlag;
//			if(ans < pre)
//				return 0;
//			pre = ans;
//		}
//		
//		if (!positive) {
//			return -ans;
//		} else {
//			return ans;
//		}
//		
//    }
}
