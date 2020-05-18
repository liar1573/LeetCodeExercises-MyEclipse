/**RemoveNthNodeFromEndofList.java
 * com.leetcode.linkedlist
 * TODO
 * 19 经典链表系列问题
 * @author liar
 * 2020年5月18日 上午10:11:16
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
        
        //删除pre之后的节点即可达到要求
        pre.next = pre.next.next; //这里的pre.next.next;无法处理空链表，需要开头返回
        
        return guardNode.next;
    }
}
