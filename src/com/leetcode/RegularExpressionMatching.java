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
 * 2020年4月5日 下午4:21:57
 * @version 1.0
 */
package com.leetcode;

import java.util.LinkedList;

public class RegularExpressionMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isMatch(String s, String p) {
		LinkedList<Character> queue = new LinkedList<Character>();
		for (int i = 0; i < s.length(); i++) {
			queue.add(s.charAt(i));
		}
		
		for (int i = 0; i < p.length(); i++) {
			if(p.charAt(i) == '.'){
				//先讨论.在讨论字母
				if(i + 1 < p.length() && (p.charAt(i + 1) == '*')){
					i++;//对于字符后附带的*直接移动走指针
					queue.clear();
				}
			}
		}
		
		return queue.isEmpty();
    }

}
