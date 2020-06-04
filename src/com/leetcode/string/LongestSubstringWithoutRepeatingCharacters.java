/**LongestSubstringWithoutRepeatingCharacters.java
 * com.leetcode.string
 * TODO
 * LC3.���ַ���������ظ��ַ����Ӵ��ĳ���
 * @author liar
 * 2020��6��3�� ����9:17:20
 * @version 1.0
 */
package com.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}
	
	public static int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0)
			return 0;
		
		int result = 1;
		HashSet<Character> set = new HashSet<Character>();
		set.add(s.charAt(0));
		//�����º������set������������Ҫһ��list����
		//ʾ���㷨�в�û��ʹ��list������ʹ��ͷβ˫ָ���ƶ�����ʾlist
		int start = 0, end = 1; 
		while ( end < s.length()) {
			//if(set.contains(s.charAt(i)))
			if(set.contains(s.charAt(end))){
				//��һ�������for����û�д��ֺ����������ѭ��
				for(;s.charAt(start) != s.charAt(end);start++)
					set.remove(s.charAt(start)); //ͬʱ���ﻹ��Ҫ��֮ǰset�е�Ԫ��ɾ��һ����
				set.remove(s.charAt(start++));
			}else {  //��������Ȼ�ǶԵģ�����set��ָ��Ĳ����߼��������ǳ��ҡ�����
				set.add(s.charAt(end));
				result = (end - start + 1)  > result ? end - start + 1: result;
				end++;
			}
		}
		
		return result;
    }
	
	    public int lengthOfLongestSubstringExample1(String s) {
	    	//����LCӢ�ĵĽⷨ2�����İ��Ǹ�ָ���ƶ������ܾ��ùֵֹġ���
	        int n = s.length();
	        Set<Character> set = new HashSet<>();
	        int ans = 0, i = 0, j = 0;
	        while (i < n && j < n) {
	        	//����ָ���ƶ��������ƶ���Set��������������˼·�߼��ͷǳ�����
	            // try to extend the range [i, j]
	            if (!set.contains(s.charAt(j))){
	                set.add(s.charAt(j++));
	                ans = Math.max(ans, j - i);
	            }
	            else {//����ע�⵽����Ĵ�����һ��while��ֻ�Ƴ�set�е�һ���ַ�
	            	//����Ч�ʿ��ܻ��Ե�һ�㣬���Ǵ����߼��ǳ�����
	                set.remove(s.charAt(i++));
	                //֮ǰ�Լ���while���ּ���һ��forѭ����������ɾ��set�ж�����ַ������������߼��������ͺ���
	            }
	        }
	        return ans;
	    }

	    public int lengthOfLongestSubstringArrayMap(String s) {
	        int n = s.length(), ans = 0;
	        int[] index = new int[128]; // current index of character
	        //ע�⵽��Ŀ����ע�ͣ�128��ASCII�ı������������ھ��󲿷ֳ����ַ����붼�ǹ��õ�
	        // try to extend the range [i, j]
	        for (int j = 0, i = 0; j < n; j++) {
	            i = Math.max(index[s.charAt(j)], i);
	            ans = Math.max(ans, j - i + 1);
	            index[s.charAt(j)] = j + 1;
	        }
	        return ans;
	    }
	    
	    public int lengthOfLongestSubstringHashMap(String s) {
	        int n = s.length(), ans = 0;
	        Map<Character, Integer> map = new HashMap<>(); // current index of character
	        //ע�⵽key���ַ���value���±�
	        // try to extend the range [i, j]
	        for (int j = 0, i = 0; j < n; j++) {
	            if (map.containsKey(s.charAt(j))) {
	                i = Math.max(map.get(s.charAt(j)), i);
	                //ע�⵽���������ĵ��ǲ�û�а��ظ��ַ���Map��ɾ������ֻ�ǲ鵽�ظ�Ԫ�ص�λ�ú����ָ��i
	            }
	            ans = Math.max(ans, j - i + 1);
	            map.put(s.charAt(j), j + 1);//�����ַ�j������ΪʲôҪ��j+1�أ�
	            //ԭ����Ϊ����map.containsKey(s.charAt(j))�����ȡ��i��ʱ���������һ�μӷ�
	            //��ʵ��������j��ǰ������ظ���ĸ����i��ʱ��������1�Ϳ�����
	        }
	        return ans;
	    }

}
