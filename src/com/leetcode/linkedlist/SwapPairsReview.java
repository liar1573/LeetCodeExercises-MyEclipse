/**SwapPairsReview.java
 * com.leetcode.linkedlist
 * TODO
 * ��ϰ��24. Swap Nodes in Pairs �������������еĽڵ�
 * @author liar
 * 2020��5��7�� ����11:39:21
 * @version 1.0
 */
package com.leetcode.linkedlist;


public class SwapPairsReview {
	public ListNode swapPairsError(ListNode head) {
		//����д����û��ȫdebug
		if(head == null || head.next == null)
			return head;
		//����Ϊ0��1�Ľڵ㶼����Ҫ�κβ���

		//206��ת�����ʱ���õ���3�����棬����Ӧ�ò������
		ListNode cur = head, node = head.next, pre = node; //����ָ��
		
		//ͷ���Ĵ���о�û�취�Ž�while��
		head = head.next; pre = head;
		
		
		//һ��ʼֻ��������ָ��cur��node���������ÿ������֮�����ӻ�ϵ�
		//���ܻ�����Ҫһ��preָ��
		while (node != null) {
			cur.next = node.next;
			node.next = cur;
			//cur = node; //����ָ�븳ֵ�����е��ͻ��
			//����ͷ�������Ӻ���Ͽ��ˡ���
			//ͷ���Ͽ�����о���Ҫ��whileѭ��ǰ���⴦��һ�£�
			//ͷ���Ĵ���о�û�취�Ž�while��
			//cur = node.next;
			pre.next = node;
			//���������Ҫ����һ��preָ��
			pre = cur;
			
			cur = cur.next;
			//��������ĵ���˳����Ҫ�������cur��һ���ǿ��жϣ���������һ�л������
			if(cur == null)
				break;
			node = cur.next;
		}
		
        return head;
    }
	
	public ListNode swapPairsExample(ListNode head) {
		//����40���ľ���ʵ�ִ���
		//ListNode pre = new ListNode(0);
		ListNode result = new ListNode(0);
		ListNode pre = result;
		pre.next = head;
		//ͬʱע�⵽�����ж�д��Ҳ���԰ѳ���Ϊ0��1�����������ȥ���������ǳ����
		while (pre.next != null && pre.next.next != null) {
			//ע�⵽����ȷʵ��Ҫʹ������ֵ���жϵ��������ģ�������ܻ����֮ǰ���������
			//��Ҫ��whileѭ���м����һ���жϣ���������������������Ҳ�����׳���
			ListNode a = pre.next;
			ListNode b = a.next;
			//�������ʱ����a��b������������������Ҫ�����������ڵ��
			pre.next = b;
			a.next = b.next;
			b.next = a;
			pre = a;
		}
				
		//ע�⵽���ﷵ��ֵ������pre������Ҫ�½�һ����ʱ����
		//pre���ڵ����иı�ֵ��Python�Ľⷨʹ�������ñ���self��Ҳ�൱���½���һ��������
		//return pre.next;
		return result.next;
	}
	
}
