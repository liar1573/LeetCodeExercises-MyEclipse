/**SearchIn2DArray.java
 * com.nowcoder.aimforoffer
 * TODO
 * 1.在行列分别递增的2D数组中，查找目标数字是否存在
 * @author liar
 * 2020年5月24日 下午9:36:31
 * @version 1.0
 */
package com.nowcoder.aimforoffer;


public class SearchIn2DArray {
	public static void main(String[] args){
		int[][] arr = {{1,5,9},{6,10,12},{9,11,16}};
		SearchIn2DArray test = new SearchIn2DArray();
		System.out.println(test.Find(11, arr));
		//为什么对于11会有下标3的越界？
	}
	
	
	public boolean Find(int target, int [][] array) {
		if(array == null || array.length == 0 || array[0].length == 0
				|| target > array[array.length - 1][array[0].length - 1])
			return false;//矩阵非法的情况，肯定找不到
		//要不要把大于最大值直接返回false加进去呢？对于极端情况感觉可以减少很多计算量
		
		
		//首先查找行
		int rowIndex = my2DLowerBound(array, target, 0, 0);
		//然后是列序查找
		//注意到这里被越界异常提示了！！由于lowerBound可能会返回len，所以需要判断一下越界情况再取值
		if(rowIndex < array.length && array[0][rowIndex] == target)
			return true;
		for (int i = 0; i < rowIndex-1; i++) {
			int colIndex = my2DLowerBound(array, target, i, 1);
			if(colIndex < array[0].length && array[colIndex][i] == target)
				return true;
		}
		
		//行列遍历完都没找到只能说明不存在
		return false;
    }
	
	public static int my2DLowerBound(int[][] arr, int target,int index, int direction) {
		//基于本题情况做了2D扩展，index表示行列下标，direction=0表示行，1表示列
		
		//返回升序数组arr中，第一个大于等于target元素的下标
		//如果target大于数组中的最大值，则返回值为arr.length
		
		//行序查找：
		if(direction == 0){
			int low = 0, high = arr.length;
			while (low < high) {
				int mid = (low + high)/2;
				if(arr[index][mid] == target){
					return mid;
				} else if (arr[index][mid] < target) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
			
			return low;
		} else {//列序查找
			int low = 0, high = arr[0].length;
			while (low < high) {
				int mid = (low + high)/2;
				if(arr[mid][index] == target){
					return mid;
				} else if (arr[mid][index] < target) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}	
			return low;
		}
		
	}

	//这个思路感觉很诡异啊，从起点[0][n]或者[m][0]来查找
	//单仔细想了想确实也有道理，因为如果从0,0或者m,n开始，
	//由于已经是全局极值，没法根据大小判断下一步具体往哪个方向走
	public boolean FindExample(int [][] array,int target) {
		//原代码中没有异常情况监测，这里自己把它补上
		if(array == null || array.length == 0 || array[0].length == 0
				|| target > array[array.length - 1][array[0].length - 1] ||  target < array[0][0])
			return false;//矩阵非法的情况，肯定找不到
		
		int row=0;        
		int col=array[0].length-1; 
		//简记数组尺寸为[m][n]
		//次算法的开始点是[0][n]
		while(row<=array.length-1&&col>=0){            
			if(target==array[row][col])                
				return true;            
			else if(target>array[row][col])                
				row++; //根据这里的判断可以发现，默认在row字段值是升序           
			else  //这里省略了判断语句，即target < array[row][col]        
				col--;   //可以发现这里在col字段也是升序     
		}        
		return false;     
	}
	
	public boolean FindExampleImprove(int [][] array,int target) {
		//然而自己想尝试一下，却发现并不好把二分查找加进基于比较的坐标移动中。。
		
		//但是这里方法2应该也有办法优化一下，有序的数组一定尽量想办法使用二分查找，顺序查找太低效了
		//每一次行列的移动可以先基于二分查找
		int row=0;        
		int col=array[0].length-1; 
		//简记数组尺寸为[m][n]
		//次算法的开始点是[0][n]
		while(row<=array.length-1&&col>=0){  
			//先行搜索:
			
			if(target==array[row][col])                
				return true;            
			else if(target>array[row][col]) {
				row = my2DLowerBound(array, target, col, 1);
				row++;
				//row++; //根据这里的判断可以发现，默认在row字段值是升序           
			} else {  //这里省略了判断语句，即target < array[row][col]        
				col = my2DLowerBound(array, target, row, 0);
				if(array[row][col] == target) return true;
				col--;
				//col--;   //可以发现这里在col字段也是升序
			}
		}        
		return false;     
	}
	
	
}
