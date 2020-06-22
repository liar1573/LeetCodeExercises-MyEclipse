/**GetLongestPalindromicSubstring.java
 * com.leetcode.string
 * TODO
 * LC 5 获取最长回文子串的Manacher解法（马拉车
 * 这玩意感觉有点DP的意思，但是又不属于标准的DP
 * @author liar
 * 2020年4月30日 下午3:46:56
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
		
		//初始化
		p[0] = 1;
		int id = 0,mx = 1;
		//mx为当前状态下验证的回文序列能达到的最大下标值,id则为达到mx时，回文串中心点的下标
		//应该还需要一个maxIndex用于返回结果，不知道示例代码里面一开始为啥没给。。
		//示例代码好像只完成了p[]的赋值，并没有完成返回最大子串的结果
		int maxIndex = 0; //这里初始值为1或者0应该都无所谓
		for (int i = 1; i < p.length; i++) {
			if (mx > i) {
				//当前节点在最右回文边界的内容时，直接使用原来计算过的值更新当前值
				p[i] = Math.min(p[2*id-i], mx-i); 
			} else {
				p[i]= 1; 
			}
			//for(;arr[i+p[i]] == arr[i-p[i]]; p[i]++);
			for(;p[i] + i < arr.length && arr[i+p[i]] == arr[i-p[i]]; p[i]++);
			
			//在这里放一个判断记录p[i]最大值的下标
			if(p[i] > p[maxIndex] )
				maxIndex = i;
				
			if (mx < i + p[i]) {
				mx = i + p[i];
				id = i;
			}
		}
		System.out.println(maxIndex + "+" + p[maxIndex]);
		
		//return s.substring(id - p[id]/2 + 1, id + p[id]/2 - 1);
		//注意这里除了p[id]/2之外，id也要除以2（arr串中加入了#所以长度翻倍了）
		return s.substring((maxIndex - p[maxIndex])/2 , (maxIndex + p[maxIndex])/2 - 1);
		//做到这发现结果好像不太对，最后并不是要id，而是需要p[]中的一个最大值下标
		
		
	}
	
	public char[] preProcess(String input){
		//对于初始输入字符串，进行首位添加$，奇数位添加#的操作
		char[] result = new char[2*input.length() + 2];
		Arrays.fill(result, '#');
		//想了想还是先填充#，其他位置再填充别的最快
		result[0] = '$';
		for (int i = 1; i <= input.length(); i++) {
			result[2*i] = input.charAt(i - 1);
		}
		
		return result;
	}
}
