/**ReverseLinkedListReview.java
 * com.leetcode.linkedlist
 * TODO
 * 链表操作类题目复习 LC206，反转链表节点
 * @author liar
 * 2020年5月7日 上午10:20:06
 * @version 1.0
 */
package com.leetcode.linkedlist;


public class ReverseLinkedListReview {
	public ListNode reverseList(ListNode head) {
		//先用迭代的方法解好了
		if(head == null)
			return null;
		
		//当链表非空的时候，首先把头结点变成最后一个节点（head.next = null
		//然后再遍历把其他节点倒着添加到head的前面
		ListNode node = head.next, temp = node; //缓存指针
		
		head.next = null; //当链表非空的时候，首先把头结点变成最后一个节点
		while (node != null) {
			temp = node.next;
			node.next = head;
			head = node;
			node = temp;
		}
		//完成之后一共用到了3个缓存指针:head,node和temp  （感觉似乎还能精简的
		
		
        return head;
    }
	
	public ListNode reverseListRecursion(ListNode head) {
		//反转链表的递归解法
		
		
	    if(head == null || head.next == null){
	        return head;
	    }
	    ListNode remaining = reverseList(head.next);
	    //代码逻辑基本上是一样的感觉这个方法每一次迭代好像只能反转离头指针最近的两个节点，然后再要依靠递归去不停的每次反转两个节点
	    //效率好像不怎么高。。（虽然运行结果也是0ms）
	    
	    //递归遍历链表，将当前节点的下一个节点的next指针指向当前节点，当前节点的next指针指向空。
	    head.next.next = head;
	    head.next = null;
	    
	    return remaining;	    
	}
	
	
	
}



class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
