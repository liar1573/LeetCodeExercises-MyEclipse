package com.mihoyo;

import java.util.*;

public class Solution {
    /**
     * У��ԭ�ַ��� s �Ƿ�ƥ�� ���� p
     * @param s string�ַ��� ԭ�ַ���
     * @param p string�ַ��� ƥ�����
     * @return bool������
     * ����"abcbc","a(bc)*c"  false
     *����2��"ac","a(bc)*c"  true
     *�����ſ������滹�б�ע��1������ֻ����a-z��Сд�ַ���  2������һ���ɶԳ������м䲻��Ƕ��
     *3)���봮s�͹���p������Ϊ��  ��sΪ������������*�����Ϊtrue����pΪ����s�ǿ�ʱ��Ϊfalse��
     */
	public static void main(String[] args) {
		//���鷳����ʵ��()�����*�������֮���ʹ�á���
		//�ܷ�ο�Stackƥ�䣨���ķ�ʽ�����Ȱ�s������ȫ����ջ���ٸ��ݹ���pһ��������
		//������StackΪ�����������ƥ��ɹ�
		
		//�ܷ��õݹ�ķ����أ���
	}
	
    public boolean Match (String s, String p) {
        // write code here
    	//�ο�ʹ��Stackƥ�����ŵĽⷨ��������StackΪ�����������ƥ��ɹ�
    	//Java��ʹ��LinkedList��ΪStackʹ�ã�������String���ˣ�����һ�ε���()�ַ����е�����
    	//������Stack�������ƺ����ǵ���Character����������sû������
    	//���淢��˳�����FIFO�Ļ�����Stack��Queue����
    	LinkedList<Character> queue = new LinkedList<Character>();
    	
    	//����p�̶�ס�����������ַ���s��ջ
    	for (int i = 0; i < s.length(); i++) {
    		queue.add(s.charAt(i));
		}
    	
    	for (int i = 0; i < p.length(); i++) {
			if ('(' == p.charAt(i)) {//�����ж�����������
				int endIndex = p.indexOf(')');//���б�֤��()һ���ɶԳ����в�Ƕ��
				//���ص�һ�γ��ֵ��±�
				//���˷��ż�֮��Ҫ�жϺ����Ƿ����*
				
				if ((endIndex + 1 < p.length()) && ('*' == p.charAt(endIndex+1))) {
					for (int j = i+1; j < endIndex; j++) {
						//�����ַ��������*�����
						if (queue.removeFirst() != p.charAt(j)) {
							//�����������ƥ��ֱ�ӷ���false
							return false;
						}//�������������ֻ��*�м����ݳ���һ�ε��߼����������0�λ��߶��Ҫ��δ���
						//�뵽����о�����˼·�е����⣬���ֻʹ�����������Ƽ���˼·�������ֳ��Ļ�
						//����*ƥ�����ַ��������û�����ݡ���
						//���ǵ����ݵĻ��ܷ���õݹ�Ľⷨ�أ���
					}
					
				}
				
				i = endIndex + 1;	
			} else {
				//�������۹�()����󣬺����Ƿ��ַ������
				if ((i + 1 < p.length()) && ('*' == p.charAt(i+1))) {
					for (int j = i+1; j < p.length(); j++) {
						//�����ַ��������*�����
						if (queue.removeFirst() != p.charAt(j)) {
							//�����������ƥ��ֱ�ӷ���false
							return false;
						}
					}
					
				}
				
			}
			}
			
			
    	
    	
    	return queue.isEmpty();
    }
    
    
    
    
}