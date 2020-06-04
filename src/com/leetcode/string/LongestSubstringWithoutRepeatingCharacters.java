/**LongestSubstringWithoutRepeatingCharacters.java
 * com.leetcode.string
 * TODO
 * LC3.求字符串中最长非重复字符的子串的长度
 * @author liar
 * 2020年6月3日 下午9:17:20
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
		//试了下好像光有set还不够，还需要一个list。。
		//示例算法中并没有使用list，而是使用头尾双指针移动来表示list
		int start = 0, end = 1; 
		while ( end < s.length()) {
			//if(set.contains(s.charAt(i)))
			if(set.contains(s.charAt(end))){
				//第一次这里空for操作没有带分号造成了无限循环
				for(;s.charAt(start) != s.charAt(end);start++)
					set.remove(s.charAt(start)); //同时这里还需要把之前set中的元素删掉一部分
				set.remove(s.charAt(start++));
			}else {  //这里结果虽然是对的，不过set、指针的操作逻辑看起来非常乱。。。
				set.add(s.charAt(end));
				result = (end - start + 1)  > result ? end - start + 1: result;
				end++;
			}
		}
		
		return result;
    }
	
	    public int lengthOfLongestSubstringExample1(String s) {
	    	//来自LC英文的解法2，中文版那个指针移动看着总觉得怪怪的。。
	        int n = s.length();
	        Set<Character> set = new HashSet<>();
	        int ans = 0, i = 0, j = 0;
	        while (i < n && j < n) {
	        	//这里指针移动、窗口移动、Set数据增减看起来思路逻辑就非常清晰
	            // try to extend the range [i, j]
	            if (!set.contains(s.charAt(j))){
	                set.add(s.charAt(j++));
	                ans = Math.max(ans, j - i);
	            }
	            else {//可以注意到这里的处理是一次while中只移除set中的一个字符
	            	//这样效率可能会稍低一点，但是代码逻辑非常清晰
	                set.remove(s.charAt(i++));
	                //之前自己在while中又加了一个for循环，想更快的删除set中多余的字符，不过整体逻辑看起来就很乱
	            }
	        }
	        return ans;
	    }

	    public int lengthOfLongestSubstringArrayMap(String s) {
	        int n = s.length(), ans = 0;
	        int[] index = new int[128]; // current index of character
	        //注意到题目给的注释，128是ASCII的编码数量，对于绝大部分常见字符编码都是够用的
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
	        //注意到key是字符，value是下标
	        // try to extend the range [i, j]
	        for (int j = 0, i = 0; j < n; j++) {
	            if (map.containsKey(s.charAt(j))) {
	                i = Math.max(map.get(s.charAt(j)), i);
	                //注意到这里很巧妙的点是并没有把重复字符从Map中删掉，而只是查到重复元素的位置后更新指针i
	            }
	            ans = Math.max(ans, j - i + 1);
	            map.put(s.charAt(j), j + 1);//这里字符j的坐标为什么要放j+1呢？
	            //原来是为了在map.containsKey(s.charAt(j))情况下取出i的时候可以少做一次加法
	            //其实如果这里放j，前面出现重复字母计算i的时候额外加上1就可以了
	        }
	        return ans;
	    }

}
