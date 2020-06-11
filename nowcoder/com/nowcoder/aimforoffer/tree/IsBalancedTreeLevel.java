/**IsBalancedTreeLevel.java
 * com.nowcoder.aimforoffer.tree
 * TODO
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 * 核心思想是利用maxDepth递归求树最大深度再进行判断
 * （有一个优化思想是树节点高度可以自底向上计算，可以剪枝省去很多不必要的计算）
 * @author liar
 * 2020年6月11日 下午3:27:00
 * @version 1.0
 */
package com.nowcoder.aimforoffer.tree;

import com.leetcode.tree.TreeNode;

public class IsBalancedTreeLevel {
	public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null)  return true;//空树满足条件
        
        if(maxDepth(root.left) - maxDepth(root.right) > 1 
        	|| maxDepth(root.left) - maxDepth(root.right) < -1)
        	return false;
        	
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);      
    }
	
	public int maxDepth(TreeNode root) {
		if(root == null)  return 0;
		
		return (1 + Math.max(maxDepth(root.left), maxDepth(root.right)));
	}
	
	public boolean IsBalanced_SolutionExample(TreeNode root) {
		return (getDepthExample(root) != -1); 
	}
	
	
	public int getDepthExample(TreeNode root) {
		//从讨论区看到的自底向上求二叉树深度的方法
		if(root == null)  return 0;
		int left = getDepthExample(root.left);
		if(left == -1)
			return -1;
		int right = getDepthExample(root.right);
		if(right == -1)
			return -1;
		
		return Math.abs(left - right) > 1 ? -1: 1 + Math.max(left, right); 
	}
	
}
