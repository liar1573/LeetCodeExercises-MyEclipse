/**
 * 
 */
package com.leetcode.tree;


public class MergeTrees {
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if(t1 == null)
			return t2; //如果t1的根就是空，则直接返回t2
		
		//到达此分支后t1非空，默认可以返回t1的根
		if(t2 == null)
			return t1;
		
		//t1、t2均非空
		t1.val = t1.val + t2.val;
//		注意一点细节，官方解法中新建了合并节点并没有修改原始值
//		TreeNode merged = new TreeNode(t1.val + t2.val);
//		这个算法运行后最开始的t1和t2都是不受影响的
		t1.left = mergeTrees(t1.left, t2.left);
		t1.right = mergeTrees(t1.right, t2.right);
		
		return t1;
    }
}
