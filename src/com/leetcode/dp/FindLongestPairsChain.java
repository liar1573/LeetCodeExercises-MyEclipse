/**FindLongestPairsChain.java
 * com.leetcode.dp
 * LC646��������У���LC300����������к��񣬵�����Ҫ�����������ֶԵ���ʽ���ɡ�
 * @author liar
 * 2020��11��24�� ����3:54:20
 * @version 1.0
 */
package com.leetcode.dp;

import java.util.Arrays;
import java.util.Comparator;

public class FindLongestPairsChain {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] pairs = {{3,1,2}, {5,3,2}};
//		int[][] pairs = {{3,5},{1,3}, {2,2}};
		int[][] pairs = {{-6,9} , {1,6}, {8,10}, {-1,4}, {-6,-2}, {-9,8}, {-5,3}, {0,3}};
		
		FindLongestPairsChain test = new FindLongestPairsChain();
		System.out.println("����ǰ");
		for (int[] is : pairs) {
			for (int i : is) {
				System.out.print(i + "  ");
			}
			System.out.println();
		}
//		System.out.println(test.findLongestChain(pairs));
		System.out.println(test.findLongestChainGreedy(pairs));
		System.out.println("�����");
		for (int[] is : pairs) {
			for (int i : is) {
				System.out.print(i + "  ");
			}
			System.out.println();
		}
	}
	
	public int findLongestChain(int[][] pairs) {
		int ans = 1;
		int[] dp = new int[pairs.length];
//		dp[0] = 1;
		//��һ��ֻ��dp[0]��ֵ1�������Ĭ����0�����������1��ֵ��ƫ��
		//�����dpȫ����ʼ��0���ԣ�
		for (int i = 0; i < dp.length; i++) 
			dp[i] = 1;
		//����֮��Ͷ��ˣ���Ȼ��ϸ�����⡣������ܻ�����м�ڵ����¿�ʼ�����ģ������ʼ��dp������0��������ܻ�������
		
		
		//lambda���ʽ
		Arrays.sort(pairs, (a, b) -> {
            return a[0] - b[0];
        });
		
//		Arrays.sort(pairs, new Comparator<int[]>() {
//			@Override
//			public int compare(int[] o1, int[] o2) {
//			return o1[0]-o2[0];
//			}
//			});
		
		for (int i = 1; i < pairs.length; i++) {
			for (int j = 0; j < i; j++) {
				if(pairs[j][1] < pairs[i][0]){
					dp[i] = Math.max(dp[i], dp[j] + 1); 
				}
			}
			if(dp[i] > ans)
				ans = dp[i];
		}
		
		
		return ans;
    }
	
	public int findLongestChainGreedy(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        //������Լ�����΢�е㲻һ�����ǶԵڶ���ά��[a,b]�е�b������������
        int cur = Integer.MIN_VALUE, ans = 0;
        for (int[] pair: pairs) if (cur < pair[0]) {
            cur = pair[1];
            ans++;
        }
        return ans;
    }


}
