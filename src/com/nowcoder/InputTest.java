/**InputTest.java
 * com.nowcoder
 * ���ڲ�����ţ��ƽ̨����������
 * @author liar
 * 2020��4��2�� ����9:43:56
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
	
	private void testCase3() {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> result = new ArrayList<Integer>();
		while (in.hasNext()) {
			//ע�⵽����һ��Ҫʹ��nextLine,��Ȼ�ո����ǰ�ж϶�ȡ
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
            System.out.println("�ָ���ַ�������" + strings.length);
            //������������ʽ��ȷ��Strings�ĳ���Ӧ���Ǹպõ���times��
            //��ô˵������ʵtimes��ȫ���ã�ֱ����str.length�Ϳ�����
            Arrays.sort(strings);
            StringBuilder sBuilder = new StringBuilder();
		    for (int i = 0; i < strings.length - 1; i++)
			//ע�⵽������ʾ�����һ��������治�ܸ��ո���������Ҫ��΢���⴦��һ��
			    sBuilder.append(strings[i] + " ");
            //ע�⵽������ڿմ�����Ҳ����Ϊ1�����Բ��õ��������±�Խ��
		    sBuilder.append(strings[strings.length - 1]);
		    System.out.println(sBuilder.toString()); 
	}
}
}