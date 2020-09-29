package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * LC39. 组合总和
 * 给定一个无重复元素的数组candidates和一个目标数target，找出 candidates 中所有可以使数字和为 target 的组合。candidates中的数字可以无限制重复被选取。
 * 
 */

public class NumberDivision {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberDivision test = new NumberDivision();
		int[] arr = {2,3,6,7};
		test.combinationSum(arr, 7);
		System.out.println("Done!");
	}
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ans= new ArrayList<List<Integer>>();
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		int[][] nums = new int[candidates.length][1];
		for (int i = 0; i < candidates.length; i++) 
			nums[i][0] = candidates[i];
		Arrays.sort(nums, (a, b) -> {
			return (b[0] - a[0]);
			});
		
		backtrack(ans, tempList, nums,0 , 0, target);
		
		return ans;
    }
	
	public void backtrack(List<List<Integer>> ans, ArrayList<Integer> tempList,
			int[][] nums, int index, int sum, int target) {
		if (sum == target) {
			ans.add((List<Integer>) tempList.clone());
			return;
		}else {
			for (int i = index; i < nums.length; i++) {
				if(nums[i][0] + sum <= target){
					tempList.add(nums[i][0]);
					backtrack(ans, tempList, nums, i, sum + nums[i][0], target);
					tempList.remove(tempList.size() - 1);
				}
			}
		}
	}
}
