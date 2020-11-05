/**LC279.按平方数来分割整数。与LC322硬币换零钱有些相似，只不过限制了条件组成数字只能为平方数。
 */
package com.leetcode.dp;

import java.util.HashSet;
import java.util.Set;

public class PerfectSquares {
	Set<Integer> square_nums = new HashSet<Integer>();
	
	
	public static void main(String[] args) {
		PerfectSquares test = new PerfectSquares();
		System.out.println(test.numSquares(4));
		
	}
	
	public int numSquares(int n) {
		int square = (int) Math.sqrt(n);
		int[] array = new int[square];
		int[] dp = new int[n + 1];
		for (int i = 0; i < array.length; i++)
			array[i] = (i + 1) * (i + 1); 
		for (int i = 0; i < dp.length; i++)
			dp[i] = i;
		
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if(array[j] > i)
					break;
				dp[i] = Math.min(dp[i], dp[i - array[j]] + 1); 
			}
		}
		 
		return dp[n];
    }
	
	//解法3，贪心枚举
//	public int numSquares(int n) {
//	    this.square_nums.clear();
//
//	    for (int i = 1; i * i <= n; ++i) {
//	      this.square_nums.add(i * i);
//	    }
//
//	    int count = 1;
//	    for (; count <= n; ++count) {
//	      if (is_divided_by(n, count))
//	        return count;
//	    }
//	    return count;
//	  }

	  protected boolean is_divided_by(int n, int count) {
		    if (count == 1) {
		      return square_nums.contains(n);
		    }

		    for (Integer square : square_nums) {
		      if (is_divided_by(n - square, count - 1)) {
		        return true;
		      }
		    }
		    return false;
		  }

	  //解法4，使用贪心和BFS的解法
//	  public int numSquares(int n) {
//
//		    ArrayList<Integer> square_nums = new ArrayList<Integer>();
//		    for (int i = 1; i * i <= n; ++i) {
//		      square_nums.add(i * i);
//		    }
//
//		    Set<Integer> queue = new HashSet<Integer>();
//		    queue.add(n);
//
//		    int level = 0;
//		    while (queue.size() > 0) {
//		      level += 1;
//		      Set<Integer> next_queue = new HashSet<Integer>();
//
//		      for (Integer remainder : queue) {
//		        for (Integer square : square_nums) {
//		          if (remainder.equals(square)) {
//		            return level;
//		          } else if (remainder < square) {
//		            break;
//		          } else {
//		            next_queue.add(remainder - square);
//		          }
//		        }
//		      }
//		      queue = next_queue;
//		    }
//		    return level;
//		  }
	
}
