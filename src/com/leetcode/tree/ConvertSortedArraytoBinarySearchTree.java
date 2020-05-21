/**ConvertSortedArraytoBinarySearchTree.java
 * com.leetcode.tree
 * TODO
 * 108.����������ת���ɸ߶�ƽ�����������
 * ��ע���AVL���������ܶ࣬��Ҫ������Ҳ��AVL����ֻҪ���������������1���ɣ�
 * @author liar
 * 2020��5��21�� ����10:23:01
 * @version 1.0
 */
package com.leetcode.tree;

public class ConvertSortedArraytoBinarySearchTree {
	public static void main(String[] args) {
		ConvertSortedArraytoBinarySearchTree test = new ConvertSortedArraytoBinarySearchTree();
		int[] nums = {-10,-3,0,5,9};
		TreeNode root = test.sortedArrayToBST(nums);
		System.out.println("qianxu");
		TreeTraverse.preOrderTraverse(root);
		System.out.println();
		System.out.println("inOrder");
		TreeTraverse.inOrderTraverse(root);
//		System.out.println();
		
		
	}
	
	 public TreeNode sortedArrayToBST(int[] nums) {
		 if(nums == null || nums.length == 0)
			 return null;
		 
		 //����Ϊ1������Ҳ����������
//		 int rootIndex = nums.length / 2;
//		 TreeNode root = new TreeNode(nums[rootIndex]);
//		 root.left = dfsLeft(nums, rootIndex - 1);
//		 root.right = dfsRight(nums, rootIndex + 1);
//		 return root;
		 return dfs(nums, 0, nums.length - 1);
		 //���濴������ʵ�������Ӧ�����鳤��Ϊ1���������
	 }

	 public TreeNode dfs(int[] nums, int startIndex, int endIndex) {
		 if(startIndex > endIndex)
			 return null;
		 
		 int rootIndex = (endIndex + startIndex) / 2;
		 TreeNode node = new TreeNode(nums[rootIndex]);
		 node.left = dfs(nums, startIndex, rootIndex - 1);
		 node.right = dfs(nums, rootIndex + 1, endIndex);
		 
		 return node;
	 }
	 
	 
	 
	 //��������dfs����dfsLeftd��fsRight��������������AVL��������
	 public TreeNode dfsLeft(int[] nums, int startIndex) {
		if(startIndex < 0)//���������ս������±�һ����0������Ҫ����Ĳ���
			return null;
		
		TreeNode node = new TreeNode(nums[startIndex]);
		node.left = dfsLeft(nums, startIndex - 1);
		return node;
	}
	 
	 public TreeNode dfsRight(int[] nums, int startIndex) {
			if(startIndex == nums.length)//���������ս������±�һ����0������Ҫ����Ĳ���
				return null;
			
			TreeNode node = new TreeNode(nums[startIndex]);
			node.right = dfsRight(nums, startIndex + 1);
			return node;
		}
	 
	 
}
