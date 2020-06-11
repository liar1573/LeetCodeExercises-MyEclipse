/**IsBalancedTreeLevel.java
 * com.nowcoder.aimforoffer.tree
 * TODO
 * ����һ�ö��������жϸö������Ƿ���ƽ���������
 * ���������ֻ��Ҫ������ƽ���ԣ�����Ҫ�������ǲ������������
 * ����˼��������maxDepth�ݹ������������ٽ����ж�
 * ����һ���Ż�˼�������ڵ�߶ȿ����Ե����ϼ��㣬���Լ�֦ʡȥ�ܶ಻��Ҫ�ļ��㣩
 * @author liar
 * 2020��6��11�� ����3:27:00
 * @version 1.0
 */
package com.nowcoder.aimforoffer.tree;

import com.leetcode.tree.TreeNode;

public class IsBalancedTreeLevel {
	public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null)  return true;//������������
        
        if(maxDepth(root.left) - maxDepth(root.right) > 1 
        	|| maxDepth(root.left) - maxDepth(root.right) < -1)
        	return false;
        	
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);      
    }
	
	public int maxDepth(TreeNode root) {
		if(root == null)  return 0;
		
		return (1 + Math.max(maxDepth(root.left), maxDepth(root.right)));
	}
	
	public boolean IsBalanced_SolutionExample(TreeNode root) {
		return (getDepthExample(root) != -1); 
	}
	
	
	public int getDepthExample(TreeNode root) {
		//���������������Ե��������������ȵķ���
		if(root == null)  return 0;
		int left = getDepthExample(root.left);
		if(left == -1)
			return -1;
		int right = getDepthExample(root.right);
		if(right == -1)
			return -1;
		
		return Math.abs(left - right) > 1 ? -1: 1 + Math.max(left, right); 
	}
	
}
