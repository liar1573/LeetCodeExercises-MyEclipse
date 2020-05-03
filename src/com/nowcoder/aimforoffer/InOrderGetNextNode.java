/**InOrderGetNextNode.java
 * com.nowcoder.aimforoffer
 * TODO
 * ţ����-��ָoffer
 * ����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�
 * ע������Ľڵ�����һ��ָ�򸸽ڵ��ָ��
 * 
 * @author liar
 * 2020��5��3�� ����10:21:13
 * @version 1.0
 */
package com.nowcoder.aimforoffer;
 class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;
    TreeLinkNode(int val) {
        this.val = val;
    }
}


public class InOrderGetNextNode {
	public TreeLinkNode GetNext(TreeLinkNode pNode){
        //case1����Ч���롢����
		if(pNode == null)//����Ч����ֱ�ӷ���
        	return null;
        //case2 �����ҽڵ㣨ע���������������ʣ�ֻҪ�����ҽڵ������£�������������ȫ���ԣ�
        if(pNode.right != null){
        	TreeLinkNode node = pNode.right;
        	for(; node.left != null; node = node.left);
        	return node;
        }
        
        //���������������case3����û�취����ڵ�Ϊ�������ڵ���������Ҫ��ǰ�������۴���һ��
        //case4 ��ֻ��һ�Ÿ��ڵ�
        if (pNode.next == null)
        	return null;
        
        //case3 ���ҽڵ�������ڣ���ʵֻҪ�������ҽڵ㼴�ɣ�
        if (pNode.right == null) {
			if (pNode == pNode.next.left) {
				//����ýڵ����丸�ڵ�����ӣ��򷵻ظ��ڵ㣻
				return pNode.next;
			} else {
				//����������ϱ����丸�ڵ�ĸ��ڵ㣬�ظ�֮ǰ���жϣ����ؽ��
				//TreeLinkNode node = pNode.next;
				TreeLinkNode node = null;
				//����for�ж���������Ҫ����һ��node.next�ǿգ�������ܻ���ݵ����ڵ�
				for(node = pNode.next; (node.next != null) && node.next.left != node; node = node.next);
				return node.next;
				//�����֧�������е�֡��������Ƕ�Ӧ���һ���ڵ�������
			}
		}
        //���return��֧��ʵ�ǲ������ߵ��ģ�ǰ���if�����ϰ��������п��ܵ����
        //�������ﻹ��Ҫ����return��䣬����������ᱨ��ȱ��return
		return pNode;
    }

	public TreeLinkNode GetNextExample(TreeLinkNode pNode){
		//ţ�͸��޽ⷨ���ⷨ˼·����������Ҳ�ܼ��
		
		if(pNode == null)
			return null;
		
		if (pNode.right != null) {
			TreeLinkNode node = pNode.right;
			while (node.left != null)
				node = node.left;
			//����һ��ʼʹ��forд��Ҳ���Գ�������������ο������õ���while�о�˼·�����һЩ
			return node;
		}
		
		while (pNode.next != null) {
			TreeLinkNode parent = pNode.next;
			if(parent.left == pNode)
				return parent;
			pNode = pNode.next;
			//����Ĳ�����ʵ������Ĳ����ǳ��񣬲��ϵ���p.next��p.left���е���
		}
		
		//���������ǰ�ڵ��Ƕ�������������һ���ڵ�����
		//Ҳ��������ֻ��һ�����ڵ�����
		return null;
	}
}
