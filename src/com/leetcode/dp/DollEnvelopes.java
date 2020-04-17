/**DollEnvelopes.java
 * com.leetcode.dp
 * TODO
 * 从网易20春招笔试题第四套套包装盒，看到大佬的帖子找到的（原来这道题LC也是有原型或者说类似模型的）
 * LC 354 俄罗斯套娃问题
快递盒问题是三维问题，这里的套娃是二维问题，其实思路应该差不多
 * @author liar
 * 2020年4月16日 上午11:22:10
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
//这里注意到跟一般二分不太一样，等式右边多了一个left，妈个鸡后面反映过来这玩意跟(left+right)/2在数学上是完全等效的！！
                if (map[mid] < height) {
                    left = mid + 1;
                } else {
                    right = mid;
//注意到这里right没有+1，后期有机会也可以对比一下传统写法有什么差别。。
//同时这里也没有传统的等于选项，其他的都合并到不小于里面去了。。
                }
            }
            map[left] = height;
            if (left == max) max++;
        }
        return max;
	}
	
    public int maxEnvelopesDP(int[][] envelopes) {
    	//这里应该不会用长度为0或者null这种无聊的输入吧。。
    	//然而还真有长度为0的数组这种无聊输入。。
    	if(null == envelopes || envelopes.length == 0)
    		return 0;
        int result = 1;
        Arrays.sort(envelopes, new Comparator<int[]>() {    
		    @Override    
		    public int compare(int[] o1, int[] o2) {
		    	if(o1[0] == o2[0])//如果第一列键值相等则根据第二列排序
		    		return o1[1] - o2[1];
		        return o1[0] - o2[0];    
		}});
        
        int[] dp = new int[envelopes.length];
//        dp[0] = 1;
        //一开始漏掉了一点，这里dp全体都要用1赋值，而不能只对dp[0]赋值1
        for (int i = 0; i < dp.length; i++) {
			dp[i] = 1; 
		}
        
        for (int i = 1; i < envelopes.length; i++) {
			for (int j = 0; j < i; j++) {
				if (envelopes[j][0] < envelopes[i][0] 
						&& envelopes[j][1] < envelopes[i][1]) {
					//注意到使用sort排序的时候会有相等的情况，所以这里一定要严格判断小于
					dp[i] = (dp[i] > (dp[j] + 1)) ? dp[i] : (dp[j] + 1); 
				}		
			}
			//这里result的判断从j循环拉到i循环中是不是可以减少判断次数？（结果应该没问题）
			result = (result > dp[i]) ? result: dp[i];
		}
        
        return result;
    }
}
