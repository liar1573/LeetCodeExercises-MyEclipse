/**SameTree.java
 * com.leetcode.tree
 * TODO
 * LC 100，判断两棵树是否完全相等
 * @author liar
 * 2020年4月22日 下午6:47:38
 * @version 1.0
 */
package com.leetcode.tree;


public class SameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		//这里应该算是先序遍历吧，因为最先比较的是根节点的值是否相等
		//这样可以最快的失败返回，应该是效率最高的
		
		if(p == null && q == null)
			return true;
		//经过上一个条件筛选，这里应该最多只有一个指针为空了
		if(p == null || q == null)
			return false;
		
		//此时两个节点都不为空
		if(p.val != q.val)
			return false;
		
		return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
	
	
	public static boolean preOrderTraverse(TreeNode p, TreeNode q) {
		//这里需要对前序遍历做一下适配，需要同时遍历两个树节点
		if(p == null && q == null)
			return true;
		//经过上一个条件筛选，这里应该最多只有一个指针为空了
		if(p == null || q == null)
			return false;
		
		//此时两个节点都不为空
		if(p.val != q.val)
			return false;
		
		return (preOrderTraverse(p.left, q.left) && preOrderTraverse(p.right, q.right));
	}
}
