/**FindFirstCommonNodeInTwoList.java
 * com.nowcoder.aimforoffer.linkedlist
 * TODO
 * 输入两个链表，找出它们的第一个公共结点。
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 * @author liar
 * 2020年6月18日 上午10:37:28
 * @version 1.0
 */
package com.nowcoder.aimforoffer.linkedlist;

import java.util.*;



import com.leetcode.linkedlist.ListNode;

public class FindFirstCommonNodeInTwoList {
	 public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		 if(pHead1 == null || pHead2 == null)  return null;
		 
		 Set<ListNode> set = new HashSet<ListNode>();
		 ListNode result = null;
		 for (; pHead1 != null && pHead2 != null; 
				 pHead1 = pHead1.next, pHead2 = pHead2.next) {
			 
			 if(set.contains(pHead1)){
					result = pHead1;
					break;
				}else {
					set.add(pHead1);
				}
			 
			if(set.contains(pHead2)){
				result = pHead2;
				break;
			}else {
				set.add(pHead2);
			}	
		}
		
		 if(pHead1 == null){
			 while (pHead2 != null) {
				 if(set.contains(pHead2)){
						result = pHead2;
						break;
					}else {
						set.add(pHead2);
					}
				 pHead2 = pHead2.next;
			}
		 }
		 
		 if(pHead2 == null){
			 while (pHead1 != null) {
				 if(set.contains(pHead1)){
						result = pHead1;
						break;
					}else {
						set.add(pHead1);
					}
				 pHead1 = pHead1.next;
			}
		 }
		 		 
		 return result;
	 }

	 public ListNode FindFirstCommonNodeExample(ListNode pHead1, ListNode pHead2) {
		 //参考答案，使用两个指针在两个指针中来回拼接移动追赶
		 ListNode p1 = pHead1,p2 = pHead2;
		 while (p1 != p2) {
			p1 = (p1 == null)? pHead2: p1.next;
			p2 = (p2 == null)? pHead1: p2.next;
		}
		 
		return p1; 
	 }
}
