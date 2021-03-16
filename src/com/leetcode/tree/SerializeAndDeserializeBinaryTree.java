/**SerializeAndDeserializeBinaryTree.java
 * com.leetcode.tree
 * TODO LC297，剑指offer。
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 格式不确定，比如可以使用逗号分隔，可以使用#表示空节点，也可以直接用空值表示空节点。
 * 二叉树的遍历顺序可以是层序、前、中后序等等
 * @author liar
 * 2021年3月16日 下午5:13:35
 * @version 1.0
 */
package com.leetcode.tree;

/**
 * //序列化代码一直没问题
同时发现LC的解法中，节点之间全部使用逗号‘,’隔开更好处理，可以使用一个split(",")分割所有的节点值；同时直接使用空串""表示null节点
而剑指中题目暗示使用!分割数值，使用#表示空节点处理反而更麻烦一些，但是后面再仔细看题目，发现并没有强制要求这种格式。。。
注意不要被题目中的描述误导，自己判断选择最简单的方式
 *
 */
import java.util.*;

public class SerializeAndDeserializeBinaryTree {
	//这次自己想使用中序遍历
	
    String Serialize(TreeNode root) {
        LinkedList<TreeNode> que = new LinkedList<TreeNode>();
        StringBuilder sb = new StringBuilder();
        //由于本题需要将空节点打印成#，故不需要一开始判断是否为空树了，可以统一处理
        que.offer(root);
        while(!que.isEmpty()){
            int levelSize = que.size(); //注意这里每层确认当前用于循环节点数量很重要
            for(int i = 0; i < levelSize;i++){
                TreeNode tempNode = que.poll();
                if(tempNode == null){
                    sb.append("#");
                }else{
                    sb.append(Integer.toString(tempNode.val) + "!");
                    que.offer(tempNode.left);
                    que.offer(tempNode.right);
                }
            }
        }
        return sb.toString();
    }
    
    TreeNode Deserialize(String str) {
    if(str.charAt(0) == '#')
        return null;
    TreeNode root = new TreeNode(Integer.parseInt(str.substring(0, str.indexOf('!'))));
    LinkedList<TreeNode> que = new LinkedList<TreeNode>();
    //que.offer(root);
        //这里似乎不应该放root，而应该放root的子节点
//换放入子节点，在while循环中再处理左右指针
    que.offer(root.left);
    que.offer(root.right);
        
    int index = str.indexOf('!') + 1;
        while(!que.isEmpty()){
            //手动带入尝试了一下，感觉还是应该以que为主序，str字符序列为次序列
        //这里需要像层序遍历一样每层处理，否则循环可能会出现异常
            int levelSize = que.size();
            for(int i = 0; i < levelSize;i++){
                     
                TreeNode tempNode = que.poll();




                if(str.charAt(index) == '#'){
                    index++;
                    //空节点可以不操作直接跳过
                }else{
                    int nextIndex = str.indexOf('!', index);
                    TreeNode node = new TreeNode(Integer.parseInt(str.substring(index, nextIndex)));
                    index = nextIndex + 1;
                    //发现问题点了！！while循环里对于非空数值用indexOf确定间隔之后忘记更新索引下标了！！
                    que.offer(node.left);
                    que.offer(node.right);
                    tempNode = node; //将存入que中的上一次节点的左右孩子指针指向这一层的节点
                    //理论上应该是这样的，不过看起来好像也有点问题。。
                }
            }
           
        }
     return root;
}
    
    
    
}


/*
 评论区大佬高赞解法
 public class Codec {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuilder res = new StringBuilder();
        res.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null){
                res.append("" + node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }else{
                res.append("null");
            }
            res.append(",");
        }
        res.append("]");
        return res.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == ""){
            return null;
        }
        String[] dataList = data.substring(1, data.length() - 1).split(",");
        //可以看到这里使用split正则匹配来预处理字符串，可能会使后面的操作简单很多
        TreeNode root = new TreeNode(Integer.parseInt(dataList[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        //注意到这里入队的节点选择不一样，自己选择入队的是树节点的左右子指针，而笔者这里直接将树节点本身入队，操作的时候再处理子节点
        //可能就是这个原因，导致如队列的时候会出问题
        //按照笔者的解法，每个入队的节点都是非空的；而自己之前的写法，每个入队的一定是空节点
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(!"null".equals(dataList[i])){
                node.left = new TreeNode(Integer.parseInt(dataList[i]));
                queue.offer(node.left);
            }
            i++;
            if(!"null".equals(dataList[i])){
                node.right = new TreeNode(Integer.parseInt(dataList[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }
}
 
 
 */

