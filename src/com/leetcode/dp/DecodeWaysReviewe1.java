/**
 * 2020/11/10���ٸ�ϰLC91���ַ������뷽��������DP��Ŀ֮һ
 */
package com.leetcode.dp;


public class DecodeWaysReviewe1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecodeWaysReviewe1 test = new DecodeWaysReviewe1();
		System.out.println(test.numDecodings("2101"));
	}

//	public int numDecodingsSample(String s) {
//		//Ŀǰ�ο����C++��д�������΢�е�����
//		//����������һЩ���⡣��
//		if(s.charAt(0) == '0')
//			return 0; //0��ͷ���ǷǷ��������У�ֱ�ӷ���0
//		int pre = 1, curr = 1;
//		
//		for (int i = 1; i < s.length(); i++) {
//			int temp = curr;
//			if(s.charAt(0) == '0'){
//				if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2')  curr = pre;
//				else	return 0;
//				}
//			else if (s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i-1) - '0' > 0 && s.charAt(i-1) - '0' <= 6)) {
//				curr = curr + temp;
//			}
////			else {
////				pre = temp;
////			}
//			pre = temp;
//		}
//		
//		return curr;
//	}
	
	

	public int numDecodings(String s) {
		int[] dp = new int[s.length() + 1];
		dp[0] = 1; dp[1] = 1;
		if(s.charAt(0) == '0') //���ַ�Ϊ0������о���Ҫ�ر����һ��
			return 0;
	
		//���ݲο������Ż�һ���Լ���֧�����д��
		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);

			
			if (c == '0'){
				if(s.charAt(i-1) != '1' && s.charAt(i-1) != '2')
					return 0;
				else
					dp[i+1] = dp[i-1];	
			} else if (s.charAt(i-1) == '1'){
				dp[i+1] = dp[i] + dp[i-1];
			}else if (s.charAt(i-1) == '2' && (c - '0' > 0) && (c - '0' <= 6)) {
				dp[i+1] = dp[i] + dp[i-1];
			}else{
				dp[i+1] = dp[i];
			}
			
			
//			if (c == '0'){
//				if(s.charAt(i-1) != '1' && s.charAt(i-1) != '2')
//					return 0;
//				else{
//					dp[i+1] = dp[i-1];
//					continue;
//				}
//				//����ķ�֧��ֵ��֮����Ҫֱ��continue�ģ�֮ǰûע�⵽
//			}
//				
//			if (s.charAt(i-1) == '1' && c != '0'){
//				dp[i+1] = dp[i] + dp[i-1];
//			}else if (s.charAt(i-1) == '2' && (c - '0' > 0) && (c - '0' <= 6)) {
//				dp[i+1] = dp[i] + dp[i-1];
//			}else{
//				dp[i+1] = dp[i];
//			}
			
	
		}
		
		return dp[s.length()];
    }
}
