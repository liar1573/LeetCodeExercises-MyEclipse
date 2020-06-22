/**GetLongestPalindromicSubstringReview2.java
 * com.leetcode.dp
 * TODO
 * �ڶ��θ�ϰ����������Ӵ����㷨
 * ���������������Git-repo���濴��һ���ǳ������㷨
 * LC-5
 * @author liar
 * 2020��6��22�� ����2:56:07
 * @version 1.0
 */
package com.leetcode.dp;


public class GetLongestPalindromicSubstringReview2 {
	
	public String getPalin(String input, int left, int right) {
		//�����������Ϊleft��right�ǳ�����
		//ͳһ�˻��ĳ���Ϊ������ż���������
		while (left >= 0 && right < input.length() 
				&& input.charAt(left) == input.charAt(right)) {
			left--;  right++;
		}
		return input.substring(left + 1, right);
		//����C++��java���ַ����±괦����һ����Ҫ��΢ע��
	}
	
	public String longestPalindrome(String s) {
		//���ⷨ�ı��ʾ�������forǶ��ѭ��
		//����DP�ⷨ�ڱ��Ⲣ���ܼ��ٸ��Ӷȣ�dp����Ĺ������Ƚ��鷳����ֱ��ʹ������forЧ�ʸ���
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
