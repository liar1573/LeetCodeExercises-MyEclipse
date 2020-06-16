/**IncreasingPoker.java
 * com.nowcoder.aimforoffer.string
 * TODO �ж������Ŵ�С����������任���˿����У�����������ܷ񹹳�˳��
 * @author liar
 * 2020��6��15�� ����8:15:36
 * @version 1.0
 */
package com.nowcoder.aimforoffer.string;

import java.util.Arrays;

public class IncreasingPoker {
	public boolean isContinuous(int[] numbers) {
		Arrays.sort(numbers);
		int zeroCount = 0;//ͳ���м���0����С����
		//����Ͳ����Լ��ж�����Ϸ����ˣ�Ĭ�����붼�ǺϷ���
		for (int i = 0; i < numbers.length; i++)
			if(numbers[i] == 0)
				zeroCount++;
		
		int increaseCount = 1;//ͳ���������г���
		int temp = 1;
		for(int i = numbers.length - 1;i >= zeroCount + 1; i--){
			if(numbers[i] - numbers[i-1] == 1){
				temp++;
				increaseCount = (temp > increaseCount) ? temp: increaseCount;
			}else {
				temp = 1;
			}
		}
		//���ԣ�������������;�Ͽ����ǿ�����0������û�п��ǵ�,����0���в���һ��Ҫ��������
		
		
		//ͻȻ�뵽�ƺ��ۼ������Խ��,5-3 + 3-1 = 4
		// 0 0 1 3 5
		//����ܳ�˳�ӣ�����ֵ���ۼƲ�Ӧ��Ϊ2 * zeroCount
		//���У�Ҳ����������
		
		
		
		return (zeroCount + increaseCount == numbers.length);
    }

	public boolean isContinuousExample(int[] numbers) {
		//�����жϣ�1.min - max < 5����0���⣩ 2.��0���ⲻ�����ظ�����  3.����Ϊ5
		if(numbers.length != 5)
			return false;
		
		Arrays.sort(numbers);
		int zeroCount = 0;//ͳ���м���0����С����
		//����Ͳ����Լ��ж�����Ϸ����ˣ�Ĭ�����붼�ǺϷ���
		for (int i = 0; i < numbers.length; i++){
			if(numbers[i] != 0)
				break;
			else
				zeroCount++;
		}
		
		if(numbers[numbers.length - 1] - numbers[zeroCount] >= 5)
			return false;
		
		for (int i = zeroCount; i < numbers.length - 1; i++) 
			if(numbers[i] == numbers[i+1] )
				return false;
		
		return true;
	}
}
