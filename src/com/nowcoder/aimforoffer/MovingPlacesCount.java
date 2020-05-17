/**MovingPlacesCount.java
 * com.nowcoder.aimforoffer
 * TODO
 * 整体思路应该与前一道找单词路径的题目差不多，求机器人能到达的格子总数量
 * 这个题有点坑的是坐标和取得并不是本身的值，而是各个位相加的和
 * @author liar
 * 2020年5月14日 上午10:18:14
 * @version 1.0
 */
package com.nowcoder.aimforoffer;

/**
 * @author liar
 *
 */
public class MovingPlacesCount {
	int areaCount = 0;
	
	public static void main(String[] args) {
		int rows = 10;
		int cols = 10;
		int k = 5;
		int count = 0;
		
		MovingPlacesCount test = new MovingPlacesCount();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if(test.isAccessible(i, j, k)){
					System.out.print("[ " + i + " ," + j + " ]  ");
					count++;
				}
			}
			System.out.println();
		}
		
		
//		System.out.println(test.movingCountBruteForce(k, rows, cols));
//		System.out.println(test.movingCount(k, rows, cols));
	}
	
	 public int movingCount(int threshold, int rows, int cols){
		 if(threshold < 0 || rows <=0 || cols <= 0)
			 return 0;
		 
		 boolean[][] visited = new boolean[rows][cols];
		 dfs(visited, 0, 0, threshold);
		 return this.areaCount;
	 }
	
	
	 public void dfs(boolean[][] visited, int row, int col, int threshold) {		
			if(row < 0 || col < 0 || row == visited.length || col == visited[0].length
					|| visited[row][col] || !isAccessible(row, col, threshold))
				return;
			
			this.areaCount++;
			visited[row][col] = true;
			dfs(visited, row - 1, col, threshold);
			dfs(visited, row, col - 1, threshold);
			dfs(visited, row + 1, col, threshold);
			dfs(visited, row, col + 1, threshold);
		}
	 
	public void dfsFault(boolean[][] visited, int row, int col, int threshold) {
//		if(row < 0 || col < 0 || visited[row][col])
//			return;
		
		if(row < 0 || col < 0 || row == visited.length || col == visited[0].length|| visited[row][col])
			return;
		
		if(isAccessible(row, col, threshold))
			this.areaCount++;
		visited[row][col] = true;
		dfs(visited, row - 1, col, threshold);
		dfs(visited, row, col - 1, threshold);
		//补上四向的试试效果如何？
		dfs(visited, row + 1, col, threshold);
		dfs(visited, row, col + 1, threshold);
		//如果补充成四向的，则dfs入口还需要考虑坐标上限
	}
	
	boolean isAccessible(int row, int col, int threshold){
		int count = 0;
		while (row > 0) {
			count += row % 10;
			row /= 10;
		}
		
		while (col > 0) {
			count += col % 10;
			col /= 10;
		}
		
		
		if (count <= threshold) {
			return true;
		} else {
			return false;
		}
	}

	public int movingCountBruteForceFault(int threshold, int rows, int cols){
		//做一个纯BF迭代保证正确的方法来对比debug
		//这个暴力迭代的写法凭什么结果也有问题？？
		//实际值：30， 正确答案：21
		
		if(threshold < 0 || rows <=0 || cols <= 0)
			 return 0;
		
		for (int i = rows - 1; i >= 0; i--) {
			for (int j = cols - 1; j >= 0; j--) {
				if(isAccessible(j, j, threshold))
					this.areaCount++;
			}
		}
		
		
		return this.areaCount;
	}

}
