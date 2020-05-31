/** com.nowcoder.aimforoffer
 * TODO
 * ���������Ķ�����������任ΪԴ�������ľ���
 * @author liar
 * 2020��5��30�� ����10:00:18
 * @version 1.0
 */

package com.nowcoder.aimforoffer;
import com.leetcode.tree.BuildTreePreInOrderExample;
import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeTraverse;

public class TreeMirror {
	public static void main(String[] args) {
		int[] pre1 = {1,2,4,5,3};
		int[] in1 = {4,2,5,1,3};
		TreeNode root = BuildTreePreInOrderExample.buildTree(pre1, in1);
		TreeTraverse.preOrderTraverse(root);
		TreeMirror test = new TreeMirror();
		test.MirrorExample(root);
		System.out.println();
		TreeTraverse.preOrderTraverse(root);
	}
	
	public void Mirror(TreeNode root) {
        if(root == null)
        	return;
        
        dfs(root.left, root.right);
    }
	
	public void dfs(TreeNode leftSub, TreeNode rightSub) {
		//ע�⵽���������ӽڵ���ܻ��пյģ�������Ҫ�Լ�����
		if(leftSub == null && rightSub == null)
			return;//���Ҿ��յ�ʱ��ֱ�ӽ���
		//ɸѡ��������һ���ǿ�
		if(leftSub == null && rightSub != null){
			leftSub = new TreeNode(rightSub.val);
			TreeNode tempNode = rightSub;
			//������񻹲���ֱ�Ӹ�ֵ�գ������������ӻ�ϵ�����
			rightSub = null;
			dfs(leftSub.left, tempNode.right);
			dfs(leftSub.right, tempNode.left);
			return;
		}
		if (leftSub != null && rightSub == null) {
			rightSub = new TreeNode(leftSub.val);
			TreeNode tempNode = leftSub;
			leftSub =null;
			dfs(tempNode.left, rightSub.right);
			dfs(tempNode.right, rightSub.left);
			return;
		}
		
		//ɸ��󣬴˴������ӽڵ�һ���ǿ�
		
		int	tempValue = leftSub.val;
		leftSub.val = rightSub.val;
		rightSub.val = tempValue;
		
		dfs(leftSub.left, rightSub.right);
		dfs(leftSub.right, rightSub.left);
	}

	public void MirrorExample(TreeNode root) {
		if(root == null)  return;
		
		TreeNode tempNode = null;
		
		//ע�⵽���ﾵ��Ĳ�����ֱ���ƶ�ԭʼ�ڵ��ָ��
		//��֮ǰ�Լ����뷨��ͨ���½��ڵ���ʵ�־���
		//�����·���ֱ��ʹ��ԭʼ�ڵ㲻����ʡ�˿ռ䣬���Ҵ���Ҳ�����
		//��ֱ��ʹ��ָ���滻�Ͳ���Ҫʹ��left.val��Ҳ�Ͳ���Ҫ��ǰ�жϷǿգ�
		tempNode = root.left;
		root.left = root.right;
		root.right = tempNode;
		//ͬʱ����ݹ�ĵ��÷�ʽҲ���Լ�֮ǰ��Ĳ�һ��
		//֮ǰ�Լ�һֱ��Ϊ���־������һ��Ҫͬʱ��������ָ�����ʵ�֣�û�뵽����ֻ��һ���Ϳ�����
		if(root.left != null)
			MirrorExample(root.left);
		if(root.right != null)
			MirrorExample(root.right);
		//�Լ��Ƶ���һ�£�ȷʵ���ֵ�ָ������ĵݹ鷽�����Էǳ���Ч��ʵ�־������
	}
}


