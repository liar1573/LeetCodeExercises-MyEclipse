/**FindLongestPairsChain.java
 * com.leetcode.dp
 * LC646��������У���LC300����������к��񣬵�����Ҫ�����������ֶԵ���ʽ���ɡ�
 * @author liar
 * 2020��11��24�� ����3:54:20
 * @version 1.0
 */
package com.leetcode.dp;

import java.util.Arrays;

public class FindLongestPairsChain {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] pairs = {{3,1,2}, {5,3,2}};
		FindLongestPairsChain test = new FindLongestPairsChain();
		System.out.println(test.findLongestChain(pairs));
	}
	
	public int findLongestChain(int[][] pairs) {
		int ans = 1;
		
		Arrays.sort(pairs, (a, b) -> {
            return a[0] - b[0];
        });
		
		
		
		return ans;
    }

}
