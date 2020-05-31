/**NKHasSubtree.java
 * com.nowcoder.aimforoffer
 * TODO
 * 剑指-树的子结构，输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）。
 * 这题题目卡了很久。。子结构一开始理解错了，dfs判断条件一开始也想错了。
 * @author liar
 * 2020年5月30日 上午10:00:18
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
	
	//递归先序遍历树A
	public boolean preOrderTreeA(TreeNode node1,TreeNode node2) {
		if(node1 == null)
			return false;
		boolean temp1 = false;
		if(node1.val == node2.val)
			temp1 = dfs(node1, node2);
		
		return (temp1 || preOrderTreeA(node1.left, node2) || preOrderTreeA(node1.right, node2));
		
	}
	
	public boolean dfs(TreeNode node1,TreeNode node2) {
		//递归判断两个子结构是否完全相等
		//if(node1 == null && node2 == null)
        	//return true;//两者均遍历为空，此时相等
		if(node2 == null)  //只需要node2先遍历到达空就可以判断B为A的一部分
			return true;//并不需要A、B的部分完全相等
		if(node1 == null)
			return false; //这里只需要A先到达空，就说明结构不相等了
		if(node1.val != node2.val)
			return false;
		
		return (dfs(node1.left, node2.left) && dfs(node1.right, node2.right));
	}
	
	
//	public boolean dfsFault(TreeNode node1,TreeNode node2) {
//		//从提交结果看并不是这种情况，节点B并不在A中间，是另外的树
//		if(node1 == null)
//        	return false;
//		//if(node1 == node2)
//		if(node1.equals(node2))
//			return true;
//		
//		return (dfs(node1.left, node2) || dfs(node1.right, node2));
//	}
	
}
