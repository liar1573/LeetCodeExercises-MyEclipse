/**GetPostOrderArray.java
 * com.leetcode.tree
 * TODO
 * BAT算法特训班 - 5.05.树(Av17664182,P5)-1
 * 尝试输入输出都为数组的形式再做一次，也算是稍微复习一下
 * 不过如果不需要恢复树的话，可以不涉及麻烦点树节点指针操作，只操作数组填充值的话应该可以简单不少
 * @author liar
 * 2020年5月1日 上午10:59:21
 * @version 1.0
 */
package com.leetcode.tree;

import java.util.LinkedList;

public class GetPostOrderArray {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pre = {3,9,20,15,7};
		int[] in = {9,3,15,20,7};
		GetPostOrderArray test = new GetPostOrderArray();
		int[] last = test.getPostOrderArray(pre, in);
		for (int i : last) {
			System.out.println(i);
		}
	}
	
	public int[] getPostOrderArray(int[] preorder, int[] inorder) {
		int[] result = new int[preorder.length];
		//如果直接用int[]作为递归参数，下标的处理稍微有点麻烦
		//先用List记录相关参数好了，最后再倒序赋值给int[]即可
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		//操作思路跟前面比起来应该大致没变
		buildLastOrderArray(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, list);
		for (int i = 0; i < result.length; i++) {
			result[i] = list.get(result.length - i - 1); 
		}
		
		return result;
	}
	
	
	private void buildLastOrderArray(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn, LinkedList<Integer> list){                 
        if(startPre>endPre||startIn>endIn)            
            return;        
        //TreeNode root=new TreeNode(pre[startPre]);
        list.add(pre[startPre]);
        for(int i=startIn;i<=endIn;i++)            
            if(in[i]==pre[startPre]){
            	//这里修改后没有返回值了，不过左右子树的顺序还是很重要的，特意注释一下
            	
            	//注意到这里如果想返回后续遍历数组的话，遍历结果需要稍微做一下调整
            	//要先遍历右子树再遍历左子树才可以
            	
            	//其次是右子树
            	buildLastOrderArray(pre,i-startIn+startPre+1,endPre,in,i+1,endIn,list);
            	//首先是左子树
            	buildLastOrderArray(pre,startPre+1,startPre+i-startIn,in,startIn,i-1,list);
                
            	//其次是右子树
            	//buildLastOrderArray(pre,i-startIn+startPre+1,endPre,in,i+1,endIn,list);       
                break;            
            }                         
        return;    
    }

}
