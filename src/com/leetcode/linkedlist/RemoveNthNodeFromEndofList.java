/**RemoveNthNodeFromEndofList.java
 * com.leetcode.linkedlist
 * TODO
 * 19 ��������ϵ������
 * @author liar
 * 2020��5��18�� ����10:11:16
 * @version 1.0
 */
package com.leetcode.linkedlist;


public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null)
			return null;
		
        ListNode guardNode = new ListNode(0, head);
        ListNode pre = guardNode, last = guardNode;
        
        for (int i = 0; i < n; i++)
        	last = last.next;
        
        while (last.next != null) {
			 last = last.next;
			 pre = pre.next;
		}
        
        //ɾ��pre֮��Ľڵ㼴�ɴﵽҪ��
        pre.next = pre.next.next; //�����pre.next.next;�޷������������Ҫ��ͷ����
        
        return guardNode.next;
    }
}
