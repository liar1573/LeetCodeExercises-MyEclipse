/**LeftShiftString.java
 * com.nowcoder.aimforoffer.string
 * TODO
 * �����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵����񣬾������ַ���ģ�����ָ�����������
 * ���磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc����
 * @author liar
 * 2020��6��16�� ����11:38:32
 * @version 1.0
 */
package com.nowcoder.aimforoffer.string;

import java.util.Arrays;

public class LeftShiftString {
	public static void main(String[] args) {
		for (int i = 0; i < 7; i++) {
			System.out.println(i);
			System.out.println(LeftRotateString("abcXYZdef", i));
		}
		
	}
	
	public static String LeftRotateString(String str,int n) {
        if(str == null || str.length() <= 1)
        	return str;
        
        n = n % str.length();
        char[] arr = str.toCharArray();
        char[] temp = Arrays.copyOf(arr, n);
        //͵�������Լ�forѭ��д��
        for (int i = 0; i < arr.length - n; i++)
			arr[i] = arr[n + i]; 
		for (int i = 0; i < n; i++)
			arr[arr.length - n + i] = temp[i];
		
        
        //ֱ����ԭ�����ϲ����о����ѡ���
//        for (int i = 0; i < n; i++) {
//			char temp = arr[i];
//			arr[i] = arr[arr.length - n + i];
//			arr[arr.length - n + i] = temp;
//		}
        
        return new String(arr);       
    }
	
	//ͬʱҲ����ʹ��������ת��ԭ�ַ����Ͻ��в�����
	//��һ��������ѡ��
	//�ڶ�����ѡ��ǰlen-N�Ĳ���ѡ����ѡ���N�Ĳ���ѡ��
	
}
