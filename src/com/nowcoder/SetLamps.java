/**SetLamps.java
 * com.nowcoder
 * 题目描述
小Q正在给一条长度为n的道路设计路灯安置方案。
为了让问题更简单,小Q把道路视为n个方格,需要照亮的地方用'.'表示, 不需要照亮的障碍物格子用'X'表示。
小Q现在要在道路上设置一些路灯, 对于安置在pos位置的路灯, 这盏路灯可以照亮pos - 1, pos, pos + 1这三个位置。
小Q希望能安置尽量少的路灯照亮所有'.'区域, 希望你能帮他计算一下最少需要多少盏路灯。
输入描述:
输入的第一行包含一个正整数t(1 <= t <= 1000), 表示测试用例数
接下来每两行一个测试数据, 第一行一个正整数n(1 <= n <= 1000),表示道路的长度。
第二行一个字符串s表示道路的构造,只包含'.'和'X'。
输出描述:
对于每个测试用例, 输出一个正整数表示最少需要多少盏路灯。
示例：
输入
2
3
.X.
11
...XX....XX

输出：
1
3

 * 
 * 
 * @author liar
 * 2020年4月3日 下午5:06:01
 * @version 1.0
 */
package com.nowcoder;

import java.util.Random;
import java.util.Scanner;

public class SetLamps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] showStrings = generateInput(1234, 5, 8);
		for (String string : showStrings) {
			System.out.println(string + lampsNumber(string));
//			System.out.println();
		}
		
		/**
		Scanner in = new Scanner(System.in);
		int totalNumber;
		int[] roadLens;
		int[] result;
		String[] roadStrings = null;
		
		while (in.hasNext()) {
			totalNumber = in.nextInt();
			roadLens = new int[totalNumber];
			result = new int[totalNumber];
			roadStrings = new String[totalNumber];
			for (int i = 0; i < totalNumber; i++) {
				roadLens[i] = in.nextInt();
				roadStrings[i] = new String(in.next()); 				
			}
//			System.out.println(roadStrings.length);
			
			for (int i = 0; i < roadStrings.length; i++) {
				for (int j = 0; j < roadStrings[i].length(); j++) {
					if ('.' == roadStrings[i].charAt(j)) {
						result[i] += 1;
						j += 3;
					}
				}
			}
			
			for (int i = 0; i < result.length; i++) {
				System.out.println(result[i]);
			}
			
		}
		
		
//		System.out.println(roadStrings.length);
//		for (int i = 0; i < roadStrings.length; i++) {
//			
//		}
 * 
 * 
 */
		
	}
	
	
	public static String[] generateInput(int randomSeed, int number, int len){
		String[] inputSample = new String[number];
		StringBuilder tempsb = new StringBuilder();
		Random random = new Random(randomSeed);//用于生成伪随机输入序列 
		
		for (int i = 0; i < inputSample.length; i++) {
			for (int j = 0; j < len; j++) {
				if (random.nextBoolean()) {
					tempsb.append('.');
				}else {
					tempsb.append('x');
				}
			}
			inputSample[i] = new String(tempsb.toString()); 
			tempsb.delete(0, len);
		}
		
		return inputSample;
	}

	public static int lampsNumber(String inputString) {
		int result = 0;
		for (int j = 0; j < inputString.length(); j++) {
			if ('.' == inputString.charAt(j)) {
				result += 1;
				j += 2;
			}
		}
		return result;
	}
}
