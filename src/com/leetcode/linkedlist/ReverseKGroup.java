/**
 * LC25��K��һ�鷴ת������󳤶Ȳ���K�Ĳ��ֱ���ԭ˳�򲻱䡣 
 */
package com.leetcode.linkedlist;

import java.lang.invoke.LambdaConversionException;

public class ReverseKGroup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode kNode = getKthNode(head, k);
        if(kNode == null)
            return head; //����k���ڵ�ֱ�ӷ���

        ListNode other = reverseKGroup(kNode, k);
        //��һ�ε����ƺ�������
        //reverseKGroup(kNode, k);

        // head.next = other;//�ƺ�������һ����Լ򵥵ؽ������������
        //���ǲ���
        //�����������ʹ��LC206�ķ�����ת��ʱ���ƺ���Ҫ����β��������ͷ��㣬�Ӷ����Խ�ǰk����ת���������ݹ�Ĳ�����������

        //�����ƺ�Ҫ�ȵ��õݹ��ٷ�ת�������ȷ�ת�Ļ���k���ڵ��nextָ��ᷢ���仯
        //�ο�LC24��206��Ҳ�����ȵݹ�����ٷ�תǰ�����ֵ�
        // reverseKNodes(head, kNode, k);
//        ListNode top = reverseKNodes(head, kNode);
        reverseKNodes(head, kNode);
        head.next = other;
//        top.next = other; //ϣ������һ���ǰ����������������

        return kNode;
    }


    public ListNode getKthNode(ListNode head, int k) {
        //����е�k���ڵ�ͷ��ظýڵ��ָ�룬���û�о�ֱ�ӷ���null
        int count = 1;
        while(head != null && count < k){
            count++;
            head = head.next;
        }

        return head;
    }
    
    
    public void reverseKNodes(ListNode head, ListNode end) {
        ListNode temp = head;
        ListNode pre = head, cur = pre.next;
        head.next = null; //����������Ƚ�headָ�գ������������������
        //���ǲ��У�LC���뻹�Ǳ����л�
//        pre.next = end.next; //���Ҷ���Ľⷨ��û��һ��ʼ����ĸ�ֵ
        while(pre != end){//���﷭ת�Ĵ��������ǶԵģ�������һЩϸ��ʵ�ֲ�һ��
        	//����ķ����жϵ���cur != end���Լ��õ���pre != end
            // head = cur.next;
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            // cur = head;
            cur = temp;
        }
    }
    
	 
}
