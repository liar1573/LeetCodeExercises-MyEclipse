/**ReplacingSpace.java
 * com.nowcoder.aimforoffer
 * TODO
 * 2.将字符串中的空格替换为"%20"
 * 参数格式为StringBuilder
 * @author liar
 * 2020年5月25日 下午8:54:31
 * @version 1.0
 */
package com.nowcoder.aimforoffer;

/**
 * @author liar
 *
 */
public class ReplacingSpace {
	public String replaceSpace(StringBuffer str) {
    	
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ' '){
				str.replace(i, i+1, "%20");//由于空格占了一个位置，i+1肯定不会越界的
				i += 2;//注意要对应sb长度的增加
			}
		}
			
		return str.toString();
    }
}
