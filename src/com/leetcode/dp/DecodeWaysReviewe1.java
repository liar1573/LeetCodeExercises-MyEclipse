/**
 * 2020/11/10，再复习LC91，字符串解码方法，经典DP题目之一
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
//		//目前参考这个C++的写法结果稍微有点问题
//		//最后的括号有一些问题。。
//		if(s.charAt(0) == '0')
//			return 0; //0开头的是非法编码序列，直接返回0
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
		if(s.charAt(0) == '0') //首字符为0的情况感觉需要特别分析一下
			return 0;
	
		//根据参考答案再优化一下自己分支代码的写法
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
//				//这里的分支赋值了之后需要直接continue的，之前没注意到
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
