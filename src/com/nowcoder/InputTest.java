/**InputTest.java
 * com.nowcoder
 * 用于测试在牛客平台下输入数据
 * @author liar
 * 2020年4月2日 上午9:43:56
 * @version 1.0
 */
package com.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InputTest {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InputTest inputTest = new InputTest();
//		inputTest.testCase1();
		inputTest.testCase4();
		
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
	
	private void testCase3() {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> result = new ArrayList<Integer>();
		while (in.hasNext()) {
			//注意到这里一定要使用nextLine,不然空格会提前中断读取
			String[] numStrings = in.nextLine().split(" ");
			int sum = 0;
            for(int j = 0;j < numStrings.length;j++)
                sum += Integer.parseInt(numStrings[j]);
            result.add(sum);  			
		}
		
		 for(int j = 0;j < result.size();j++)
	            System.out.println(result.get(j));
	}

	private void testCase4() {
		Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int times = in.nextInt();
            String blank = in.nextLine();
            String[] strings = in.nextLine().split(" ");
            System.out.println("分割后字符串长度" + strings.length);
            //这里如果输入格式正确，Strings的长度应该是刚好等于times的
            //这么说起来其实times完全无用，直接用str.length就可以了
            Arrays.sort(strings);
            StringBuilder sBuilder = new StringBuilder();
		    for (int i = 0; i < strings.length - 1; i++)
			//注意到这里提示了最后一个输出后面不能跟空格，所以这里要稍微特殊处理一下
			    sBuilder.append(strings[i] + " ");
            //注意到这里对于空串长度也至少为1，所以不用担心数组下标越界
		    sBuilder.append(strings[strings.length - 1]);
		    System.out.println(sBuilder.toString()); 
	}
}
}