/**SameTree.java
 * com.leetcode.tree
 * TODO
 * LC 100���ж��������Ƿ���ȫ���
 * @author liar
 * 2020��4��22�� ����6:47:38
 * @version 1.0
 */
package com.leetcode.tree;


public class SameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		//����Ӧ��������������ɣ���Ϊ���ȱȽϵ��Ǹ��ڵ��ֵ�Ƿ����
		//������������ʧ�ܷ��أ�Ӧ����Ч����ߵ�
		
		if(p == null && q == null)
			return true;
		//������һ������ɸѡ������Ӧ�����ֻ��һ��ָ��Ϊ����
		if(p == null || q == null)
			return false;
		
		//��ʱ�����ڵ㶼��Ϊ��
		if(p.val != q.val)
			return false;
		
		return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
	
	
	public static boolean preOrderTraverse(TreeNode p, TreeNode q) {
		//������Ҫ��ǰ�������һ�����䣬��Ҫͬʱ�����������ڵ�
		if(p == null && q == null)
			return true;
		//������һ������ɸѡ������Ӧ�����ֻ��һ��ָ��Ϊ����
		if(p == null || q == null)
			return false;
		
		//��ʱ�����ڵ㶼��Ϊ��
		if(p.val != q.val)
			return false;
		
		return (preOrderTraverse(p.left, q.left) && preOrderTraverse(p.right, q.right));
	}
}
