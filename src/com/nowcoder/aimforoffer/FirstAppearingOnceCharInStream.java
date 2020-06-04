/**FirstAppearingOnceCharInStream.java
 * com.nowcoder.aimforoffer
 * TODO
 * ��ָ-��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ���
 * @author liar
 * 2020��6��4�� ����10:33:23
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
	
	//ʹ��int[]��ʾ��ϣ��ķ���
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
