/**GetLongestPalindromicSubstring.java
 * com.leetcode.dp
 * LC 5  ����������Ӵ�
 * Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Input: "cbbd"
Output: "bb"
 * @author liar
 * 2020��4��3�� ����11:00:27
 * @version 1.0
 */
package com.leetcode.dp;


public class GetLongestPalindromicSubstring {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String longestPalindromeDP(String s) {
        //��һ��ʹ��dp�Ľⷨ
		//�쳣�жϣ��մ��㲻����ģ�����������ˡ�����������������߼�����len=0��Ҳ���Է���
		//len=0ʱ������"".subString(0,0);
		//��"".substring(0,1)�����ˣ���������Ҫ�������ۡ���
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
					//��ʵ���i+2 <= j �о�����ֱ�ӷŽ�j �ĳ�ʼ�����棬ֱ�Ӵ�i+2��ʼ����
					//ע�⵽ǰ����dp[i][i + 1] = true;��һ����ʵ�Լ���i+1=j��������˳�ʼֵ			
					dp[i][j] = dp[i + 1][j - 1];
					if (dp[i][j] && (j - i + 1 > maxLen)) {
						start = i;end = j;maxLen = j - i + 1;
					}
					//ע������Ӧ��������������i+1 <= j-1 �� i+2 <= j 
					//�ֶ�������һ���жϣ���������������ʹ��δ��ʼ����ֵ��iӦ�ô�len��ʼ�ݼ���������
				}else {
					dp[i][j] = false; 
				}
			}
		}
		//�������ﹹ����dp�󲢲���ֱ�ӵõ���������ý��в��Ҵ�����
		//����ͷ��������β��,��������Ҫ����end+1������end
		return s.substring(start, end+1);
    }

}
