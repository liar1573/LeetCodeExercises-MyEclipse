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
//		}//�������дֻ������[1,2,3]����[1,3,2]���޷����ɡ�����
//		//�������ûᱣ֤�����Ԫ��һ����ǰ���Ԫ�ش�
//		//��ֻ�ܵ�һ�ֵ�����for (int i = index; i < nums.length; i++)������ĵ�����Ҫ��nums��ʣ�µ�����������ѡ
		
		//ʹ����list.contains���ж��Ƿ�������ظ���Ԫ�ء�
		for (int i = 0; i < nums.length; i++) {
			if(tempList.contains(nums[i]))
				continue;
			tempList.add(nums[i]);
			dfs(nums);
			tempList.remove(tempList.size() - 1);
		}
	}
	
	//LC�ٷ���������һ��ͨ������ά������˳����ȡ���������ķ�������������Ԫ�صĽ�������������Ҳͦ�鷳�ģ����Ƕ����õ�list.contains���������߼����ܶࡣ
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
        // ��������������
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // ��̬ά������
            Collections.swap(output, first, i);
            // �����ݹ�����һ����
            backtrack(n, output, res, first + 1);
            // ��������
            Collections.swap(output, first, i);
        }
    }
	
}
