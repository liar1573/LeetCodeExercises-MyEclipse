package com.leetcode;
/**StockSaling.java
 * 
 * TODO
 * @author liar
 * 2020��2��1�� ����12:54:22
 * @version 1.0
 */

/**
 * @author liar
 *
 */
public class StockSaling {

	/**
	 * @Description: TODO
	 * @para: @param args
	 * @return: void
	 * @throws: @param args
	 * @author: liar
	 * @date: 2020��2��1�� ����12:54:22
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {7,1,5,3,6,4};
		
		System.out.println(profit3d(prices));
		
	}
	
	public static int profit(int[] prices){
		if (prices.length < 2) {
			return 0;
		}
		
		int profit = 0; int min =prices[0];
		
		//���������ķ�DP������ʽд��
//		for (int i = 1; i < prices.length; i++) {
//			int temp = prices[i]- min;
//			profit = (temp > profit)?temp:profit;
//			min = (min < prices[i] )?min:prices[i];
//		}
		
//		int[][] mp = new int[prices.length][2];
//		mp[0][0] = 0;//��һ��û�й����Ʊʱ������
//		mp[0][1] = -prices[0];//��һ�칺���˹�Ʊʱ������
//		
//		for (int i = 1; i < prices.length; i++) {
//			mp[i][0] = Math.max(mp[i-1][0], mp[i-1][1] + prices[i]);
//			mp[i][1] = Math.max(mp[i-1][1], mp[i-1][0] - prices[i]);
//		}
//		
//		print2dArray(mp);
		
		
		int[][][] mp3=new int[2][3][prices.length];
		//��һά��Ӧ�Ƿ��й�Ʊ0-1���ڶ�ά��Ӧ����Ĵ���ͳ��
		mp3[0][0][0] = 0;//��һ��û�й����Ʊʱ������
		mp3[1][1][0] = -prices[0];
		
			for (int i = 1; i < prices.length; i++) {
				for (int k = 0; k < 2; k++) {
					//���k��0��ʼ��k-1�϶���Խ��Ϊ-1��
//				mp3[0][k][i] = Math.max(mp3[0][k][i-1], mp3[1][k-1][i-1] + prices[i]);
//				mp3[1][k][i] = Math.max(mp3[1][k][i-1], mp3[0][k-1][i-1] - prices[i]);
				
				//��k,k-1���k+1,k���ԣ�ͬʱ�ռ俪��k+1����ֹ���
				mp3[0][k+1][i] = Math.max(mp3[0][k][i-1], mp3[1][k][i-1] + prices[i]);
				mp3[1][k+1][i] = Math.max(mp3[1][k][i-1], mp3[0][k][i-1] - prices[i]);
				
				//ʾ�����룺1-���ڣ�2-�������k��3-�Ƿ��й�Ʊ0-1
				//�Լ������ã�1-�Ƿ��й�Ʊ0-1��2-���������3-����
				//��k�ĵ���չ������
				//��k=0ʱ
				//�Աȷ����Լ���������һ��������
				mp3[0][0][i] = mp3[0][0][i-1];//����û���Ʊ���ֲ�������һ��ʼ����©���ˡ���
				//�ο��˰��������Լ���ǰ�Թ������k�Ĵ��������ⲻ̫�Ͻ�
				//����mp3����ĳ�ʼ���ƺ�Ҳ��̫��ȷ
				
				//
				mp3[0][1][i] = Math.max(mp3[0][0][i-1], mp3[1][0][i-1] + prices[i]);
				mp3[1][1][i] = Math.max(mp3[1][0][i-1], mp3[0][0][i-1] - prices[i]);

				
				
			}
			
		}
		
		
		
		//return mp[prices.length-1][0];
		int max = 0;
		for (int i = 0; i < 2; i++) {
			max = (mp3[0][i][prices.length-1] > max)?mp3[0][i][prices.length-1]:max;
		}
		return max;
		
//		return profit;
	}
	
	public static int profit3d(int[] prices){
		//�����г�����������άͨ�ô�����˼·
		if (prices.length < 2) {
			return 0;
		}
		
		int[][][] mp3=new int[3][2][prices.length];
		
		//���ں��ڴ𰸲鿴�м����ݣ�java��ά����Ŀ��ٵ���ԭ��������ά��˳���������Ϊ
		//��һάKΪ�������ͳ�ƣ��ڶ�ά0-1����Ƿ�ӵ�й�Ʊ������άi��Ӧ����
		
		//ʾ�����룺1-���ڣ�2-�������k��3-�Ƿ��й�Ʊ0-1
		
		//ʾ���ĳ�ʼ������
		mp3[0][0][0] = 0;//��һ��û�й����Ʊʱ������
		mp3[0][1][0] = -prices[0];//��һ�칺���˹�Ʊ������
		//���չ�������ļ��������ﲻӦ����mp3[1][1][0] = -price[0]�𣬵�һ���Ѿ������
		//�ѵ����벻���������ż����ģ���
		//��mp3[][][0]��һ������Ӧ��������������ϣ�����ȫ����ʼ��Ϊ��С��ֵ��
		//�����С��ֵ�ĳ�ʼ��������ڣ���ֱ��Ĭ�ϳ�ʼ��Ϊ0�ܷ���У�
		//ʾ����������mp[1][0][0],mp[1][1][0],mp[2][0][0],mp[2][1][0]��Ϊ��С����
		//
		
		
		
		//��һ�����в��ԣ�mp3[0]�е������ĸ�ֵĬ������Ϊ0�������н���Ƿ�����
		//��һ�������У�mp3[0]�е�ֵĬ��Ϊ0ʱ��������������������Ҳ����������������쳣�ģ���
		
		
		
		/************************/
		
