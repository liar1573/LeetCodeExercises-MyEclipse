/**MergeIntervals.java
 * com.leetcode.sort
 * TODO
 * LC56，以2D数组起始坐标的形式给出一维的区间坐标，需要合并有重叠区间再输出
 * @author liar
 * 2020年5月23日 上午11:22:21
 * @version 1.0
 */
package com.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	  public int[][] merge(int[][] intervals) {
		  if(intervals.length <= 1)//此时不需要合并
			  return intervals;
		  
		  Arrays.sort(intervals, new Comparator<int[]>() {
			  @Override    
			    public int compare(int[] o1, int[] o2) {
				  //根据第一列值排序
				  return o1[0] - o2[0]; 
			  }		       
		});
		  
		  int count = 0; //count统计需要删除的区间
		  for (int i = 1; i < intervals.length; i++) {
			if(intervals[i-1][1] >= intervals[i][0]){ 
				count++;
				//需要对两个区间的相交、合并情况做更细致的讨论
				//注意在y1 >= x2的情况下，还需要讨论y1和y2的关系
				if(intervals[i-1][1] >= intervals[i][1]){
					intervals[i][1] = intervals[i-1][1];
					intervals[i][0] = intervals[i-1][0];
					
				} else {
					intervals[i][0] = intervals[i-1][0];
				}
				intervals[i-1][0] = -1;
			}
		}
		  
		  int[][] result = new int[intervals.length - count][2];
		  for (int i = 0,j = 0; i < intervals.length; i++) {
			if(intervals[i][0] != -1){
				result[j][0] = intervals[i][0];
				result[j][1] = intervals[i][1];
				j++;
			}
		}
		  
		  
		  return result;
	  }


	  public int[][] mergeArrayList(int[][] intervals) {
		  //使用ArrayList的解法，只用遍历一次区间
	        List<int[]> res = new ArrayList<>();
	        if (intervals.length == 0 || intervals == null) return res.toArray(new int[0][]);
	        // 对起点终点进行排序
	        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
	        int i = 0;
	        while (i < intervals.length) {
	            int left = intervals[i][0];
	            int right = intervals[i][1];
	            // 如果有重叠，循环判断哪个起点满足条件
	            while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
	                i++;
	                right = Math.max(right, intervals[i][1]);
	            }
	            // 将现在的区间放进res里面
	            res.add(new int[]{left, right});
	            // 接着判断下一个区间
	            i++;
	        }
	        return res.toArray(new int[0][]);
	    }

	  public int[][] mergeCopyOf(int[][] intervals) {
	        //使用index向前移动被删除的节点，然后使用Arrays.copyOf方法，
		    //从代码上看也只需遍历一次区间
	        if (intervals.length == 0) return intervals;                
	        Arrays.sort(intervals, (int[] n1, int[] n2) -> n1[0]-n2[0]);
	        int index = 0;
	        for (int i = 1; i < intervals.length; i++) {
	            
	            if (intervals[index][1] >= intervals[i][0]) {
	                
	                if (intervals[index][1] < intervals[i][1])
	                intervals[index][1] = intervals[i][1];
	            } else { 
	                intervals[++index] = intervals[i];
	            }
	        }   
	        return Arrays.copyOf(intervals, index+1);
	    }

}
