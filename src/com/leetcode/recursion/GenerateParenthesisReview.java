/**GenerateParenthesisReview.java
 * com.leetcode.recursion
 * TODO
 * ��������������ʲô�ط��������ţ����Ҹо�����˼·Ҳ�ܼ��ٸ�ϰһ��
 * LC 22 ����ָ�����ȵ����ű��ʽ
 * ����ϸ�����룬����ֻ�õ��˵ݹ飬��û���漰������
 * @author liar
 * 2020��5��6�� ����3:55:00
 * @version 1.0
 */
package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParenthesisReview {
	public List<String> generateParenthesis(int n) {
		ArrayList<String> result = new ArrayList<String>();
		//ӡ�������ﻹ���ֹ�һ�δ�����ǰ���ַ�������ʹ��StringBUffer������������
		//ʵ���Ͼ�Ӧ��ÿ���½�һ��String�������еݹ�
		dfs(result, "", n, n);
		
		return result;
    }
	
	public void dfs(ArrayList<String> result, String input, int left, int right) {
		if(left > right || left < 0 || right < 0)//�˴�ѡ�����������ݼ�������n--0
			return;
			//�����κ�״̬�£�һ��Ҫ��ʣ������������С�ڵ��������ţ�������ǷǷ�ƥ��ֱ�ӷ���
		 	//�����Ż�������������С��0ʱҲ����
		if(left == 0 && right == 0){
			//��ʱ�������Ÿպ�����ƥ��
			result.add(input);
			return;
		}
		
		dfs(result, input + "(", left-1, right);
		dfs(result, input + ")", left, right-1);
		//����о��������ȷ������Ż����ȷ�������Ӧ�ö���û�����
		//ͬʱ����"()"��������԰���������������У�ֱ��д�����Ļ�������Ӱ���жϡ�
	}
}
