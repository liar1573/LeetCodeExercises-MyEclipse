/**FindMoreThanHalfNum.java
 * com.nowcoder.aimforoffer.array
 * TODO-��ϰ��Ŀ
 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
 * ��������������0��
 * @author liar
 * 2020��6��19�� ����9:19:19
 * @version 1.0
 */
package com.nowcoder.aimforoffer.array;


public class FindMoreThanHalfNum {
	public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0)  return 0;
		int result = array[0];
		int times = 1;
		//�ٷ�ʾ��result��ʼֵ��ֵ-1��times��ʼֵΪ0���������Լ�����������ж�
		//��ʵЧ��Ҳ�����
		
		
		// ����ÿ��Ԫ�أ�����¼����������ǰһ��Ԫ����ͬ���������1�����������1
		for (int i = 1; i < array.length; i++) {
			if(times == 0){
				// ����result��ֵΪ��ǰԪ�أ����ô���Ϊ1
				result = array[i];
				times = 1;
			} //else if (array[i] == result ) {//ע�⵽����ԭʼ���߼���κ����е����⡣
			else {
				if (array[i] == result )
					times++;//��ͬʱ����+1
				else 
					times--;
			}
		}
		
		//����Ϊʲô�ֽ����˵ڶ��α��������������һ�ֱ���֮������Ӧ���Ѿ���result������
		//���������������һ�ֱ���ֻ�ܱ�֤����result�д�ŵ��ǳ��ִ������ģ�
		//�����޷���֤���ִ����������鳤�ȵ�һ�루�м�����������ֵ�ʱ��times�����)
		times = 0;
		for (int i = 0; i < array.length; i++) {
			if(result == array[i])  times++;
		}
		
		return (times > array.length / 2) ? result : 0;
    }
}
