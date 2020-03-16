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
		//�ڶ�����ݲο�python�ⷨ�ĸĽ��棬ȥ������ת���У�ֻʹ����һ������
    	if (null == root) {
    		return new ArrayList<List<Integer>>();
		}
    	
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        ArrayDeque<TreeNode> parentDeque = new ArrayDeque<TreeNode>();
        
        parentDeque.add(root);
        
        while (!parentDeque.isEmpty()) {
        	ArrayList<Integer> tempArrayList = new ArrayList<Integer>();
        	int queueSize = parentDeque.size();
        	
        	//������Ӧ�������ܰ�size����forѭ�����ʽ�з������queue���ݶ�̬�仯�ģ�Ӧ��ʹ����ʱ��������
//        	for (int i = 0; i < parentDeque.size(); i++) {
        	for (int i = 0; i < queueSize; i++) {
				TreeNode tempTreeNode = parentDeque.poll();
				//��һ���������Ǽ���list�ģ�����ֵ���ǿյ�
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
		//����BFSʹ�ö��а���������㷨������ϸ΢���޸�
    	if (null == root) {
    		return 0;
		}
    	  	
    	int depth = 1;
        ArrayDeque<TreeNode> parentDeque = new ArrayDeque<TreeNode>();
        parentDeque.add(root);
        
        while (!parentDeque.isEmpty()) {
        	int queueSize = parentDeque.size();
        	boolean levelFlag = true;
        	//��������һ�����־λ��������֤ÿ��ֻ��ͳ��1��
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
    	//����Ч�ʺܵ͵Ľⷨ��ʱ��11.74%�ռ�5.33%
    	if (null == root) {
//			return null;
    		return new ArrayList<List<Integer>>();
		}
    	//��һ���ύ���ռ���������ˡ���
    	//input:[]  Output:null Except��[]
    	//������ֱ�ӷ��ؿ�ָ�룬��Ҫ����һ���յ�ArrayList
    	
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
    	
    	//����ͼ�����������Ҫ����һ��set����
    	
    	
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
        	//��������һ�����־λ��������֤ÿ��ֻ��ͳ��1��
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
    
    
    /*python�ο���
     import collections
def levelOrder(self, root):
    if not root:
        return []
    # ע�⵽����Կ����Ĵ���Ҳ�Ƿ���һ���յ��б������ֱ�ӷ���null
    result = []
    queue = collections.deque
    queue.append(root)
    #visited = set(root)
    # �����������������������Ӧ���ǲ���Ҫ�ģ����Ƕ��ڴ�ͳ��BFSͼ�����Ļ��Ǳ���ģ���������Ӵ������ظ�������
    
    #��ʦ�������������׼BFSģ����Լ�����
    while queue:
        level_size = len(queue)
        current_level = []
        for _ in range(level_size):
            # ��һ�ο���python�������ֿ�ѭ����ʽ
            node = queue.popleft()  #����Ӧ�þ��ǴӶ�ͷ����ֱ����pop������
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

