/**SetLamps.java
 * com.nowcoder
 * ��Ŀ����
СQ���ڸ�һ������Ϊn�ĵ�·���·�ư��÷�����
Ϊ�����������,СQ�ѵ�·��Ϊn������,��Ҫ�����ĵط���'.'��ʾ, ����Ҫ�������ϰ��������'X'��ʾ��
СQ����Ҫ�ڵ�·������һЩ·��, ���ڰ�����posλ�õ�·��, ��յ·�ƿ�������pos - 1, pos, pos + 1������λ�á�
СQϣ���ܰ��þ����ٵ�·����������'.'����, ϣ�����ܰ�������һ��������Ҫ����յ·�ơ�
��������:
����ĵ�һ�а���һ��������t(1 <= t <= 1000), ��ʾ����������
������ÿ����һ����������, ��һ��һ��������n(1 <= n <= 1000),��ʾ��·�ĳ��ȡ�
�ڶ���һ���ַ���s��ʾ��·�Ĺ���,ֻ����'.'��'X'��
�������:
����ÿ����������, ���һ����������ʾ������Ҫ����յ·�ơ�
ʾ����
����
2
3
.X.
11
...XX....XX

�����
1
3

 * 
 * 
 * @author liar
 * 2020��4��3�� ����5:06:01
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
		Random random = new Random(randomSeed);//��������α����������� 
		
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
