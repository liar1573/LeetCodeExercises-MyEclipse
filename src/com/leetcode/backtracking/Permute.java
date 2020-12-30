/**
 * 
 */
package com.leetcode.backtracking;
import java.util.*;

public class Permute {
	List<Integer> tempList = new ArrayList<Integer>();
	List<List<Integer>> ansList = new ArrayList<List<Integer>>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> permute(int[] nums) {
		dfs(nums);
		return ansList;
    }
	
	public void dfs(int[] nums) {
		if(tempList.size() == nums.length){
			ansList.add(new ArrayList<Integer>(tempList));
			return;
		}
		
//		for (int i = index; i < nums.length; i++) {
//			tempList.add(nums[index]);
//			dfs(nums, i + 1);
//			tempList.remove(tempList.size() - 1);
//		}//如果这样写只能生成[1,2,3]，连[1,3,2]都无法生成。。。
//		//这样调用会保证后面的元素一定比前面的元素大
//		//即只能第一轮迭代用for (int i = index; i < nums.length; i++)，后面的迭代需要从nums中剩下的数字里面挑选
		
		//使用了list.contains来判断是否出现了重复的元素。
		for (int i = 0; i < nums.length; i++) {
			if(tempList.contains(nums[i]))
				continue;
			tempList.add(nums[i]);
			dfs(nums);
			tempList.remove(tempList.size() - 1);
		}
	}
	
	//LC官方还给出了一个通过交换维护数组顺序来取消标记数组的方法。不过数组元素的交换操作看起来也挺麻烦的，还是东哥用的list.contains方法代码逻辑简洁很多。
	public List<List<Integer>> permuteExample(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
	
}
