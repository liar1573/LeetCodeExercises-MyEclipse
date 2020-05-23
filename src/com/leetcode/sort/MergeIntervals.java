/**MergeIntervals.java
 * com.leetcode.sort
 * TODO
 * LC56����2D������ʼ�������ʽ����һά���������꣬��Ҫ�ϲ����ص����������
 * @author liar
 * 2020��5��23�� ����11:22:21
 * @version 1.0
 */
package com.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	  public int[][] merge(int[][] intervals) {
		  if(intervals.length <= 1)//��ʱ����Ҫ�ϲ�
			  return intervals;
		  
		  Arrays.sort(intervals, new Comparator<int[]>() {
			  @Override    
			    public int compare(int[] o1, int[] o2) {
				  //���ݵ�һ��ֵ����
				  return o1[0] - o2[0]; 
			  }		       
		});
		  
		  int count = 0; //countͳ����Ҫɾ��������
		  for (int i = 1; i < intervals.length; i++) {
			if(intervals[i-1][1] >= intervals[i][0]){ 
				count++;
				//��Ҫ������������ཻ���ϲ��������ϸ�µ�����
				//ע����y1 >= x2������£�����Ҫ����y1��y2�Ĺ�ϵ
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
		  //ʹ��ArrayList�Ľⷨ��ֻ�ñ���һ������
	        List<int[]> res = new ArrayList<>();
	        if (intervals.length == 0 || intervals == null) return res.toArray(new int[0][]);
	        // ������յ��������
	        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
	        int i = 0;
	        while (i < intervals.length) {
	            int left = intervals[i][0];
	            int right = intervals[i][1];
	            // ������ص���ѭ���ж��ĸ������������
	            while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
	                i++;
	                right = Math.max(right, intervals[i][1]);
	            }
	            // �����ڵ�����Ž�res����
	            res.add(new int[]{left, right});
	            // �����ж���һ������
	            i++;
	        }
	        return res.toArray(new int[0][]);
	    }

	  public int[][] mergeCopyOf(int[][] intervals) {
	        //ʹ��index��ǰ�ƶ���ɾ���Ľڵ㣬Ȼ��ʹ��Arrays.copyOf������
		    //�Ӵ����Ͽ�Ҳֻ�����һ������
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
