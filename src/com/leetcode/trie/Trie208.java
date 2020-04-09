/**Trie208.java
 * com.leetcode.trie
 * LC 208  ����һ���ֵ���������ֻ��Сд��ĸ������Ҫʵ��insert��search��startWith����
 * �Լ�����Trie����ĿҪ����΢�ع���һ��ԭ���ıʼǣ�����д��һ���ֵ�����ʵ�֣�һ��ͨ��
 * ��ͬʱͨ�����Ի�ɾȥ��ʾ�������в���Ҫ���ֶΣ���΢�����Ч�ʣ�
 * @author liar
 * 2020��4��9�� ����10:53:27
 * @version 1.0
 */
package com.leetcode.trie;


public class Trie208 {
	private TrieNode root;
	
	public Trie208() {
        this.root = new TrieNode();
    }
	
	public void insert(String word){
		TrieNode node = this.root;
		for (int i = 0; i < word.length(); i++) {
			//ע��ʵ��ϸ�ڣ�ʾ����������ʱ������ȡ��word.charAt(i)ʹ��������һЩ
			char tempChar = word.charAt(i);
			//ͬʱע����������һ������Ҫ�Ķ�Ӧchildren�ڵ��Ƿ�Ϊ�յ��ж�
			//Ϊ��ʱ����Ҫnew������ֱ�ӽ�����ǰ���ɵĽڵ�
			//�������null�ж�һֱnew�Ļ��ᵼ����ǰ����ڵ��е���Ϣ��ʧ
			if (node.children[tempChar - 'a'] == null) {
				node.children[tempChar - 'a'] = new TrieNode();
				//��֮ǰ��ʾ����ͬ������ڵ�ֱ��ʹ���޲ι��쿴���᲻��������
				//��������ûӰ��ģ���ΪTrie����Ϣֻ����ڱ߹�ϵ��
			}			
			node = node.children[tempChar - 'a'];
		}
		node.isEnd = true;
	}
	
	public boolean search(String word){
		TrieNode node = this.root;
		for (int i = 0; i < word.length(); i++) {
			char tempChar = word.charAt(i);
			if (node.children[tempChar - 'a'] != null) {
				node = node.children[tempChar - 'a'];
			} else {
				//break;//������ʵ����break,ֱ�ӷ���false����
				return false;
			}
		}
		
		return node.isEnd;
	}
	
	public boolean startWith(String word) {
		TrieNode node = this.root;
		for (int i = 0; i < word.length(); i++) {
			char tempChar = word.charAt(i);
			if (node.children[tempChar - 'a'] != null) {
				node = node.children[tempChar - 'a'];
			} else {
				//break;//������ʵ����break,ֱ�ӷ���false����
				return false;
			}
		}
		//startWith�����о�����ʵ��Ӧ�þͿ����˰ɣ�ǰ�漸�����ҵ��ˣ�û����for��ֱ���˳�
		return true;
	}
}

//����ͬ�����ͻ����ʱע�͵�
//class TrieNode{//�ֵ����ڵ���
//	private final int NUM = 26;//�ֵ����ڵ���ֵ��ַ�������
//	//֮ǰ��������10����10�����֣���λ���Сд��ĸ����
//	TrieNode[] children = new TrieNode[NUM];
//	//��һ���Լ�д��ʱ��������isEnd�����־
//	boolean isEnd = false;
//	//����Ӧ�û���������һ��ֵ��������isEndΪtrue��ʱ��洢���ݣ����������Ǳ����
//	//String infor = null;
//	//���֮ǰ��ʦ�ᵽ��Trie�ڵ㱾���洢���ݣ����Ǳ߹�ϵ������Ϣ�����б�Ҫ�����������ֶ���
//	//public char val;
//	
//	//ͨ�����Է��ֹ�ȻLC 208�ǲ���Ҫchar�ֶεģ�ֱ������ͨ��
//	public TrieNode(){	}
//		
//}
