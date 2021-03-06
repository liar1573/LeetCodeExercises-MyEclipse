/**Trie.java
 * com.leetcode.trie
 * LC 208  构建一棵字典树（内容只有小写字母），需要实现insert、search和startWith方法
 * 根据电话号码归属地问题对TrieNode结构进行了一定的修改，添加了String address字段
 * 该字段在isEnd为真时进行赋值，初步测试结果正常
 * @author liar
 * 2020年4月2日 下午8:19:24
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
		root.val = ' ';//根的值域放了一个空格进去
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
			}//这个判断逻辑大致写了一下，不知道会不会有问题。。
			//随意写了一两个测试用例发现没问题，不知道会不会有其他特殊情况没有考虑到
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
	}//做到这发现有个麻烦的地方，即地址前缀位数是不确定的，测试号码出现后无法确认用哪几位去进行查找
	//能否对search做一些修改，直接把整体测试数字都送进去查找呢？如果提前在Trie中查找到null就直接返回nowhere
	//在判断指针是否为null的同时加上对isEnd的判断，如果为null的同时isEnd为真则返回对应的规则
	//如果为null但是isEnd是假则返回nowhere
	//同时TrieNode需要加一个字段String address，只有在isEnd为true的时候才有赋值，否则为null
	
	public boolean startWith(String word) {
		TrieNode node = this.root;
		for (int i = 0; i < word.length(); i++) {
			char tempChar = word.charAt(i);
			if (node.children[tempChar - 'a'] != null) {
				node = node.children[tempChar - 'a'];
			} else {
				//break;//这里其实比起break,直接返回false更快
				return false;
			}
		}
		//startWith方法感觉这样实现应该就可以了吧，前面几个都找到了，没有在for中直接退出
		return true;
	}
	
}

class TrieNode{
	public char val; //这里域修饰都用成public了不知道会不会有问题。。
	public boolean isEnd;
	public TrieNode[] children = new TrieNode[10];//由于这次是电话号码前缀10个数字就够用了
	String address; //同时TrieNode需要加一个字段String address，只有在isEnd为true的时候才有赋值，否则为null
	//这个字段重复出现不知道空间复杂度会不会太高了。。
	public TrieNode() {}
	TrieNode(char c){
		TrieNode node = new TrieNode();
		node.val = c;
	}
}