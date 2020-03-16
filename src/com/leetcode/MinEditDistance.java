package com.leetcode;
//LeetCode 72

public class MinEditDistance {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//˵����֮ǰһֱ������static��̬��������
		//��ʵ�����и���JUnit�����������Ի᷽��ܶ�
		//pycharm��idea����Ҳ�����Ƶ�ģ����Թ���
		System.out.println(minDistance("horse","ros"));
		
	}
	
	
	 public static int minDistance(String word1, String word2) {
		 //null�ڱ�����ȫû�����壬�������Ǵ���һ�º���
		 if (null == word1 || null == word1) {
			return 0;
		}
		 
		 //����ʾ�����ѳ���ר���ñ�����ʾ�����濴�Ż���ܶ�
		 int m = word1.length();
		 int n = word2.length();		 
		 int[][] dp = new int[m+1][n+1]; 
		 //ʾ��python����ͨ��������ߴ�����Ϊdp[m+1,n+1]��������ıܿ��˶��ַ�����Ϊ0���������ۣ��Ǵ������˺ܶ�
		 //ע�⵽���ﳤ������Ϊm+1,n+1һ�����ã����ܱ�����ⳤ��Ϊ0���жϣ�����ʹ�±��볤�ȶ�����ǿ�ɶ���
		 
		 
		 //java int����ӡ�������Զ���ʼ��Ϊ0�ģ�����͵��������
		 for (int i = 0; i < m+1; i++) {
			dp[i][0] = i; //Ŀ��Ϊ�յ��������ȫ��ɾ��ԭ�е�
		}
		 for (int i = 0; i < n+1; i++) {
			dp[0][i] = i; //ԴΪ�յ�������Զ���Ŀ���������
		}
		 
		 //��ע��+1�ȱ߽�����
		 for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (word1.charAt(i-1) == word2.charAt(j-1)) {
					//ע�⵽dp�ĳ��ȼ���1������string�Ĺ��û�б䣬��Ҫ��1����
					dp[i][j] = dp[i-1][j-1]; 
				}else {
//					int tempValue = (dp[i-1][j] < dp[i][j-1]) ? dp[i-1][j] + 1: dp[i][j-1] + 1;
//					dp[i][j] = (tempValue < dp[i-1][j-1]) ? tempValue + 1 : dp[i-1][j-1] + 1 ;
					//һ��ʼ�����temp�����һ��1���½������1.
					//�����+1����Ҫ�����ļӼ���
					int tempValue = (dp[i-1][j] < dp[i][j-1]) ? dp[i-1][j]: dp[i][j-1];
					dp[i][j] = (tempValue < dp[i-1][j-1]) ? tempValue + 1 : dp[i-1][j-1] + 1 ;
				}
			}
		}
		 		 
		 return dp[m][n];
	 }
}
