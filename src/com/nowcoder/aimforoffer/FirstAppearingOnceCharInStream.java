/**FirstAppearingOnceCharInStream.java
 * com.nowcoder.aimforoffer
 * TODO
 * 剑指-请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * @author liar
 * 2020年6月4日 上午10:33:23
 * @version 1.0
 */
package com.nowcoder.aimforoffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FirstAppearingOnceCharInStream {
	private Set<Character> set= new HashSet<Character>();
	private List<Character> list = new ArrayList<Character>();
	
	//使用int[]表示哈希表的方法
	private StringBuilder sb = new StringBuilder();
	private int[] hash = new int[256]; 
	
	public static void main(String[] args) {
		FirstAppearingOnceCharInStream test = new FirstAppearingOnceCharInStream();
		String str = "google";
		for (int i = 0; i < str.length(); i++) {
			test.Insert(str.charAt(i));
			System.out.println(test.FirstAppearingOnce());
		}
		
	}
	
	
	//Insert one char from stringstream
    public void Insert(char ch){
    	
        if (this.set.contains(ch)) {
        	while (list.contains(ch))
        		list.remove(new Character(ch));
		} else {
			set.add(ch);
			list.add(ch);
		}
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
    	if (list.isEmpty()) {
			return '#';
		} else {
			return list.get(0);
		}
    }
    
    
  //Insert one char from stringstream
    public void InsertExample(char ch){
    	sb.append(ch);
    	hash[ch]++;
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnceExample(){
    	for (int i = 0; i < sb.length(); i++) {
			if(hash[sb.charAt(i)] == 1)
				return sb.charAt(i);
		}
    	
    	return '#';
    }
}
