/**ListNode.java
 * com.leetcode.linkedlist
 * TODO
 * 方便统一导入调试的ListNode类
 * @author liar
 * 2020年5月18日 上午10:22:54
 * @version 1.0
 */
package com.leetcode.linkedlist;


public class ListNode {
	int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
