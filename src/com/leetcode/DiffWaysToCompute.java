/**DiffWaysToCompute.java
 * com.leetcode
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。
 * 你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 * @author liar
 * 2021年1月22日 下午9:52:34
 * @version 1.0
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class DiffWaysToCompute {

	/**
	 * @Description: TODO
	 * @para: @param args
	 * @return: void
	 * @throws: @param args
	 * @author: liar
	 * @date: 2021年1月22日 下午9:52:34
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DiffWaysToCompute test = new DiffWaysToCompute();
		test.diffWaysToCompute("2-1-1-12");
	}
	
	public List<Integer> diffWaysToCompute(String input) {
	    List<Integer> ways = new ArrayList<>();
	    for (int i = 0; i < input.length(); i++) {
	    //可以看到这里并没有跟自己之前推测的那样，一开始先遍历字符串并转换为数字和运算符，然后接下来再操作
	    //这里作者直接一遍遍历字符串，然后在遍历的过程中再调用递归
	        char c = input.charAt(i);
	        if (c == '+' || c == '-' || c == '*') {
	            List<Integer> left = diffWaysToCompute(input.substring(0, i));
	            List<Integer> right = diffWaysToCompute(input.substring(i + 1));//substring只有一个索引参数时，直接从该位置到字符串末尾截断
	            //注意到这里的分治（或者也可以叫递归吧）操作非常巧妙，直接递归调用处理操作符的两侧
	            //并且也可以看到，这里并没有纠结于括号的组合，而是直接以运算符为中心来确定计算顺序
	            for (int l : left) {
	                for (int r : right) {
	                    switch (c) {//很久没有用switch，都快忘了语法规定了。。
	                        case '+':
	                            ways.add(l + r);
	                            break;
	                        case '-':
	                            ways.add(l - r);
	                            break;
	                        case '*':
	                            ways.add(l * r);
	                            break;
	                    }
	                }
	            }
	        }
	    }
	    if (ways.size() == 0) {//这里是对没有操作符的字符串，只有一个数字的字符串进行处理
	    	//这种特殊情况一般都作为递归出口放在递归函数的最开头，而这里放在了最后面有点神奇
	        ways.add(Integer.valueOf(input));
	    }
	    return ways;
	}
	
	
//	public void stringToArray(String input, int[] nums, char[] operators){
//		//这里似乎还得先确认数字和字符串的个数，才能初始化数组并传入
//		
//		
//	}
	
	
}
