/**DeleteDuplicationLinkedNode.java
 * com.nowcoder.aimforoffer
 * TODO
 * ��һ������������У������ظ��Ľ�㣬
 * ��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣
 * ���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5
 * @author liar
 * 2020��5��6�� ����4:46:06
 * @version 1.0
 */
package com.nowcoder.aimforoffer;


public class DeleteDuplicationLinkedNode {
	public ListNode deleteDuplicationError(ListNode pHead){
		//ǰ��ʧ�ܵĳ���
		if(pHead == null)  //��������Ŀ˵�ˡ���һ������������У������ظ��Ľ�㡱�������Է���һ���Ǽ��Ϻ���
			return null;
		
		//��ʱ����������Ϊ1
		//�о������ƺ���Ҫ2��3������ָ������
		ListNode pre, cur, last;
		
		//��ʵ���������cur��last���Ժϲ�Ϊһ��������cur.next����ʾlast
		//���������������߼���̫����������ֻΪ��ʡһ�������ռ�û��Ҫ
		
		pre = pHead;cur = pHead; last = cur.next;
		int tempValue = cur.val;
		
		while (last != null) {
			if (last.val == tempValue) {//ֻ�г���ֵ�ظ���ʱ�����Ҫɾ��������ֱ����������
				while (last != null && last.val == tempValue) {//�����������ظ�ֵʱ��ָ�����������
					//while (last != null && last.val == tempValue)
					//����о������Ҫ��һ��
						last = last.next;
				}
				//tempValue = last.val;//���µ�ֵ����tempvalue
				//��һ��Ӧ�ÿ����ᵽif����ȥ
				pre.next = last;
				//�����ƺ����Զ�last==null��������������ж�
				//���lastΪ��˵�������Ѿ��ﵽĩβ������ֱ��return�Ϳ�����
				if(last == null)
					return pHead;
			}
			
			tempValue = last.val;//���µ�ֵ����tempvalue
			pre = cur;
			cur = last;
			last = cur.next;
		}
		
		
		
		return pHead;
    }

	public ListNode deleteDuplication(ListNode pHead){
		//�ο��ؼ����ⴴ��һ��ͷ�ڱ��ڵ����������
		ListNode first = new ListNode(0);//firstΪ�ڱ��ڵ�
		//�ڱ���ֵ��������ȫ��Ӱ�죬��Ҫ�������ڱ���ָ���Ǳ�̸����ױ��������������ж�
		first.next = pHead;
		//��������о�������Ҫ����ָ�룬��������ʱ�����Ǳ����--pre,a,b
		ListNode pre = first;
		
		//ע�⵽���������Ҫɾ��ָ��Ļ���ɾ��֮����Ҫpre.next��ָ��
		//���������жϾ���pre.next�����ж�
		while (pre.next != null && pre.next.next != null) {
			ListNode a = pre.next;
			ListNode b = pre.next.next;
			if (a.val == b.val) {
				while (b.next != null && a.val == b.next.val )
					b = b.next;//�������whileѭ��֮��bָ�����һ���ظ��ڵ�
				//д���ⷢ����������û�з�ת����ֻ�ǵ����Ľڵ�ɾ��������ͬʱɾ���Ľڵ㻹��������
				//���ָ�����������֮ǰ��Ҫ��ת��ʱ���ٵö�
				pre.next = b.next;
				continue;
			}		
			//������ͬ�ڵ�ɾ���Ͳ���Ҫɾ����ָ���ƶ��ǲ�һ����
			pre = a;
		}	
		return first.next;
	}
}

class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}
