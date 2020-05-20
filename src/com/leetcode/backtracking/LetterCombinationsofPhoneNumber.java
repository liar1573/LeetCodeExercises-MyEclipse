/**LetterCombinationsofPhoneNumber.java
 * com.leetcode.backtracking
 * TODO
 * 17. Letter Combinations of a Phone Number 2G时代经常用手机数字键盘发短信的情况
 * @author liar
 * 2020年5月20日 下午2:15:25
 * @version 1.0
 */
package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofPhoneNumber {
	public static void main(String[] args) {
		LetterCombinationsofPhoneNumber test = new LetterCombinationsofPhoneNumber();
		System.out.println(test.letterCombinations("23"));
	
	}
	
	
	public List<String> letterCombinations(String digits) {
		//还是把判空加上好了
		ArrayList<String> result = new ArrayList<String>();
		if(digits == null || digits.length() == 0)
			return result;
		
		//这里7和8都是四个字符，其他数字都只对应3个字符，长度没统一有点恶心。。
		//再用个List好了。。
		ArrayList<String> numberMap = new ArrayList<String>();
		//保持下标顺序统一
		numberMap.add("");	numberMap.add("");	numberMap.add("abc");  numberMap.add("def");	
		numberMap.add("ghi");  numberMap.add("jkl");  numberMap.add("mno");  numberMap.add("pqrs");
		numberMap.add("tuv");  numberMap.add("wxyz");
		//妈个鸡这种机械结构定义应该预定义好不需要我们操作才对。。
		
		//这题看上去是比较容易的数学组合问题，就是如何用编码实现得考虑一下。。
				//能否多重嵌套循环来做？？
//		for (int i = 0; i < digits.length(); i++) {
//			//这里数字和字母的一对多映射要怎么记录一下呢？ 数组？
//		}		
		dfs(0, numberMap, result, "", digits);
		
		System.out.println(result);
		return result;
    }
	
	public void dfs(int index, ArrayList<String> numberMap, 
			ArrayList<String> result, String input, String digits) {
		if(input.length() == digits.length()){
			result.add(input);
			return;
		}
		
		int tempIndex = digits.charAt(index) - '0';
		//这里找一个中间变量表示一下，不然程序中指示下标的代码太长了
		for (int i = 0; i < numberMap.get(tempIndex).length(); i++) 
			dfs(index + 1, numberMap, result, input + numberMap.get(tempIndex).charAt(i), digits);	
	}
}
