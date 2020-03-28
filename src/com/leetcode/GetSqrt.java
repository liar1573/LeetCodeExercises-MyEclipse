/**GetSqrt.java
 * com.leetcode
 * LC 69 ������������ƽ��������������
 * @author liar
 * 2020��3��25�� ����5:49:46
 * @version 1.0
 */
package com.leetcode;


public class GetSqrt {

	/**
	 * @Description: TODO
	 * @para: @param args
	 * @return: void
	 * @throws: @param args
	 * @author: liar
	 * @date: 2020��3��25�� ����5:49:46
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetSqrt testGetSqrt = new GetSqrt();
		System.out.print(testGetSqrt.mySqrt(2147395599));
	}
	
	
	public int mySqrt(long x) {
		//��Ŀ�ᵽx guaranteed to ����������û����
		long low = 0; long high = x;
//		int precision = 1;
//		while ((high - low) > precision) {
		while (high > low) {
			long mid = (low + high) / 2;
			//�����е���������ΪintʱӦ�ûᵼ�µ����������������ǽ�ľ��Ȳ���
			//���ڱ����ض������������ֵ����������������
			if (mid * mid == x) {
				return (int)mid;
			}
			if(mid * mid  > x){
				high = mid - 1;
			}else {
				low = mid + 1;
			}
		}
		
        //return low;
        //������lowʱ��3-2,5-3,7-2??
		//return high;
		//��������highҲ���У����ڱ߽�ֵ���紦��һ��С��������ֵ���ǲ�1����
		//������΢���һ������ж�һ��
		return (low * low > x) ? (int)low - 1 : (int)low; 
//		if (low * low > x) {
//			return low - 1;
//		}else {
//			return low;
//		}//����������Զ����С�жϽ������ȫ������
		//û�뵽��һ���ύ��Ȼ��ʱ��-2147395599����Ӧ�����в��ٷ����������������߽��//����Դ󲿷����ֶ��ԣ�����sqrt(x) < x/2 
		//						  2147483647
		//ͻȻ�뵽������ֻ᲻�ᳬ��int�����ˣ���֮ǰ��������intҪ����long�ſ��Ե����
		//��Ȼ�������ֳ������Χ�ˣ���ô�����еĲ�������int x��ȫ��д���ˡ�����
		//���������������
		
		
    }
	
	
//	public int mySqrt(int x) {
//		//��Ŀ�ᵽx guaranteed to ����������û����
//		int low = 0; int high = x;
////		int precision = 1;
////		while ((high - low) > precision) {
//		while (high > low) {
//			int mid = (low + high) / 2;
//			//�����е���������ΪintʱӦ�ûᵼ�µ����������������ǽ�ľ��Ȳ���
//			//���ڱ����ض������������ֵ����������������
//			if (mid * mid == x) {
//				return mid;
//			}
//			if(mid * mid  > x){
//				high = mid - 1;
//			}else {
//				low = mid + 1;
//			}
//		}
//		
//        //return low;
//        //������lowʱ��3-2,5-3,7-2??
//		//return high;
//		//��������highҲ���У����ڱ߽�ֵ���紦��һ��С��������ֵ���ǲ�1����
//		//������΢���һ������ж�һ��
//		return (low * low > x) ? low - 1 : low; 
////		if (low * low > x) {
////			return low - 1;
////		}else {
////			return low;
////		}//����������Զ����С�жϽ������ȫ������
//		//û�뵽��һ���ύ��Ȼ��ʱ��-2147395599����Ӧ�����в��ٷ����������������߽��
//		//						  2147483647
//		//ͻȻ�뵽������ֻ᲻�ᳬ��int�����ˣ���֮ǰ��������intҪ����long�ſ��Ե����
//		//��Ȼ�������ֳ������Χ�ˣ���ô�����еĲ�������int x��ȫ��д���ˡ�����
//		//����Դ󲿷����ֶ��ԣ�����sqrt(x) < x/2 
//		
//    }

}
