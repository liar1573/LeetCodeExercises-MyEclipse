/**LongestUnrepeatSubstring.java
 * LC 3. Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters.
 * Example 1：
 * Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
 * @author liar
 * 2020年3月31日 上午10:51:54
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
	 * @date: 2020年3月31日 上午10:51:54
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
		//直接返回一个最长子串
		char[] arr = s.toCharArray();
		ArrayList<Character> charList = new ArrayList<Character>();
		int result = 0;
		ArrayList<Character> resultList = new ArrayList<Character>();
		
		for (int i = 0; i < arr.length; i++) {
			//为了不特殊处理空串""，还是从0下标开始好了
			int index = charList.indexOf(arr[i]);
			if (-1 == index) {
				charList.add(arr[i]);
//				result = (charList.size() > result) ? charList.size(): result;
				if(charList.size() > result){
					result = charList.size();
					resultList = (ArrayList<Character>) charList.clone();
				}
			}else {//如果出现过，需要把以前的序列移除
				//charList.removeRange(0, index + 1); 没办法直接使用，protect类型
				for (int j = 0; j <= index; j++) {
					charList.remove(0);
				}
				//第一次忘记把新的加进去了，只去掉了以前重复的。。
				charList.add(arr[i]);
				//加完之后搞定了，时空效率也还行
			}
	
		}		
		//return result;
		for (Character character : resultList) {
			System.out.print(character);
		}
		return charList;
		
		
	}
	
	public int lengthOfLongestSubstringWay2(String s) {
		//回顾了以前的笔记之后再来写一个dp的解法
		//下面的逻辑对长度为0和1的情况没办法处理，需要特殊判断一下
		if (s.length() < 2) {
			return s.length();
		}
		int result = 1;
		int tempValue = 1;
		char[] arr = s.toCharArray();
		int startIndex = 0;
		//toCharArray()对于空串而是会返回一个长度为0的字符串数组
		for (int i = 1; i < arr.length; i++) {
			boolean flag = true;//用于判断当前元素跟以前的是否有重复的
			for (int j = startIndex; j < i; j++) {
				if(arr[i] == arr[j] ){
					startIndex = j + 1;
					//通过"pwwkew"的检查，这里还需要修改result
					tempValue = i - j;
					flag = false;
					break;//最多只可能有一个重复字符，不需要全部遍历完
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
		//这次尝试维护一个最长子串
		//这个解法不知道能不能处理空串啊？？
		//还真可以！！对于空串""，toCharArray会返回一个长度为0的数组
		char[] arr = s.toCharArray();
		ArrayList<Character> charList = new ArrayList<Character>();
		int result = 0;
		
		for (int i = 0; i < arr.length; i++) {
			//为了不特殊处理空串""，还是从0下标开始好了
			int index = charList.indexOf(arr[i]);
			if (-1 == index) {
				charList.add(arr[i]);
				result = (charList.size() > result) ? charList.size(): result;
			}else {//如果出现过，需要把以前的序列移除
				//charList.removeRange(0, index + 1); 没办法直接使用，protect类型
				for (int j = 0; j <= index; j++) {
					charList.remove(0);
				}
				//第一次忘记把新的加进去了，只去掉了以前重复的。。
				charList.add(arr[i]);
				//加完之后搞定了，时空效率也还行
			}
	
		}		
		return result;
	}

}
