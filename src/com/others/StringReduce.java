/**StringReduce.java
 * com.others
 * 网易官方教程某年的笔试真题
 * 字符串缩写
题目描述：
假设输入字符串全部是大写英文字母，如果有连续的M个（M>=4）按照字典顺序相邻的大写字母，则缩写为“首字母-尾字母”的形式
例如输入：XYZABCDMMM    输出：XYZA-DMMM
 * @author liar
 * 2020年4月1日 上午11:54:46
 * @version 1.0
 */
package com.others;


public class StringReduce {

	/**
	 * @Description: TODO
	 * @para: @param args
	 * @return: void
	 * @throws: @param args
	 * @author: liar
	 * @date: 2020年4月1日 上午11:54:46
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(reduceString("WXYZABCDEMMM"));
		System.out.println(reduceStringSample("WXYZABCDEMMM"));

	}
	
	private static String reduceString(String inputString) {
		int M = 4; //最大出现次数统计
		int count = 1; //用于统计连续字母出现的个数
		int startIndex = 0; //用于指示滑动窗口开始位置
		char[] arr = inputString.toCharArray();
		//字符串的裁剪稍微有点麻烦。。
		//先整体把缓存记录在StringBuffer里面进行删除或者替换，最后再整体toString
		StringBuilder tempsb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			tempsb.append(arr[i]);
			if ((i+1 < arr.length) && (arr[i+1] - arr[i] == 1)) {
				//这里似乎不应该只用if，需要用while
				count++;//如果字母连续增长就累加count
				startIndex = i;
				//这里startIndex的坐标是相对原始串inputString的
				//但是后面对sb.delete的时候需要使用相对sb的坐标所以出错了
				//对于输入"WXYZABCDEMMM"本来应该返回"W-ZA-EMMM"，结果返回了
				//"W-ZA-BMMM"
				i++;
				tempsb.append(arr[i]);
				while((i+1 < arr.length) && (arr[i+1] - arr[i] == 1)){
					count++;
					i++;
					tempsb.append(arr[i]);
				}//满足条件下一直循环统计count个数
				
				if (count >= M) {
					tempsb.delete(startIndex + 1, i);
					//删除重复字符，再插入一个-
					tempsb.insert(tempsb.length() - 1, '-');
					count = 1;
				} else {
					count = 1;
				}	
			}	
			
		}
		
		return tempsb.toString();
	}

	
	private static String reduceStringSample(String inputString) {
		int len = inputString.length();
		int pos = 0;
		//注意到示例的解法是直接对于特定的OJ情况下把输出打印了出来
		//如果想返回变形后串还是得使用Sb缓存
		StringBuilder sBuilder = new StringBuilder(); 
		while (pos < len) {
			int next;
//			for (next = pos + 1; next < len; ++next) {//这里示例代码特意用到了++next，与next++有什么区别呢？
			for (next = pos + 1; next < len; next++) {	
				//从下面的代码逻辑似乎明白用++next的好处了，不需要额外再判断next + 1 < len??真的吗
				if (inputString.charAt(next) - inputString.charAt(next - 1) != 1) {
					break;
				}
			}
			
			if (next - pos >= 4) {
				//printf("%c-%c", str[pos], str[next - 1]); //OJ写法
				sBuilder.append(inputString.charAt(pos) + "-" + inputString.charAt(next - 1));
			} else {
				for (int i = pos; i < next; i++) {
					//putchar(str[i])  //OJ写法
					sBuilder.append(inputString.charAt(i));
				}
			}
			pos = next;
		}
				
				
		return sBuilder.toString();
	}
}
