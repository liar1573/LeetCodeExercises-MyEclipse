/**ValidParentheses.java
 * com.leetcode.stackandqueue
 * TODO
 * LC20���ж��ַ����е������Ƿ�ƥ�䡣�ַ�����ֻ��������С���������ַ�
 * @author liar
 * 2020��7��10�� ����9:36:40
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
			}else {//����������һ����������
				if(stack.isEmpty())
					return false;//����������������޷�ƥ�䣬����false
				char tempLeft = stack.pop();
				if((tempLeft == '(' && tempChar != ')') ||(tempLeft == '[' && tempChar != ']') 
						||(tempLeft == '{' && tempChar != '}'))
					return false;
			}
		}
		
		return stack.isEmpty();
    }
	
	//˳�㸴ϰһ�������������⣬LC22
	
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
	 
	 //ʹ�õݹ���ݵĽⷨ
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
