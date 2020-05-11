/**SnakeLevelOrder.java
 * com.nowcoder.aimforoffer
 * TODO
 * ��ʵ��һ����������֮���Σ����Σ���ӡ������������һ�а��մ����ҵ�˳���ӡ���ڶ��㰴�մ��������˳���ӡ��
 * �����а��մ����ҵ�˳���ӡ���������Դ����ơ�
 * �����ͻȻ���Ӷ�·�ˡ�����һ��ʼ����˼·��Ҫһ����ֱ�Ӱ�Ԫ�ذ���˳��͵����ӡ������������Ŀ����û��������Ҫ�󡣡�
 * ������ȫʹ��BFS���㷨��ֻҪ��΢����ӵ�ʱ���ArrayList��һЩ�����ֱ��ͷ��β����Ϳ�����
 * @author liar
 * 2020��5��11�� ����2:31:32
 * @version 1.0
 */
package com.nowcoder.aimforoffer;
import java.util.ArrayList;
import java.util.LinkedList;



public class SnakeLevelOrder {
	
	public static void main(String[] args) {
//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.right = new TreeNode(3);
		SnakeLevelOrder build = new SnakeLevelOrder();
		//ͻȻ��������Ե�����ǰ�������ĺ�������������������
		int[] pre = {1,2,4,5,3,6,7};
		int[] in = {4,2,5,1,6,3,7};
		TreeNode root = build.buildTree(pre, in);
		build.Print(root);
//		build.preOrderTraverse(root);
//		build.inOrderTraverse(root);
		
	}
	
	public ArrayList<ArrayList<Integer> > PrintBackUp(TreeNode pRoot) {
		//����֮ǰ�Ĵ����߼�
		ArrayList<ArrayList<Integer>> result= new ArrayList<ArrayList<Integer>>();
		if(pRoot == null)
			return result;
		
		LinkedList<TreeNode> levelQueue = new LinkedList<TreeNode>();
		levelQueue.add(pRoot);
		boolean seqFlag = true; //��ǲ����Ǵ����һ��Ǵ��ҵ���
		
		while (!levelQueue.isEmpty()) {
			int levelSize = levelQueue.size();
			ArrayList<Integer> tempList = new ArrayList<Integer>();		
			//flagΪ���ʾ�������Ҵ�ӡ
			//����flag��λ�÷��ĸо���Ҫ�࿼��һ�£���Ȼ������Եú�����
			//flag��Ҫ���õ�forѭ������ߣ�����ÿ�ֶ�Ҫ�����ж�levelSize-1��
			for (int i = 0; i < levelSize; i++) {				
				//TreeNode tempNode = levelQueue.getLast();
				TreeNode tempNode = levelQueue.removeLast();
				tempList.add(tempNode.val);
				System.out.print(tempNode.val + " ");
				if (seqFlag) {
					if(tempNode.right != null)
						levelQueue.offerFirst(tempNode.right);
					if(tempNode.left != null)
						//levelQueue.add(tempNode.left);
						levelQueue.offerFirst(tempNode.left);	
				} else {
					if(tempNode.right != null)
						levelQueue.offerFirst(tempNode.right);
					if(tempNode.left != null)
						levelQueue.offerFirst(tempNode.left);
				}
			}
			result.add(tempList);
			seqFlag = !seqFlag;
			System.out.println();
		}
		
		return result;
    }
	
	
	public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> result= new ArrayList<ArrayList<Integer>>();
		if(pRoot == null)
			return result;
		
		LinkedList<TreeNode> levelQueue = new LinkedList<TreeNode>();
		levelQueue.add(pRoot);
		boolean seqFlag = true; //��ǲ����Ǵ����һ��Ǵ��ҵ���
		
		while (!levelQueue.isEmpty()) {
			int levelSize = levelQueue.size();
			ArrayList<Integer> tempList = new ArrayList<Integer>();		

			for (int i = 0; i < levelSize; i++) {				
				//TreeNode tempNode = levelQueue.getLast();
				TreeNode tempNode = levelQueue.poll();
				if (seqFlag) {
					tempList.add(tempNode.val);
				} else {
					tempList.add(0, tempNode.val);
				}
				if(tempNode.left != null)
					levelQueue.offer(tempNode.left);
				if(tempNode.right != null)
					levelQueue.offer(tempNode.right);
			}
			result.add(tempList);
			seqFlag = !seqFlag;
		}
		
		return result;
    }
	
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root=buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        return root;
    }
    
    private TreeNode buildTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn){                 
        if(startPre>endPre||startIn>endIn)            
            return null;        
        TreeNode root=new TreeNode(pre[startPre]);                 
        for(int i=startIn;i<=endIn;i++)            
            if(in[i]==pre[startPre]){                
                root.left=buildTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=buildTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);       
                break;            
            }                         
        return root;    
    }
	
    
	public static void preOrderTraverse(TreeNode root) {
		if(root == null)
			return;
		
		printIntValue(root);
		preOrderTraverse(root.left);
		preOrderTraverse(root.right);
	}
	
	public static void inOrderTraverse(TreeNode root) {
		if(root == null)
			return;
		
		inOrderTraverse(root.left);
		printIntValue(root);
		inOrderTraverse(root.right);
	}
	
	public static void printIntValue(TreeNode node) {
		System.out.println(node.val);
	}
	
	public void printList(ArrayList<Integer> list) {
		for (Integer integer : list) {
			System.out.print(integer + "  ");
		}
		System.out.println();
	}
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
