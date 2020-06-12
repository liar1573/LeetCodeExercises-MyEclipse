/**IsSortingTree.java
 * com.nowcoder.aimforoffer.tree
 * TODO
 * ���Ų���ƽ���жϣ�˳�㸴ϰһ�¶������������ж�
 * ��ϰ-LC98-�ж����Ƿ�Ϊ��������
 * ˼·1����list�����������ÿ�ε���ǰһ�����ֲ��ж��Ƿ�ȵ�ǰС��
 * ˼·2ʹ��dfs(root,min,max)�ݹ�ָ�����ע��min��Ҫ��Integer���ͷ��㴦���ָ�롣
 * @author liar
 * 2020��6��12�� ����6:45:21
 * @version 1.0
 */
package com.nowcoder.aimforoffer.tree;

import java.util.LinkedList;

import com.leetcode.tree.TreeNode;

public class IsSortingTree {
	public boolean isBSTDFS(TreeNode root){
		return range(root, null, null);
		//��һ��ֱ�ӱ�int-max�ٷ����ˡ���
	}
	
	public boolean range(TreeNode root, Integer min, Integer max){
		if(root == null)  return true;
		if(max != null && root.val >= max 
			|| min != null && root.val <= min)
			return false;
		return (range(root.left, min, root.val) && range(root.right, root.val, max));
	}
	
	public boolean isBSTInOrder(TreeNode root) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		return inOrder(root, list);	
	}
	
	private boolean inOrder(TreeNode root, LinkedList<Integer> list) {
		if(root == null)  return true;
		
		if(!inOrder(root.left, list))
			return false;
		//if(!list.isEmpty() && root.val <= list.getLast())
		if(!list.isEmpty() && root.val <= list.pollLast())
			return false;
		list.add(root.val);
		return inOrder(root.right, list);
	}
	
//	public int getMax(TreeNode root) {//dfs���ص�ǰ�������Ԫ��
//		//if(root == null)  return Integer.MIN_VALUE;
//		//������սڵ����ﷵ��min_value����Ҳ���У�����ֵ����ڵ�1�ı��жϲ���BST�����
//		//��û����ж�ΪҶ�ӽڵ�ͷ��ص�ǰֵ
//		if(root.left == null && root.right == null)
//			return root.val;
//		//�ų������������յ������������һ���ǿ�
//		
//		
//		boolean lFlag = false, rFlag = false;
//		int leftMax = 0, rightMax = 0;
//		if(root.left != null){
//			leftMax = getMax(root.left);
//			lFlag = true;
//		}
//		
//		if(root.right != null){
//			leftMax = getMax(root.right);
//			rFlag = true;
//		}
//			
//	}
	
}
