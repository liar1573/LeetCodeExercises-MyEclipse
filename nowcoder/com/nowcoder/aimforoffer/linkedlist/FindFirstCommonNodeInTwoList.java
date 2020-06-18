/**FindFirstCommonNodeInTwoList.java
 * com.nowcoder.aimforoffer.linkedlist
 * TODO
 * �������������ҳ����ǵĵ�һ��������㡣
 * ��ע����Ϊ�����������������Դ���������ݵ���ʾ����������ʽ��ʾ�ģ���֤������������ȷ�ģ�
 * @author liar
 * 2020��6��18�� ����10:37:28
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
		 //�ο��𰸣�ʹ������ָ��������ָ��������ƴ���ƶ�׷��
		 ListNode p1 = pHead1,p2 = pHead2;
		 while (p1 != p2) {
			p1 = (p1 == null)? pHead2: p1.next;
			p2 = (p2 == null)? pHead1: p2.next;
		}
		 
		return p1; 
	 }
}
