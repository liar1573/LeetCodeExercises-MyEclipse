/**FindPathInTree.java
 * com.nowcoder.aimforoffer.tree
 * TODO
 * ����һ�Ŷ������ĸ��ڵ��һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
 * ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
 * ����ţ��tag��H���������е���˼
 * @author liar
 * 2020��6��13�� ����9:09:25
 * @version 1.0
 */
package com.nowcoder.aimforoffer.tree;

import java.util.ArrayList;

import com.leetcode.tree.BuildTreePreInOrderExample;
import com.leetcode.tree.TreeNode;

public class FindPathInTree {
	
	public static void main(String[] args) {
//		TreeNode root = new TreeNode(5);
		int[] pre = {10,5,7,12};
		int[] in = {7,5,10,12};
		TreeNode root = BuildTreePreInOrderExample.buildTree(pre, in);
		
		ArrayList<ArrayList<Integer>> result = FindPath(root, 22);
		
		for (ArrayList<Integer> arrayList : result) {
			for (Integer integer : arrayList) {
				System.out.print(integer + "  ");
			}
			System.out.println();
		}
	}
	
	public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        dfs(root, 0, target, result, tempList);
        
        return result;
    }
	
	public static void dfs(TreeNode root, int sum, int target,
			ArrayList<ArrayList<Integer>> result, ArrayList<Integer> tempList) {
//		if(root == null){
//			//ע�⵽������ص��жϺ����е����⣬ֱ���ж�root == null�ƺ�������ȷ���ýڵ�ΪҶ�ӽڵ�
//			//���߷�֧�ڵ�Ҳ���Դﵽ���Ч��
//			if(sum == target)
//				result.add(tempList);  
//			return;
//		}
		
		if(root == null)  return;
		//������һ�£�����Ҷ�ӽڵ���Ҫ�����жϣ���������nullһ�����
		
//		if(root.left == null && root.right == null //�жϴ˴�ΪҶ�ӽڵ� 
//				&& (sum + root.val == target)){
//			tempList.add(root.val);
//			result.add(tempList);
//			return;
//		}  //�߼��ŵ�����addһ���ƺ�����һЩ
			
		
		
		//��ʱroot�ǿ�
		//if(root.val + sum  > target) �������Ҳ�ӽ���������ܾ��е��鷳��
		tempList.add(root.val);
		
		if(root.left == null && root.right == null //�жϴ˴�ΪҶ�ӽڵ� 
				&& (sum + root.val == target)){
			result.add((ArrayList<Integer>) tempList.clone());
			return;
		}
		
		dfs(root.left, sum + root.val, target, result, tempList);
		//������������Ҫ�������ԭ�����ʹ��Ľڵ�
		//���Ҳ����Ƿ�Ϸ���Ҫ�������Ϊ��ͬ��Ҷ�ӽڵ���Ӧ��ͬ��·����
		//tempList.remove(tempList.size() - 1);
		//������񲢲���ֱ��ע�͵�������Ҫ����root.left�Ƿ�Ϊ�վ����Ƿ�ע��
		if(root.left != null)
			tempList.remove(tempList.size() - 1);
		//ÿһ��dfs������ֻ��һ��add������������remove������������
		//Ӧ��ֻ��һ��remove�������Ƿ������������������������֮��
		dfs(root.right, sum + root.val, target, result, tempList);
		if(root.right != null)
			tempList.remove(tempList.size() - 1);
		
		
	}
	
	
}
