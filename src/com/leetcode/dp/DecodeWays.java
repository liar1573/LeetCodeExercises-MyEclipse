/**DecodeWays.java
 * com.leetcode.dp
 * TODO
 * 91.在LC Top面试题中的一道tag为DP的题目，求1-26的数字解码为字母的方案总数
 * 由于0的出现使得本题的情况讨论更麻烦了一些
 * @author liar
 * 2020年5月19日 上午10:03:01
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
		//用于下标调整前的备份
        //注意到题设给出了这里输入一定是非空字符串序列
		if(s.charAt(0) == '0')
			return 0; //0开头的是非法编码序列，直接返回0
		
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;  dp[1] = 1;
		
		for (int i = 1; i < s.length(); i++) {
			if(s.charAt(i) == '0' && !(s.charAt(i-1) == '1' || s.charAt(i-1) == '2'))
				return 0;//遇到非法编码序列，直接返回0
			//妈个鸡一开始字符1、2忘记单引号了。。
			if(s.charAt(i) == '0' && (s.charAt(i-1) == '1' || s.charAt(i-1) == '2')){
				dp[i+1] = dp[i-1]; continue;
			}
			//前面两种已经完成了数字0的讨论
			
			//debug举反例发现，前一位为0的也要特殊讨论
			if(s.charAt(i-1) == '0'){
				dp[i+1] = dp[i]; continue;
			}
			
			//计算新增数字的组合性质
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
		//用于下标调整前的备份
        //注意到题设给出了这里输入一定是非空字符串序列
		if(s.charAt(0) == '0')
			return 0; //0开头的是非法编码序列，直接返回0
		
//		int[] dp = new int[s.length()];
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		
		for (int i = 1; i < dp.length; i++) {
			if(s.charAt(i) == '0' && !(s.charAt(i-1) == '1' || s.charAt(i-1) == '2'))
				return 0;//遇到非法编码序列，直接返回0
			//妈个鸡一开始字符1、2忘记单引号了。。
			if(s.charAt(i) == '0' && (s.charAt(i-1) == '1' || s.charAt(i-1) == '2')){
				dp[i] = Math.max(dp[i-1] - 1, 1); continue;
			    //注意到这里合法情况下dp的取值不能降为0，需要稍微处理一下
			}
			//前面两种已经完成了数字0的讨论
			
			//debug举反例发现，前一位为0的也要特殊讨论
			if(s.charAt(i-1) == '0'){
				dp[i] = dp[i-1]; continue;
			}
			
			//计算新增数字的组合性质
			int temp1 = s.charAt(i-1) - '0';
			int temp2 = s.charAt(i) - '0';
			if(10 * temp1 + temp2 <= 26)
				//dp[i] = dp[i-1] + 1;  一开始的递推公式想简单了
				dp[i] = dp[i-1] + dp[i-2]; 
			else
				dp[i] = dp[i-1]; 
		}
		
		return dp[s.length()];
		//return dp[s.length()-1];
    }

	//下方为递归解法
	
	/*直接递归
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
	
	/*  使用辅助标记数组的递归
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

