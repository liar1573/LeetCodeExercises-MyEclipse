/**EvenOddArraySorting.java
 * com.nowcoder.aimforoffer
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��
 * ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ������ĺ�벿�֣�
 * ����֤������������ż����ż��֮������λ�ò��䡣
 * @author liar
 * 2020��5��28�� ����11:29:14
 * @version 1.0
 */
package com.nowcoder.aimforoffer;


public class EvenOddArraySorting {
	 public void reOrderArray(int[] array) {
		 if(array == null || array.length < 2)  return;
		 
		 int[] oddArr = new int[array.length];//����
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
		 //������������ʾ����һ�Բ�������ķ�ʽ
		 //ʱ��ΪN^2�����ǿռ�Ϊ1
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
