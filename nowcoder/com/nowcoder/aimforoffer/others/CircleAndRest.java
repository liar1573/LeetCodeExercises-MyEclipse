/**CircleAndRest.java
 * com.nowcoder.aimforoffer.others
 * TODO
 * ÿ����һ��ͯ��,ţ�Ͷ���׼��һЩС����ȥ�����¶�Ժ��С����,����������ˡ�HF��Ϊţ�͵�����Ԫ��,��ȻҲ׼����һЩС��Ϸ��
 * ����,�и���Ϸ��������:����,��С������Χ��һ����Ȧ��Ȼ��,�����ָ��һ����m,�ñ��Ϊ0��С���ѿ�ʼ������
 * ÿ�κ���m-1���Ǹ�С����Ҫ���г��׸�,Ȼ���������Ʒ�����������ѡ����,���Ҳ��ٻص�Ȧ��,��������һ��С���ѿ�ʼ,����0...m-1����....������ȥ....
 * ֱ��ʣ�����һ��С����,���Բ��ñ���,�����õ�ţ������ġ�����̽���ϡ���ذ�(��������Ŷ!!^_^)��
 * ������������,�ĸ�С���ѻ�õ������Ʒ�أ�(ע��С���ѵı���Ǵ�0��n-1)
 * @author liar
 * 2020��6��15�� ����11:20:20
 * @version 1.0
 */
package com.nowcoder.aimforoffer.others;

import com.leetcode.linkedlist.ListNode;

public class CircleAndRest {
	public static void main(String[] args) {
		//System.out.println(LastRemaining_Solution(5, 3));
		System.out.println(LastRemaining_SolutionList(5, 3));
	}
	
	
	public static int LastRemaining_Solution(int n, int m) {
        if(n <= 1 || m <= 0)
            return -1;
        
        int result = 0,kidCount  = n; // countͳ��ʣ������
        boolean[] queue = new boolean[n];
        while(kidCount > 1){
        	int numberCount = m;
        	while (numberCount > 1) {
        		result++;
        		if(result == n)
					result = 0;
				if(!queue[result]){//����		
					//����������ѭ�����飬ÿ����������֮����Ҫ�ָ�0
					//����ÿ��ȡ��о��ж���0Ч�ʸ���һЩ
					numberCount--;
				}					
			}
        	kidCount--;
        	queue[result] = true;
        	if(result < n-1)
        		result++;
        	else
        		result = 0;
        	//���������Ÿо�result����Ҫ����һ��
        }  
        
        return result;
    }

	public static int LastRemaining_SolutionList(int n, int m) {
		if(n <= 1 || m <= 0)
            return -1;
		
		ListNode head = new ListNode(0), pre = head;
		
		for (int i = 0; i < n; i++) {
			ListNode temp = new ListNode(i);
			pre.next = temp;
			pre = temp;
		}
		pre.next = head.next; //��β����ͷ���������
		head = head.next; //ȥ��һ��ʼ�ĸ���ͷ���
		
		while(n > 1){
			int tempCount = m-1;//����ɾ���ڵ㣬����ָ����Ҫ����ǰһλ
			while (tempCount > 1) {
				head = head.next;
				tempCount--;
			}
			head.next = head.next.next;//ɾ��ĳ���ڵ� 
			head = head.next;
			n--;
		}
		
		return head.val;
	}

}
