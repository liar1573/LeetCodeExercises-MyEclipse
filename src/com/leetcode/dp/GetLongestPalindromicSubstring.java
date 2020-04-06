/**GetLongestPalindromicSubstring.java
 * com.leetcode.dp
 * LC 5  返回最长回文子串
 * Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Input: "cbbd"
Output: "bb"
 * @author liar
 * 2020年4月3日 上午11:00:27
 * @version 1.0
 */
package com.leetcode.dp;


public class GetLongestPalindromicSubstring {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String longestPalindromeDP(String s) {
        //第一种使用dp的解法
		//异常判断，空串算不算回文？？姑且算好了。。不过好像下面的逻辑对了len=0的也可以返回
		//len=0时，返回"".subString(0,0);
		//被"".substring(0,1)报错了，看来还是要额外讨论。。
		if (0 == s.length()) {
			return "";
		}
		
		int len = s.length();
		boolean[][] dp = new boolean[len][len];
		int start = 0, end = 0, maxLen = 0;
		
		for (int i = 0; i < len; i++) {
			dp[i][i] = true;
		}
		
		for (int i = 0; i < len - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				dp[i][i + 1] = true;
				if (2 > maxLen) {
					start = i;end = i+1;maxLen = 2;
				}
			}
		}
		
//		for (int i = 0; i < len; i++) {
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i + 2; j < len; j++) {
				//if (s.charAt(i) == s.charAt(j) && (i+2 <= j)) {
				if (s.charAt(i) == s.charAt(j)) {
					//其实这个i+2 <= j 感觉可以直接放进j 的初始化里面，直接从i+2开始递增
					//注意到前面有dp[i][i + 1] = true;这一步其实以及对i+1=j的情况赋了初始值			
					dp[i][j] = dp[i + 1][j - 1];
					if (dp[i][j] && (j - i + 1 > maxLen)) {
						start = i;end = j;maxLen = j - i + 1;
					}
					//注意这里应该增加条件限制i+1 <= j-1 即 i+2 <= j 
					//手动迭代了一下判断，发现如果不想出现使用未初始化的值，i应该从len开始递减迭代才行
				}else {
					dp[i][j] = false; 
				}
			}
		}
		//但是这里构造完dp后并不能直接得到结果，还得进行查找处理。。
		//包含头，不包含尾巴,所以这里要返回end+1而不是end
		return s.substring(start, end+1);
    }

}
