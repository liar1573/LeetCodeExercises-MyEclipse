/**LetterCombinationsofPhoneNumber.java
 * com.leetcode.backtracking
 * TODO
 * 17. Letter Combinations of a Phone Number 2Gʱ���������ֻ����ּ��̷����ŵ����
 * @author liar
 * 2020��5��20�� ����2:15:25
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
		//���ǰ��пռ��Ϻ���
		ArrayList<String> result = new ArrayList<String>();
		if(digits == null || digits.length() == 0)
			return result;
		
		//����7��8�����ĸ��ַ����������ֶ�ֻ��Ӧ3���ַ�������ûͳһ�е���ġ���
		//���ø�List���ˡ���
		ArrayList<String> numberMap = new ArrayList<String>();
		//�����±�˳��ͳһ
		numberMap.add("");	numberMap.add("");	numberMap.add("abc");  numberMap.add("def");	
		numberMap.add("ghi");  numberMap.add("jkl");  numberMap.add("mno");  numberMap.add("pqrs");
		numberMap.add("tuv");  numberMap.add("wxyz");
		//��������ֻ�е�ṹ����Ӧ��Ԥ����ò���Ҫ���ǲ����Ŷԡ���
		
		//���⿴��ȥ�ǱȽ����׵���ѧ������⣬��������ñ���ʵ�ֵÿ���һ�¡���
				//�ܷ����Ƕ��ѭ����������
//		for (int i = 0; i < digits.length(); i++) {
//			//�������ֺ���ĸ��һ�Զ�ӳ��Ҫ��ô��¼һ���أ� ���飿
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
		//������һ���м������ʾһ�£���Ȼ������ָʾ�±�Ĵ���̫����
		for (int i = 0; i < numberMap.get(tempIndex).length(); i++) 
			dfs(index + 1, numberMap, result, input + numberMap.get(tempIndex).charAt(i), digits);	
	}
}
