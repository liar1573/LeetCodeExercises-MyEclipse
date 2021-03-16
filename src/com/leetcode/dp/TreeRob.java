/**TreeRob.java
 * com.leetcode.dp
 * TODOLC337，树形打家劫舍，DP。参考官方的解法，dfs返回int[2]分别表示当前节点抢或者不抢时的收益。
 * @author liar
 * 2021年3月16日 下午5:32:50
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

       //如果当前节点不抢，则两个子节点一定要抢
       //是否一定要同时抢两个子节点呢，是否会出现只抢一个最优的？ 但是返回int[2]的逻辑好像没法处理这种问题。。
       //先默认同时抢两个子节点好了

       //对比DP模板，这里似乎少了一个max比较的步骤。。
       return new int[] {Math.max(leftArr[0], leftArr[1]) + Math.max(rightArr[0], rightArr[1]), node.val + leftArr[0] + rightArr[0]};
   }
}
