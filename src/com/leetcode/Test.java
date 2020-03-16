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

		//�ֶ�������һ�ż򵥵���
		TreeNode aNode = new TreeNode(6);
		TreeNode bNode = new TreeNode(3);
		bNode.left = aNode;
		TreeNode cNode = new TreeNode(4);
		TreeNode dNode = new TreeNode(5);
		TreeNode eNode = new TreeNode(2);
		eNode.left = cNode;
		eNode.right = dNode;
		TreeNode fNode = new TreeNode(1);
		fNode.left = eNode;
		fNode.right = bNode;
		
//		breadthFirstSearch(fNode);
		
//		LinkedList<Object> testLinkedList = new LinkedList<Object>();
//		testLinkedList.add(null);
//		System.out.println(testLinkedList.size());
//		if (null == testLinkedList.peek()) {
//			System.out.println("true");
//		}

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