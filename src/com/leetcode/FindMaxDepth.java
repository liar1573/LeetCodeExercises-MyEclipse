package com.leetcode;

public class FindMaxDepth {
	static int max = 0;
	int findMaxDepth(TreeNode root){
		if (null == root) {
			return 0;
		}
		this.max = 1;
		fmd(root.left, 1);
		fmd(root.right, 1);
		
		return this.max;
	}
	
	void fmd(TreeNode node, int currentLevel){
		if (null == node) {
			return;
		}
		currentLevel++;
		//注意到这里的++操作必须要在递归函数内部实现，而不能在参数中传入+1
		//否则会出现空节点+1的错误情况
		this.max = (currentLevel > this.max)?currentLevel:this.max;
		fmd(node.left, currentLevel);
		fmd(node.right, currentLevel);	
	}
	
}
