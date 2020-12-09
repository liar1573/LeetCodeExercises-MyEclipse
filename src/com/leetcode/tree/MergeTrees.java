/**
 * 
 */
package com.leetcode.tree;


public class MergeTrees {
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if(t1 == null)
			return t2; //���t1�ĸ����ǿգ���ֱ�ӷ���t2
		
		//����˷�֧��t1�ǿգ�Ĭ�Ͽ��Է���t1�ĸ�
		if(t2 == null)
			return t1;
		
		//t1��t2���ǿ�
		t1.val = t1.val + t2.val;
//		ע��һ��ϸ�ڣ��ٷ��ⷨ���½��˺ϲ��ڵ㲢û���޸�ԭʼֵ
//		TreeNode merged = new TreeNode(t1.val + t2.val);
//		����㷨���к��ʼ��t1��t2���ǲ���Ӱ���
		t1.left = mergeTrees(t1.left, t2.left);
		t1.right = mergeTrees(t1.right, t2.right);
		
		return t1;
    }
}
