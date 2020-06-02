/**ClockwisePrintMatrix.java
 * com.nowcoder.aimforoffer
 * TODO
 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣����磬�����������4 X 4���� 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @author liar
 * 2020��6��1�� ����10:53:18
 * @version 1.0
 */
package com.nowcoder.aimforoffer;

import java.util.ArrayList;

public class ClockwisePrintMatrix {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[1][5];
		ClockwisePrintMatrix test = new ClockwisePrintMatrix();
		test.generateMatrix(arr);
		ArrayList<Integer> result = test.printMatrixExample(arr);
		test.showList(result);
	}
	
	public ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(matrix.length == 0 || matrix[0].length == 0)
			return result;
		
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		//������visited�������һ�㣬��bfs���жϸ�ͳһ����������Ҳ�е��鷳����
		//bfs�ķ���û��д��������������ʸо������С���
		
		
		return result;
    }
	
	public void bfs(int[][] matrix, boolean[][] visited, 
			ArrayList<Integer> result, int direction) {
		//����������������ݹ���Ⱥ���̫���ˣ�������һ��Ϊ����ߴ�N*M
	}
	
	public ArrayList<Integer> printMatrixExample(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(matrix.length == 0 || matrix[0].length == 0)
			return result;
		int n = matrix.length, m = matrix[0].length;
		
		int circles = (Math.min(n, m) - 1)/2 + 1;
		for (int i = 0; i < circles; i++) {
			for (int j = i; j < m - i; j++)//�ϱߵĴ����ұ���
				result.add(matrix[i][j]);
			for (int j = i + 1; j < n - i; j++)//�ұߵĴ��ϵ��±���
				//ͬʱע�⵽�������ʼ�±겻��Ϊi�ˣ���Ҫi+1
				result.add(matrix[j][m - 1 - i]);
				//�����±������m����m-1��Ҫ����С��
			for (int j = m - i - 2; n - 1 - i != i&& j >= i; j--)//�±ߵĴ��ҵ������
				//result.add(matrix[n - 1 - i][j]);
				result.add(matrix[n - 1 - i][j]);
			//���������±߶���1*N�ĳߴ��������һ�顣�����ж�����������x��j >= i�ǲ����ģ�����Ҫ˳���ж���y��
			//�±ߵ�x���겻�����ϱ��غϣ���n - 1 - i != i
			for (int j = n - i - 2; m - 1 - i != i && j >= i + 1; j--)//��ߵĴ��µ��ϱ���
				result.add(matrix[j][i]);			
		}
		
		return result;
	}
	
	public void generateMatrix(int[][] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = count++; 
			}
		}
	}
	
	public void showList(ArrayList<Integer> list) {
		System.out.println();
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + ", ");
		}
	}
}
