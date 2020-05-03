/**BuildTreePreInOrderExample.java
 * com.leetcode.tree
 * TODO
 * ����ţ���� ��ָofferͬ����Ŀ����ǰ����������ָ�����������Ŀ
 * ������һ�����еĸ��޵ݹ�ⷨ������˼·�ǳ���࣬
 * ��LeetCode�ύ��Ч��Ҳ���Լ�ԭ����д������ݹ�����˺ܶ�
 * @author liar
 * 2020��5��2�� ����9:47:20
 * @version 1.0
 */
package com.leetcode.tree;


public class BuildTreePreInOrderExample {
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
}
