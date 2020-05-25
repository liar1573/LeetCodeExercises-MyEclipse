/**SearchIn2DArray.java
 * com.nowcoder.aimforoffer
 * TODO
 * 1.�����зֱ������2D�����У�����Ŀ�������Ƿ����
 * @author liar
 * 2020��5��24�� ����9:36:31
 * @version 1.0
 */
package com.nowcoder.aimforoffer;


public class SearchIn2DArray {
	public static void main(String[] args){
		int[][] arr = {{1,5,9},{6,10,12},{9,11,16}};
		SearchIn2DArray test = new SearchIn2DArray();
		System.out.println(test.Find(11, arr));
		//Ϊʲô����11�����±�3��Խ�磿
	}
	
	
	public boolean Find(int target, int [][] array) {
		if(array == null || array.length == 0 || array[0].length == 0
				|| target > array[array.length - 1][array[0].length - 1])
			return false;//����Ƿ���������϶��Ҳ���
		//Ҫ��Ҫ�Ѵ������ֱֵ�ӷ���false�ӽ�ȥ�أ����ڼ�������о����Լ��ٺܶ������
		
		
		//���Ȳ�����
		int rowIndex = my2DLowerBound(array, target, 0, 0);
		//Ȼ�����������
		//ע�⵽���ﱻԽ���쳣��ʾ�ˣ�������lowerBound���ܻ᷵��len��������Ҫ�ж�һ��Խ�������ȡֵ
		if(rowIndex < array.length && array[0][rowIndex] == target)
			return true;
		for (int i = 0; i < rowIndex-1; i++) {
			int colIndex = my2DLowerBound(array, target, i, 1);
			if(colIndex < array[0].length && array[colIndex][i] == target)
				return true;
		}
		
		//���б����궼û�ҵ�ֻ��˵��������
		return false;
    }
	
	public static int my2DLowerBound(int[][] arr, int target,int index, int direction) {
		//���ڱ����������2D��չ��index��ʾ�����±꣬direction=0��ʾ�У�1��ʾ��
		
		//������������arr�У���һ�����ڵ���targetԪ�ص��±�
		//���target���������е����ֵ���򷵻�ֵΪarr.length
		
		//������ң�
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
		} else {//�������
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

	//���˼·�о��ܹ��찡�������[0][n]����[m][0]������
	//����ϸ������ȷʵҲ�е�����Ϊ�����0,0����m,n��ʼ��
	//�����Ѿ���ȫ�ּ�ֵ��û�����ݴ�С�ж���һ���������ĸ�������
	public boolean FindExample(int [][] array,int target) {
		//ԭ������û���쳣�����⣬�����Լ���������
		if(array == null || array.length == 0 || array[0].length == 0
				|| target > array[array.length - 1][array[0].length - 1] ||  target < array[0][0])
			return false;//����Ƿ���������϶��Ҳ���
		
		int row=0;        
		int col=array[0].length-1; 
		//�������ߴ�Ϊ[m][n]
		//���㷨�Ŀ�ʼ����[0][n]
		while(row<=array.length-1&&col>=0){            
			if(target==array[row][col])                
				return true;            
			else if(target>array[row][col])                
				row++; //����������жϿ��Է��֣�Ĭ����row�ֶ�ֵ������           
			else  //����ʡ�����ж���䣬��target < array[row][col]        
				col--;   //���Է���������col�ֶ�Ҳ������     
		}        
		return false;     
	}
	
	public boolean FindExampleImprove(int [][] array,int target) {
		//Ȼ���Լ��볢��һ�£�ȴ���ֲ����ðѶ��ֲ��Ҽӽ����ڱȽϵ������ƶ��С���
		
		//�������﷽��2Ӧ��Ҳ�а취�Ż�һ�£����������һ��������취ʹ�ö��ֲ��ң�˳�����̫��Ч��
		//ÿһ�����е��ƶ������Ȼ��ڶ��ֲ���
		int row=0;        
		int col=array[0].length-1; 
		//�������ߴ�Ϊ[m][n]
		//���㷨�Ŀ�ʼ����[0][n]
		while(row<=array.length-1&&col>=0){  
			//��������:
			
			if(target==array[row][col])                
				return true;            
			else if(target>array[row][col]) {
				row = my2DLowerBound(array, target, col, 1);
				row++;
				//row++; //����������жϿ��Է��֣�Ĭ����row�ֶ�ֵ������           
			} else {  //����ʡ�����ж���䣬��target < array[row][col]        
				col = my2DLowerBound(array, target, row, 0);
				if(array[row][col] == target) return true;
				col--;
				//col--;   //���Է���������col�ֶ�Ҳ������
			}
		}        
		return false;     
	}
	
	
}
