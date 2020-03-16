package com.leetcode;
import java.util.ArrayDeque;

public class findMinDepth {

	
	
	public int levelOrder_findmin(TreeNode root) {
		//����BFSʹ�ö��а���������㷨������ϸ΢���޸�
    	if (null == root) {
    		return 0;
		}
    	  	
    	int depth = 0;
        ArrayDeque<TreeNode> parentDeque = new ArrayDeque<TreeNode>();
        parentDeque.add(root);
        
        while (!parentDeque.isEmpty()) {
        	int queueSize = parentDeque.size();
        	depth++;

        	for (int i = 0; i < queueSize; i++) {
				TreeNode tempTreeNode = parentDeque.poll();
				
				if ((null != tempTreeNode.left)&&(null != tempTreeNode.right)) {
					return depth;
				}
				
				if (null != tempTreeNode.left) {
					parentDeque.add(tempTreeNode.left);
				}
				if (null != tempTreeNode.right) {
					parentDeque.add(tempTreeNode.right);
				}	
			}
		}
    	
        return depth;
	}
	
	public int findMinRecursion(TreeNode root) {
		if (null == root) {
			return 0;
		}
		
		if ((null == root.right)&&(null == root.left)) {
			return 1;
		}
		
		return Math.min(findMinRecursion(root.left) + 1,findMinRecursion(root.right) + 1);
		
	}
	
	
	public int minDepth(TreeNode root) {
		if (null == root) {
			return 0;
		}
		
		TreeNode a = root.left;
		TreeNode b = root.right;
		
		if ((null == a)&&(null == b)) {
			return 1;
		}else if ((null == a)&&(null != b)) {
			return minDepth(b) + 1;
		}else if ((null != a)&&(null == b)) {
			return minDepth(a) + 1;
		}else {
			return Math.min(minDepth(root.left) + 1,minDepth(root.right) + 1);
		}
		
		
//		if ((null == root.right)&&(null == root.left)) {
//			return 1;
//		}
//		
//		if ((null == root.left)&&(null != root.right)) {
//			return minDepth(root.right);
//		}
//		
//		return Math.min(minDepth(root.left) + 1,minDepth(root.right) + 1);
		//��������[1,2]���ֺ�����ֱ�ӷ���������������С��ȣ���Ҫ�Կ������⴦��
		
	}
}
