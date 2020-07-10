/**ValidParentheses.java
 * com.leetcode.stackandqueue
 * TODO
 * LC20，判断字符串中的括号是否匹配。字符串中只包含大中小三种括号字符
 * @author liar
 * 2020年7月10日 上午9:36:40
 * @version 1.0
 */
package com.leetcode.stackandqueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class ValidParentheses {
	
	public boolean isValid(String s) {
		LinkedList<Character> stack = new LinkedList<Character>();	
		for (int i = 0; i < s.length(); i++) {
			char tempChar = s.charAt(i);
			if(tempChar == '(' || tempChar == '[' || tempChar == '{'){
				stack.push(tempChar);
			}else {//除了左括号一定是右括号
				if(stack.isEmpty())
					return false;//这种情况下右括号无法匹配，返回false
				char tempLeft = stack.pop();
				if((tempLeft == '(' && tempChar != ')') ||(tempLeft == '[' && tempChar != ']') 
						||(tempLeft == '{' && tempChar != '}'))
					return false;
			}
		}
		
		return stack.isEmpty();
    }
	
	//顺便复习一下括号生成问题，LC22
	
//	 public List<String> generateParenthesis(int n) {
//		 ArrayList<String> ans = new ArrayList<String>();
//		 dfs(ans, "", 0, 0, n);
//		 return ans;
//	 }
	 
	 public void dfs(ArrayList<String> ans, String str, int left, int right, int n) {
		if(right > left || left > n || right > n)
				return;
		 
		if(str.length() == 2*n){
			ans.add(str);
			return;
		}
				
		dfs(ans, str + "(", left + 1, right, n);
		dfs(ans, str + ")", left, right + 1, n);
	 }
	 
	 //使用递归回溯的解法
	 public List<String> generateParenthesis(int n) {
		 ArrayList<String> ans = new ArrayList<String>();
		 backTracing(ans, new char[2 * n], 0, 0, 0);
		 return ans;
	 }
	 
	 public void backTracing(ArrayList<String> ans, char[] arr, int left, int right, int index) {
			if(right > left || left > arr.length/2 || right > arr.length/2)
					return;
			 
			if(index == arr.length){
				ans.add(String.valueOf(arr));
				return;
			}
			
			arr[index] = '(';
			backTracing(ans, arr, left + 1, right, index + 1);
			
			arr[index] = ')';
			backTracing(ans, arr, left, right + 1, index + 1);
		 }
}
