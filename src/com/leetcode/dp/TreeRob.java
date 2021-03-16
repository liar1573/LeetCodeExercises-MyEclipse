/**TreeRob.java
 * com.leetcode.dp
 * TODOLC337�����δ�ҽ��ᣬDP���ο��ٷ��Ľⷨ��dfs����int[2]�ֱ��ʾ��ǰ�ڵ������߲���ʱ�����档
 * @author liar
 * 2021��3��16�� ����5:32:50
 * @version 1.0
 */
package com.leetcode.dp;
import com.leetcode.tree.TreeNode;

public class TreeRob {
	public int rob(TreeNode root) {
        int[] result = dfs(root);
        return (result[0] > result[1] ? result[0]: result[1]);
   }

   public int[] dfs(TreeNode node) {
       if(node == null){
           return new int[] {0, 0};
       }

       int[] leftArr = dfs(node.left);
       int[] rightArr = dfs(node.right);

       //�����ǰ�ڵ㲻�����������ӽڵ�һ��Ҫ��
       //�Ƿ�һ��Ҫͬʱ�������ӽڵ��أ��Ƿ�����ֻ��һ�����ŵģ� ���Ƿ���int[2]���߼�����û�������������⡣��
       //��Ĭ��ͬʱ�������ӽڵ����

       //�Ա�DPģ�壬�����ƺ�����һ��max�ȽϵĲ��衣��
       return new int[] {Math.max(leftArr[0], leftArr[1]) + Math.max(rightArr[0], rightArr[1]), node.val + leftArr[0] + rightArr[0]};
   }
}
