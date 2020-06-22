/**GetLongestPalindromicSubstring.java
 * com.leetcode.string
 * TODO
 * LC 5 ��ȡ������Ӵ���Manacher�ⷨ��������
 * ������о��е�DP����˼�������ֲ����ڱ�׼��DP
 * @author liar
 * 2020��4��30�� ����3:46:56
 * @version 1.0
 */
package com.leetcode.string;

import java.util.Arrays;

public class GetLongestPalindromicSubstring {
	public static void main(String[] args) {
		GetLongestPalindromicSubstring test = new GetLongestPalindromicSubstring();
		System.out.println(test.longestPalindromeDP("babad"));

	}
	
	public String longestPalindromeDP(String s) {
 		if(s.length() < 2)
			return s;
		
		char[] arr = preProcess(s);
		int[] p = new int[2*s.length() + 2];
		
		//��ʼ��
		p[0] = 1;
		int id = 0,mx = 1;
		//mxΪ��ǰ״̬����֤�Ļ��������ܴﵽ������±�ֵ,id��Ϊ�ﵽmxʱ�����Ĵ����ĵ���±�
		//Ӧ�û���Ҫһ��maxIndex���ڷ��ؽ������֪��ʾ����������һ��ʼΪɶû������
		//ʾ���������ֻ�����p[]�ĸ�ֵ����û����ɷ�������Ӵ��Ľ��
		int maxIndex = 0; //�����ʼֵΪ1����0Ӧ�ö�����ν
		for (int i = 1; i < p.length; i++) {
			if (mx > i) {
				//��ǰ�ڵ������һ��ı߽������ʱ��ֱ��ʹ��ԭ���������ֵ���µ�ǰֵ
				p[i] = Math.min(p[2*id-i], mx-i); 
			} else {
				p[i]= 1; 
			}
			//for(;arr[i+p[i]] == arr[i-p[i]]; p[i]++);
			for(;p[i] + i < arr.length && arr[i+p[i]] == arr[i-p[i]]; p[i]++);
			
			//�������һ���жϼ�¼p[i]���ֵ���±�
			if(p[i] > p[maxIndex] )
				maxIndex = i;
				
			if (mx < i + p[i]) {
				mx = i + p[i];
				id = i;
			}
		}
		System.out.println(maxIndex + "+" + p[maxIndex]);
		
		//return s.substring(id - p[id]/2 + 1, id + p[id]/2 - 1);
		//ע���������p[id]/2֮�⣬idҲҪ����2��arr���м�����#���Գ��ȷ����ˣ�
		return s.substring((maxIndex - p[maxIndex])/2 , (maxIndex + p[maxIndex])/2 - 1);
		//�����ⷢ�ֽ������̫�ԣ���󲢲���Ҫid��������Ҫp[]�е�һ�����ֵ�±�
		
		
	}
	
	public char[] preProcess(String input){
		//���ڳ�ʼ�����ַ�����������λ���$������λ���#�Ĳ���
		char[] result = new char[2*input.length() + 2];
		Arrays.fill(result, '#');
		//�����뻹�������#������λ������������
		result[0] = '$';
		for (int i = 1; i <= input.length(); i++) {
			result[2*i] = input.charAt(i - 1);
		}
		
		return result;
	}
}
