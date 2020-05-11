/**SnakeLevelOrder.java
 * com.nowcoder.aimforoffer
 * TODO
 * 请实现一个函数按照之字形（蛇形）打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 * 妈个鸡突然脑子短路了。。。一开始局限思路非要一次性直接把元素按照顺序和倒叙打印出来，但是题目根本没有这样的要求。。
 * 可以完全使用BFS的算法，只要稍微再添加的时候对ArrayList做一些处理，分别从头和尾加入就可以了
 * @author liar
 * 2020年5月11日 下午2:31:32
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
		//突然想了想可以调用以前构建树的函数用来构建测试用例
		int[] pre = {1,2,4,5,3,6,7};
		int[] in = {4,2,5,1,6,3,7};
		TreeNode root = build.buildTree(pre, in);
		build.Print(root);
//		build.preOrderTraverse(root);
//		build.inOrderTraverse(root);
		
	}
	
	public ArrayList<ArrayList<Integer> > PrintBackUp(TreeNode pRoot) {
		//备份之前的代码逻辑
		ArrayList<ArrayList<Integer>> result= new ArrayList<ArrayList<Integer>>();
		if(pRoot == null)
			return result;
		
		LinkedList<TreeNode> levelQueue = new LinkedList<TreeNode>();
		levelQueue.add(pRoot);
		boolean seqFlag = true; //标记层序是从左到右还是从右到左
		
		while (!levelQueue.isEmpty()) {
			int levelSize = levelQueue.size();
			ArrayList<Integer> tempList = new ArrayList<Integer>();		
			//flag为真表示从左往右打印
			//这里flag的位置放哪感觉需要多考虑一下，不然代码会显得很冗余
			//flag需要放置到for循环的外边，否则每轮都要多余判断levelSize-1次
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
		boolean seqFlag = true; //标记层序是从左到右还是从右到左
		
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
