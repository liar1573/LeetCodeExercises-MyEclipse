/**LinkedListCycleII.java
 * com.leetcode.linkedlist
 * TODO
 * LC142，检查链表中是否有环问题的升级版，如果无环返回null
 * 如果有环还得返回环的指针
 * 这题本来应该是141判断链表环问题的进阶版，287数组中重复数字的前置问题，不过昨天顺序好像不太对。。
 * 1.快慢指针算法线性时间，空间为常数。2.HashSet解法，相对快慢指针效率差很多，但是思路和代码都很简单
 * @author liar
 * 2020年6月2日 上午11:28:44
 * @version 1.0
 */
package com.leetcode.linkedlist;

import java.util.HashSet;

public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
        if(head == null)	return null;
        //注意到后期找环的时候还需要用到head，所以最好设一个额外变量
        ListNode slow = head, fast = head;
		do {
			if(fast.next == null || fast.next.next == null)
				return null;
			fast = fast.next.next;
			//这里由于fast跳转更快，检查fast之后感觉理论上应该是不需要再检查slow了
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
		//HashSet解法，相对快慢指针效率差很多，但是思路和代码都很简单
		//if(head == null) return null; 使用头结点可以避免额外判断
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
