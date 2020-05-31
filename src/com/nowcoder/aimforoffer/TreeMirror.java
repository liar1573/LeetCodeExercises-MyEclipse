/** com.nowcoder.aimforoffer
 * TODO
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * @author liar
 * 2020年5月30日 上午10:00:18
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
		//注意到这里左右子节点可能会有空的，但是需要自己不上
		if(leftSub == null && rightSub == null)
			return;//左右均空的时候直接结束
		//筛选后至少有一个非空
		if(leftSub == null && rightSub != null){
			leftSub = new TreeNode(rightSub.val);
			TreeNode tempNode = rightSub;
			//这里好像还不能直接赋值空，否则后面的链接会断掉。。
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
		
		//筛查后，此处左右子节点一定非空
		
		int	tempValue = leftSub.val;
		leftSub.val = rightSub.val;
		rightSub.val = tempValue;
		
		dfs(leftSub.left, rightSub.right);
		dfs(leftSub.right, rightSub.left);
	}

	public void MirrorExample(TreeNode root) {
		if(root == null)  return;
		
		TreeNode tempNode = null;
		
		//注意到这里镜像的操作是直接移动原始节点的指针
		//而之前自己的想法是通过新建节点来实现镜像
		//衡量下发现直接使用原始节点不仅节省了空间，而且代码也更简洁
		//（直接使用指针替换就不需要使用left.val，也就不需要提前判断非空）
		tempNode = root.left;
		root.left = root.right;
		root.right = tempNode;
		//同时这里递归的调用方式也跟自己之前想的不一样
		//之前自己一直以为这种镜像操作一定要同时传入两个指针才能实现，没想到这里只用一个就可以了
		if(root.left != null)
			MirrorExample(root.left);
		if(root.right != null)
			MirrorExample(root.right);
		//自己推导了一下，确实这种单指针参数的递归方法可以非常高效的实现镜像操作
	}
}


