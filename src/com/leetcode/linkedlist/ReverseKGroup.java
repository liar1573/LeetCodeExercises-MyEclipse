/**
 * LC25。K个一组反转链表，最后长度不够K的部分保持原顺序不变。 
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
            return head; //不足k个节点直接返回

        ListNode other = reverseKGroup(kNode, k);
        //第一次调用似乎断链了
        //reverseKGroup(kNode, k);

        // head.next = other;//似乎补上这一句可以简单地解决断链的问题
        //还是不行
        //这里的子问题使用LC206的方法反转的时候，似乎需要返回尾结点而不是头结点，从而可以将前k个反转部分与后面递归的部分连接起来

        //这里似乎要先调用递归再翻转，否则先翻转的话第k个节点的next指针会发生变化
        //参考LC24和206，也都是先递归调用再反转前方部分的
        // reverseKNodes(head, kNode, k);
//        ListNode top = reverseKNodes(head, kNode);
        reverseKNodes(head, kNode);
        head.next = other;
//        top.next = other; //希望用这一句把前后两部分连接起来

        return kNode;
    }


    public ListNode getKthNode(ListNode head, int k) {
        //如果有第k个节点就返回该节点的指针，如果没有就直接返回null
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
        head.next = null; //这里如果不先将head指空，后面好像会产生环。。
        //还是不行，LC编译还是报错有环
//        pre.next = end.next; //而且东哥的解法并没有一开始这里的赋值
        while(pre != end){//这里翻转的大致流程是对的，但是有一些细节实现不一样
        	//东哥的方法判断的是cur != end，自己用的是pre != end
            // head = cur.next;
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            // cur = head;
            cur = temp;
        }
    }
    
	 
}
