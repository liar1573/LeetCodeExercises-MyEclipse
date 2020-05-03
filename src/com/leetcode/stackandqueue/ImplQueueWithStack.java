/**ImplQueueWithStack.java
 * com.leetcode.stackandqueue
 * TODO
 * ��ϰLC232ʹ��ջʵ�ֶ���
 * @author liar
 * 2020��5��3�� ����3:01:35
 * @version 1.0
 */
package com.leetcode.stackandqueue;

import java.util.LinkedList;

public class ImplQueueWithStack {

}

class MyQueue {
	private LinkedList<Integer> s1;
	private LinkedList<Integer> s2;
	
    /** Initialize your data structure here. */
    public MyQueue() {
        this.s1 = new LinkedList<Integer>();
        this.s2 = new LinkedList<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        this.s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!s2.isEmpty()){
        	return s2.pop();
        } else {
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
			return s2.pop();
		}   
    }
    
    /** Get the front element. */
    public int peek() {
    	if(!s2.isEmpty()){
        	return s2.peek();
        } else {
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
			return s2.peek();
		}   
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        //return (s1.isEmpty() || s2.isEmpty());
    	//ע�⵽����һ��ʼ����ˣ���Ӧ���ǻ��Ҫ����
        return (s1.isEmpty() && s2.isEmpty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
