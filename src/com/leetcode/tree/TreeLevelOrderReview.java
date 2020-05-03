/**TreeLevelOrderReview.java
 * com.leetcode.tree
 * TODO
 * 层序遍历二叉树算法实现的阶段性复习
 * @author liar
 * 2020年4月23日 下午9:15:19
 * @version 1.0
 */
package com.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;



public class TreeLevelOrderReview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
		//注意这里的不能直接对root为空的情况返回null，而应该返回一个空的List
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
		if(root != null)
			queue.add(root);
		
		while (!queue.isEmpty()) {//注意到Java中queue的特性是不允许进入null，需要提前进行判断
			ArrayList<Integer> tempList = new ArrayList<Integer>();
			int nodeNumber = queue.size();
			for (int i = 0; i < nodeNumber; i++) {
				TreeNode tempNode = queue.poll();		
				tempList.add(tempNode.val);
				if(tempNode.left != null)
					queue.add(tempNode.left);
				if(tempNode.right != null)
					queue.add(tempNode.right);
			}
			
			result.add(tempList);
		}
		
		return result;
	}

	
	public static List<List<Integer>> levelOrderDFS(TreeNode root) {
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		dfs(root, 0, result);
		return result;
	}
	
	public static void dfs(TreeNode node, int level, List<List<Integer>> result) {
		if(node == null)
            return;
		if(result.size() <= level)
			result.add(new ArrayList<Integer>());
		List<Integer> myLevel = result.get(level);
		myLevel.add(node.val);
		dfs(node.left, level + 1, result);
		dfs(node.right, level + 1, result);	
	}
	
}
