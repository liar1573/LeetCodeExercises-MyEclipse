/**SymmetricTree.java
 * com.leetcode.tree
 * TODO
 * LC 101 判断一棵树是否轴对称
 * （注意这里并不能直接套用100的解法判断两棵树是否完全相等）
 * 轴对称节点数值完全相等，但是左右顺序相反
 * @author liar
 * 2020年4月23日 上午11:11:57
 * @version 1.0
 */
package com.leetcode.tree;


public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
        if(root == null)
        	return true;
        if(root.left == null && root.right != null)
        	return false;
		
		//return (isSymmetric(root.left) && isSymmetric(root.right));
		return preOrderSymmetry(root.left, root.right);
        
    }
	
	public boolean preOrderSymmetry(TreeNode p, TreeNode q) {
		if(p == null && q == null)
			return true;
		if(p == null || q == null)
			return false;
		
		if(p.val != q.val)
			return false;
		
		//注意到这里跟LC100题目最大的区别就是递归调用函数时，左右子节点顺序错开了
		return (preOrderSymmetry(p.left, q.right) && preOrderSymmetry(p.right, q.left));
	}
}
