/**SerializeAndDeserializeBinaryTree.java
 * com.leetcode.tree
 * TODO LC297����ָoffer��
 * �����һ���㷨��ʵ�ֶ����������л��뷴���л������ﲻ�޶�������� / �����л��㷨ִ���߼�����ֻ��Ҫ��֤һ�����������Ա����л�Ϊһ���ַ������ҽ�����ַ��������л�Ϊԭʼ�����ṹ��
 * ��ʽ��ȷ�����������ʹ�ö��ŷָ�������ʹ��#��ʾ�սڵ㣬Ҳ����ֱ���ÿ�ֵ��ʾ�սڵ㡣
 * �������ı���˳������ǲ���ǰ���к���ȵ�
 * @author liar
 * 2021��3��16�� ����5:13:35
 * @version 1.0
 */
package com.leetcode.tree;

/**
 * //���л�����һֱû����
ͬʱ����LC�Ľⷨ�У��ڵ�֮��ȫ��ʹ�ö��š�,���������ô�������ʹ��һ��split(",")�ָ����еĽڵ�ֵ��ͬʱֱ��ʹ�ÿմ�""��ʾnull�ڵ�
����ָ����Ŀ��ʾʹ��!�ָ���ֵ��ʹ��#��ʾ�սڵ㴦�������鷳һЩ�����Ǻ�������ϸ����Ŀ�����ֲ�û��ǿ��Ҫ�����ָ�ʽ������
ע�ⲻҪ����Ŀ�е������󵼣��Լ��ж�ѡ����򵥵ķ�ʽ
 *
 */
import java.util.*;

public class SerializeAndDeserializeBinaryTree {
	//����Լ���ʹ���������
	
    String Serialize(TreeNode root) {
        LinkedList<TreeNode> que = new LinkedList<TreeNode>();
        StringBuilder sb = new StringBuilder();
        //���ڱ�����Ҫ���սڵ��ӡ��#���ʲ���Ҫһ��ʼ�ж��Ƿ�Ϊ�����ˣ�����ͳһ����
        que.offer(root);
        while(!que.isEmpty()){
            int levelSize = que.size(); //ע������ÿ��ȷ�ϵ�ǰ����ѭ���ڵ���������Ҫ
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
        //�����ƺ���Ӧ�÷�root����Ӧ�÷�root���ӽڵ�
//�������ӽڵ㣬��whileѭ�����ٴ�������ָ��
    que.offer(root.left);
    que.offer(root.right);
        
    int index = str.indexOf('!') + 1;
        while(!que.isEmpty()){
            //�ֶ����볢����һ�£��о�����Ӧ����queΪ����str�ַ�����Ϊ������
        //������Ҫ��������һ��ÿ�㴦������ѭ�����ܻ�����쳣
            int levelSize = que.size();
            for(int i = 0; i < levelSize;i++){
                     
                TreeNode tempNode = que.poll();




                if(str.charAt(index) == '#'){
                    index++;
                    //�սڵ���Բ�����ֱ������
                }else{
                    int nextIndex = str.indexOf('!', index);
                    TreeNode node = new TreeNode(Integer.parseInt(str.substring(index, nextIndex)));
                    index = nextIndex + 1;
                    //����������ˣ���whileѭ������ڷǿ���ֵ��indexOfȷ�����֮�����Ǹ��������±��ˣ���
                    que.offer(node.left);
                    que.offer(node.right);
                    tempNode = node; //������que�е���һ�νڵ�����Һ���ָ��ָ����һ��Ľڵ�
                    //������Ӧ���������ģ���������������Ҳ�е����⡣��
                }
            }
           
        }
     return root;
}
    
    
    
}


/*
 ���������и��޽ⷨ
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
        //���Կ�������ʹ��split����ƥ����Ԥ�����ַ��������ܻ�ʹ����Ĳ����򵥺ܶ�
        TreeNode root = new TreeNode(Integer.parseInt(dataList[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        //ע�⵽������ӵĽڵ�ѡ��һ�����Լ�ѡ����ӵ������ڵ��������ָ�룬����������ֱ�ӽ����ڵ㱾����ӣ�������ʱ���ٴ����ӽڵ�
        //���ܾ������ԭ�򣬵�������е�ʱ��������
        //���ձ��ߵĽⷨ��ÿ����ӵĽڵ㶼�Ƿǿյģ����Լ�֮ǰ��д����ÿ����ӵ�һ���ǿսڵ�
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

