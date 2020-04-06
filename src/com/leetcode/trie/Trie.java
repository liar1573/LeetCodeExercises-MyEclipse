/**Trie.java
 * com.leetcode.trie
 * LC 208  ����һ���ֵ���������ֻ��Сд��ĸ������Ҫʵ��insert��search��startWith����
 * @author liar
 * 2020��4��2�� ����8:19:24
 * @version 1.0
 */
package com.leetcode.trie;


public class Trie {
	private TrieNode root;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie testTrie = new Trie();
		testTrie.insertAddress("138", "beijing");
		System.out.println(testTrie.searchAddress("1387169"));
		System.out.println(testTrie.searchAddress("137169"));
		System.out.println(testTrie.searchAddress("13"));
		System.out.println(testTrie.searchAddress("1"));
		System.out.println(testTrie.searchAddress(""));
	}

	public Trie() {
		root = new TrieNode();
		root.val = ' ';//����ֵ�����һ���ո��ȥ
	}
	
	public void insert(String number) {
		TrieNode ws = root;
		for (int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
			if(ws.children[c - '0'] == null){
				ws.children[c - '0'] = new TrieNode(c);
			}
			ws = ws.children[c - '0'];
		}
		ws.isEnd = true;
	}

	public void insertAddress(String number, String address) {
		TrieNode ws = root;
		for (int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
			if(ws.children[c - '0'] == null){
				ws.children[c - '0'] = new TrieNode(c);
			}
			ws = ws.children[c - '0'];
		}
		ws.isEnd = true;
		ws.address = address;
	}
	
	public String searchAddress(String number) {
		TrieNode ws= root;
		for (int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
			if (ws.children[c - '0'] == null && !ws.isEnd) {
				return "nowhere";
			}
			if (ws.children[c - '0'] == null && ws.isEnd) {
				return ws.address;
			}//����ж��߼�����д��һ�£���֪���᲻�������⡣��
			//����д��һ����������������û���⣬��֪���᲻���������������û�п��ǵ�
			ws = ws.children[c - '0'];
		}
		
		return "nowhere";
	}
	
	public boolean search(String number) {
		TrieNode ws= root;
		for (int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
			if (ws.children[c - '0'] == null) {
				return false;
			}
			ws = ws.children[c - '0'];
		}
		return ws.isEnd;
	}//�����ⷢ���и��鷳�ĵط�������ַǰ׺λ���ǲ�ȷ���ģ����Ժ�����ֺ��޷�ȷ�����ļ�λȥ���в���
	//�ܷ��search��һЩ�޸ģ�ֱ�Ӱ�����������ֶ��ͽ�ȥ�����أ������ǰ��Trie�в��ҵ�null��ֱ�ӷ���nowhere
	//���ж�ָ���Ƿ�Ϊnull��ͬʱ���϶�isEnd���жϣ����Ϊnull��ͬʱisEndΪ���򷵻ض�Ӧ�Ĺ���
	//���Ϊnull����isEnd�Ǽ��򷵻�nowhere
	//ͬʱTrieNode��Ҫ��һ���ֶ�String address��ֻ����isEndΪtrue��ʱ����и�ֵ������Ϊnull
}

class TrieNode{
	public char val; //���������ζ��ó�public�˲�֪���᲻�������⡣��
	public boolean isEnd;
	public TrieNode[] children = new TrieNode[10];//��������ǵ绰����ǰ׺10�����־͹�����
	String address; //ͬʱTrieNode��Ҫ��һ���ֶ�String address��ֻ����isEndΪtrue��ʱ����и�ֵ������Ϊnull
	//����ֶ��ظ����ֲ�֪���ռ临�ӶȻ᲻��̫���ˡ���
	public TrieNode() {}
	TrieNode(char c){
		TrieNode node = new TrieNode();
		node.val = c;
	}
}