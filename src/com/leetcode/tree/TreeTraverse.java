/**TreeTraverse.java
 * com.leetcode.tree
 * TODO
 * дһЩ���õ������������������Ժ����ʹ��
 * @author liar
 * 2020��4��22�� ����11:05:28
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
