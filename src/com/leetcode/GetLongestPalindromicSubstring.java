/**GetLongestPalindromicSubstring.java
 * com.leetcode
 * TODO
 * 获取最长回文子串，暴力解法
 * 但是注意这道题的BF解法在LeetCode上是没法通过的会超时！
示例举了个巨长的全部是重复c字母的字符串（可能是上限1k个），结果超时了。。。
因此对于本题的Brute Force算法一般只停留在理论分析阶段，实际一般不会使用(N^3的时间复杂度很可能会超时)
 * @author liar
 * 2020年4月29日 下午8:14:36
 * @version 1.0
 */
package com.leetcode;


public class GetLongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if(s.length() <2)
			//当输入长度小于2的时候，其本身就是回文的
			return s;
		
		int stratIndex = 0,endIndex = 1,maxLength = 1;
		//默认初始回文字符串就为单个字符串
		
		for (int i = 0; i < s.length() - 1; i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if (isPalindrom(s.substring(i, j + 1))) {
					if (j - i + 1> maxLength) {
						maxLength = j - i + 1;
						//上面这行一开始忘记写结果报错了
						stratIndex = i;
						endIndex = j + 1;
					}
				}
			}
		}
		//其实从这个暴力破解的二重for就可以看出来，其中有大量的重复子问题
		//即比如某个串已经不是回文了，以它为中心的串也不可能为回文，因此理论上DP是可行的
		
		
		return s.substring(stratIndex, endIndex);
	}
	
	
	
	public boolean isPalindrom(String input) {
		//根据题意，这里的参数字符串长度至少为2（长度为1的串和空串默认是回文的）
		for (int i = 0; i < input.length()/2; i++) {
			if(input.charAt(i) != input.charAt(input.length() - 1 -i))
				//注意这里一开始忘记减一被报越界了
				return false;
		}
		return true;
	}
}
