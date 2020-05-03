/**BuildTreePreInOrder.java
 * com.leetcode.tree
 * TODO
 * LeetCode 105 题，难度 Medium，让你根据前序遍历和中序遍历的结果还原一棵二叉树，很经典的问题吧
 * @author liar
 * 2020年4月21日 下午4:38:35
 * @version 1.0
 */
package com.leetcode.tree;



public class BuildTreePreInOrder {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BuildTreePreInOrder test = new BuildTreePreInOrder();
		int[] pre = {3,9,20,15,7};
		int[] in = {9,3,15,20,7};
		TreeNode root = test.buildTreePass1(pre, in);
		System.out.println("前序遍历结果");
		TreeTraverse.preOrderTraverse(root);
		System.out.println("中序遍历结果");
		TreeTraverse.inOrderTraverse(root);
		
	}
	
//	public TreeNode buildTree(int[] preorder, int[] inorder) {
//        if(preorder.length == 0)
//        	return null;
//        
////        TreeNode root = new TreeNode(preorder[0]);
//        TreeNode root = null;
//        buildSubTreeExample(root, preorder, inorder);
//        
//        return root;
//    }
	
	public TreeNode buildTreePass1(int[] preorder, int[] inorder) {
		//参考知乎解答第一次通过的写法
		if (preorder.length < 1) {
			return null;
		}
		//疑问？是否有任何时刻，dfs参数的pre和in的长度都一定是相等的？
		//感觉好像是但是不能确认
		
		int rootValue = preorder[0];
		TreeNode root = new TreeNode(rootValue);
		int rootIndex = findIndex(inorder, rootValue);
		int[] inLeft = copyArray(inorder, 0, rootIndex - 1);
		int[] inRight = copyArray(inorder, rootIndex + 1, inorder.length-1);
		//在pre[]中，左右子树的分割需要通过长度来完成
		//这里想想下标有可能会超出pre的范围，故去copyArray函数中补充了
		//end>=len时返回int[0]的额外判断条件
		int[] preLeft = copyArray(preorder, 1, inLeft.length);
		int[] preRight = copyArray(preorder, preLeft.length + 1, preorder.length-1);
		
		
		root.left = buildTreePass1(preLeft, inLeft);
		root.right = buildTreePass1(preRight, inRight);
//		buildSubTreeExample(root.left, preLeft, inLeft);
//		buildSubTreeExample(root.right, preRight, inRight);
		
		return root;
    }
	
	public void buildSubTree(TreeNode node, int[] pre, int[] in) {
		//递归的终止条件应该就是前、中序数组被分割到只含一个元素了
		if (pre.length == 1) {
			node = new TreeNode(pre[0]);
		} 
		if (in.length == 1) {
			node = new TreeNode(in[0]);
		}
		if (pre.length == 0) {
			return;
		}
		if (in.length == 0) {
			return;
		}
		
		
		
		int rootValue = pre[0];
		node = new TreeNode(rootValue);
		//int rootIndex = Arrays.binarySearch(in, rootValue);
		int rootIndex = findIndex(in, rootValue);
//		int[] inLeft = Arrays.copyOfRange(in, 0, rootIndex);
		//第一次被这个copyOfRange报错了，非法参数:0>-1
		//还是老老实实用for复制好了
		int[] inLeft = new int[rootIndex];
		for (int i = 0; i < inLeft.length; i++) {
			inLeft[i] = in[i];
		}
		
		//这里如果in[]中至少有2个数字，否则不会通过函数刚开始的结束条件判定
		//如果root刚好为最最后一个元素（比如树中只有2个节点）
		//则right长度应该为0，也不会越界
		int[] inRight = new int[in.length - 1 - rootIndex];
		for (int i = rootIndex + 1; i < in.length; i++) {
			inRight[i - rootIndex - 1] = in[i]; 
		}
		//不光是中序遍历数组需要分割，前序遍历数组也需要，两者结合在一起才能重构树
		//这里也需要in长度最少为2
		//int leftIndex = Arrays.binarySearch(pre, in[rootIndex - 1]);
		int leftIndex = findIndex(pre, in[rootIndex - 1]);
		int[] preLeft = new int[leftIndex];
		for (int i = 1; i <= leftIndex; i++) {
			preLeft[i-1] = pre[i];
		}
		int[] preRight = new int[pre.length - leftIndex - 1];
		for (int i = leftIndex + 1; i < pre.length; i++) {
			preRight[i - leftIndex - 1] = pre[i]; 
		}
		
		
		
		buildSubTree(node.left, preLeft, inLeft);
		buildSubTree(node.right, preRight, inRight);
		
	}
	
	public void buildSubTreeExample(TreeNode node, int[] pre, int[] in){
		if (pre.length < 1) {
			return;
		}
		//疑问？是否有任何时刻，dfs参数的pre和in的长度都一定是相等的？
		//感觉好像是但是不能确认
		
		int rootValue = pre[0];
		node = new TreeNode(rootValue);
		int rootIndex = findIndex(in, rootValue);
		int[] inLeft = copyArray(in, 0, rootIndex - 1);
		int[] inRight = copyArray(in, rootIndex + 1, in.length-1);
		//在pre[]中，左右子树的分割需要通过长度来完成
		//这里想想下标有可能会超出pre的范围，故去copyArray函数中补充了
		//end>=len时返回int[0]的额外判断条件
		int[] preLeft = copyArray(pre, 1, inLeft.length);
		int[] preRight = copyArray(pre, preLeft.length + 1, pre.length-1);
		
		buildSubTreeExample(node.left, preLeft, inLeft);
		buildSubTreeExample(node.right, preRight, inRight);
	}

	public void buildSubTreeFault(TreeNode node, int[] pre, int[] in) {
		//根据知乎参考写法重写递归函数
		if (pre.length < 1) {
			return;
		}
		//根据设定，根节点一定不能为空，即pre.len>=1，而其他子树在递归的过程中可能出现空的情况
		//比如当树只有两个节点的时候，必然有左子树或者右子树为空
		
		int rootValue = pre[0];
		node = new TreeNode(rootValue);
		int rootIndex = findIndex(in, rootValue);
//		int[] inLeft = Arrays.copyOfRange(in, 0, rootIndex);
		//第一次被这个copyOfRange报错了，非法参数:0>-1
		//还是老老实实用for复制好了
		int[] inLeft = new int[rootIndex];
		for (int i = 0; i < inLeft.length; i++) {
			inLeft[i] = in[i];
		}
		
		//发现之前想的确认左右子树的方法好像有点问题！！
		//根的确定可以搜索值没问题，但是左右子树的确认只能通过节点长度，没法再通过值搜索下标，顺序可能是不确定的！！
		
		//这里当in[]长度为0的时候也会下标越界
		int[] inRight = new int[in.length - 1 - rootIndex];
		for (int i = rootIndex + 1; i < in.length; i++) {
			inRight[i - rootIndex - 1] = in[i]; 
		}
		
		
//		buildSubTree(node.left, preLeft, inLeft);
//		buildSubTree(node.right, preRight, inRight);
	}
	
	
	public int findIndex(int[] arr, int value) {
		//根据题设这里一定会找到对应值
		//后来发现也不一定，数组长度可能会被减到0
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == value )
				return i;
		}
		return 0; //表示没找到，只有在数组长度为0的时候才会发生
	}
	
	public int[] copyArray(int[] input, int start, int end){
		//这里起始和截止下标都会被复制
		//考虑自己写一个分割数组的方法？？Arrays.copyRangeOf()实在不好用。。
		//copyRangeOf()不包括截止下标，还会带来很多无用的下标越界报错
		//对于end < start的情况(或者end下标超出input)，直接返回长度为0的数组即可
		if(end < start || end >= input.length || start >= input.length)
			return new int[0];
		
		int[] result = new int[end - start + 1];
		for (int i = 0; i < result.length; i++) {
			result[i] = input[start + i]; 
		}
		return result;
	}

}

