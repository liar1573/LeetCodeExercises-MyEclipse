package com.leetcode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/**Test.java
 * 
 * TODO������LeetCodeѵ����
 * @author liar
 * 2019��9��10�� ����6:03:04
 * @version 1.0
 */

public class Test {

	/**
	 * @Description: TODO
	 * @para: @param args
	 * @return: void
	 * @throws: @param args
	 * @author: liar
	 * @date: 2019��9��10�� ����6:03:04
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] para = "PUSH 20".split(" ");
		System.out.println(para.length);
		System.out.println(para[0]);
		System.out.println(para[1]);

	}
	

	
	
    public static void breadthFirstSearch(TreeNode root) {
    	if(null == root)
    		return;
    	
		ArrayDeque<TreeNode> parentQueue = new ArrayDeque<TreeNode>();	
		parentQueue.add(root);
		
			while (!parentQueue.isEmpty()) {
				TreeNode tempNode = parentQueue.poll();
				if (null != tempNode) {
					System.out.print(tempNode.val + "  ");
				}
				
				if (null != tempNode.left) {
					parentQueue.add(tempNode.left);
				}
				if (null != tempNode.right) {
					parentQueue.add(tempNode.right);
				}
				//������API�����add����Ϊnull��֮�䱨NullPointerException
			}

		
	}



}


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}