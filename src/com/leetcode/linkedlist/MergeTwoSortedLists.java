/**MergeTwoSortedLists.java
 * com.leetcode.linkedlist
 * TODO
 * 21 �ϲ�������������
 * ע�⵽��Ŀ�е�Ҫ������СС���������Ѷȣ������������µĽڵ㣬ֻ�����ƶ����еĽڵ�
 * @author liar
 * 2020��5��18�� ����10:48:08
 * @version 1.0
 */
package com.leetcode.linkedlist;


public class MergeTwoSortedLists {
	public ListNode mergeTwoListsFaultTry(ListNode l1, ListNode l2) {
		//�пղ���Ӧ�û�ʹ��������۸���һЩ
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		
		//����������������ɸѡ�󣬴�ʱl1��l2���ٶ�����һ���ڵ�
		
        //�����Ƚ�һ��ͷ��㷽����
		ListNode guardNode = new ListNode(0);
		if(l1.val <= l2.val)
			guardNode.next = l1;
		else
			guardNode.next = l2;
		
		
		
		//ֱ����l1��l2�������Ͳ�����������������
		
		//���������»�����Ҫ�������ʱ����
		ListNode temp1 = l1,temp2 = l2;
		while(l1 != null || l2 != null){
			l1 = temp1;
			if(l1 == null){//��ʱl1�����գ�ֻʣ��l2��һ������l2ȫ�������ϼ���
				guardNode.next = l2;
				break;
			}
			if(l2 == null){
				guardNode.next = l1;
				break;
			}
			//����������������ɸѡ�󣬴�ʱl1��l2���ٶ�����һ���ڵ�
			if(l1.val <= l2.val){
				//l1 = temp1;
	
				temp1 = l1.next;
				l1.next = l2;
				//l1 = l1.next;
			} else {
				guardNode.next = l2;
				l2 = l2.next;
			}
		}//ֻ��l1��l2ͬʱ���������Ż�����ѭ��
		
		
		return guardNode.next;
    }

	public ListNode mergeTwoListsRecursion(ListNode l1, ListNode l2) {
	    if(l1==null) return l2;
	    if(l2==null) return l1;
	    if(l1.val<=l2.val){
	        l1.next=mergeTwoListsRecursion(l1.next, l2);
	        return l1;
	    } else {
	        l2.next=mergeTwoListsRecursion(l1, l2.next);
	        return l2;
	    }
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode cur = new ListNode(0);
		ListNode dummy = cur;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}

		if (l1 == null)
			cur.next = l2;

		if (l2 == null)
			cur.next = l1;

		return dummy.next;
	}
}
