/**
 * �����������
 */
package com.leetcode.dp;

/**
 * @author liar-pc
 *
 */
public class KnapsackProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] weight = {2,2,6,5,4};
		int[] value =  {6,3,5,4,6};
		int maxWeight = 10; //��target=10��ʱ�򣬷���ֵΪ15���⼯Ϊ{{2,6},{2,3},{4,6}}
		KnapsackProblem test = new KnapsackProblem();
		System.out.println(test.bag01(weight, value, maxWeight));
		
	}
	
	int bag01(int[] weight, int[] value, int maxWeight){
		//Ϊ�˱�������������ۣ�Ĭ��Ԫ�طǿգ��������Ҫ�����0
		int[][] dp = new int[weight.length][maxWeight + 1];
		//���� dp[i][j] ��ʾǰ i ����Ʒ���/���������� j ��������ܴﵽ������ֵ
		
		//�±�Ϊ0λ�õĳ�ʼ��
		if(weight[0] <= maxWeight){
			for (int j = weight[0]; j <= maxWeight; j++) {
				dp[0][j] = value[0]; 
			}
		}
			dp[0][weight[0]] = value[0];
		
		for (int i = 1; i < dp.length; i++) {
			//for (int j = 1; j < dp[0].length; j++) {
				for (int j = 1; j < dp[0].length; j++) {
				if(weight[i] <= j){
					dp[i][j] = (dp[i-1][j] > (dp[i-1][j - weight[i]] + value[i]))? dp[i-1][j]: (dp[i-1][j - weight[i]] + value[i]); 
				}else {
					dp[i][j] = dp[i-1][j]; 
				}
			}
		}
		
		//for(j) {for(i)}  ��һ��ͨ��ʵ�ʱ���ȷ�ϣ�ѭ��index��weight��Ƕ��˳��û��Ӱ��
		
		return dp[weight.length - 1][maxWeight];
	}
	
	
}
