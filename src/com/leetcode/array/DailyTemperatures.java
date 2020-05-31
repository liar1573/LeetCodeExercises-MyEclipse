/**DailyTemperatures.java
 * com.leetcode.array
 * TODO
 * LC 739
 * @author liar
 * 2020��5��31�� ����9:57:43
 * @version 1.0
 */
package com.leetcode.array;

import java.util.Arrays;
import java.util.LinkedList;

public class DailyTemperatures {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] dailyTemperatures(int[] T) {
        if(T == null)	return null;
		int len = T.length;
        int[] result = new int[len];
		if(len == 0)	return result;
		
		LinkedList<Integer> stack = new LinkedList<Integer>();
		stack.push(len-1);
		
		for (int i = len - 2; i >= 0; i--) {
			if(T[i] < T[stack.peek()]){
				result[i] = stack.peek() - i;
				stack.push(i);
			}else { // ������ںʹ��ڵ��������ͬ������
				while (!stack.isEmpty() && T[i] >= T[stack.peek()]) 
					stack.pop();
				//����result[i]=0 ���ǳ�ʼֵ��ʵ���Բ���Ҫ�������
				//����������һ�������֧����һ������0����Ҫ�������ж�
				if(!stack.isEmpty())
					result[i] = stack.peek() - i;
				stack.push(i);
			}
		}
		
		return result;
    }
	
	public int[] dailyTemperaturesBF(int[] T) {
		//����for�ı����ⷨ
		if(T == null)	return null;
		int len = T.length;
        int[] result = new int[len];
		if(len == 0)	return result;
		
		for (int i = 0; i < len - 1; i++) 
			for (int j = i + 1; j < len; j++) 
				if(T[j] > T[i]){
					result[i] = j - i;
					break;
				}		

		return result;
	}
	
	//�ٷ��ⷨ���ǳ���࣬����˼·�����е㲻̫���뵽����
//	public int[] dailyTemperatures(int[] T) {
//        int[] ans = new int[T.length];
//        Stack<Integer> stack = new Stack();
//        for (int i = T.length - 1; i >= 0; --i) {
//            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) stack.pop();
//            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
//            stack.push(i);
//        }
//        return ans;
//    }
	
	//�ٷ��Ĺ�ϣ��ⷨ
	public int[] dailyTemperaturesHashTable(int[] T) {
        int[] ans = new int[T.length];
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);
        //��ʵ����ĸ���ʼֵ��T�ĳ�����΢��һЩ���У���һ��Ҫ��max-int
        for (int i = T.length - 1; i >= 0; --i) {
            int warmer_index = Integer.MAX_VALUE;
            for (int t = T[i] + 1; t <= 100; ++t) {
            	//ע�⵽���ﱾ����Ҳ������forѭ����ֻ�����ڲ�ĳ���Ϊ���W�������㶼��N���ӶȽ��˺ܶ�
                if (next[t] < warmer_index)
                    warmer_index = next[t];
            }
            if (warmer_index < Integer.MAX_VALUE)
                ans[i] = warmer_index - i;
            next[T[i]] = i;
        }
        return ans;
    }

	
}
