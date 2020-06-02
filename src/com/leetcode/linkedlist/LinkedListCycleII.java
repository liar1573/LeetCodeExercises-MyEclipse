/**LinkedListCycleII.java
 * com.leetcode.linkedlist
 * TODO
 * LC142������������Ƿ��л�����������棬����޻�����null
 * ����л����÷��ػ���ָ��
 * ���Ȿ��Ӧ����141�ж���������Ľ��װ棬287�������ظ����ֵ�ǰ�����⣬��������˳�����̫�ԡ���
 * 1.����ָ���㷨����ʱ�䣬�ռ�Ϊ������2.HashSet�ⷨ����Կ���ָ��Ч�ʲ�ܶ࣬����˼·�ʹ��붼�ܼ�
 * @author liar
 * 2020��6��2�� ����11:28:44
 * @version 1.0
 */
package com.leetcode.linkedlist;

import java.util.HashSet;

public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
        if(head == null)	return null;
        //ע�⵽�����һ���ʱ����Ҫ�õ�head�����������һ���������
        ListNode slow = head, fast = head;
		do {
			if(fast.next == null || fast.next.next == null)
				return null;
			fast = fast.next.next;
			//��������fast��ת���죬���fast֮��о�������Ӧ���ǲ���Ҫ�ټ��slow��
			slow = slow.next;
		} while (slow != fast);
		
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
    }
	
	public ListNode detectCycleHashSet(ListNode head) {
		//HashSet�ⷨ����Կ���ָ��Ч�ʲ�ܶ࣬����˼·�ʹ��붼�ܼ�
		//if(head == null) return null; ʹ��ͷ�����Ա�������ж�
		HashSet<ListNode> set = new HashSet<ListNode>();
		ListNode preNode = new ListNode();  preNode.next = head;
		while (preNode.next != null) {
			if(!set.add(preNode.next))
				return preNode.next;
			preNode = preNode.next;
		}
		
		return null;
	}
}
