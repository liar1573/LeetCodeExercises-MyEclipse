/**SwapPairsReview.java
 * com.leetcode.linkedlist
 * TODO
 * 复习，24. Swap Nodes in Pairs 两两交换链表中的节点
 * @author liar
 * 2020年5月7日 上午11:39:21
 * @version 1.0
 */
package com.leetcode.linkedlist;


public class SwapPairsReview {
	public ListNode swapPairsError(ListNode head) {
		//错误写法还没完全debug
		if(head == null || head.next == null)
			return head;
		//长度为0和1的节点都不需要任何操作

		//206反转链表的时候都用到了3个缓存，这里应该不会更少
		ListNode cur = head, node = head.next, pre = node; //缓存指针
		
		//头结点的处理感觉没办法放进while中
		head = head.next; pre = head;
		
		
		//一开始只用了两个指针cur和node，结果发现每队链表之间连接会断掉
		//可能还是需要一个pre指针
		while (node != null) {
			cur.next = node.next;
			node.next = cur;
			//cur = node; //这里指针赋值好像有点冲突了
			//而且头结点的链接好像断开了。。
			//头结点断开这个感觉需要在while循环前特殊处理一下，
			//头结点的处理感觉没办法放进while中
			//cur = node.next;
			pre.next = node;
			//这里可能需要备份一个pre指针
			pre = cur;
			
			cur = cur.next;
			//根据这里的迭代顺序，需要在这里对cur加一个非空判断，否则下面一行会出问题
			if(cur == null)
				break;
			node = cur.next;
		}
		
        return head;
    }
	
	public ListNode swapPairsExample(ListNode head) {
		//补充40讲的经典实现代码
		//ListNode pre = new ListNode(0);
		ListNode result = new ListNode(0);
		ListNode pre = result;
		pre.next = head;
		//同时注意到这种判断写法也可以把长度为0和1的情况包含进去，看起来非常简洁
		while (pre.next != null && pre.next.next != null) {
			//注意到这里确实需要使用两个值来判断迭代结束的，否则可能会出现之前遇到的情况
			//需要在while循环中间插入一个判断，这样看起来不清晰而且也很容易出错
			ListNode a = pre.next;
			ListNode b = a.next;
			//这里的临时遍历a和b是用来操作相邻且需要交换的两个节点的
			pre.next = b;
			a.next = b.next;
			b.next = a;
			pre = a;
		}
				
		//注意到这里返回值不能用pre，还需要新建一个临时变量
		//pre会在迭代中改变值（Python的解法使用了内置变量self，也相当于新建了一个变量）
		//return pre.next;
		return result.next;
	}
	
}
