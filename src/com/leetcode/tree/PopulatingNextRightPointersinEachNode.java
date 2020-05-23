/**PopulatingNextRightPointersinEachNode.java
 * com.leetcode.tree
 * TODO
 * LC116.����ȫ�����������нڵ�����һ��next��ָ�����һ�����ֵܽڵ㣨û�е�ָ��null��
 * 
 * @author liar
 * 2020��5��22�� ����10:53:37
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
			//flag�����ж��²㻹��û�нڵ㣬��������ȫ����ֻ���ж�һ�μ���
			//��BFS���ƵĲ�������ȡÿ��ڵ�����
			for (int i = 0; i < levelNum - 1; i++){
				Node tempNode = nodeList.poll();
				tempNode.next = nodeList.peek();
				if(flag){
					nodeList.add(tempNode.left);
					nodeList.add(tempNode.right);
				}
			}
			//ÿ�����һ���ڵ�Ĭ�ϲ���������next��ʼֵ��Ϊ��
			Node tempNode = nodeList.poll();
			if(flag){
				nodeList.add(tempNode.left);
				nodeList.add(tempNode.right);
			}
		}
        
        return root;
    }

	
	//BFS ��ҵ1  ����ǳ����
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
	                    //����ָ���ǲ����е����⣿�� ��û��
	                    //ע�⵽��������˳��ǳ�������ҽڵ�����ڵ㣬����ǰ��˳����е㵹������
	                    //ͬʱ��������ı��������һ���ڵ�������۵����Σ���������д���Ĵ��������Լ������˲���
	                    q.offer(curr.right);
	                    q.offer(curr.left);
	                    
	                    prev = curr;
	                }
	            }
	        }
	        return root;
	    }
	
	//DFS ��ҵ1
	//����Ĵ�����΢����һЩ�������о��������
	private Node connectDFS1(Node root) {
	    if (root == null) return root;
	    if (root.left == null && root.right == null) return root;
	    root.next = null; //�����ֵ�Ƕ���ģ���ʼĬ��next���ǿ�
	    recursive(root, root.next);
	    return root;
	}
	
	//�����next����ָ���һ�����ֵܽڵ��ָ������WienextParent�о��е��������
	private void recursive(Node current, Node nextParent) {
	    if(current.left != null) {
	        current.left.next = current.right; 
	        //��������ӣ����ӵ�nextһ��ָ���Һ���������������
	        if (nextParent != null) {
	        	//��������ֵܣ����Һ��ӵ�nextһ��ָ�����ֵܵ����ӣ���һ������
	            current.right.next = nextParent.left;
	        } else current.right.next = null;//��һ��Ϊnext��ֵnullҲ�Ƕ����
	    }
	    //�о�����ݹ��㷨�ľ�����ͬʱ�ѵ�ǰ�ڵ�͵�ǰ�ڵ����ֵܽڵ��ָ�봫���ˣ�ʹ�ò��������˺ܶ�
	    //֮ǰ��ӡ�������Ǹо����ֵܸ���ǰ�ڵ㴦��ͬһ��û�취��ȡ�������ڿ�������������
	    
	    if (current.left != null && current.left.left != null) {
	        // Still has nodes to connect.
	    	//�ж��ж����ӽڵ㣬�����ӽڵ�
	        recursive(current.left, current.right);
	        if (nextParent != null) 
	        	recursive(current.right, nextParent.left);
	        else 
	        	recursive(current.right, null);
	    }
	} 

	//DFS ��ҵ2
	//�����DFS����ǳ���࣬���Ǹ��˸о���̫�����
	  public static Node connectDFS2(Node root) {
		  //������ڿ����͵����ڵ�����������ϵ���һ�𣬴���ǳ����
	        connectInner(root, null);
	        return root;
	    }
	     
    public static void connectInner(Node root, Node next){
    	//�ݹ鵽�ڵ�Ϊ��ʱ����
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

//ע�⵽����ʹ���˶����Node�ṹ��������ȫ�������Ľڵ�
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