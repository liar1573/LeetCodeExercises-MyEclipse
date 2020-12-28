/**
 * LC28.给定一组不含重复元素的整数数组nums，返回该数组所有可能的子集（包括空集和自身）。
 */
package com.leetcode;

import java.util.*;


public class Subsets {
	LinkedList<Integer> temp = new LinkedList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
	
	public static void main(String[] args){
		Subsets test = new Subsets();
		int[] arr = {1, 2, 3};
		test.subsetsBacktrack(arr);
		
	}
	
	
	 public List<List<Integer>> subsets(int[] nums) {
		 ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		 result.add(new ArrayList<Integer>()); //先放入一定存在的空集
		 for (int i = 0; i < nums.length; i++) {
			//这里感觉需要对双重list做一个备份，不能直接操作原始数据
//			 ArrayList<List<Integer>> tempDoubleList = (ArrayList<List<Integer>>) result.clone();
//			 ArrayList<List<Integer>> tempDoubleList = new ArrayList<List<Integer>>();
//			 tempDoubleList.addAll(result);
			 ArrayList<List<Integer>> tempDoubleList = (ArrayList<List<Integer>>) deepClone(result);
			 for (List<Integer> list : tempDoubleList) {
				list.add(nums[i]);
				result.add(list);
			}
		}
		 return result;
	 }
	 
	 public List<List<Integer>> deepClone(List<List<Integer>> source){
		 //自己写一个深拷贝的方法
		 ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		 for (List<Integer> list : source) {
			ArrayList<Integer> tempList = new ArrayList<Integer>();
			 Iterator<Integer> it=list.iterator();
			 while(it.hasNext()){
				 tempList.add(it.next());
			 }
			result.add(tempList);
		} 
		 return result;
	 }
	 
	 public List<List<Integer>> subsetsDFS(int[] nums) {
		 ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		 dfs(result, nums, nums.length - 1);
		 return result;
	 }
	 
	 public void dfs(List<List<Integer>> result, int[] nums, int index) {
		 //这里强行用递归的话感觉有点怪，只是把for循环换成了递归的表示，并没有什么其他明显的好处反而还额外增加了递归栈的开销。。
		if(index < 0){
			result.add(new ArrayList<Integer>());
			return;
		}
		
		dfs(result, nums, index - 1); //递归获取N-1个元素的子集
		//想了想这里同样需要深拷贝
		ArrayList<List<Integer>> tempDoubleList = (ArrayList<List<Integer>>) deepClone(result);
		for (List<Integer> list : tempDoubleList) {
			list.add(nums[index]);
			result.add(list);
		}
		return;	
	}
	 
	    public List<List<Integer>> subsetsBacktrack(int[] nums) {
	        backtrack(nums, 0);
	        return ans;
	    }
	    
	    //回溯解法
	    public void backtrack(int[] nums, int index) {
//			ans.add(new LinkedList<Integer>(temp));
			ans.add((List<Integer>) temp.clone());
	        for(int i = index; i <nums.length; i++){
	            temp.add(nums[index]);
	            backtrack(nums, index + 1);
	            temp.removeLast();
	        }
	    }
	    //输出：
	    //[[],[1],[1,2],[1,2,3],[1,2],[1,2,3],[1],[1,2],[1,2,3],[1,2],[1,2,3],[1],[1,2],[1,2,3],[1,2],[1,2,3]]
	 
}
