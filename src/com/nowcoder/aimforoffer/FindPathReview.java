/**FindPathReview.java
 * com.nowcoder.aimforoffer
 * TODO
 * 在这里的描述是找单词路径，与LC-79题目几乎一样即在棋盘中找单词，顺便复习一下
 * @author liar
 * 2020年5月13日 下午8:16:45
 * @version 1.0
 */
package com.nowcoder.aimforoffer;


public class FindPathReview {
	boolean flag = false;
	
	public static void main(String[] args) {
		char[] matrix = {'a','b','c','e','s','f','c','s','a','d','e','e'};
		char[] str = {'b','c','c','e','d'};
		FindPathReview test = new FindPathReview();
		System.out.println(test.hasPath(matrix, 3, 4, str));
	}
	
	
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
    	if(matrix.length < 1 || rows < 1 || cols < 1 || str.length < 1)
    		return false; //这里不合法情况太多了，随便列几个好了
    	char[][] board = new char[rows][cols];
    	for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++) 
				board[i][j] = matrix[i * cols + j];//这里row起始值就是0，故不需要-1 
		boolean[][] visited = new boolean[rows][cols];
    	
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++){
				if(dfs(board, i, j, visited, "", new String(str)))
//				dfs(board, i, j, visited, "", new String(str));
//				if(this.flag)
					return true;
			}
    		
    	return false;
    }
    
    public boolean dfs(char[][] board, int row, int col, boolean[][] visited, String input, String str) {
    	//感觉如果dfs的参数设置为boolean，则没办法很好地回溯visited了
    	 //看了下布尔返回值同样也可以回溯visited
    	
    	if(row < 0 || row == board.length || col < 0 || col == board[0].length)
    		return false;
    	
    	if (visited[row][col]) 
    		return false;
    		
    	
    	    	
    	String newString = new String(input + board[row][col]);
    	if(newString.equals(str))
    		return true;
    	if(!str.startsWith(newString))
    		return false;
    	
    	visited[row][col] = true;
    	 if (dfs(board, row - 1, col, visited, newString, str) ||
    		 dfs(board, row + 1, col, visited, newString, str) || 
    		 dfs(board, row, col - 1, visited, newString, str) ||
    		 dfs(board, row, col + 1, visited, newString, str))
    		 return true;
    	 
    	 visited[row][col] = false;
    	 return false;
      }
	
    
//    public void dfs(char[][] board, int row, int col, boolean[][] visited, String input, String str) {
//    	//感觉如果dfs的参数设置为boolean，则没办法很好地回溯visited了
//    	//改成void类型，设置全局flag试试？
//    	//返回值为void，使用全局flag的解法AC了
//    	
//		if(row < 0 || row == board.length || col < 0 || col == board[0].length)
//			return;
//    	
//    	if (visited[row][col]) 
//			return;
//				    	
//    	String newString = new String(input + board[row][col]);
//		if(newString.equals(str)){
//			this.flag = true;
//			return;
//		}
//		if(!str.startsWith(newString))
//			return;
//		
//		visited[row][col] = true;
//    	dfs(board, row - 1, col, visited, newString, str);
//    	dfs(board, row + 1, col, visited, newString, str);
//    	dfs(board, row, col - 1, visited, newString, str);
//    	dfs(board, row, col + 1, visited, newString, str);
//    	visited[row][col] = false;
//	}
	
    

}
