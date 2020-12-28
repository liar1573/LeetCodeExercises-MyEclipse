/**
 * LC28.����һ�鲻���ظ�Ԫ�ص���������nums�����ظ��������п��ܵ��Ӽ��������ռ���������
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
		 result.add(new ArrayList<Integer>()); //�ȷ���һ�����ڵĿռ�
		 for (int i = 0; i < nums.length; i++) {
			//����о���Ҫ��˫��list��һ�����ݣ�����ֱ�Ӳ���ԭʼ����
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
		 //�Լ�дһ������ķ���
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
		 //����ǿ���õݹ�Ļ��о��е�֣�ֻ�ǰ�forѭ�������˵ݹ�ı�ʾ����û��ʲô�������Եĺô����������������˵ݹ�ջ�Ŀ�������
		if(index < 0){
			result.add(new ArrayList<Integer>());
			return;
		}
		
		dfs(result, nums, index - 1); //�ݹ��ȡN-1��Ԫ�ص��Ӽ�
		//����������ͬ����Ҫ���
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
	    
	    //���ݽⷨ
	    public void backtrack(int[] nums, int index) {
//			ans.add(new LinkedList<Integer>(temp));
			ans.add((List<Integer>) temp.clone());
	        for(int i = index; i <nums.length; i++){
	            temp.add(nums[index]);
	            backtrack(nums, index + 1);
	            temp.removeLast();
	        }
	    }
	    //�����
	    //[[],[1],[1,2],[1,2,3],[1,2],[1,2,3],[1],[1,2],[1,2,3],[1,2],[1,2,3],[1],[1,2],[1,2,3],[1,2],[1,2,3]]
	 
}
