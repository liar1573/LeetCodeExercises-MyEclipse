/**
 * 
 */
package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liar-pc
 *
 */
public class Combine {
	
	LinkedList<Integer> temp = new LinkedList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> combine(int n, int k) {
//    	backtrack(0, n, k);
    	backtrack(1, n, k);
    	return this.ans;
    }
    
    public void backtrack(int index, int n, int k) {
    	//这条逻辑表示当前的序列长度，加上剩余的最大长度也无法满足目标长度，所以后面的就不需要遍历了可以直接返回
    	if(n - index + 1 + temp.size() < k)
    	  return;
    	//加了这条剪枝判断之后，时间提升非常明显！！
    	//从简化代码的角度，n和k感觉可以复制给类的成员变量减少函数调用
    	if(temp.size() == k){
    		this.ans.add(new LinkedList<Integer>(temp));
			return;
    	}//感觉列表内容格式需要比索引下标优先判断
    		
		if(index == (n+1)){
			return;
		}
		
		this.temp.add(index);
		backtrack(index + 1, n, k);
		//这里一开始以为需要什么额外的判断条件，但是参考了一下LC78的解答，并不需要什么其他判断条件
		temp.removeLast();
		backtrack(index + 1, n, k);
	}
	
    


        public List<List<Integer>> combineBit(int n, int k) {
        	//基于位运算的解法，以后有机会再看看
            List<Integer> temp = new ArrayList<Integer>();
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            // 初始化
            // 将 temp 中 [0, k - 1] 每个位置 i 设置为 i + 1，即 [0, k - 1] 存 [1, k]
            // 末尾加一位 n + 1 作为哨兵
            for (int i = 1; i <= k; ++i) {
                temp.add(i);
            }
            temp.add(n + 1);
            
            int j = 0;
            while (j < k) {
                ans.add(new ArrayList<Integer>(temp.subList(0, k)));
                j = 0;
                // 寻找第一个 temp[j] + 1 != temp[j + 1] 的位置 t
                // 我们需要把 [0, t - 1] 区间内的每个位置重置成 [1, t]
                while (j < k && temp.get(j) + 1 == temp.get(j + 1)) {
                    temp.set(j, j + 1);
                    ++j;
                }
                // j 是第一个 temp[j] + 1 != temp[j + 1] 的位置
                temp.set(j, temp.get(j) + 1);
            }
            return ans;
        }

}
