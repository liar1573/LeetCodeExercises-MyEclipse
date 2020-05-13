/**FindPathReview.java
 * com.nowcoder.aimforoffer
 * TODO
 * ��������������ҵ���·������LC-79��Ŀ����һ�������������ҵ��ʣ�˳�㸴ϰһ��
 * @author liar
 * 2020��5��13�� ����8:16:45
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
    		return false; //���ﲻ�Ϸ����̫���ˣ�����м�������
    	char[][] board = new char[rows][cols];
    	for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++) 
				board[i][j] = matrix[i * cols + j];//����row��ʼֵ����0���ʲ���Ҫ-1 
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
    	//�о����dfs�Ĳ�������Ϊboolean����û�취�ܺõػ���visited��
    	 //�����²�������ֵͬ��Ҳ���Ի���visited
    	
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
//    	//�о����dfs�Ĳ�������Ϊboolean����û�취�ܺõػ���visited��
//    	//�ĳ�void���ͣ�����ȫ��flag���ԣ�
//    	//����ֵΪvoid��ʹ��ȫ��flag�ĽⷨAC��
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
