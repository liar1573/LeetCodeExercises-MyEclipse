/**EvenOddArraySorting.java
 * com.nowcoder.aimforoffer
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author liar
 * 2020年5月28日 上午11:29:14
 * @version 1.0
 */
package com.nowcoder.aimforoffer;


public class EvenOddArraySorting {
	 public void reOrderArray(int[] array) {
		 if(array == null || array.length < 2)  return;
		 
		 int[] oddArr = new int[array.length];//奇数
		 int[] evenArr = new int[array.length];
		 int oddCount = 0, evenCount = 0;
		 
		 for (int i = 0; i < array.length; i++) {
			if ((array[i] & 1) == 1) {
				oddArr[oddCount] = array[i];
				oddCount++;
			} else {
				evenArr[evenCount] = array[i];
				evenCount++;
			}
		}
		 
		for (int i = 0; i < oddCount; i++) {
			array[i] = oddArr[i]; 
		}
		 
		for (int i = 0; i < evenCount; i++) {
			array[i + oddCount] = evenArr[i];
		}
		 
	 }

	 public void reOrderArrayExample(int[] array) {
		 //根据评论区提示，试一试插入排序的方式
		 //时间为N^2，但是空间为1
		 if(array == null || array.length < 2)  return;
		 
		 int oddCount = 0;
		 for (int i = 0; i < array.length; i++) {
			if((array[i] & 1) == 1){
				int temp = array[i];
				for (int j = i; j > oddCount; j--)
					array[j] = array[j-1];
				array[oddCount] = temp;
				oddCount++;
			}
		}
	 }
}
