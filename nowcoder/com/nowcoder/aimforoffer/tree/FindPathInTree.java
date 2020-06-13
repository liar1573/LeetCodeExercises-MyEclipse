/**FindPathInTree.java
 * com.nowcoder.aimforoffer.tree
 * TODO
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 这题牛客tag是H，看起来有点意思
 * @author liar
 * 2020年6月13日 上午9:09:25
 * @version 1.0
 */
package com.nowcoder.aimforoffer.tree;

import java.util.ArrayList;

import com.leetcode.tree.BuildTreePreInOrderExample;
import com.leetcode.tree.TreeNode;

public class FindPathInTree {
	
	public static void main(String[] args) {
//		TreeNode root = new TreeNode(5);
		int[] pre = {10,5,7,12};
		int[] in = {7,5,10,12};
		TreeNode root = BuildTreePreInOrderExample.buildTree(pre, in);
		
		ArrayList<ArrayList<Integer>> result = FindPath(root, 22);
		
		for (ArrayList<Integer> arrayList : result) {
			for (Integer integer : arrayList) {
				System.out.print(integer + "  ");
			}
			System.out.println();
		}
	}
	
	public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        dfs(root, 0, target, result, tempList);
        
        return result;
    }
	
	public static void dfs(TreeNode root, int sum, int target,
			ArrayList<ArrayList<Integer>> result, ArrayList<Integer> tempList) {
//		if(root == null){
//			//注意到这里的重点判断好像有点问题，直接判断root == null似乎并不能确定该节点为叶子节点
//			//单边分支节点也可以达到这个效果
//			if(sum == target)
//				result.add(tempList);  
//			return;
//		}
		
		if(root == null)  return;
		//考虑了一下，这里叶子节点需要单独判断，而不能与null一起操作
		
//		if(root.left == null && root.right == null //判断此处为叶子节点 
//				&& (sum + root.val == target)){
//			tempList.add(root.val);
//			result.add(tempList);
//			return;
//		}  //逻辑放到下面add一起似乎更好一些
			
		
		
		//此时root非空
		//if(root.val + sum  > target) 如果负数也加进来计算可能就有点麻烦了
		tempList.add(root.val);
		
		if(root.left == null && root.right == null //判断此处为叶子节点 
				&& (sum + root.val == target)){
			result.add((ArrayList<Integer>) tempList.clone());
			return;
		}
		
		dfs(root.left, sum + root.val, target, result, tempList);
		//想了想这里需要回溯清掉原来访问过的节点
		//而且不管是否合法都要清掉，因为不同的叶子节点会对应不同的路径，
		//tempList.remove(tempList.size() - 1);
		//这里好像并不能直接注释掉，而是要根据root.left是否为空决定是否注释
		if(root.left != null)
			tempList.remove(tempList.size() - 1);
		//每一个dfs函数中只有一次add，但是有两次remove，好像有问题
		//应该只有一次remove，而且是放在最后左右子树都访问完了之后
		dfs(root.right, sum + root.val, target, result, tempList);
		if(root.right != null)
			tempList.remove(tempList.size() - 1);
		
		
	}
	
	
}
