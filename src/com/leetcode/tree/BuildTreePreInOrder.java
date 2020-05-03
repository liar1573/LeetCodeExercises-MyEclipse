/**BuildTreePreInOrder.java
 * com.leetcode.tree
 * TODO
 * LeetCode 105 �⣬�Ѷ� Medium���������ǰ���������������Ľ����ԭһ�ö��������ܾ���������
 * @author liar
 * 2020��4��21�� ����4:38:35
 * @version 1.0
 */
package com.leetcode.tree;



public class BuildTreePreInOrder {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BuildTreePreInOrder test = new BuildTreePreInOrder();
		int[] pre = {3,9,20,15,7};
		int[] in = {9,3,15,20,7};
		TreeNode root = test.buildTreePass1(pre, in);
		System.out.println("ǰ��������");
		TreeTraverse.preOrderTraverse(root);
		System.out.println("����������");
		TreeTraverse.inOrderTraverse(root);
		
	}
	
//	public TreeNode buildTree(int[] preorder, int[] inorder) {
//        if(preorder.length == 0)
//        	return null;
//        
////        TreeNode root = new TreeNode(preorder[0]);
//        TreeNode root = null;
//        buildSubTreeExample(root, preorder, inorder);
//        
//        return root;
//    }
	
	public TreeNode buildTreePass1(int[] preorder, int[] inorder) {
		//�ο�֪������һ��ͨ����д��
		if (preorder.length < 1) {
			return null;
		}
		//���ʣ��Ƿ����κ�ʱ�̣�dfs������pre��in�ĳ��ȶ�һ������ȵģ�
		//�о������ǵ��ǲ���ȷ��
		
		int rootValue = preorder[0];
		TreeNode root = new TreeNode(rootValue);
		int rootIndex = findIndex(inorder, rootValue);
		int[] inLeft = copyArray(inorder, 0, rootIndex - 1);
		int[] inRight = copyArray(inorder, rootIndex + 1, inorder.length-1);
		//��pre[]�У����������ķָ���Ҫͨ�����������
		//���������±��п��ܻᳬ��pre�ķ�Χ����ȥcopyArray�����в�����
		//end>=lenʱ����int[0]�Ķ����ж�����
		int[] preLeft = copyArray(preorder, 1, inLeft.length);
		int[] preRight = copyArray(preorder, preLeft.length + 1, preorder.length-1);
		
		
		root.left = buildTreePass1(preLeft, inLeft);
		root.right = buildTreePass1(preRight, inRight);
//		buildSubTreeExample(root.left, preLeft, inLeft);
//		buildSubTreeExample(root.right, preRight, inRight);
		
		return root;
    }
	
	public void buildSubTree(TreeNode node, int[] pre, int[] in) {
		//�ݹ����ֹ����Ӧ�þ���ǰ���������鱻�ָֻ��һ��Ԫ����
		if (pre.length == 1) {
			node = new TreeNode(pre[0]);
		} 
		if (in.length == 1) {
			node = new TreeNode(in[0]);
		}
		if (pre.length == 0) {
			return;
		}
		if (in.length == 0) {
			return;
		}
		
		
		
		int rootValue = pre[0];
		node = new TreeNode(rootValue);
		//int rootIndex = Arrays.binarySearch(in, rootValue);
		int rootIndex = findIndex(in, rootValue);
//		int[] inLeft = Arrays.copyOfRange(in, 0, rootIndex);
		//��һ�α����copyOfRange�����ˣ��Ƿ�����:0>-1
		//��������ʵʵ��for���ƺ���
		int[] inLeft = new int[rootIndex];
		for (int i = 0; i < inLeft.length; i++) {
			inLeft[i] = in[i];
		}
		
		//�������in[]��������2�����֣����򲻻�ͨ�������տ�ʼ�Ľ��������ж�
		//���root�պ�Ϊ�����һ��Ԫ�أ���������ֻ��2���ڵ㣩
		//��right����Ӧ��Ϊ0��Ҳ����Խ��
		int[] inRight = new int[in.length - 1 - rootIndex];
		for (int i = rootIndex + 1; i < in.length; i++) {
			inRight[i - rootIndex - 1] = in[i]; 
		}
		//�������������������Ҫ�ָǰ���������Ҳ��Ҫ�����߽����һ������ع���
		//����Ҳ��Ҫin��������Ϊ2
		//int leftIndex = Arrays.binarySearch(pre, in[rootIndex - 1]);
		int leftIndex = findIndex(pre, in[rootIndex - 1]);
		int[] preLeft = new int[leftIndex];
		for (int i = 1; i <= leftIndex; i++) {
			preLeft[i-1] = pre[i];
		}
		int[] preRight = new int[pre.length - leftIndex - 1];
		for (int i = leftIndex + 1; i < pre.length; i++) {
			preRight[i - leftIndex - 1] = pre[i]; 
		}
		
		
		
		buildSubTree(node.left, preLeft, inLeft);
		buildSubTree(node.right, preRight, inRight);
		
	}
	
	public void buildSubTreeExample(TreeNode node, int[] pre, int[] in){
		if (pre.length < 1) {
			return;
		}
		//���ʣ��Ƿ����κ�ʱ�̣�dfs������pre��in�ĳ��ȶ�һ������ȵģ�
		//�о������ǵ��ǲ���ȷ��
		
		int rootValue = pre[0];
		node = new TreeNode(rootValue);
		int rootIndex = findIndex(in, rootValue);
		int[] inLeft = copyArray(in, 0, rootIndex - 1);
		int[] inRight = copyArray(in, rootIndex + 1, in.length-1);
		//��pre[]�У����������ķָ���Ҫͨ�����������
		//���������±��п��ܻᳬ��pre�ķ�Χ����ȥcopyArray�����в�����
		//end>=lenʱ����int[0]�Ķ����ж�����
		int[] preLeft = copyArray(pre, 1, inLeft.length);
		int[] preRight = copyArray(pre, preLeft.length + 1, pre.length-1);
		
		buildSubTreeExample(node.left, preLeft, inLeft);
		buildSubTreeExample(node.right, preRight, inRight);
	}

	public void buildSubTreeFault(TreeNode node, int[] pre, int[] in) {
		//����֪���ο�д����д�ݹ麯��
		if (pre.length < 1) {
			return;
		}
		//�����趨�����ڵ�һ������Ϊ�գ���pre.len>=1�������������ڵݹ�Ĺ����п��ܳ��ֿյ����
		//���統��ֻ�������ڵ��ʱ�򣬱�Ȼ������������������Ϊ��
		
		int rootValue = pre[0];
		node = new TreeNode(rootValue);
		int rootIndex = findIndex(in, rootValue);
//		int[] inLeft = Arrays.copyOfRange(in, 0, rootIndex);
		//��һ�α����copyOfRange�����ˣ��Ƿ�����:0>-1
		//��������ʵʵ��for���ƺ���
		int[] inLeft = new int[rootIndex];
		for (int i = 0; i < inLeft.length; i++) {
			inLeft[i] = in[i];
		}
		
		//����֮ǰ���ȷ�����������ķ��������е����⣡��
		//����ȷ����������ֵû���⣬��������������ȷ��ֻ��ͨ���ڵ㳤�ȣ�û����ͨ��ֵ�����±꣬˳������ǲ�ȷ���ģ���
		
		//���ﵱin[]����Ϊ0��ʱ��Ҳ���±�Խ��
		int[] inRight = new int[in.length - 1 - rootIndex];
		for (int i = rootIndex + 1; i < in.length; i++) {
			inRight[i - rootIndex - 1] = in[i]; 
		}
		
		
//		buildSubTree(node.left, preLeft, inLeft);
//		buildSubTree(node.right, preRight, inRight);
	}
	
	
	public int findIndex(int[] arr, int value) {
		//������������һ�����ҵ���Ӧֵ
		//��������Ҳ��һ�������鳤�ȿ��ܻᱻ����0
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == value )
				return i;
		}
		return 0; //��ʾû�ҵ���ֻ�������鳤��Ϊ0��ʱ��Żᷢ��
	}
	
	public int[] copyArray(int[] input, int start, int end){
		//������ʼ�ͽ�ֹ�±궼�ᱻ����
		//�����Լ�дһ���ָ�����ķ�������Arrays.copyRangeOf()ʵ�ڲ����á���
		//copyRangeOf()��������ֹ�±꣬��������ܶ����õ��±�Խ�籨��
		//����end < start�����(����end�±곬��input)��ֱ�ӷ��س���Ϊ0�����鼴��
		if(end < start || end >= input.length || start >= input.length)
			return new int[0];
		
		int[] result = new int[end - start + 1];
		for (int i = 0; i < result.length; i++) {
			result[i] = input[start + i]; 
		}
		return result;
	}

}

