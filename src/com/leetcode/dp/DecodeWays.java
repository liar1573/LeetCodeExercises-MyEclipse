/**DecodeWays.java
 * com.leetcode.dp
 * TODO
 * 91.��LC Top�������е�һ��tagΪDP����Ŀ����1-26�����ֽ���Ϊ��ĸ�ķ�������
 * ����0�ĳ���ʹ�ñ����������۸��鷳��һЩ
 * @author liar
 * 2020��5��19�� ����10:03:01
 * @version 1.0
 */
package com.leetcode.dp;


public class DecodeWays {
	
	public static void main(String[] args) {
		DecodeWays test = new DecodeWays();
//		System.out.println(test.numDecodings("1212"));
		//1212>5   12120>3	227>2
		System.out.println(test.numDecodings("227"));
		
	}
	

	
	public int numDecodings(String s) {
		//�����±����ǰ�ı���
        //ע�⵽�����������������һ���Ƿǿ��ַ�������
		if(s.charAt(0) == '0')
			return 0; //0��ͷ���ǷǷ��������У�ֱ�ӷ���0
		
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;  dp[1] = 1;
		
		for (int i = 1; i < s.length(); i++) {
			if(s.charAt(i) == '0' && !(s.charAt(i-1) == '1' || s.charAt(i-1) == '2'))
				return 0;//�����Ƿ��������У�ֱ�ӷ���0
			//�����һ��ʼ�ַ�1��2���ǵ������ˡ���
			if(s.charAt(i) == '0' && (s.charAt(i-1) == '1' || s.charAt(i-1) == '2')){
				dp[i+1] = dp[i-1]; continue;
			}
			//ǰ�������Ѿ����������0������
			
			//debug�ٷ������֣�ǰһλΪ0��ҲҪ��������
			if(s.charAt(i-1) == '0'){
				dp[i+1] = dp[i]; continue;
			}
			
			//�����������ֵ��������
			int temp1 = s.charAt(i-1) - '0';
			int temp2 = s.charAt(i) - '0';
			if(10 * temp1 + temp2 <= 26)
				dp[i+1] = dp[i] + dp[i-1]; 
			else
				dp[i+1] = dp[i];
		}
		
		return dp[s.length()];
    }
	
	public int numDecodingsBackUp(String s) {
		//�����±����ǰ�ı���
        //ע�⵽�����������������һ���Ƿǿ��ַ�������
		if(s.charAt(0) == '0')
			return 0; //0��ͷ���ǷǷ��������У�ֱ�ӷ���0
		
//		int[] dp = new int[s.length()];
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		
		for (int i = 1; i < dp.length; i++) {
			if(s.charAt(i) == '0' && !(s.charAt(i-1) == '1' || s.charAt(i-1) == '2'))
				return 0;//�����Ƿ��������У�ֱ�ӷ���0
			//�����һ��ʼ�ַ�1��2���ǵ������ˡ���
			if(s.charAt(i) == '0' && (s.charAt(i-1) == '1' || s.charAt(i-1) == '2')){
				dp[i] = Math.max(dp[i-1] - 1, 1); continue;
			    //ע�⵽����Ϸ������dp��ȡֵ���ܽ�Ϊ0����Ҫ��΢����һ��
			}
			//ǰ�������Ѿ����������0������
			
			//debug�ٷ������֣�ǰһλΪ0��ҲҪ��������
			if(s.charAt(i-1) == '0'){
				dp[i] = dp[i-1]; continue;
			}
			
			//�����������ֵ��������
			int temp1 = s.charAt(i-1) - '0';
			int temp2 = s.charAt(i) - '0';
			if(10 * temp1 + temp2 <= 26)
				//dp[i] = dp[i-1] + 1;  һ��ʼ�ĵ��ƹ�ʽ�����
				dp[i] = dp[i-1] + dp[i-2]; 
			else
				dp[i] = dp[i-1]; 
		}
		
		return dp[s.length()];
		//return dp[s.length()-1];
    }

	//�·�Ϊ�ݹ�ⷨ
	
	/*ֱ�ӵݹ�
	 class Solution {
    int res = 0;
    public int numDecodings(String s) {
        char[] arr = s.toCharArray();
        DFS(arr, 0);
        return res;
    }
    void DFS(char[] arr, int index) {
        if (index == arr.length) {
            res++;
            return;
        }
        if (arr[index] != '0') {
            DFS(arr, index + 1);
        }
        if (index <= arr.length -2 && (arr[index] == '1' ||(arr[index] == '2' && arr[index+1] - '6' <= 0))) {
            DFS(arr, index + 2);
        }
            
    }
} 
	 */
	
	/*  ʹ�ø����������ĵݹ�
	  public int numDecodings(String s) {
	Integer[] memo = new Integer[s.length() + 1];
	return numDecodings(s, 0, memo);
}

private int numDecodings(String s, int index, Integer[] memo) {
	if (index == s.length()) {
		return 1;
	}
	if (s.charAt(index) == '0') {
		return 0;
	}
	if (memo[index] != null) {
		return memo[index];
	}
	int way1 = numDecodings(s, index + 1, memo);
	int way2 = 0;
	if (index < s.length() - 1 && Integer.parseInt(s.substring(index, index + 2)) <= 26) {
		way2 = numDecodings(s, index + 2, memo);
	}
	memo[index] = way1 + way2;
	return memo[index];
}
	 
	 * 
	 */
	
}

