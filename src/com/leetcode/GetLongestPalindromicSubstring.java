/**GetLongestPalindromicSubstring.java
 * com.leetcode
 * TODO
 * ��ȡ������Ӵ��������ⷨ
 * ����ע��������BF�ⷨ��LeetCode����û��ͨ���Ļᳬʱ��
ʾ�����˸��޳���ȫ�����ظ�c��ĸ���ַ���������������1k�����������ʱ�ˡ�����
��˶��ڱ����Brute Force�㷨һ��ֻͣ�������۷����׶Σ�ʵ��һ�㲻��ʹ��(N^3��ʱ�临�ӶȺܿ��ܻᳬʱ)
 * @author liar
 * 2020��4��29�� ����8:14:36
 * @version 1.0
 */
package com.leetcode;


public class GetLongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if(s.length() <2)
			//�����볤��С��2��ʱ���䱾����ǻ��ĵ�
			return s;
		
		int stratIndex = 0,endIndex = 1,maxLength = 1;
		//Ĭ�ϳ�ʼ�����ַ�����Ϊ�����ַ���
		
		for (int i = 0; i < s.length() - 1; i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if (isPalindrom(s.substring(i, j + 1))) {
					if (j - i + 1> maxLength) {
						maxLength = j - i + 1;
						//��������һ��ʼ����д���������
						stratIndex = i;
						endIndex = j + 1;
					}
				}
			}
		}
		//��ʵ����������ƽ�Ķ���for�Ϳ��Կ������������д������ظ�������
		//������ĳ�����Ѿ����ǻ����ˣ�����Ϊ���ĵĴ�Ҳ������Ϊ���ģ����������DP�ǿ��е�
		
		
		return s.substring(stratIndex, endIndex);
	}
	
	
	
	public boolean isPalindrom(String input) {
		//�������⣬����Ĳ����ַ�����������Ϊ2������Ϊ1�Ĵ��Ϳմ�Ĭ���ǻ��ĵģ�
		for (int i = 0; i < input.length()/2; i++) {
			if(input.charAt(i) != input.charAt(input.length() - 1 -i))
				//ע������һ��ʼ���Ǽ�һ����Խ����
				return false;
		}
		return true;
	}
}
