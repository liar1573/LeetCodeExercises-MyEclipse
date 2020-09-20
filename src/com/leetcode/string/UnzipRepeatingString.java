/**
 * 腾讯2020校园招聘-后台20200919
 * 于是小Q发明了一种压缩算法对字符串中重复的部分进行了压缩，对于字符串中连续的m个相同字符串S将会压缩为[m|S](m为一个整数且1<=m<=100)，
 * 例如字符串ABCABCABC将会被压缩为[3|ABC]，现在小Q的同学收到了小Q发送过来的字符串，你能帮助他进行解压缩么？ 
 */
package com.leetcode.string;


public class UnzipRepeatingString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(('3' - '0') == 3);
		UnzipRepeatingString test = new UnzipRepeatingString();
//		System.out.println(test.dfs("HG[3|B[2|CA]]F"));
//		System.out.println("input".substring(6, 6));
		System.out.println(test.unzipString("HG[3|B[2|CA]]F"));
	}
	
	//经过了一堆调试之后终于输出正确结果了！！！！
	//之后可以调整一下IO，去OJ上面试试
	public String unzipString(String input) {
		String result = input;
		while (result.indexOf('|') >= 0) //注意到这里不能用[]判断，只能用|
			result = unzip(result);
		
		return result;
	}
	
	public String unzip(String input) {
		//返回单次解压的结果，并没有使用递归
		StringBuilder sBuilder = new StringBuilder();
		
		int start = input.lastIndexOf('[');
		int end = input.indexOf(']');
		int seperatorIndex = input.lastIndexOf('|');	
		//新的分割模式下，每一次迭代肯定都同时含有[]和|
		
		int times = 0, bit = 1;			
		for (int i = seperatorIndex - 1; i > start; i--) {
			times += bit * (input.charAt(i) - '0');
			bit *= 10;
		}
		
		//如果有括号
		sBuilder.append(input.substring(0, start));
		sBuilder.append(repeatString(times,input.substring(seperatorIndex + 1, end)));
		sBuilder.append(input.substring(end + 1, input.length()));

		return sBuilder.toString();
	}
	
	
	
	//第一次失败的递归方法尝试
	public String dfs(String input) {
		if(input.indexOf('|') == -1){
			return input;
		}
		
		int start = input.indexOf('[');
		int end = input.lastIndexOf(']');
		int seperatorIndex = input.indexOf('|');
		int times = 0, bit = 1;
		int numIndex = (start > seperatorIndex)? -1 : start;			
		for (int i = seperatorIndex - 1; i > numIndex; i--) {
			times += bit * (input.charAt(i) - '0');
			bit *= 10;
		}
		//这样改有时候会出现start或者end = -1的情况
		
		if(start < 0){
			return repeatString(times, dfs(input.substring(seperatorIndex + 1, input.length())));
		}else{
		return input.substring(0, start) + 
			repeatString(times, dfs(input.substring(start + 1, end)) )
		+ input.substring(end + 1, input.length());
		//这里最后一部分的substring感觉end+1和length有可能会越界。。
		}
	}
	
//	public String dfs(String input) {
//		if(input.indexOf('[') == -1){
//			if(input.indexOf('|') > 0){
//				int seperatorIndex = input.indexOf('|');
//				int times = 0, bit = 1;
//				for (int i = seperatorIndex - 1; i >= 0; i--) {
//					times += bit * (input.charAt(i) - '0');
//					bit *= 10;
//				}
//				return repeatString(times, input.substring(seperatorIndex + 1, input.length())); 
//			}else {
//				return input;
//			}
//		}
//		
//		int start = input.indexOf('[');
//		int end = input.lastIndexOf(']');
////		int seperatorIndex = input.indexOf('|');
////		int times = 0, bit = 1;
////		for (int i = seperatorIndex - 1; i > start; i--) {
////			times += bit * (input.charAt(i) - '0');
////			bit *= 10;
////		}
//		
//		
//		return input.substring(0, start) + 
//			dfs(input.substring(start + 1, end)) 
//		+ input.substring(end + 1, input.length());
//		//这里最后一部分的substring感觉end+1和length有可能会越界。。
//	}
//	
	public String repeatString(int times, String input) {
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i < times; i++) 
			sBuilder.append(input);
		return sBuilder.toString();
	}
	
}
