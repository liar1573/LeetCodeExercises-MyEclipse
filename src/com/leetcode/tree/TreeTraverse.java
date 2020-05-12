/**TreeTraverse.java
 * com.leetcode.tree
 * TODO
 * 写一些常用的树遍历方法，便于以后调试使用
 * @author liar
 * 2020年4月22日 上午11:05:28
 * @version 1.0
 */
package com.leetcode.tree;


public class TreeTraverse {
	
	public static void preOrderTraverse(TreeNode root) {
		if(root == null)
			return;
		
		printIntValue(root);
		preOrderTraverse(root.left);
		preOrderTraverse(root.right);
	}
	
	public static void inOrderTraverse(TreeNode root) {
		if(root == null)
			return;
		
		inOrderTraverse(root.left);
		printIntValue(root);
		inOrderTraverse(root.right);
	}
	
	public static void lastOrderTraverse(TreeNode root) {
		if(root == null)
			return;
		
		lastOrderTraverse(root.left);
		lastOrderTraverse(root.right);
		printIntValue(root);
	}
	
	
	public static void printIntValue(TreeNode node) {
		System.out.println(node.val);
	}
	
}
