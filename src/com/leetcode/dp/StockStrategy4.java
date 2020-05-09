/**StockStrategy4.java
 * com.leetcode.dp
 * TODO
 * DP��Ʊ��������4������Ϊ������k�ι�Ʊ������ͬһʱ�̻���ֻ��ӵ��һ֧��Ʊ
 * @author liar
 * 2020��5��8�� ����3:25:39
 * @version 1.0
 */
package com.leetcode.dp;



public class StockStrategy4 {
	
	public static void main(String[] args) {
		StockStrategy4 test = new StockStrategy4();
		//int[] prices = {3,2,6,5,0,3};
		int[] prices = {1,2,4,2,5,7,2,4,9,0};
		//System.out.print(test.maxProfitExample(2, prices));
		System.out.print(test.maxProfitUnlimitedTimes(prices));
		
	}
	
    public int maxProfitMLC(int k, int[] prices) {
    	//����㷨����k��len�����������Ӧ���ǹ��õģ����Ƕ���LC�ļ��˰���k=10E������ڴ�����
        //�Ƿ���Ҫk��prices�Ϸ����жϣ�
    	if(k <= 0 || prices.length <= 1)
    		return 0;
    	
    	k = Math.min(k, prices.length/2);
    	
    	//int[][][] dp = new int[prices.length][k][2];
    	//ʵ���ϵڶ�ά��ȡֵ��Χ��0-k���ʴ�СӦ��Ϊk+1
    	int[][][] dp = new int[prices.length][k+1][2];
    	
    	//��һ����΢���⴦��һ�£���Ϊ��һ��ֻ�������޷�����
    	dp[0][0][1] = -prices[0];
    	//�����һ�����ֻ��������ʱ���k+1����
    	
    	//����ӡ���к�������Ҫ��dp[0][0...k][0-1]�������⸳��ʼֵ�����
    	//��Ȼ��ʵ�����忼�ǣ���һ��ֻ���ܳ���dp[0][0][1]��dp[0][0][0]�������
    	
    	//1��ֱ�Ӷ�dp[0][k][1]�������ȫ����ֵ-prices[0]��Σ�����Ȼ������ʵ�ʣ����ǿ��ܻ�Ժ�����ж�������
    	for (int i = 0; i <= k; i++) {
			dp[0][i][1] = -prices[0];
		}
    	
    	
    	for (int i = 1; i < dp.length; i++) {
    		//֮ǰ�������Ϊ2��ʱ�����ﶼ���ֶ������������д������
    		//����һ������չ��k�е㲻֪����������ˡ���
    		
    		//k=0��������⴦������Խ��Ϊ-1
    		dp[i][0][0] = dp[i-1][0][0];
    		dp[i][0][1] = Math.max(dp[i-1][0][1], dp[i-1][0][0] - prices[i]);
    		for (int j = 1; j <= k; j++) {
				//��ʵ��Щk�ĸ�ֵ���ǵ���ǰ���������������ģ�����Ϊ��ͳһ��̶��ӽ�ȥ����
    			//���������Ҫһ��max��������
    			dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j-1][1] + prices[i]);
    			//ע�⵽�������Ҫ��j=0��j-1�������һЩ���⴦�������Խ��Ϊ-1
    			dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j][0] - prices[i]);
    			
			}
    		
		}
    	
    	
    	int result = 0;
    	for (int i = 0; i <= k; i++)
			result = (result > dp[prices.length - 1][i][0]) ? result : dp[prices.length - 1][i][0];
    	
    	return result;
    }

    public int maxProfitExample(int k, int[] prices) {
    	//������һ��AC�⣬����ʹ��int length = Math.min(k, prices.length / 2) + 1;
    	//ͬʱ�Ż��˵����ռ��������ͨ����
	    	int length = Math.min(k, prices.length / 2) + 1; // caculate the theoretically max transactions we can make
	    	int sell[] = new int[length];
	    	int hold[] = new int[length];
	    	//�����sell��hold������൱���Լ������һά[1-0]Ч����һ����
	    	for(int i = 0; i < length; i++)
	    		hold[i] = Integer.MIN_VALUE;
	    	//�������ʹ���˸���Сֵ��ֵ��ʵ��һ����ֻҪ��-prices[0]��ֵ�Ϳ�����
	    	for(int i = 0; i < prices.length; i++) {
		    	for(int j = length - 1; j >= 1; j--) { // index from high to low since hold[k] depends on sell[k - 1]
		    		//����j��length-1������1��ʡ��������������ж�
		    		sell[j] = Math.max(sell[j], hold[j] + prices[i]);
		    		hold[j] = Math.max(hold[j], sell[j - 1] - prices[i]);
		    	}//��ʵ�о����������˼·�����Լ����㷨�����޸�һ��Ҳ���Խ�
		    	//��Ҫ��Ҫ����dp�ĳߴ���Ӧ�Լ��˴����
	    	}
	    	return sell[length - 1];
    	}
    
    
    public int maxProfitImproved(int k, int[] prices) {
    	//�������������нⷨ��Ӧ��LC�ļ��˰���k=10E������ڴ��������Ż�
        //�Ƿ���Ҫk��prices�Ϸ����жϣ�
    	if(k <= 0 || prices.length <= 1)
    		return 0;
    	
    	k = Math.min(k, prices.length/2);
    	
    	//int[][][] dp = new int[prices.length][k][2];
    	//ʵ���ϵڶ�ά��ȡֵ��Χ��0-k���ʴ�СӦ��Ϊk+1
    	//int[][][] dp = new int[prices.length][k+1][2];
    	int[][][] dp = new int[2][k+1][2];
    	//ʵ���������һλ���ò���len�������ϴ�СΪ2��¼��ǰ��ǰһ���ֵ�͹���
    	//�뵽��ǰ��һ�����ɣ�����i%2��(i-1)%2ʹ��ѭ�����鸳ֵ
    	
    	
    	//��һ����΢���⴦��һ�£���Ϊ��һ��ֻ�������޷�����
    	dp[0][0][1] = -prices[0];
    	//�����һ�����ֻ��������ʱ���k+1����
    	
    	//����ӡ���к�������Ҫ��dp[0][0...k][0-1]�������⸳��ʼֵ�����
    	//��Ȼ��ʵ�����忼�ǣ���һ��ֻ���ܳ���dp[0][0][1]��dp[0][0][0]�������
    	
    	//1��ֱ�Ӷ�dp[0][k][1]�������ȫ����ֵ-prices[0]��Σ�����Ȼ������ʵ�ʣ����ǿ��ܻ�Ժ�����ж�������
    	for (int i = 0; i <= k; i++) {
			dp[0][i][1] = -prices[0];
		}
    	
    	
    	for (int i = 1; i < prices.length; i++) {
    		//ע�⵽���ｵ��dp��ά��֮��dp�ĵ�һά�Ͳ��ڵ���prices.length��
    		//֮ǰ�������Ϊ2��ʱ�����ﶼ���ֶ������������д������
    		//����һ������չ��k�е㲻֪����������ˡ���
    		
    		//k=0��������⴦������Խ��Ϊ-1
    		dp[i % 2][0][0] = dp[(i - 1) % 2][0][0];
    		dp[i % 2][0][1] = Math.max(dp[(i - 1) % 2][0][1], dp[(i - 1) % 2][0][0] - prices[i]);
    		for (int j = 1; j <= k; j++) {
				//��ʵ��Щk�ĸ�ֵ���ǵ���ǰ���������������ģ�����Ϊ��ͳһ��̶��ӽ�ȥ����
    			//���������Ҫһ��max��������
    			dp[i % 2][j][0] = Math.max(dp[(i - 1) % 2][j][0], dp[(i - 1) % 2][j-1][1] + prices[i]);
    			//ע�⵽�������Ҫ��j=0��j-1�������һЩ���⴦�������Խ��Ϊ-1
    			dp[i % 2][j][1] = Math.max(dp[(i - 1) % 2][j][1], dp[(i - 1) % 2][j][0] - prices[i]);
    			
			}
    		
		}
    	
    	
    	int result = 0;
    	for (int i = 0; i <= k; i++)
			result = (result > dp[(prices.length - 1) % 2][i][0]) ? result : dp[(prices.length - 1) % 2][i][0];
    	
    	return result;
    }

    public int maxProfitBetter(int k, int[] prices) {
    	//�ο����������Ľⷨ����k>n/2�������ֱ���������޴�����ģ�ͽ��
    	//ͬʱ��for��ʹ����ʱ����ȥ���鷳��%2����
    	if(k <= 0 || prices.length <= 1)
    		return 0;
    	
    	if(k >= prices.length / 2)
    		return maxProfitUnlimitedTimes(prices);
    	
    	int[][] dp = new int[k+1][2];
    	for (int i = 0; i <= k; i++) {
			dp[i][1] = -prices[0];
		}
    	
    	for (int i = 1; i < prices.length; i++) {
    		//ע�⵽���ｵ��dp��ά��֮��dp�ĵ�һά�Ͳ��ڵ���prices.length��
    		//֮ǰ�������Ϊ2��ʱ�����ﶼ���ֶ������������д������
    		//����һ������չ��k�е㲻֪����������ˡ���
    		
    		//k=0��������⴦������Խ��Ϊ-1
    		
    		//dp[i % 2][0][0] = dp[(i - 1) % 2][0][0];
    		dp[0][1] = Math.max(dp[0][1], dp[0][0] - prices[i]);
    		for (int j = 1; j <= k; j++) {
				//��ʵ��Щk�ĸ�ֵ���ǵ���ǰ���������������ģ�����Ϊ��ͳһ��̶��ӽ�ȥ����
    			//���������Ҫһ��max��������
    			int tempValue = dp[j][0];
    			dp[j][0] = Math.max(dp[j][0], dp[j-1][1] + prices[i]);
    			//ע�⵽�������Ҫ��j=0��j-1�������һЩ���⴦�������Խ��Ϊ-1
    			dp[j][1] = Math.max(dp[j][1], tempValue - prices[i]);
			}
    		//������жϲ���һ�㣬�����е�����
		}
    	
    	int result = 0;
    	for (int i = 0; i <= k; i++)
			result = (result > dp[i][0]) ? result : dp[i][0];
    	
    	return result;
    	
    }
    
    public int maxProfitUnlimitedTimes(int[] prices){
    	//���޽��״����Ľⷨ��ʹ�����Ч��̰�Ľⷨ
    	int profit = 0;

    	for(int i=0; i<prices.length-1; i++){
    	    if(prices[i+1] > prices[i]){
    	        profit += (prices[i+1] - prices[i]);
    	    }
    	}

    	return profit;
    	
    }
}
