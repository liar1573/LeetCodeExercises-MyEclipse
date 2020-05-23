/**PopulatingNextRightPointersinEachNode.java
 * com.leetcode.tree
 * TODO
 * LC116.将完全二叉树中所有节点设置一个next域，指向其第一个右兄弟节点（没有的指向null）
 * 
 * @author liar
 * 2020年5月22日 上午10:53:37
 * @version 1.0
 */
package com.leetcode.tree;


import java.util.LinkedList;


public class PopulatingNextRightPointersinEachNode {
	public static void main(String[] args) {
		PopulatingNextRightPointersinEachNode test = new PopulatingNextRightPointersinEachNode();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		test.connect(root);
		//System.out.println(test.letterCombinations("23"));
	
	}
	
	public Node connect(Node root) {
        if(root == null)
        	return null;
        
        LinkedList<Node> nodeList = new LinkedList<Node>();
        nodeList.add(root); 
        while (!nodeList.isEmpty()) {
			int levelNum = nodeList.size();
			boolean flag = !(nodeList.get(0).left == null);
			//flag用于判断下层还有没有节点，由于是完全树，只需判断一次即可
			//跟BFS类似的操作，先取每层节点数量
			for (int i = 0; i < levelNum - 1; i++){
				Node tempNode = nodeList.poll();
				tempNode.next = nodeList.peek();
				if(flag){
					nodeList.add(tempNode.left);
					nodeList.add(tempNode.right);
				}
			}
			//每层最后一个节点默认不操作，其next初始值就为空
			Node tempNode = nodeList.poll();
			if(flag){
				nodeList.add(tempNode.left);
				nodeList.add(tempNode.right);
			}
		}
        
        return root;
    }

	
	//BFS 作业1  代码非常简洁
	 public Node connectBFS1(Node root) {
	        
		 LinkedList<Node> q = new LinkedList<Node>();
	        q.offer(root);
	        
	        // BFS -- add in reverse order        
	        while (!q.isEmpty()) {
	            int len = q.size();
	            Node prev = null;            
	            for (int i = 0; i < len; i++) {                
	                Node curr = q.poll();	                
	                if (curr != null) {
	                    curr.next = prev;
	                    //这里指针是不是有点问题？？ 并没有
	                    //注意到这里的入队顺序非常巧妙，先右节点再左节点，这样前后顺序就有点倒过来了
	                    //同时还很巧妙的避免了最后一个节点额外讨论的尴尬，所以这种写法的代码量比自己的少了不少
	                    q.offer(curr.right);
	                    q.offer(curr.left);
	                    
	                    prev = curr;
	                }
	            }
	        }
	        return root;
	    }
	
	//DFS 作业1
	//这里的代码稍微复杂一些，不过感觉更好理解
	private Node connectDFS1(Node root) {
	    if (root == null) return root;
	    if (root.left == null && root.right == null) return root;
	    root.next = null; //这个赋值是多余的，初始默认next域都是空
	    recursive(root, root.next);
	    return root;
	}
	
	//这里把next，即指向第一个右兄弟节点的指针命名WienextParent感觉有点混淆。。
	private void recursive(Node current, Node nextParent) {
	    if(current.left != null) {
	        current.left.next = current.right; 
	        //如果有左孩子，左孩子的next一定指向右孩子这个很容易理解
	        if (nextParent != null) {
	        	//如果有右兄弟，则右孩子的next一定指向右兄弟的左孩子，这一步很妙
	            current.right.next = nextParent.left;
	        } else current.right.next = null;//这一步为next赋值null也是多余的
	    }
	    //感觉这里递归算法的精髓是同时把当前节点和当前节点右兄弟节点的指针传入了，使得操作方便了很多
	    //之前在印象中总是感觉右兄弟跟当前节点处于同一层没办法简单取出，现在看来并不是这样
	    
	    if (current.left != null && current.left.left != null) {
	        // Still has nodes to connect.
	    	//判断有二重子节点，即孙子节点
	        recursive(current.left, current.right);
	        if (nextParent != null) 
	        	recursive(current.right, nextParent.left);
	        else 
	        	recursive(current.right, null);
	    }
	} 

	//DFS 作业2
	//这里的DFS代码非常简洁，但是个人感觉不太好理解
	  public static Node connectDFS2(Node root) {
		  //本题对于空树和单根节点树情况都整合到了一起，代码非常简洁
	        connectInner(root, null);
	        return root;
	    }
	     
    public static void connectInner(Node root, Node next){
    	//递归到节点为空时返回
        if(root == null){
            return;
        }
        
        root.next = next;
        connectInner(root.left, root.right);
        
        if(next != null){
            connectInner(root.right, next.left);
        }
        else{
            connectInner(root.right, null);
        }
    }

}

//注意到这里使用了额外的Node结构来定义完全二叉树的节点
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};