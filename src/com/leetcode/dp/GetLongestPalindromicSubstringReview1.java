/**GetLongestPalindromicSubstringReview1.java
 * com.leetcode.dp
 * TODO
 * LC 5
 * ��һ�θ�ϰʵ�ֻ�ȡ������Ӵ���DPʵ�ַ���
 * @author liar
 * 2020��4��30�� ����2:18:28
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
		
		
		
		//����������endIndex��maxLength��ʵֻҪһ���Ϳ�����
		for (int i = s.length() - 3; i >= 0; i--) {
			for (int j = i + 2; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)  && dp[i+1][j-1]) {
					//����о�������Ҫ����ֵ��ȣ�����Ҫǰһ���׶�Ҳ��true����
					//dp[i][j] = dp[i+1][j-1];
					dp[i][j] = true;
					if(j - i + 1 > maxLength){
						maxLength = j-i+1;
						startIndex = i;
					}
				}//�����ϵ�����о�ֱ�Ӳ����¼��ɣ�Ĭ�϶���false 
			}
		}
		
		
		return s.substring(startIndex, startIndex + maxLength);
	}
}
