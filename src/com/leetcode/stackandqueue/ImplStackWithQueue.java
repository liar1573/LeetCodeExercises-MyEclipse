/**ImplStackWithQueue.java
 * com.leetcode.stackandqueue
 * TODO
 * 复习LC225使用队列实现栈
 * @author liar
 * 2020年5月3日 下午3:54:26
 * @version 1.0
 */
package com.leetcode.stackandqueue;

import java.util.LinkedList;

public class ImplStackWithQueue {

}

class MyStack {
	private LinkedList<Integer> queue;
	
    /** Initialize your data structure here. */
    public MyStack() {
        this.queue = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
			int temp = queue.poll();
			queue.offer(temp);
		}
        return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
    	int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
			int temp = queue.poll();
			queue.offer(temp);
		}
        int result = queue.poll();
        queue.offer(result);
        //被debug报错一次之后发现这里应该要与poll采取不一样的操作
        //这里peek之后要恢复现场，否则后面一次再操作会出问题
        return result;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

