/**Mode3Array.java
 * com.nowcoder
 * ţ������ҳ > ���߱�� > 2019У������
 * ���ס���3����
 * СQ�õ�һ�����������: 1, 12, 123,...12345678910,1234567891011...�� 
����СQ�����ܷ�3����������ʺܸ���Ȥ�� 
СQ����ϣ�����ܰ�������һ�´����еĵ�l������r��(�����˵�)�ж��ٸ������Ա�3������ 
����Ŀ��û�����������������Ĺ��ɣ��������¿�������ÿ��������������������i��
ʱ�����ƣ�C/C++ 1�룬��������2�� �ռ����ƣ�C/C++ 32M����������64M
 * @author liar
 * 2020��4��2�� ����10:16:59
 * @version 1.0
 */
package com.nowcoder;


public class Mode3Array {

	/**
	 * @Description: TODO
	 * @para: @param args
	 * @return: void
	 * @throws: @param args
	 * @author: liar
	 * @date: 2020��4��2�� ����10:16:59
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mod3Array(2, 5));
	}
	
	private static int mod3Array(int start, int end) {
		//���������������l��r(1 <= l <= r <= 1e9)
		//��������������������Ͳ�����������
		int count = 0;
		int total = 0;//���ڴ洢�ۼӺ�
		for(int i = 0; i < start;i++){
			//��Ҫ��΢ע��һ��start��end�߽�Ҫ��δ���,����startҪ��<
			//start����֮ǰ��ֻ�����ۼӺͲ�����
			total += i;
		}
		
		for (int i = start; i <= end; i++) {
			//�����±��start��ʼ��end�߽���Ҫ���Ⱥ�
			total += i;
			if (0 == total % 3) {
				count++;
			}
			
		}
		
		return count;
	}

}
