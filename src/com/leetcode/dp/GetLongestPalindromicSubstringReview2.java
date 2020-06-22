/**GetLongestPalindromicSubstringReview2.java
 * com.leetcode.dp
 * TODO
 * 第二次复习返回最长回文子串的算法
 * 这次在拉不拉东的Git-repo里面看到一个非常简洁的算法
 * LC-5
 * @author liar
 * 2020年6月22日 下午2:56:07
 * @version 1.0
 */
package com.leetcode.dp;


public class GetLongestPalindromicSubstringReview2 {
	
	public String getPalin(String input, int left, int right) {
		//这里参数设置为left和right非常巧妙
		//统一了回文长度为奇数和偶数两种情况
		while (left >= 0 && right < input.length() 
				&& input.charAt(left) == input.charAt(right)) {
			left--;  right++;
		}
		return input.substring(left + 1, right);
		//这里C++和java的字符串下标处理风格不一样需要稍微注意
	}
	
	public String longestPalindrome(String s) {
		//本解法的本质就是两层for嵌套循环
		//由于DP解法在本题并不能减少复杂度，dp矩阵的构建还比较麻烦，故直接使用两层for效率更高
		String result = new String();
		for (int i = 0; i < s.length(); i++) {
			String s1 = getPalin(s, i, i);
			String s2 = getPalin(s, i, i+1);
			result = (s1.length() > result.length())?new String(s1): result;
			result = (s2.length() > result.length())?new String(s2): result;
		}
		
		return result;
	}
}
