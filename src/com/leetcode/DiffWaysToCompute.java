/**DiffWaysToCompute.java
 * com.leetcode
 * ����һ���������ֺ���������ַ�����Ϊ���ʽ������ţ��ı����������ȼ��������ͬ�Ľ����
 * ����Ҫ�������п��ܵ���ϵĽ������Ч��������Ű��� +, - �Լ� * ��
 * @author liar
 * 2021��1��22�� ����9:52:34
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
	 * @date: 2021��1��22�� ����9:52:34
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DiffWaysToCompute test = new DiffWaysToCompute();
		test.diffWaysToCompute("2-1-1-12");
	}
	
	public List<Integer> diffWaysToCompute(String input) {
	    List<Integer> ways = new ArrayList<>();
	    for (int i = 0; i < input.length(); i++) {
	    //���Կ������ﲢû�и��Լ�֮ǰ�Ʋ��������һ��ʼ�ȱ����ַ�����ת��Ϊ���ֺ��������Ȼ��������ٲ���
	    //��������ֱ��һ������ַ�����Ȼ���ڱ����Ĺ������ٵ��õݹ�
	        char c = input.charAt(i);
	        if (c == '+' || c == '-' || c == '*') {
	            List<Integer> left = diffWaysToCompute(input.substring(0, i));
	            List<Integer> right = diffWaysToCompute(input.substring(i + 1));//substringֻ��һ����������ʱ��ֱ�ӴӸ�λ�õ��ַ���ĩβ�ض�
	            //ע�⵽����ķ��Σ�����Ҳ���Խеݹ�ɣ������ǳ����ֱ�ӵݹ���ô��������������
	            //����Ҳ���Կ��������ﲢû�о��������ŵ���ϣ�����ֱ���������Ϊ������ȷ������˳��
	            for (int l : left) {
	                for (int r : right) {
	                    switch (c) {//�ܾ�û����switch�����������﷨�涨�ˡ���
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
	    if (ways.size() == 0) {//�����Ƕ�û�в��������ַ�����ֻ��һ�����ֵ��ַ������д���
	    	//�����������һ�㶼��Ϊ�ݹ���ڷ��ڵݹ麯�����ͷ�������������������е�����
	        ways.add(Integer.valueOf(input));
	    }
	    return ways;
	}
	
	
//	public void stringToArray(String input, int[] nums, char[] operators){
//		//�����ƺ�������ȷ�����ֺ��ַ����ĸ��������ܳ�ʼ�����鲢����
//		
//		
//	}
	
	
}
