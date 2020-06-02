/**ClockwisePrintMatrix.java
 * com.nowcoder.aimforoffer
 * TODO
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @author liar
 * 2020年6月1日 上午10:53:18
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
		//可以在visited数组多套一层，是bfs中判断更统一，不过操作也有点麻烦。。
		//bfs的方法没有写完整，不过大概率感觉不可行。。
		
		
		return result;
    }
	
	public void bfs(int[][] matrix, boolean[][] visited, 
			ArrayList<Integer> result, int direction) {
		//想了想这样纯单向递归深度好像太深了，最大深度一定为矩阵尺寸N*M
	}
	
	public ArrayList<Integer> printMatrixExample(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(matrix.length == 0 || matrix[0].length == 0)
			return result;
		int n = matrix.length, m = matrix[0].length;
		
		int circles = (Math.min(n, m) - 1)/2 + 1;
		for (int i = 0; i < circles; i++) {
			for (int j = i; j < m - i; j++)//上边的从左到右遍历
				result.add(matrix[i][j]);
			for (int j = i + 1; j < n - i; j++)//右边的从上到下遍历
				//同时注意到这里的起始下标不能为i了，需要i+1
				result.add(matrix[j][m - 1 - i]);
				//这里下标具体是m还是m-1需要格外小心
			for (int j = m - i - 2; n - 1 - i != i&& j >= i; j--)//下边的从右到左遍历
				//result.add(matrix[n - 1 - i][j]);
				result.add(matrix[n - 1 - i][j]);
			//发现这里下边对于1*N的尺寸好像会多算一遍。看来判断条件单纯对x轴j >= i是不够的，还需要顺便判断下y轴
			//下边的x坐标不能与上边重合，即n - 1 - i != i
			for (int j = n - i - 2; m - 1 - i != i && j >= i + 1; j--)//左边的从下到上遍历
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
