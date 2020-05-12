/**GetPostOrderArray.java
 * com.leetcode.tree
 * TODO
 * BAT�㷨��ѵ�� - 5.05.��(Av17664182,P5)-1
 * �������������Ϊ�������ʽ����һ�Σ�Ҳ������΢��ϰһ��
 * �����������Ҫ�ָ����Ļ������Բ��漰�鷳�����ڵ�ָ�������ֻ�����������ֵ�Ļ�Ӧ�ÿ��Լ򵥲���
 * @author liar
 * 2020��5��1�� ����10:59:21
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
		//���ֱ����int[]��Ϊ�ݹ�������±�Ĵ�����΢�е��鷳
		//����List��¼��ز������ˣ�����ٵ���ֵ��int[]����
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		//����˼·��ǰ�������Ӧ�ô���û��
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
            	//�����޸ĺ�û�з���ֵ�ˣ���������������˳���Ǻ���Ҫ�ģ�����ע��һ��
            	
            	//ע�⵽��������뷵�غ�����������Ļ������������Ҫ��΢��һ�µ���
            	//Ҫ�ȱ����������ٱ����������ſ���
            	
            	//�����������
            	buildLastOrderArray(pre,i-startIn+startPre+1,endPre,in,i+1,endIn,list);
            	//������������
            	buildLastOrderArray(pre,startPre+1,startPre+i-startIn,in,startIn,i-1,list);
                
            	//�����������
            	//buildLastOrderArray(pre,i-startIn+startPre+1,endPre,in,i+1,endIn,list);       
                break;            
            }                         
        return;    
    }

}
