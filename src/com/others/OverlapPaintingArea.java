/**OverlapPaintingArea.java
 * com.others
 * TODO
 * @author liar
 * 2020年3月16日 下午5:27:45
 * @version 1.0
 */
package com.others;

/**
 * 来自从网上找到的号称米忽悠的笔试题
* 洒毒液，洒一次会在地上铺盖一定的面积，重复铺盖的面积只算一次
* 输入
* 2     //代表洒几次
* 0 0 2 //第一次起始坐标为（0,0）洒出边长为2的正方形，毒液往向右上蔓延
* 1 1 2 //第二次起始坐标（1,1） 洒出边长为2的正方形
* 输出
* 7     //不是8因为有一块重复
 */

import java.util.ArrayList;
import java.util.List;
//本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;

public class OverlapPaintingArea {

	/**
	 * @Description: TODO
	 * @para: @param args
	 * @return: void
	 * @throws: @param args
	 * @author: liar
	 * @date: 2020年3月16日 下午5:27:45
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
	     while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
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
	                    num = (x[i]+j)*max+y[i]+k;//将二维坐标变一维，统计占用的坐标点
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
