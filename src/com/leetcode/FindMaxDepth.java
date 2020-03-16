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
		//ע�⵽�����++��������Ҫ�ڵݹ麯���ڲ�ʵ�֣��������ڲ����д���+1
		//�������ֿսڵ�+1�Ĵ������
		this.max = (currentLevel > this.max)?currentLevel:this.max;
		fmd(node.left, currentLevel);
		fmd(node.right, currentLevel);	
	}
	
}