		//ʾ���ĵ�������
		
		for (int i = 1; i < prices.length; i++) {
		mp3[0][0][i] = mp3[0][0][i-1];//���ﲻ���κ��жϵĸ�ֵ��ʲô���壿��
		mp3[0][1][i] = Math.max(mp3[0][1][i-1],mp3[0][0][i-1]-prices[i]);
		//������������һ�����룬���״���kӦ��Ҫ+1�Ŷԣ���������Ĵ����򱣳ֲ���
		//������Ϊ�˴���Խ����������Ǳ���������Ϲ����Υ���ֲ������һ�����⴦��
		
		//��i�ι���Ŀǰ��ͷû�й�Ʊ
		//����ĵ����Ƿ���֮ǰ�ķ���k�����ı仯
		mp3[1][0][i] = Math.max(mp3[1][0][i-1],mp3[0][1][i-1]+prices[i]);
		
		//��1�ι���Ŀǰ��ͷ�й�Ʊ
		//����ĵ�������k���ֲ��䣿��������֮ǰ�ķ���k�����ı仯
		mp3[1][1][i] = Math.max(mp3[1][1][i-1],mp3[1][0][i-1]-prices[i]);
		
		//��2��������ͷû��Ʊ���������֪��Ϊʲôֻ������һ���������
		//�Ƿ��ǵ�����������Ϊ2�����Ҵ���Ϊ2��ʱ��һ��������û�й�Ʊ��ʱ�������������ֻ��������һ�����
		mp3[2][0][i] = Math.max(mp3[2][0][i-1],mp3[1][1][i-1]+prices[i]);
		
		
		}
		/************************/
		
		
		//��һ��ʧ�ܵĳ��ԣ��������ȷ������Ǻ�
		/*
			for (int i = 1; i < prices.length; i++) {
				for (int k = 0; k < 2; k++) {
					//���k��0��ʼ��k-1�϶���Խ��Ϊ-1��
//				mp3[0][k][i] = Math.max(mp3[0][k][i-1], mp3[1][k-1][i-1] + prices[i]);
//				mp3[1][k][i] = Math.max(mp3[1][k][i-1], mp3[0][k-1][i-1] - prices[i]);
				
				//��k,k-1���k+1,k���ԣ�ͬʱ�ռ俪��k+1����ֹ���
				mp3[0][k+1][i] = Math.max(mp3[0][k][i-1], mp3[1][k][i-1] + prices[i]);
				mp3[1][k+1][i] = Math.max(mp3[1][k][i-1], mp3[0][k][i-1] - prices[i]);
	
				}
			}
			*/
		
		
		print3dArray(mp3);
		
		int maxProfit = 0;
		for (int i = 0; i < mp3.length; i++) {
			maxProfit = (maxProfit > mp3[i][0][prices.length-1])?maxProfit:mp3[i][0][prices.length-1];
		}
		
		
		return maxProfit;
	}
	
	
	static void print2dArray(int[][] arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i][0] + "   ");
		}
		System.out.println();
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i][1] + "   ");
		}
		
	}
	
	static void print3dArray(int[][][] arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.println("��" + i + "�ι���");		
			for (int j = 0; j < arr[0].length; j++) {
				for (int k = 0; k < arr[0][0].length; k++) {
					System.out.print(arr[i][j][k] + "   ");	
				}	
				System.out.println();
			}		
		}	
	}
	
	
	

}
