/**Trie208.java
 * com.leetcode.trie
 * LC 208  构建一棵字典树（内容只有小写字母），需要实现insert、search和startWith方法
 * 自己根据Trie和题目要求（稍微回顾了一下原来的笔记）重新写了一下字典树的实现，一遍通过
 * （同时通过尝试还删去了示例代码中不必要的字段，略微提高了效率）
 * @author liar
 * 2020年4月9日 上午10:53:27
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
			//注意实现细节，示例中用了临时变量来取代word.charAt(i)使代码更简洁一些
			char tempChar = word.charAt(i);
			//同时注意这里少了一个很重要的对应children节点是否为空的判断
			//为空时才需要new，否则直接接用以前生成的节点
			//如果不加null判断一直new的话会导致以前存入节点中的信息丢失
			if (node.children[tempChar - 'a'] == null) {
				node.children[tempChar - 'a'] = new TrieNode();
				//与之前的示例不同，这里节点直接使用无参构造看看会不会有问题
				//理论上是没影响的，因为Trie的信息只存放在边关系中
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
				//break;//这里其实比起break,直接返回false更快
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
				//break;//这里其实比起break,直接返回false更快
				return false;
			}
		}
		//startWith方法感觉这样实现应该就可以了吧，前面几个都找到了，没有在for中直接退出
		return true;
	}
}

//包内同名类冲突了暂时注释掉
//class TrieNode{//字典树节点类
//	private final int NUM = 26;//字典树节点出现的字符总数量
//	//之前的数量是10对于10个数字，这次换成小写字母好了
//	TrieNode[] children = new TrieNode[NUM];
//	//第一次自己写的时候差点忘了isEnd这个标志
//	boolean isEnd = false;
//	//这里应该还可以设置一个值域，用于在isEnd为true的时候存储数据，不过并不是必须的
//	//String infor = null;
//	//如果之前老师提到了Trie节点本身不存储数据，而是边关系包含信息，还有必要设置其他的字段吗？
//	//public char val;
//	
//	//通过尝试发现果然LC 208是不需要char字段的，直接运行通过
//	public TrieNode(){	}
//		
//}
