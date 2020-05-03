/**InOrderGetNextNode.java
 * com.nowcoder.aimforoffer
 * TODO
 * 牛客网-剑指offer
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意这里的节点中有一个指向父节点的指针
 * 
 * @author liar
 * 2020年5月3日 上午10:21:13
 * @version 1.0
 */
package com.nowcoder.aimforoffer;
 class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;
    TreeLinkNode(int val) {
        this.val = val;
    }
}


public class InOrderGetNextNode {
	public TreeLinkNode GetNext(TreeLinkNode pNode){
        //case1，无效输入、空树
		if(pNode == null)//对无效输入直接返回
        	return null;
        //case2 存在右节点（注意根据中序遍历性质，只要存在右节点的情况下，左子树可以完全忽略）
        if(pNode.right != null){
        	TreeLinkNode node = pNode.right;
        	for(; node.left != null; node = node.left);
        	return node;
        }
        
        //后来分析发现这个case3好像没办法处理节点为单个根节点的情况，需要提前额外讨论处理一下
        //case4 树只有一颗根节点
        if (pNode.next == null)
        	return null;
        
        //case3 左右节点均不存在（其实只要不存在右节点即可）
        if (pNode.right == null) {
			if (pNode == pNode.next.left) {
				//如果该节点是其父节点的左孩子，则返回父节点；
				return pNode.next;
			} else {
				//否则继续向上遍历其父节点的父节点，重复之前的判断，返回结果
				//TreeLinkNode node = pNode.next;
				TreeLinkNode node = null;
				//这里for判断条件好像还要加入一个node.next非空，否则可能会回溯到根节点
				for(node = pNode.next; (node.next != null) && node.next.left != node; node = node.next);
				return node.next;
				//这个分支看起来有点怪。。好像是对应最后一个节点的情况？
			}
		}
        //这个return分支其实是不可能走到的，前面的if理论上包含了所有可能的情况
        //但是这里还是要补个return语句，否则编译器会报错缺少return
		return pNode;
    }

	public TreeLinkNode GetNextExample(TreeLinkNode pNode){
		//牛客高赞解法，解法思路很清晰代码也很简洁
		
		if(pNode == null)
			return null;
		
		if (pNode.right != null) {
			TreeLinkNode node = pNode.right;
			while (node.left != null)
				node = node.left;
			//这里一开始使用for写的也可以出结果，不过看参考案例用的是while感觉思路更简洁一些
			return node;
		}
		
		while (pNode.next != null) {
			TreeLinkNode parent = pNode.next;
			if(parent.left == pNode)
				return parent;
			pNode = pNode.next;
			//这里的操作其实跟链表的操作非常像，不断地用p.next和p.left进行迭代
		}
		
		//这里包括当前节点是二叉中序遍历最后一个节点的情况
		//也包括树中只有一个根节点的情况
		return null;
	}
}
