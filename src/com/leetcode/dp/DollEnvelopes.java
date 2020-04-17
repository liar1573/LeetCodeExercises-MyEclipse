/**DollEnvelopes.java
 * com.leetcode.dp
 * TODO
 * ������20���б�����������װ�װ�У��������е������ҵ��ģ�ԭ�������LCҲ����ԭ�ͻ���˵����ģ�͵ģ�
 * LC 354 ����˹��������
��ݺ���������ά���⣬����������Ƕ�ά���⣬��ʵ˼·Ӧ�ò��
 * @author liar
 * 2020��4��16�� ����11:22:10
 * @version 1.0
 */
package com.leetcode.dp;

import java.util.Arrays;
import java.util.Comparator;

import javax.xml.crypto.dsig.spec.DigestMethodParameterSpec;

public class DollEnvelopes {
	
	public static void main(String[] args) {
		int[][] testArray = {{1 ,2} ,
				{7 ,3} ,
				{7 ,4} };
		System.out.println(maxEnvelopes(testArray));
	}
	
	
	public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length <= 1) return envelopes.length;
        Arrays.sort(envelopes, (a, b) -> {
//            if (a[0] == b[0]) return b[1] - a[1];
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        int[] map = new int[envelopes.length];
        int max = 0;
        for (int i = 0; i < envelopes.length; i++) {
            int height = envelopes[i][1];
            int left = 0;
            int right = max;
            while (left < right) {
                int mid = left + (right - left) / 2; 
//����ע�⵽��һ����ֲ�̫һ������ʽ�ұ߶���һ��left����������淴ӳ�����������(left+right)/2����ѧ������ȫ��Ч�ģ���
                if (map[mid] < height) {
                    left = mid + 1;
                } else {
                    right = mid;
//ע�⵽����rightû��+1�������л���Ҳ���ԶԱ�һ�´�ͳд����ʲô��𡣡�
//ͬʱ����Ҳû�д�ͳ�ĵ���ѡ������Ķ��ϲ�����С������ȥ�ˡ���
                }
            }
            map[left] = height;
            if (left == max) max++;
        }
        return max;
	}
	
    public int maxEnvelopesDP(int[][] envelopes) {
    	//����Ӧ�ò����ó���Ϊ0����null�������ĵ�����ɡ���
    	//Ȼ�������г���Ϊ0�����������������롣��
    	if(null == envelopes || envelopes.length == 0)
    		return 0;
        int result = 1;
        Arrays.sort(envelopes, new Comparator<int[]>() {    
		    @Override    
		    public int compare(int[] o1, int[] o2) {
		    	if(o1[0] == o2[0])//�����һ�м�ֵ�������ݵڶ�������
		    		return o1[1] - o2[1];
		        return o1[0] - o2[0];    
		}});
        
        int[] dp = new int[envelopes.length];
//        dp[0] = 1;
        //һ��ʼ©����һ�㣬����dpȫ�嶼Ҫ��1��ֵ��������ֻ��dp[0]��ֵ1
        for (int i = 0; i < dp.length; i++) {
			dp[i] = 1; 
		}
        
        for (int i = 1; i < envelopes.length; i++) {
			for (int j = 0; j < i; j++) {
				if (envelopes[j][0] < envelopes[i][0] 
						&& envelopes[j][1] < envelopes[i][1]) {
					//ע�⵽ʹ��sort�����ʱ�������ȵ��������������һ��Ҫ�ϸ��ж�С��
					dp[i] = (dp[i] > (dp[j] + 1)) ? dp[i] : (dp[j] + 1); 
				}		
			}
			//����result���жϴ�jѭ������iѭ�����ǲ��ǿ��Լ����жϴ����������Ӧ��û���⣩
			result = (result > dp[i]) ? result: dp[i];
		}
        
        return result;
    }
}
