/**IsSortingTree.java
 * com.nowcoder.aimforoffer.tree
 * TODO
 * 借着层数平衡判断，顺便复习一下二叉排序树的判断
 * 复习-LC98-判断树是否为二叉树。
 * 思路1借助list和中序遍历，每次弹出前一个数字并判断是否比当前小；
 * 思路2使用dfs(root,min,max)递归分割树，注意min需要是Integer类型方便处理空指针。
 * @author liar
 * 2020年6月12日 下午6:45:21
 * @version 1.0
 */
package com.nowcoder.aimforoffer.tree;

import java.util.LinkedList;

import com.leetcode.tree.TreeNode;

public class IsSortingTree {
	public boolean isBSTDFS(TreeNode root){
		return range(root, null, null);
		//第一次直接被int-max举反例了。。
	}
	
	public boolean range(TreeNode root, Integer min, Integer max){
		if(root == null)  return true;
		if(max != null && root.val >= max 
			|| min != null && root.val <= min)
			return false;
		return (range(root.left, min, root.val) && range(root.right, root.val, max));
	}
	
	public boolean isBSTInOrder(TreeNode root) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		return inOrder(root, list);	
	}
	
	private boolean inOrder(TreeNode root, LinkedList<Integer> list) {
		if(root == null)  return true;
		
		if(!inOrder(root.left, list))
			return false;
		//if(!list.isEmpty() && root.val <= list.getLast())
		if(!list.isEmpty() && root.val <= list.pollLast())
			return false;
		list.add(root.val);
		return inOrder(root.right, list);
	}
	
//	public int getMax(TreeNode root) {//dfs返回当前树中最大元素
//		//if(root == null)  return Integer.MIN_VALUE;
//		//想了想空节点这里返回min_value好像也不行，会出现单个节点1的被判断不是BST的情况
//		//最好还是判断为叶子节点就返回当前值
//		if(root.left == null && root.right == null)
//			return root.val;
//		//排除左右子树均空的情况，至少有一个非空
//		
//		
//		boolean lFlag = false, rFlag = false;
//		int leftMax = 0, rightMax = 0;
//		if(root.left != null){
//			leftMax = getMax(root.left);
//			lFlag = true;
//		}
//		
//		if(root.right != null){
//			leftMax = getMax(root.right);
//			rFlag = true;
//		}
//			
//	}
	
}
