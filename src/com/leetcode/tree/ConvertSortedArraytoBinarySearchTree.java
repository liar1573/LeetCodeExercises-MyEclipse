/**ConvertSortedArraytoBinarySearchTree.java
 * com.leetcode.tree
 * TODO
 * 108.把排序数组转换成高度平衡排序二叉树
 * （注意比AVL树限制弱很多，不要求子树也是AVL树，只要求子树深度相差不超过1即可）
 * @author liar
 * 2020年5月21日 上午10:23:01
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
		 
		 //长度为1的数组也能正常返回
//		 int rootIndex = nums.length / 2;
//		 TreeNode root = new TreeNode(nums[rootIndex]);
//		 root.left = dfsLeft(nums, rootIndex - 1);
//		 root.right = dfsRight(nums, rootIndex + 1);
//		 return root;
		 return dfs(nums, 0, nums.length - 1);
		 //后面看了下其实这里可以应对数组长度为1的特殊情况
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
	 
	 
	 
	 //以下两个dfs方法dfsLeftd和fsRight构建的树不满足AVL树的条件
	 public TreeNode dfsLeft(int[] nums, int startIndex) {
		if(startIndex < 0)//左子树的终结条件下标一定是0，不需要额外的参数
			return null;
		
		TreeNode node = new TreeNode(nums[startIndex]);
		node.left = dfsLeft(nums, startIndex - 1);
		return node;
	}
	 
	 public TreeNode dfsRight(int[] nums, int startIndex) {
			if(startIndex == nums.length)//左子树的终结条件下标一定是0，不需要额外的参数
				return null;
			
			TreeNode node = new TreeNode(nums[startIndex]);
			node.right = dfsRight(nums, startIndex + 1);
			return node;
		}
	 
	 
}
