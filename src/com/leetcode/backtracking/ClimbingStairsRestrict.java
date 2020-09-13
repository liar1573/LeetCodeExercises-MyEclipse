/**
 * С�ܲμӵĻ�Ϊ������
 * ����һ��¥�ݵĽ���N��ÿһ�ζ�������1��2��3��...N�ף�
 * ����Ҫ��ÿ�����Ľ���������ǰ�����е��κ�һ����ȡ����������е���¥�ݵķ���
 */
package com.leetcode.backtracking;

import java.util.ArrayList;

public class ClimbingStairsRestrict {

	public static int n = 40;
	public static int counter = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0); list.add(0);
		dfs(list, 0);
		
		System.out.println("results = " + counter);
	}
	
	public static void dfs(ArrayList<Integer> list, int sum){
		if(sum == n){
			counter++;
//			printList(list);
			return;
		}			
			
		int temp1 = list.get(list.size() - 1);
		int temp2 = list.get(list.size() - 2);
		
		for (int i = 1; i <= n; i++) {
			if(i == temp1 || i == temp2)
				continue;
			if (sum + i <= n) {
				list.add(i);	dfs(list, sum + i); list.remove(list.size() - 1);
			}else {
				break;
			}
		}
		
	}
	
	public static void printList(ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}
	


}
