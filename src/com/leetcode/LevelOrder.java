package com.leetcode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;


public class LevelOrder {
	static int height = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> levelOrder2(TreeNode root) {
		//第二版根据参考python解法的改进版，去掉了中转队列，只使用了一个队列
    	if (null == root) {
    		return new ArrayList<List<Integer>>();
		}
    	
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        ArrayDeque<TreeNode> parentDeque = new ArrayDeque<TreeNode>();
        
        parentDeque.add(root);
        
        while (!parentDeque.isEmpty()) {
        	ArrayList<Integer> tempArrayList = new ArrayList<Integer>();
        	int queueSize = parentDeque.size();
        	
        	//后来反应过来不能把size加入for循环表达式中否则会随queue内容动态变化的，应该使用临时变量保存
//        	for (int i = 0; i < parentDeque.size(); i++) {
        	for (int i = 0; i < queueSize; i++) {
				TreeNode tempTreeNode = parentDeque.poll();
				//第一次这里忘记加入list的，返回值都是空的
				tempArrayList.add(tempTreeNode.val);
				if (null != tempTreeNode.left) {
					parentDeque.add(tempTreeNode.left);
				}
				if (null != tempTreeNode.right) {
					parentDeque.add(tempTreeNode.right);
				}	
			}
        	resultList.add(tempArrayList);
		}
    	
        return resultList;
	}

	public int levelOrder_findmin(TreeNode root) {
		//根据BFS使用队列按层遍历的算法进行了细微的修改
    	if (null == root) {
    		return 0;
		}
    	  	
    	int depth = 1;
        ArrayDeque<TreeNode> parentDeque = new ArrayDeque<TreeNode>();
        parentDeque.add(root);
        
        while (!parentDeque.isEmpty()) {
        	int queueSize = parentDeque.size();
        	boolean levelFlag = true;
        	//多设置了一个层标志位，用来保证每层只被统计1次
//        	depth++;

        	for (int i = 0; i < queueSize; i++) {
				TreeNode tempTreeNode = parentDeque.poll();
				
				if ((null != tempTreeNode.left)&&(null != tempTreeNode.right)) {
					return depth;
				}
				
				if (null != tempTreeNode.left) {
					parentDeque.add(tempTreeNode.left);
					if (levelFlag) {
						levelFlag = false;
						depth++;
					}
				}
				if (null != tempTreeNode.right) {
					parentDeque.add(tempTreeNode.right);
					if (levelFlag) {
						levelFlag = false;
						depth++;
					}
				}	
			}
		}
    	
        return depth;
	}
	
    public List<List<Integer>> levelOrder(TreeNode root) {
    	//初版效率很低的解法，时间11.74%空间5.33%
    	if (null == root) {
//			return null;
    		return new ArrayList<List<Integer>>();
		}
    	//第一次提交被空集特例给怼了。。
    	//input:[]  Output:null Except：[]
    	//好像不能直接返回空指针，需要返回一个空的ArrayList
    	
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        ArrayDeque<TreeNode> parentDeque = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> childDeque = new ArrayDeque<TreeNode>();
        
        parentDeque.add(root);
        
//        while ((!parentDeque.isEmpty())||(!childDeque.isEmpty())) 
        do{
        	ArrayList<Integer> tempArrayList = new ArrayList<Integer>();
			while (!parentDeque.isEmpty()) {
				TreeNode tempTreeNode = parentDeque.poll();
				tempArrayList.add(tempTreeNode.val);
				if (null != tempTreeNode.left) {
					childDeque.add(tempTreeNode.left);
				}
				if (null != tempTreeNode.right) {
					childDeque.add(tempTreeNode.right);
				}			
			}
        	resultList.add(tempArrayList);
        	
        	parentDeque.addAll(childDeque);
        	childDeque.clear();
        	
		}while(!parentDeque.isEmpty());
        
        
        return resultList;
    }

    public int depthFirstSearch(TreeNode root){
    	if (null == root) {
			return 0;
		}
    	
    	//对于图的情况这里需要创建一个set查重
    	
    	
    	return this.height;
    }
    
    public void dfs(TreeNode node){
    	if (null == node) {
			return;
		}
    	height++;
    	
    	if (null != node.left) {
			dfs(node.left);
		}
    	
    	if (null != node.right) {
			dfs(node.right);
		}
    }
    
    public int bfsFindMax(TreeNode root){
    	if (null == root) {
    		return 0;
		}
    	
    	int depth = 0;
        ArrayDeque<TreeNode> parentDeque = new ArrayDeque<TreeNode>();
        parentDeque.add(root);
        
        while (!parentDeque.isEmpty()) {
        	int queueSize = parentDeque.size();
        	//多设置了一个层标志位，用来保证每层只被统计1次
        	depth++;

        	for (int i = 0; i < queueSize; i++) {
				TreeNode tempTreeNode = parentDeque.poll();
				
				if (null != tempTreeNode.left) {
					parentDeque.add(tempTreeNode.left);
				}
				if (null != tempTreeNode.right) {
					parentDeque.add(tempTreeNode.right);
				}	
			}
		}
    	
        return depth; 	
    }
    
    
    /*python参考答案
     import collections
def levelOrder(self, root):
    if not root:
        return []
    # 注意到这里对空树的处理也是返回一个空的列表而不是直接返回null
    result = []
    queue = collections.deque
    queue.append(root)
    #visited = set(root)
    # 这个判重条件对于这里树的应用是不需要的，但是对于传统的BFS图遍历的话是必须的（否则会增加大量的重复操作）
    
    #老师建议下面这个标准BFS模板可以记下来
    while queue:
        level_size = len(queue)
        current_level = []
        for _ in range(level_size):
            # 第一次看到python中用这种空循环方式
            node = queue.popleft()  #这里应该就是从队头出，直接用pop不行吗？
            current_level.append(node.val)
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
        result.append(current_level)
    return result
      
     * **/

}

//class TreeNode {
//	     int val;
//	     TreeNode left;
//	      TreeNode right;
//	      TreeNode(int x) { val = x; }
//}

