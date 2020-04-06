package com.mihoyo;

import java.util.*;

public class Solution {
    /**
     * 校验原字符串 s 是否匹配 规则 p
     * @param s string字符串 原字符串
     * @param p string字符串 匹配规则
     * @return bool布尔型
     * 样理："abcbc","a(bc)*c"  false
     *样理2："ac","a(bc)*c"  true
     *后来才看到下面还有备注：1）规则只包含a-z的小写字符串  2）括号一定成对出现且中间不能嵌套
     *3)输入串s和规则p都可能为空  （s为空如果规则带了*则可能为true）（p为空则s非空时均为false）
     */
	public static void main(String[] args) {
		//最麻烦的其实是()规则和*规则组合之后的使用。。
		//能否参考Stack匹配（）的方式？？先把s的内容全部入栈，再根据规则p一个个弹出
		//如果最后Stack为空则表明规则匹配成功
		
		//能否用递归的方法呢？？
	}
	
    public boolean Match (String s, String p) {
        // write code here
    	//参考使用Stack匹配括号的解法，如果最后Stack为空则表明规则匹配成功
    	//Java中使用LinkedList作为Stack使用，类型用String好了，可以一次弹出()字符集中的内容
    	//好像不行Stack的类型似乎还是得用Character，否则输入s没法进入
    	//后面发现顺序对齐FIFO的话不用Stack用Queue更好
    	LinkedList<Character> queue = new LinkedList<Character>();
    	
    	//规则p固定住不动，输入字符串s进栈
    	for (int i = 0; i < s.length(); i++) {
    		queue.add(s.charAt(i));
		}
    	
    	for (int i = 0; i < p.length(); i++) {
			if ('(' == p.charAt(i)) {//首先判断括号组的情况
				int endIndex = p.indexOf(')');//文中保证了()一定成对出现切不嵌套
				//返回第一次出现的下标
				//有了符号集之后还要判断后面是否跟了*
				
				if ((endIndex + 1 < p.length()) && ('*' == p.charAt(endIndex+1))) {
					for (int j = i+1; j < endIndex; j++) {
						//处理字符集后面加*的情况
						if (queue.removeFirst() != p.charAt(j)) {
							//发现任意规则不匹配直接返回false
							return false;
						}//但是做到这这个只是*中间内容出现一次的逻辑，如果出现0次或者多次要如何处理？
						//想到这里感觉部分思路有点问题，如果只使用这种线性推荐的思路不保留现场的话
						//对于*匹配多个字符集的情况没法回溯。。
						//考虑到回溯的话能否采用递归的解法呢？？
					}
					
				}
				
				i = endIndex + 1;	
			} else {
				//上面讨论过()情况后，后面是非字符集情况
				if ((i + 1 < p.length()) && ('*' == p.charAt(i+1))) {
					for (int j = i+1; j < p.length(); j++) {
						//处理字符集后面加*的情况
						if (queue.removeFirst() != p.charAt(j)) {
							//发现任意规则不匹配直接返回false
							return false;
						}
					}
					
				}
				
			}
			}
			
			
    	
    	
    	return queue.isEmpty();
    }
    
    
    
    
}