/**OverlapPaintingArea.java
 * com.others
 * TODO
 * @author liar
 * 2020��3��16�� ����5:27:45
 * @version 1.0
 */
package com.others;

/**
 * ���Դ������ҵ��ĺų��׺��Ƶı�����
* ����Һ����һ�λ��ڵ����̸�һ����������ظ��̸ǵ����ֻ��һ��
* ����
* 2     //����������
* 0 0 2 //��һ����ʼ����Ϊ��0,0�������߳�Ϊ2�������Σ���Һ������������
* 1 1 2 //�ڶ�����ʼ���꣨1,1�� �����߳�Ϊ2��������
* ���
* 7     //����8��Ϊ��һ���ظ�
 */

import java.util.ArrayList;
import java.util.List;
//����Ϊ���Ե��ж�����������淶ʾ���������ύ�����Ʒ֡�
import java.util.Scanner;

public class OverlapPaintingArea {

	/**
	 * @Description: TODO
	 * @para: @param args
	 * @return: void
	 * @throws: @param args
	 * @author: liar
	 * @date: 2020��3��16�� ����5:27:45
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
	     while (in.hasNextInt()) {// ע�⣬��������Ƕ��������������ͨ��whileѭ����������������
	         int a = in.nextInt();
	         int[] x = new int [a];
	         int[] y = new int[a];
	         int[] len = new int[a];
	         int max = 0;
	         for(int i = 0;i<a; i++){
	             x[i] = in.nextInt();
	             y[i] = in.nextInt();
	             len[i] = in.nextInt();
	             if(max < (x[i]+len[i]))
	                 max = x[i]+len[i];
	         }
	         List<Integer> list = new ArrayList<>();
	         int num = 0;
	         for(int i = 0;i<a;i++){
	             for(int j = 0;j<len[i];j++){                
	                 for (int k = 0; k < len[i]; k++) {
	                    num = (x[i]+j)*max+y[i]+k;//����ά�����һά��ͳ��ռ�õ������
	                    if(!list.contains(num)){
	                        list.add(num);
	                    }
	                }
	             }
	         }
	         System.out.println(list.size());
	     }
	}
	

}
