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
				//������.��������ĸ
				if(i + 1 < p.length() && (p.charAt(i + 1) == '*')){
					i++;//�����ַ��󸽴���*ֱ���ƶ���ָ��
					queue.clear();
				}
			}
		}
		
		return queue.isEmpty();
    }

}
