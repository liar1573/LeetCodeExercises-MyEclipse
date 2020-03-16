package com.leetcode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenerateBinaryTree {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList<Object> genLinkedList= new LinkedList<Object>();
		//��������������
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
		//��Ҫ�޶��ǿ����ĵ�һ���ڵ㲻��Ϊnull
		
		//һ��ʼ�����б�������ȵ���ѧ��ϵû�������ϡ���
		int listSize = inputLinkedList.size();
		int height = (int) (Math.round(Math.floor(Math.log(listSize)/Math.log(2))) + 1);
		
		
		
		TreeNode root = new TreeNode(Integer.parseInt(String.valueOf(inputLinkedList.poll())));
		LinkedList<TreeNode> nodeLinkedList = new LinkedList<TreeNode>();
		nodeLinkedList.add(root);
		//��ת�ڵ㣬���ڴ����һ��Ľڵ㷽���������ӽڵ�
		int depth = 0;
			
//		for (int i = 1; i < depth; i++) {
//			//���ڸ��ڵ���ǰ�����ˣ�����ȴ�1��ʼ
//			
//		}
		
		while (!inputLinkedList.isEmpty()) {//������������б�
			//�ڲ��ݴ��б�
			depth++;
			int parentNodeSize = nodeLinkedList.size();
			for (int parentCount = 0;parentCount < parentNodeSize;parentCount++) {
				TreeNode tempParentNode = nodeLinkedList.poll();
				for (int i = 0; i < Math.pow(2, depth); i++) {
					//�ȹ���������
					if (!inputLinkedList.isEmpty()) {
						Object tempObject = inputLinkedList.poll();
						//������ж����ʺű��ʽдһ�����Կ���
						//���Ǹ���API null��û������һ��List��
						if (null != tempObject) {
							TreeNode tempChildNode = new TreeNode(Integer.parseInt(String.valueOf(tempObject)));
							tempParentNode.left = tempChildNode;
							nodeLinkedList.add(tempChildNode);
						} else {
							//��ȥ���һ�·���֮ǰ��null�ж��߼��е����ⱻֱ��������
							//nullҲ��Ҫ������Ӧ�Ŀ�Ҷ�ӽڵ㣬����ͻ����ǰ����ʾ�������ṹ��λ
							//2020/3/8 ����֮�󷴶�ֻʣ�¸��ڵ��ˣ��������ܰ���
							tempParentNode.left = null;
						}	
					}
					//�ٹ���������
					if (!inputLinkedList.isEmpty()) {
						Object tempObject = inputLinkedList.poll();
						if (null != tempObject) {
							TreeNode tempChildNode = new TreeNode(Integer.parseInt(String.valueOf(tempObject)));
							tempParentNode.right = tempChildNode;
							nodeLinkedList.add(tempChildNode);
						} else {
							//2020/3/8 ����֮�󷴶�ֻʣ�¸��ڵ��ˣ��������ܰ���
							tempParentNode.right = null;
						}	
					}
					
				}
			}
			
		}
		
		
		return root;
	}
	
	static void preVisit(TreeNode root){
		//дһ���ݹ��ǰ������������ڼ�����ɽ��
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
