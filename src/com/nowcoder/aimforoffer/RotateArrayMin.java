/**RotateArrayMin.java
 * com.nowcoder.aimforoffer
 * TODO
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
 * �����ת�������СԪ��
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
 * @author liar
 * 2020��5��5�� ����11:20:04
 * @version 1.0
 */
package com.nowcoder.aimforoffer;


public class RotateArrayMin {
	public static void main(String[] args) {
		RotateArrayMin test = new RotateArrayMin();
		int[] testArr = test.generateArray(8, 6);
		System.out.print(test.minNumberInRotateArray(testArr));
		
	}
	
	public int minNumberInRotateArrayBruteForce(int [] array) {
		//�������û�����κ����Ƶ�����£�ֱ����ʱ��ΪN�ı���Ӧ��Ҳ��û����İɡ���
		//ֱ�ӱ�����AC�ˣ���������ȥЧ�ʲ�զ�ض�259ms��
        if(array.length == 0)
            return 0;
        int min = array[0];
        for(int i = 0;i < array.length;i++)
            min = (min < array[i])? min: array[i];
        
        return min;
    }

	public int minNumberInRotateArrayImprove1(int[] array){
		//ʹ��a[i+1] < a[i]�Ľ��������������Ժ��Բ��Ƶ��㷨�����Ӷ���ΪN
		if(array.length == 0)
            return 0;
		
		//���������ȫ��Ԫ�ض���ȣ���ʱ���Զ�minֱ�Ӹ�ֵ��ʼֵarray[array.length - 1];
		int min = array[array.length - 1];
		
		for (int i = 0; i < array.length-1; i++) {
			if(array[i + 1] < array[i]){
				min = array[i+1]; break;
			}
		}
		
		return min;
	}
	
	public int minNumberInRotateArray(int[] array){
		//����ʹ�ö��ֲ��ҵ�˼���Ż�
		if(array.length == 0)
            return 0;
		int left = 0,right = array.length - 1;

		while(left <= right){
			int mid = (left + right)/2;
			if(array[mid] >= array[0]){
			//��ʱ˵���ֽ�������յ���ҷ�
			  left = mid + 1;
			} else{
			//��ʱ˵���ֽ���Ϊmid������mid�����
			  right = mid - 1;
			}
		}
		
		return array[left];
		
		//����һ��ʼֱ����array[right+1]����Խ���ˡ���
		//�Ӹ���Χ�жϺ���
//		if(right + 1 == array.length)
//			return right;
//		
//		return (array[right] < array[right+1])? array[right]: array[right+1];
		
	}
	
	public int[] generateArray(int length, int index) {
		//�������ɲ����õ�����
		//���鳤��Ϊlength��Ԫ�ش�0��ʼ��һ������������indexλ�÷�����ת
		int[] result = new int[length];
		
		for (int i = 0; i < index; i++) {
			result[i] = length - index + i; 
		}
		
		for (int i = index; i < result.length; i++) {
			result[i] = i - index; 
		}
		
		return result;
	}
}
