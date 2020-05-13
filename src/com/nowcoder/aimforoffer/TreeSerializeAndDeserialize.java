/**TreeSerializeAndDeserialize.java
 * com.nowcoder.aimforoffer
 * TODO
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 * 这里比较奇怪的一点是完全没有给定序列化的顺序是用前、中、后序还是层序。。
 * @author liar
 * 2020年5月12日 上午11:10:29
 * @version 1.0
 */
package com.nowcoder.aimforoffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.leetcode.tree.BuildTreePreInOrderExample;
import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeTraverse;


public class TreeSerializeAndDeserialize {
	int index = -1; //成员变量，用于表示节点下标
	
	public static void main(String[] args) {
		TreeSerializeAndDeserialize test = new TreeSerializeAndDeserialize();
		int[] pre = {1,2,3,4,5};
		int[] in = {2,1,4,3,5};
		BuildTreePreInOrderExample build = new BuildTreePreInOrderExample();
		TreeNode root = build.buildTree(pre, in);
		String str = test.Serialize(root);
		System.out.println(str);
		TreeNode rebulidRoot = test.DeserializeExample(str);
		//TreeTraverse.preOrderTraverse(rebulidRoot);
		TreeTraverse.inOrderTraverse(rebulidRoot);
	}
	
	
	 String Serialize(TreeNode root) {
		 //先用最简单的前序试试	 
		 //return Serialize(root, "");
		 return SerializePreOrder(root,"");
	 }
	 
	 TreeNode DeserializeExample(String str) {
		 if(str.length() == 2)//由于每个节点都有,  故最小长度空树的字符串长度也有2
			 return null;
		 
		 String[] strs = str.split(",");
		 return DeserializeExample(strs);
	 }
	 
	 TreeNode DeserializeExample(String[] strs) {
		 this.index++;
		 
		 TreeNode node = null;
		 if(!strs[index].equals("#")){
			 node = new TreeNode(Integer.parseInt(strs[index]));
			 node.left = DeserializeExample(strs);
			 node.right = DeserializeExample(strs);
		 } 
		 return node;
	 }
	 
	  TreeNode DeserializeFirstTry(String str) {
		  //参数通过非迭代的方法根据层序遍历结果直接回复二叉树，未能成功
		  //感觉理论上是可行的，但是总是差一点不太好实现。。
		  if(str.length() == 1)
			  return null;//空树节点只有一个"#"
		  StringBuilder sBuilder = new StringBuilder(str);
		  
	      TreeNode root = new TreeNode(getFirstValue(sBuilder));
	      LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	      queue.add(root);
	      
	      while (!queue.isEmpty()) {//注意到Java中queue的特性是不允许进入null，需要提前进行判断
				StringBuilder tempBuilder = new StringBuilder();
				int nodeNumber = queue.size();
				for (int i = 0; i < nodeNumber; i++) {
					TreeNode tempNode = queue.poll();
					if(tempNode == null){
						tempBuilder.append("#");
						continue;
					}
					tempBuilder.append(tempNode.val + "!");
					//本题中Queue中需要出现null
					queue.add(tempNode.left);
					queue.add(tempNode.right);
				}
				
				//result.append(tempBuilder);
			}
	      
	      

	      return root;
	  }
	    
	  int getFirstValue(StringBuilder sBuilder){
		  int index = sBuilder.indexOf("!");//第一个分界下标
		  String value = sBuilder.substring(0, index);
		  sBuilder.delete(0, index + 1);
		  return Integer.parseInt(value);
	  }
	  
	    
	    String SerializeLevelOrder(TreeNode root) {
	    	//改写原来常用的层序遍历，把List换成StringBuilder
	    	StringBuilder result = new StringBuilder();
			LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);
			
			while (!queue.isEmpty()) {//注意到Java中queue的特性是不允许进入null，需要提前进行判断
				StringBuilder tempBuilder = new StringBuilder();
				int nodeNumber = queue.size();
				for (int i = 0; i < nodeNumber; i++) {
					TreeNode tempNode = queue.poll();
					if(tempNode == null){
						tempBuilder.append("#");
						continue;
					}
					tempBuilder.append(tempNode.val + "!");
					//本题中Queue中需要出现null
					queue.add(tempNode.left);
					queue.add(tempNode.right);
				}
				
				result.append(tempBuilder);
			}
			
	    	return result.toString();
	    }
	    
	    String SerializePreOrder(TreeNode root, String input) {
	    	//参考网上的解法，在#和数字后面都放上一个,  
	    	//方便后期节点分割
	    	if(root == null)
	    		return input + "#,";
	    	
	    	String strLeft = SerializePreOrder(root.left, input + root.val + ",");
	    	return SerializePreOrder(root.right, strLeft);
	    }


}
