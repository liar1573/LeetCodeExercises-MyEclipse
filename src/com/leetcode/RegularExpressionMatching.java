/**RegularExpressionMatching.java
 * com.leetcode
 * LC 10  Regular Expression Matching
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
   '*' Matches zero or more of the preceding element.
 * s could be empty and contains only lowercase letters a-z.
   p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * 
 * 
 * 
 * @author liar
 * 2020��4��5�� ����4:21:57
 * @version 1.0
 */
package com.leetcode;


public class RegularExpressionMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println();
//		System.out.println(isMatchRecursive("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*a*a*b"));
		System.out.println(isMatchDP("aab", "c*a*b"));
	}
	
	public static boolean isMatchRecursive(String s, String p) {
		int ns = s.length();
		int np = p.length();
		
		if (ns != 0 && np == 0) {
			return false;
		}
		if (ns == 0) {
			if((np & 1) == 1){
				return false;
			}
			for (int i = 1; i < np; i = i+2) {
				if (p.charAt(i) != '*') {
					return false;
				}
			}
			return true; //��������forѭ����û�з������ʾż��λ�϶���*
		}
		
		if (s.charAt(ns - 1) == p.charAt(np - 1) || p.charAt(np - 1) == '.') {
			return isMatchRecursive(s.substring(0, ns - 1), p.substring(0, np - 1));
		}
		if (p.charAt(np - 1) == '*') {//p���Ϊ*�������Ҫ�ֶ������������
			//��Ӧ*���ű�ʾ0���ظ������
			if (s.charAt(ns - 1) != p.charAt(np - 2) && p.charAt(np - 2) != '.') {//ע������np-2��������������Ǽٶ�����p������
				//ȫ���ǺϷ��ģ���û�ж��*���ӻ���*��������ĸ֮ǰ�����
				return isMatchRecursive(s, p.substring(0, np - 2));
			} else {
				//��Ӧ*���ű�ʾ����ظ������
//				boolean case1 = isMatch(s.substring(0, ns - 1), p);//case1��ʾ*��Ӧ����ַ�
//				boolean case2 = isMatch(s, p.substring(0, np - 1));//case2Ҳ��ʾ*��Ӧ����ַ��������Ǿ����Ӧ2������
//				boolean case3 = isMatch(s, p.substring(0, np - 2));//case3��ʾ*��Ӧ0���ַ������
				
				//�����������caseֱ��д��return���ԣ�˵�����������ڻ��߼���·��ʡ����ʱ��
				//return (case1 || case2 || case3);
				return (isMatchRecursive(s.substring(0, ns - 1), p) || isMatchRecursive(s, p.substring(0, np - 1)) || isMatchRecursive(s, p.substring(0, np - 2)));

				//�����ᵽ��b-1��b-2����������е��ظ��ˣ�
				//�������˵����b-1��b-2��ʾ������ظ��ˣ�b-3��a��ʾ������ظ��ˣ������Ƶ����º���û���ظ���
				//����Ҳ�����ظ���b-1��ʾ*ƥ������b-2��ʾ*ֻƥ��2��
				//b-1��һֱ����*��ĩβ��ʹ��*����һֱ��ʾ�����ظ����ַ�
				//b-3�����ʾ*ֻ��Ӧ1���ַ������
				
			}
		}
		
		
		
		return false;
		//�����false������û�ﵽ�ݹ���ֹ������ͬʱs��p�����һλû��ƥ������
    }

	
	public static boolean isMatchDP(String s, String p) {
		int ns = s.length();
		int np = p.length();
		boolean[][] dp = new boolean[ns + 1][np + 1];
		dp[0][0] = true;
		
		for (int j = 2; j < np + 1; j+=2) {
			//��s����Ϊ0��p�п�����a*b*�����Ĺ������������������ж�
			if (p.charAt(j - 1) == '*') {
				dp[0][j] = dp[0][j-2];
			}
		}
		
		for (int i = 1; i < ns + 1; i++) {
//			ͨ��ʵ�������ͼ��Դ�뷢���Լ�����һ�����󡪡�i���±��Ǵ�0��ʼ�ģ�j���±��Ǵ�1��ʼ
//			��Ӧ�ſ�����s.len = 0 && p.len = 2n ��p�е�����ȫ����x*���������Ҳ�ǳ����ģ���
//			��Щ������ֱ��߰��ж�����i > 0����i == 0���˽�ȥ
			for (int j = 1; j < np + 1; j++) {
				//ע���������õ��±��1��ʼ��������charAt��ʱ���±�Ҫͳһ-1
				if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
					dp[i][j] = dp[i-1][j-1]; 
				}
				if (p.charAt(j-1) == '*') {
					if (s.charAt(i-1) == p.charAt(j - 2) || p.charAt(j-2) == '.') {
						dp[i][j] = (dp[i - 1][j] || dp[i][j-1]||dp[i][j-2]); 
					}
					if (s.charAt(i-1) != p.charAt(j - 2) && p.charAt(j-2) != '.') {
						dp[i][j] = dp[i][j-2];
					}
				}			
			}
		}
		
		return dp[ns][np];
	}
}
