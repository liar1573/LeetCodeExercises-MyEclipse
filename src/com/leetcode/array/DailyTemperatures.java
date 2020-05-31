/**DailyTemperatures.java
 * com.leetcode.array
 * TODO
 * LC 739
 * @author liar
 * 2020年5月31日 上午9:57:43
 * @version 1.0
 */
package com.leetcode.array;

import java.util.Arrays;
import java.util.LinkedList;

public class DailyTemperatures {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] dailyTemperatures(int[] T) {
        if(T == null)	return null;
		int len = T.length;
        int[] result = new int[len];
		if(len == 0)	return result;
		
		LinkedList<Integer> stack = new LinkedList<Integer>();
		stack.push(len-1);
		
		for (int i = len - 2; i >= 0; i--) {
			if(T[i] < T[stack.peek()]){
				result[i] = stack.peek() - i;
				stack.push(i);
			}else { // 这里等于和大于的情况都是同样处理
				while (!stack.isEmpty() && T[i] >= T[stack.peek()]) 
					stack.pop();
				//这里result[i]=0 就是初始值其实可以不需要额外操作
				//后来测试了一下这个分支并不一定总是0，还要做其他判断
				if(!stack.isEmpty())
					result[i] = stack.peek() - i;
				stack.push(i);
			}
		}
		
		return result;
    }
	
	public int[] dailyTemperaturesBF(int[] T) {
		//两层for的暴力解法
		if(T == null)	return null;
		int len = T.length;
        int[] result = new int[len];
		if(len == 0)	return result;
		
		for (int i = 0; i < len - 1; i++) 
			for (int j = i + 1; j < len; j++) 
				if(T[j] > T[i]){
					result[i] = j - i;
					break;
				}		

		return result;
	}
	
	//官方解法表达非常简洁，不过思路可能有点不太好想到。。
//	public int[] dailyTemperatures(int[] T) {
//        int[] ans = new int[T.length];
//        Stack<Integer> stack = new Stack();
//        for (int i = T.length - 1; i >= 0; --i) {
//            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) stack.pop();
//            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
//            stack.push(i);
//        }
//        return ans;
//    }
	
	//官方的哈希表解法
	public int[] dailyTemperaturesHashTable(int[] T) {
        int[] ans = new int[T.length];
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);
        //其实这里的赋初始值比T的长度稍微大一些就行，不一定要用max-int
        for (int i = T.length - 1; i >= 0; --i) {
            int warmer_index = Integer.MAX_VALUE;
            for (int t = T[i] + 1; t <= 100; ++t) {
            	//注意到这里本质上也是两层for循环，只不过内层的长度为最多W，比两层都是N复杂度降了很多
                if (next[t] < warmer_index)
                    warmer_index = next[t];
            }
            if (warmer_index < Integer.MAX_VALUE)
                ans[i] = warmer_index - i;
            next[T[i]] = i;
        }
        return ans;
    }

	
}
