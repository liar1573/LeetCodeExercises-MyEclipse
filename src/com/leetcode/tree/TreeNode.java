/**TreeNode.java
 * com.leetcode.tree
 * TODO
 * 最常见的TreeNode结构，用于同一导入调试
 * @author liar
 * 2020年5月12日 上午10:45:49
 * @version 1.0
 */
package com.leetcode.tree;


public class TreeNode {
	public int val;  //为了方便包外导入调试，修饰符全部改为public
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }
}
