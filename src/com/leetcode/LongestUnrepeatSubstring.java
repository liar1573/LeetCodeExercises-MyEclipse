/**LongestUnrepeatSubstring.java
 * LC 3. Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters.
 * Example 1��
 * Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
 * @author liar
 * 2020��3��31�� ����10:51:54
 * @version 1.0
 */
package com.leetcode;

import java.util.ArrayList;

public class LongestUnrepeatSubstring {

	/**
	 * @Description: TODO
	 * @para: @param args
	 * @return: void
	 * @throws: @param args
	 * @author: liar
	 * @date: 2020��3��31�� ����10:51:54
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestUnrepeatSubstring testL = new LongestUnrepeatSubstring();
//		Character[] show = new Character[20]; 
//		testL.LongestSubstring("pwwkew");
//		for (Character character : show) {
//			System.out.print(character);
//		}
//		System.out.print(testL.lengthOfLongestSubstringWay2(""));
		System.out.print(testL.lengthOfLongestSubstringWay3("pwwkew"));
	}
	
	public ArrayList<Character> LongestSubstring(String s) {
		//ֱ�ӷ���һ����Ӵ�
		char[] arr = s.toCharArray();
		ArrayList<Character> charList = new ArrayList<Character>();
		int result = 0;
		ArrayList<Character> resultList = new ArrayList<Character>();
		
		for (int i = 0; i < arr.length; i++) {
			//Ϊ�˲����⴦��մ�""�����Ǵ�0�±꿪ʼ����
			int index = charList.indexOf(arr[i]);
			if (-1 == index) {
				charList.add(arr[i]);
//				result = (charList.size() > result) ? charList.size(): result;
				if(charList.size() > result){
					result = charList.size();
					resultList = (ArrayList<Character>) charList.clone();
				}
			}else {//������ֹ�����Ҫ����ǰ�������Ƴ�
				//charList.removeRange(0, index + 1); û�취ֱ��ʹ�ã�protect����
				for (int j = 0; j <= index; j++) {
					charList.remove(0);
				}
				//��һ�����ǰ��µļӽ�ȥ�ˣ�ֻȥ������ǰ�ظ��ġ���
				charList.add(arr[i]);
				//����֮��㶨�ˣ�ʱ��Ч��Ҳ����
			}
	
		}		
		//return result;
		for (Character character : resultList) {
			System.out.print(character);
		}
		return charList;
		
		
	}
	
	public int lengthOfLongestSubstringWay2(String s) {
		//�ع�����ǰ�ıʼ�֮������дһ��dp�Ľⷨ
		//������߼��Գ���Ϊ0��1�����û�취������Ҫ�����ж�һ��
		if (s.length() < 2) {
			return s.length();
		}
		int result = 1;
		int tempValue = 1;
		char[] arr = s.toCharArray();
		int startIndex = 0;
		//toCharArray()���ڿմ����ǻ᷵��һ������Ϊ0���ַ�������
		for (int i = 1; i < arr.length; i++) {
			boolean flag = true;//�����жϵ�ǰԪ�ظ���ǰ���Ƿ����ظ���
			for (int j = startIndex; j < i; j++) {
				if(arr[i] == arr[j] ){
					startIndex = j + 1;
					//ͨ��"pwwkew"�ļ�飬���ﻹ��Ҫ�޸�result
					tempValue = i - j;
					flag = false;
					break;//���ֻ������һ���ظ��ַ�������Ҫȫ��������
				}
			}
			if (flag) {
				tempValue++;
				result = (tempValue > result) ? tempValue : result;
			}
		}
		
		return result;
	}
	
	public int lengthOfLongestSubstringWay1(String s) {
		//��γ���ά��һ����Ӵ�
		//����ⷨ��֪���ܲ��ܴ���մ�������
		//������ԣ������ڿմ�""��toCharArray�᷵��һ������Ϊ0������
		char[] arr = s.toCharArray();
		ArrayList<Character> charList = new ArrayList<Character>();
		int result = 0;
		
		for (int i = 0; i < arr.length; i++) {
			//Ϊ�˲����⴦��մ�""�����Ǵ�0�±꿪ʼ����
			int index = charList.indexOf(arr[i]);
			if (-1 == index) {
				charList.add(arr[i]);
				result = (charList.size() > result) ? charList.size(): result;
			}else {//������ֹ�����Ҫ����ǰ�������Ƴ�
				//charList.removeRange(0, index + 1); û�취ֱ��ʹ�ã�protect����
				for (int j = 0; j <= index; j++) {
					charList.remove(0);
				}
				//��һ�����ǰ��µļӽ�ȥ�ˣ�ֻȥ������ǰ�ظ��ġ���
				charList.add(arr[i]);
				//����֮��㶨�ˣ�ʱ��Ч��Ҳ����
			}
	
		}		
		return result;
	}

}
