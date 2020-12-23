/**ReverseLinkedListReview.java
 * com.leetcode.linkedlist
 * TODO
 * �����������Ŀ��ϰ LC206����ת����ڵ�
 * @author liar
 * 2020��5��7�� ����10:20:06
 * @version 1.0
 */
package com.leetcode.linkedlist;


public class ReverseLinkedListReview {
	public ListNode reverseList(ListNode head) {
		//���õ����ķ��������
		if(head == null)
			return null;
		
		//������ǿյ�ʱ�����Ȱ�ͷ��������һ���ڵ㣨head.next = null
		//Ȼ���ٱ����������ڵ㵹����ӵ�head��ǰ��
		ListNode node = head.next, temp = node; //����ָ��
		
		head.next = null; //������ǿյ�ʱ�����Ȱ�ͷ��������һ���ڵ�
		while (node != null) {
			temp = node.next;
			node.next = head;
			head = node;
			node = temp;
		}
		//���֮��һ���õ���3������ָ��:head,node��temp  ���о��ƺ����ܾ����
		
		
        return head;
    }
	
	public ListNode reverseListRecursion(ListNode head) {
		//��ת����ĵݹ�ⷨ
		
		
	    if(head == null || head.next == null){
	        return head;
	    }
	    ListNode remaining = reverseListRecursion(head.next);
	    //�����߼���������һ���ĸо��������ÿһ�ε�������ֻ�ܷ�ת��ͷָ������������ڵ㣬Ȼ����Ҫ�����ݹ�ȥ��ͣ��ÿ�η�ת�����ڵ�
	    //Ч�ʺ�����ô�ߡ�������Ȼ���н��Ҳ��0ms��
	    
	    //�ݹ������������ǰ�ڵ����һ���ڵ��nextָ��ָ��ǰ�ڵ㣬��ǰ�ڵ��nextָ��ָ��ա�
	    head.next.next = head;
	    head.next = null;
	    
	    return remaining;	    
	}
	
	public ListNode reverseListExample(ListNode head) {
		//�����㷨40����ʦ�����ľ���ⷨ
		ListNode cur = head, pre = null, temp = null;
		//ԭ�ο�����Python�ģ���һ�ֲ��и�ֵ������һ����ʱ����������javaһ����Ҫ������ʱ����
		
		while (cur != null) {		
			temp = cur.next;//�������Ҫ����temp����cur.next������������ͶϿ���
			cur.next = pre;
			pre = cur;
			//cur = cur.next;
			cur = temp;//Ȼ��������Ҫʹ��tempȡ��cur.next��cur���и�ֵ
		}
		
		return pre;
	}
	
}



//class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }
