/**BuildTreePreInOrderExample.java
 * com.leetcode.tree
 * TODO
 * 来自牛客网 剑指offer同样题目根据前序、中序遍历恢复二叉树的题目
 * 评论区一个大佬的高赞递归解法，代码思路非常简洁，
 * 在LeetCode提交后效率也比自己原来的写的冗余递归提高了很多
 * @author liar
 * 2020年5月2日 上午9:47:20
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
