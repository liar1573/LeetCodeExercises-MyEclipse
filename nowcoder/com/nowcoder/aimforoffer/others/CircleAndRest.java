/**CircleAndRest.java
 * com.nowcoder.aimforoffer.others
 * TODO
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。
 * 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....
 * 直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 * @author liar
 * 2020年6月15日 上午11:20:20
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
        
        int result = 0,kidCount  = n; // count统计剩余人数
        boolean[] queue = new boolean[n];
        while(kidCount > 1){
        	int numberCount = m;
        	while (numberCount > 1) {
        		result++;
        		if(result == n)
					result = 0;
				if(!queue[result]){//报数		
					//这里由于是循环数组，每次数字满了之后需要恢复0
					//比起每轮取余感觉判断置0效率更高一些
					numberCount--;
				}					
			}
        	kidCount--;
        	queue[result] = true;
        	if(result < n-1)
        		result++;
        	else
        		result = 0;
        	//这里根据序号感觉result还需要自增一次
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
		pre.next = head.next; //把尾结点和头结点连起来
		head = head.next; //去掉一开始的辅助头结点
		
		while(n > 1){
			int tempCount = m-1;//这里删除节点，所以指针需要放在前一位
			while (tempCount > 1) {
				head = head.next;
				tempCount--;
			}
			head.next = head.next.next;//删掉某个节点 
			head = head.next;
			n--;
		}
		
		return head.val;
	}

}
