/**SymmetricTree.java
 * com.leetcode.tree
 * TODO
 * LC 101 �ж�һ�����Ƿ���Գ�
 * ��ע�����ﲢ����ֱ������100�Ľⷨ�ж��������Ƿ���ȫ��ȣ�
 * ��Գƽڵ���ֵ��ȫ��ȣ���������˳���෴
 * @author liar
 * 2020��4��23�� ����11:11:57
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
		
		//ע�⵽�����LC100��Ŀ����������ǵݹ���ú���ʱ�������ӽڵ�˳�����
		return (preOrderSymmetry(p.left, q.right) && preOrderSymmetry(p.right, q.left));
	}
}
