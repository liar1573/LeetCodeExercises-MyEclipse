/**InputTest.java
 * com.nowcoder
 * 用于测试在牛客平台下输入数据
 * @author liar
 * 2020年4月2日 上午9:43:56
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
		//测试情况1，输入多组int数字
		//测试结果正常，可以在一行输入内用空格隔开多个数字，Java可以自动识别分割的数字
		Scanner in = new Scanner(System.in);
		System.out.println("输入数据");
		
		//先按照刷油漆的那个格式试一下
	     while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
	    	 //注意到这里的格式还全部是int，没有出现int和String混用的情况
	    	 //第一组测试数据：2
	    	 //0 0 
	    	 //1 1
	         int a = in.nextInt();
	         int[] x = new int [a];
	         int[] y = new int[a];
	         for(int i = 0;i<a; i++){
	             x[i] = in.nextInt();
	             y[i] = in.nextInt();
	         }
		     System.out.println("打印数据");
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
		//测试一下int和String数据混合输入的情况
		//输入数据格式：
		//int n  数据总行数
		//int number String address  编号和对应地址
		
		
		//第一组测试数据
		//2
		//010 beijing
		//0710 xiangyang
		Scanner in = new Scanner(System.in);
		System.out.println("输入数据");
		
		 while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
	    	 //注意到这里的格式还全部是int，没有出现int和String混用的情况
	    	 //第一组测试数据：2
	    	 //0 0 
	    	 //1 1
	         int a = in.nextInt();
	         int[] x = new int [a];
	         String[] y = new String[a];
	         for(int i = 0;i<a; i++){
	             x[i] = in.nextInt();
	             y[i] = in.next();
	         }
		     System.out.println("打印数据");
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
