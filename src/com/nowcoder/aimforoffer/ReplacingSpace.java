/**ReplacingSpace.java
 * com.nowcoder.aimforoffer
 * TODO
 * 2.���ַ����еĿո��滻Ϊ"%20"
 * ������ʽΪStringBuilder
 * @author liar
 * 2020��5��25�� ����8:54:31
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
				str.replace(i, i+1, "%20");//���ڿո�ռ��һ��λ�ã�i+1�϶�����Խ���
				i += 2;//ע��Ҫ��Ӧsb���ȵ�����
			}
		}
			
		return str.toString();
    }
}
