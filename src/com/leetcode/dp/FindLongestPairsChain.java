/**FindLongestPairsChain.java
 * com.leetcode.dp
 * LC646，最长数对列，与LC300最长上升子序列很像，但是需要序列是以数字对的形式构成。
 * @author liar
 * 2020年11月24日 下午3:54:20
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
		System.out.println("排序前");
		for (int[] is : pairs) {
			for (int i : is) {
				System.out.print(i + "  ");
			}
			System.out.println();
		}
//		System.out.println(test.findLongestChain(pairs));
		System.out.println(test.findLongestChainGreedy(pairs));
		System.out.println("排序后");
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
		//第一次只对dp[0]赋值1，后面的默认是0，结果存在了1个值的偏差
		//如果把dp全部初始化0试试？
		for (int i = 0; i < dp.length; i++) 
			dp[i] = 1;
		//改完之后就对了，果然是细节问题。后面可能会出现中间节点重新开始计数的，如果初始化dp不都置0，后面可能会有问题
		
		
		//lambda表达式
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
        //这里跟自己的稍微有点不一样，是对第二个维度[a,b]中的b进行升序排序
        int cur = Integer.MIN_VALUE, ans = 0;
        for (int[] pair: pairs) if (cur < pair[0]) {
            cur = pair[1];
            ans++;
        }
        return ans;
    }


}
