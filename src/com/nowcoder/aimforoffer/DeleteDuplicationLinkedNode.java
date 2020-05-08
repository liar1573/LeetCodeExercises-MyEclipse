/**DeleteDuplicationLinkedNode.java
 * com.nowcoder.aimforoffer
 * TODO
 * 在一个排序的链表中，存在重复的结点，
 * 请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @author liar
 * 2020年5月6日 下午4:46:06
 * @version 1.0
 */
package com.nowcoder.aimforoffer;


public class DeleteDuplicationLinkedNode {
	public ListNode deleteDuplicationError(ListNode pHead){
		//前期失败的尝试
		if(pHead == null)  //理论上题目说了“在一个排序的链表中，存在重复的结点”，不过以防万一还是加上好了
			return null;
		
		//此时链表长度至少为1
		//感觉这里似乎需要2、3个缓存指针来着
		ListNode pre, cur, last;
		
		//其实想了想好像cur和last可以合并为一个，即用cur.next来表示last
		//不过这样看起来逻辑不太清晰，而且只为了省一个常量空间没必要
		
		pre = pHead;cur = pHead; last = cur.next;
		int tempValue = cur.val;
		
		while (last != null) {
			if (last.val == tempValue) {//只有出现值重复的时候才需要删除，否则直接跳过即可
				while (last != null && last.val == tempValue) {//当出现连续重复值时，指针连续向后跳
					//while (last != null && last.val == tempValue)
					//这里感觉表达需要变一下
						last = last.next;
				}
				//tempValue = last.val;//把新的值赋给tempvalue
				//这一步应该可以提到if外面去
				pre.next = last;
				//这里似乎可以对last==null的特殊清楚做个判断
				//如果last为空说明遍历已经达到末尾，这里直接return就可以了
				if(last == null)
					return pHead;
			}
			
			tempValue = last.val;//把新的值赋给tempvalue
			pre = cur;
			cur = last;
			last = cur.next;
		}
		
		
		
		return pHead;
    }

	public ListNode deleteDuplication(ListNode pHead){
		//参考秘籍额外创建一个头哨兵节点解决这个问题
		ListNode first = new ListNode(0);//first为哨兵节点
		//哨兵的值域内容完全无影响，主要想利用哨兵的指针是编程更容易避免各种特殊情况判断
		first.next = pHead;
		//由于这里感觉至少需要三个指针，即三个临时变量是必须的--pre,a,b
		ListNode pre = first;
		
		//注意到这里如果需要删除指针的话，删除之后需要pre.next来指向
		//所以这里判断就用pre.next进行判断
		while (pre.next != null && pre.next.next != null) {
			ListNode a = pre.next;
			ListNode b = pre.next.next;
			if (a.val == b.val) {
				while (b.next != null && a.val == b.next.val )
					b = b.next;//经过这个while循环之后，b指向最后一个重复节点
				//写到这发现由于这里没有反转操作只是单纯的节点删除操作（同时删除的节点还是连续的
				//因此指针操作次数比之前需要反转的时候少得多
				pre.next = b.next;
				continue;
			}		
			//存在相同节点删除和不需要删除的指针移动是不一样的
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
