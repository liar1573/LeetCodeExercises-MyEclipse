package com.leetcode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenerateBinaryTree {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList<Object> genLinkedList= new LinkedList<Object>();
		//构建测试用链表
		genLinkedList.add(new Integer(3));
		genLinkedList.add(new Integer(9));
		genLinkedList.add(new Integer(20));
		genLinkedList.add(null);
		genLinkedList.add(null);
		genLinkedList.add(new Integer(15));
		genLinkedList.add(new Integer(7));
		
		TreeNode root = generateBinaryTree(genLinkedList);
		preVisit(root);
		System.out.println();

		LevelOrder myLevelOrder = new LevelOrder();
		List<List<Integer>> resultList = myLevelOrder.levelOrder2(root);
		printDoubleList(resultList);
		
	}

	
	static TreeNode generateBinaryTree(LinkedList<Object> inputLinkedList){
		if (0 == inputLinkedList.size()) {
			return null;
		}
		//需要限定非空树的第一个节点不能为null
		
		//一开始输入列表长度与深度的数学关系没有利用上。。
		int listSize = inputLinkedList.size();
		int height = (int) (Math.round(Math.floor(Math.log(listSize)/Math.log(2))) + 1);
		
		
		
		TreeNode root = new TreeNode(Integer.parseInt(String.valueOf(inputLinkedList.poll())));
		LinkedList<TreeNode> nodeLinkedList = new LinkedList<TreeNode>();
		nodeLinkedList.add(root);
		//中转节点，用于存放上一层的节点方便给其添加子节点
		int depth = 0;
			
//		for (int i = 1; i < depth; i++) {
//			//由于根节点提前创建了，故深度从1开始
//			
//		}
		
		while (!inputLinkedList.isEmpty()) {//外层输入数组列表
			//内层暂存列表
			depth++;
			int parentNodeSize = nodeLinkedList.size();
			for (int parentCount = 0;parentCount < parentNodeSize;parentCount++) {
				TreeNode tempParentNode = nodeLinkedList.poll();
				for (int i = 0; i < Math.pow(2, depth); i++) {
					//先构建左子树
					if (!inputLinkedList.isEmpty()) {
						Object tempObject = inputLinkedList.poll();
						//这里把判断用问号表达式写一下试试看？
						//但是根据API null是没法进入一般List的
						if (null != tempObject) {
							TreeNode tempChildNode = new TreeNode(Integer.parseInt(String.valueOf(tempObject)));
							tempParentNode.left = tempChildNode;
							nodeLinkedList.add(tempChildNode);
						} else {
							//回去检查一下发现之前的null判断逻辑有点问题被直接跳过，
							//null也需要构建相应的空叶子节点，否则就会出现前面显示的子树结构错位
							//2020/3/8 加上之后反而只剩下跟节点了？？不可能啊？
							tempParentNode.left = null;
						}	
					}
					//再构建右子树
					if (!inputLinkedList.isEmpty()) {
						Object tempObject = inputLinkedList.poll();
						if (null != tempObject) {
							TreeNode tempChildNode = new TreeNode(Integer.parseInt(String.valueOf(tempObject)));
							tempParentNode.right = tempChildNode;
							nodeLinkedList.add(tempChildNode);
						} else {
							//2020/3/8 加上之后反而只剩下跟节点了？？不可能啊？
							tempParentNode.right = null;
						}	
					}
					
				}
			}
			
		}
		
		
		return root;
	}
	
	static void preVisit(TreeNode root){
		//写一个递归的前序遍历方法用于检查生成结果
		if (null == root) {
			return;
		}
		
		System.out.print(root.val + "  ");
		preVisit(root.left);
		preVisit(root.right);
		
	}
	
	static void printDoubleList(List<List<Integer>> inputList){
		for (List<Integer> list : inputList) {
			for (Integer integer : list) {
				System.out.print(integer + "  ");
			}
			System.out.println();
		}
	}
	
}
