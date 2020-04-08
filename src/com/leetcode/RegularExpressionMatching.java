/**RegularExpressionMatching.java
 * com.leetcode
 * LC 10  Regular Expression Matching
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
   '*' Matches zero or more of the preceding element.
 * s could be empty and contains only lowercase letters a-z.
   p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * 
 * 
 * 
 * @author liar
 * 2020年4月5日 下午4:21:57
 * @version 1.0
 */
package com.leetcode;


public class RegularExpressionMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println();
//		System.out.println(isMatchRecursive("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*a*a*b"));
		System.out.println(isMatchDP("aab", "c*a*b"));
	}
	
	public static boolean isMatchRecursive(String s, String p) {
		int ns = s.length();
		int np = p.length();
		
		if (ns != 0 && np == 0) {
			return false;
		}
		if (ns == 0) {
			if((np & 1) == 1){
				return false;
			}
			for (int i = 1; i < np; i = i+2) {
				if (p.charAt(i) != '*') {
					return false;
				}
			}
			return true; //如果上面的for循环中没有返回则表示偶数位上都是*
		}
		
		if (s.charAt(ns - 1) == p.charAt(np - 1) || p.charAt(np - 1) == '.') {
			return isMatchRecursive(s.substring(0, ns - 1), p.substring(0, np - 1));
		}
		if (p.charAt(np - 1) == '*') {//p最后为*的情况又要分多种子情况讨论
			//对应*符号表示0个重复的情况
			if (s.charAt(ns - 1) != p.charAt(np - 2) && p.charAt(np - 2) != '.') {//注意这里np-2不会溢出的条件是假定规则p的输入
				//全部是合法的，即没有多个*连接或者*出现在字母之前的情况
				return isMatchRecursive(s, p.substring(0, np - 2));
			} else {
				//对应*符号表示多个重复的情况
//				boolean case1 = isMatch(s.substring(0, ns - 1), p);//case1表示*对应多个字符
//				boolean case2 = isMatch(s, p.substring(0, np - 1));//case2也表示*对应多个字符，好像是具体对应2个来着
//				boolean case3 = isMatch(s, p.substring(0, np - 2));//case3表示*对应0个字符的情况
				
				//把上面的三个case直接写进return试试，说不定可以由于或逻辑短路节省不少时间
				//return (case1 || case2 || case3);
				return (isMatchRecursive(s.substring(0, ns - 1), p) || isMatchRecursive(s, p.substring(0, np - 1)) || isMatchRecursive(s, p.substring(0, np - 2)));

				//笔者提到的b-1和b-2的情况好像有点重复了？
				//具体的来说，即b-1跟b-2表示的情况重复了，b-3跟a表示的情况重复了（后面推到了下好像并没有重复）
				//好像也并不重复，b-1表示*匹配多个，b-2表示*只匹配2个
				//b-1中一直保留*在末尾，使得*可以一直表示更多重复的字符
				//b-3好像表示*只对应1个字符的情况
				
			}
		}
		
		
		
		return false;
		//这里的false对于着没达到递归终止条件，同时s和p的最后一位没能匹配的情况
    }

	
	public static boolean isMatchDP(String s, String p) {
		int ns = s.length();
		int np = p.length();
		boolean[][] dp = new boolean[ns + 1][np + 1];
		dp[0][0] = true;
		
		for (int j = 2; j < np + 1; j+=2) {
			//把s长度为0，p中可能有a*b*这样的规则的情况首先做特殊判断
			if (p.charAt(j - 1) == '*') {
				dp[0][j] = dp[0][j-2];
			}
		}
		
		for (int i = 1; i < ns + 1; i++) {
//			通过实例迭代和检查源码发现自己犯了一个错误——i的下标是从0开始的，j的下标是从1开始
//			对应着可能有s.len = 0 && p.len = 2n 且p中的内容全部是x*，这种情况也是成立的！！
//			这些情况发现笔者把判断条件i > 0或者i == 0加了进去
			for (int j = 1; j < np + 1; j++) {
				//注意这里设置的下标从1开始，所以用charAt的时候下标要统一-1
				if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
					dp[i][j] = dp[i-1][j-1]; 
				}
				if (p.charAt(j-1) == '*') {
					if (s.charAt(i-1) == p.charAt(j - 2) || p.charAt(j-2) == '.') {
						dp[i][j] = (dp[i - 1][j] || dp[i][j-1]||dp[i][j-2]); 
					}
					if (s.charAt(i-1) != p.charAt(j - 2) && p.charAt(j-2) != '.') {
						dp[i][j] = dp[i][j-2];
					}
				}			
			}
		}
		
		return dp[ns][np];
	}
}
