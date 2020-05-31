/**NKHasSubtree.java
 * com.nowcoder.aimforoffer
 * TODO
 * ��ָ-�����ӽṹ���������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ����
 * ������Ŀ���˺ܾá����ӽṹһ��ʼ�����ˣ�dfs�ж�����һ��ʼҲ����ˡ�
 * @author liar
 * 2020��5��30�� ����10:00:18
 * @version 1.0
 */
package com.nowcoder.aimforoffer;
import com.leetcode.tree.TreeNode;
import com.leetcode.tree.BuildTreePreInOrderExample;

public class NKHasSubtree {
	
	public static void main(String[] args) {
		int[] pre1 = {1,2,4,5,3};
		int[] in1 = {4,2,5,1,3};
		TreeNode root1 = BuildTreePreInOrderExample.buildTree(pre1, in1);
		int[] pre2 = {2,4,5};
		int[] in2 = {4,2,5};
		TreeNode root2 = BuildTreePreInOrderExample.buildTree(pre2, in2);
		NKHasSubtree test = new NKHasSubtree();
		System.out.println(test.HasSubtree(root1, root2));
	}
	
	public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null)
        	return false;
        
        return preOrderTreeA(root1, root2);
    }
	
	//�ݹ����������A
	public boolean preOrderTreeA(TreeNode node1,TreeNode node2) {
		if(node1 == null)
			return false;
		boolean temp1 = false;
		if(node1.val == node2.val)
			temp1 = dfs(node1, node2);
		
		return (temp1 || preOrderTreeA(node1.left, node2) || preOrderTreeA(node1.right, node2));
		
	}
	
	public boolean dfs(TreeNode node1,TreeNode node2) {
		//�ݹ��ж������ӽṹ�Ƿ���ȫ���
		//if(node1 == null && node2 == null)
        	//return true;//���߾�����Ϊ�գ���ʱ���
		if(node2 == null)  //ֻ��Ҫnode2�ȱ�������վͿ����ж�BΪA��һ����
			return true;//������ҪA��B�Ĳ�����ȫ���
		if(node1 == null)
			return false; //����ֻ��ҪA�ȵ���գ���˵���ṹ�������
		if(node1.val != node2.val)
			return false;
		
		return (dfs(node1.left, node2.left) && dfs(node1.right, node2.right));
	}
	
	
//	public boolean dfsFault(TreeNode node1,TreeNode node2) {
//		//���ύ���������������������ڵ�B������A�м䣬���������
//		if(node1 == null)
//        	return false;
//		//if(node1 == node2)
//		if(node1.equals(node2))
//			return true;
//		
//		return (dfs(node1.left, node2) || dfs(node1.right, node2));
//	}
	
}
