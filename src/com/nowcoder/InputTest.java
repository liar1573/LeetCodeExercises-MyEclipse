/**InputTest.java
 * com.nowcoder
 * ���ڲ�����ţ��ƽ̨����������
 * @author liar
 * 2020��4��2�� ����9:43:56
 * @version 1.0
 */
package com.nowcoder;

import java.util.Scanner;

public class InputTest {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InputTest inputTest = new InputTest();
//		inputTest.testCase1();
		inputTest.testCase2();
		
	}
	
	private void testCase1() {
		//�������1���������int����
		//���Խ��������������һ���������ÿո����������֣�Java�����Զ�ʶ��ָ������
		Scanner in = new Scanner(System.in);
		System.out.println("��������");
		
		//�Ȱ���ˢ������Ǹ���ʽ��һ��
	     while (in.hasNextInt()) {// ע�⣬��������Ƕ��������������ͨ��whileѭ����������������
	    	 //ע�⵽����ĸ�ʽ��ȫ����int��û�г���int��String���õ����
	    	 //��һ��������ݣ�2
	    	 //0 0 
	    	 //1 1
	         int a = in.nextInt();
	         int[] x = new int [a];
	         int[] y = new int[a];
	         for(int i = 0;i<a; i++){
	             x[i] = in.nextInt();
	             y[i] = in.nextInt();
	         }
		     System.out.println("��ӡ����");
		     for(int i : x){
		    	 System.out.print(i + "  ");
		     }
		     System.out.println();
		     
		     for(int i : y){
		    	 System.out.print(i + "  ");
		     }
	     }
	}
	
	private void testCase2() {
		//����һ��int��String���ݻ����������
		//�������ݸ�ʽ��
		//int n  ����������
		//int number String address  ��źͶ�Ӧ��ַ
		
		
		//��һ���������
		//2
		//010 beijing
		//0710 xiangyang
		Scanner in = new Scanner(System.in);
		System.out.println("��������");
		
		 while (in.hasNext()) {// ע�⣬��������Ƕ��������������ͨ��whileѭ����������������
	    	 //ע�⵽����ĸ�ʽ��ȫ����int��û�г���int��String���õ����
	    	 //��һ��������ݣ�2
	    	 //0 0 
	    	 //1 1
	         int a = in.nextInt();
	         int[] x = new int [a];
	         String[] y = new String[a];
	         for(int i = 0;i<a; i++){
	             x[i] = in.nextInt();
	             y[i] = in.next();
	         }
		     System.out.println("��ӡ����");
		     for(int i : x){
		    	 System.out.print(i + "  ");
		     }
		     System.out.println();
		     
		     for(String str : y){
		    	 System.out.print(str + "  ");
		     }
	     }
		
	}
	
	

}
