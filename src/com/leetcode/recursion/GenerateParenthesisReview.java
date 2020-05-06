/**GenerateParenthesisReview.java
 * com.leetcode.recursion
 * TODO
 * 这道题最近好像在什么地方见过来着，而且感觉解题思路也很简单再复习一下
 * LC 22 生成指定长度的括号表达式
 * 再仔细想了想，这题只用到了递归，并没有涉及到回溯
 * @author liar
 * 2020年5月6日 下午3:55:00
 * @version 1.0
 */
package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParenthesisReview {
	public List<String> generateParenthesis(int n) {
		ArrayList<String> result = new ArrayList<String>();
		//印象中这里还出现过一次错误，以前把字符串参数使用StringBUffer传入会出现问题
		//实际上就应该每次新建一个String副本进行递归
		dfs(result, "", n, n);
		
		return result;
    }
	
	public void dfs(ArrayList<String> result, String input, int left, int right) {
		if(left > right || left < 0 || right < 0)//此处选择括号数量递减计数从n--0
			return;
			//对于任何状态下，一定要有剩余做括号数量小于等于右括号，否则就是非法匹配直接返回
		 	//左括号或者右括号数量小于0时也返回
		if(left == 0 && right == 0){
			//此时左右括号刚好用完匹配
			result.add(input);
			return;
		}
		
		dfs(result, input + "(", left-1, right);
		dfs(result, input + ")", left, right-1);
		//这里感觉理论上先放左括号还是先放右括号应该都是没问题的
		//同时新增"()"的情况可以包含在上面的流程中，直接写出来的话反而会影响判断。
	}
}
