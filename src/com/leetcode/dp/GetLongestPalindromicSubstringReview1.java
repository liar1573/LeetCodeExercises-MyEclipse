/**GetLongestPalindromicSubstringReview1.java
 * com.leetcode.dp
 * TODO
 * LC 5
 * 再一次复习实现获取最长回文子串的DP实现方法
 * @author liar
 * 2020年4月30日 下午2:18:28
 * @version 1.0
 */
package com.leetcode.dp;


public class GetLongestPalindromicSubstringReview1 {
	public String longestPalindromeDP(String s) {
		if(s.length() < 2)
			return s;
		
		boolean[][] dp = new boolean[s.length()][s.length()];
		int startIndex = 0,maxLength = 1;
		for (int i = 0; i < dp.length; i++) {
			dp[i][i] = true;
			if(i + 1 < dp.length && (s.charAt(i) == s.charAt(i+1))){
				dp[i][i+1] = true;
				if(2 > maxLength){
					maxLength = 2;
					startIndex = i;
				}
			}
		}
		
		
		
		//后来想了想endIndex和maxLength其实只要一个就可以了
		for (int i = s.length() - 3; i >= 0; i--) {
			for (int j = i + 2; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)  && dp[i+1][j-1]) {
					//这里感觉不光需要两个值相等，还需要前一个阶段也是true才行
					//dp[i][j] = dp[i+1][j-1];
					dp[i][j] = true;
					if(j - i + 1 > maxLength){
						maxLength = j-i+1;
						startIndex = i;
					}
				}//不符合的情况感觉直接不更新即可，默认都是false 
			}
		}
		
		
		return s.substring(startIndex, startIndex + maxLength);
	}
}
