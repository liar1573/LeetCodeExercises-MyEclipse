/**TreeSerializeAndDeserialize.java
 * com.nowcoder.aimforoffer
 * TODO
 * �����������л���ָ����һ�ö���������ĳ�ֱ�����ʽ�Ľ����ĳ�ָ�ʽ����Ϊ�ַ���
 * �������ķ����л���ָ������ĳ�ֱ���˳��õ������л��ַ������str���ع���������
 * ����Ƚ���ֵ�һ������ȫû�и������л���˳������ǰ���С������ǲ��򡣡�
 * @author liar
 * 2020��5��12�� ����11:10:29
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
	int index = -1; //��Ա���������ڱ�ʾ�ڵ��±�
	
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
		 //������򵥵�ǰ������	 
		 //return Serialize(root, "");
		 return SerializePreOrder(root,"");
	 }
	 
	 TreeNode DeserializeExample(String str) {
		 if(str.length() == 2)//����ÿ���ڵ㶼��,  ����С���ȿ������ַ�������Ҳ��2
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
		  //����ͨ���ǵ����ķ������ݲ���������ֱ�ӻظ���������δ�ܳɹ�
		  //�о��������ǿ��еģ��������ǲ�һ�㲻̫��ʵ�֡���
		  if(str.length() == 1)
			  return null;//�����ڵ�ֻ��һ��"#"
		  StringBuilder sBuilder = new StringBuilder(str);
		  
	      TreeNode root = new TreeNode(getFirstValue(sBuilder));
	      LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	      queue.add(root);
	      
	      while (!queue.isEmpty()) {//ע�⵽Java��queue�������ǲ��������null����Ҫ��ǰ�����ж�
				StringBuilder tempBuilder = new StringBuilder();
				int nodeNumber = queue.size();
				for (int i = 0; i < nodeNumber; i++) {
					TreeNode tempNode = queue.poll();
					if(tempNode == null){
						tempBuilder.append("#");
						continue;
					}
					tempBuilder.append(tempNode.val + "!");
					//������Queue����Ҫ����null
					queue.add(tempNode.left);
					queue.add(tempNode.right);
				}
				
				//result.append(tempBuilder);
			}
	      
	      

	      return root;
	  }
	    
	  int getFirstValue(StringBuilder sBuilder){
		  int index = sBuilder.indexOf("!");//��һ���ֽ��±�
		  String value = sBuilder.substring(0, index);
		  sBuilder.delete(0, index + 1);
		  return Integer.parseInt(value);
	  }
	  
	    
	    String SerializeLevelOrder(TreeNode root) {
	    	//��дԭ�����õĲ����������List����StringBuilder
	    	StringBuilder result = new StringBuilder();
			LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);
			
			while (!queue.isEmpty()) {//ע�⵽Java��queue�������ǲ��������null����Ҫ��ǰ�����ж�
				StringBuilder tempBuilder = new StringBuilder();
				int nodeNumber = queue.size();
				for (int i = 0; i < nodeNumber; i++) {
					TreeNode tempNode = queue.poll();
					if(tempNode == null){
						tempBuilder.append("#");
						continue;
					}
					tempBuilder.append(tempNode.val + "!");
					//������Queue����Ҫ����null
					queue.add(tempNode.left);
					queue.add(tempNode.right);
				}
				
				result.append(tempBuilder);
			}
			
	    	return result.toString();
	    }
	    
	    String SerializePreOrder(TreeNode root, String input) {
	    	//�ο����ϵĽⷨ����#�����ֺ��涼����һ��,  
	    	//������ڽڵ�ָ�
	    	if(root == null)
	    		return input + "#,";
	    	
	    	String strLeft = SerializePreOrder(root.left, input + root.val + ",");
	    	return SerializePreOrder(root.right, strLeft);
	    }


}
