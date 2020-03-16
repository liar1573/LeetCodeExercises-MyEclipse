package com.leetcode;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//	Input: coins = [1, 2, 5], amount = 11 Output: 3
//			Explanation: 11 = 5 + 5 + 1
	
    public int coinChange(int[] coins, int amount) {
        //������Ҫ�������ĺϷ���
    	//conis[]���ȴ���0���ڲ�ֵ��Ϊ��������amount>0(����0�Ƿ������壿)
    	if ((null == coins)||(0 == coins.length)||(amount < 0)) {
			return -1;
		}
    	if (0 == amount) {
			return 0;//������amount=0����Ҳ�Ǻ����
		}//���ֺ�������Ľⷨ����amount = 0�����������������ȥ
    	//��amount=0ʱһ���᷵��-1����ʵamount=0ʱ����0Ӧ�þͿ����ˣ�
    	
    	
    	int over = amount + 1;
    	//��ϱ�����������������ֵ�����޲�����жϷ����Ƿ����
    	int dp[] = new int[over];//Ϊ�˱����±�����ֵ�������+1
    	for (int i = 1; i < dp.length; i++) {
			dp[i] = over; 
		}
    	dp[0] = 0;
    	
    	for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i >= coins[j]) {
					dp[i] = (dp[i] < (dp[i - coins[j]] + 1)) ? dp[i] : (dp[i - coins[j]] + 1); 
				}
			}
		}
    	
    	return (dp[amount] < over) ? dp[amount]: -1;
    }
    
    public int recurrentChange(int[] coins, int amount) {
    	for (int i = 0; i < coins.length; i++) {
			if (amount < coins[i]) {//ʣ����С�ڵ�ǰ��ֵ��ֱ������
				continue;
			} else if (amount == coins[i]) {//�պõ��ڵ�ǰ������һ��Ӳ��
				return 1;
			} else {//ʣ������ڵ�ǰ��ֵ�����в��
				return recurrentChange(coins, amount - coins[i]) + 1;
			}
		}
    	//���ǵ�������д����û�м�¼��Сֵ�Ĺ���
    	//��������ݹ�д���е��ң�����ֵ̫���ˡ�����
    	//���ϵ��µĵݹ�о��е�����
    	
    	return -1;
	}

}
