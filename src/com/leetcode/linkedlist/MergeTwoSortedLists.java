/**MergeTwoSortedLists.java
 * com.leetcode.linkedlist
 * TODO
 * 21 合并两个有序链表
 * 注意到题目中的要求，算是小小的增加了难度，即不允许创建新的节点，只允许移动已有的节点
 * @author liar
 * 2020年5月18日 上午10:48:08
 * @version 1.0
 */
package com.leetcode.linkedlist;


public class MergeTwoSortedLists {
	public ListNode mergeTwoListsFaultTry(ListNode l1, ListNode l2) {
		//判空操作应该会使后面的讨论更简单一些
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		
		//经过上面两个条件筛选后，此时l1和l2至少都还有一个节点
		
        //还是先建一个头结点方便编程
		ListNode guardNode = new ListNode(0);
		if(l1.val <= l2.val)
			guardNode.next = l1;
		else
			guardNode.next = l2;
		
		
		
		//直接用l1和l2操作，就不再设置其他变量了
		
		//后来试了下还是需要额外的临时变量
		ListNode temp1 = l1,temp2 = l2;
		while(l1 != null || l2 != null){
			l1 = temp1;
			if(l1 == null){//此时l1遍历空，只剩下l2，一口气将l2全部连接上即可
				guardNode.next = l2;
				break;
			}
			if(l2 == null){
				guardNode.next = l1;
				break;
			}
			//经过上面两个条件筛选后，此时l1和l2至少都还有一个节点
			if(l1.val <= l2.val){
				//l1 = temp1;
	
				temp1 = l1.next;
				l1.next = l2;
				//l1 = l1.next;
			} else {
				guardNode.next = l2;
				l2 = l2.next;
			}
		}//只有l1和l2同时遍历结束才会跳出循环
		
		
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
