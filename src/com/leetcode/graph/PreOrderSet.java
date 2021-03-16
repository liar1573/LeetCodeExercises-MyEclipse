/**
* LC210,207。以数组对的形式给出一组编号课程的依赖关系，要求返回任意一个合法的安排顺序，如果不存在合法顺序（即图中存在环）则返回空数组。
* LC207是210的子问题，只用返回true或false表示是否存在环即可。
*/
package com.leetcode.graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class PreOrderSet {
    public int[] findOrder(int numCourses, int[][]  prerequisites) {
     //首先是BFS的解法，这个解法代码简洁很多，也更容易理解一些
     List<ArrayList<Integer>> edges = new  ArrayList<ArrayList<Integer>>();
     //以邻接表的形式表示有向图
     int[] indeg = new int[numCourses];
     //用于存放节点入度的数组，入度为0表示该节点没有依赖关系，可以直接放入结果中
     int[] result = new int[numCourses];
     //存放最终结果
     int index = 0;//用于记录最终结果时使用的下标，最后还可以用于辅助判断是否有环
     
     for (int i = 0; i < numCourses; i++)
              edges.add(new ArrayList<Integer>());
          
     
     //首先初始化邻接表和入度矩阵
     //注意细节，到底是用int[0]还是int[1]
     for (int i = 0; i < prerequisites.length; i++) {
              edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
              indeg[prerequisites[i][0]]++;
          }
     
     //还得额外创建一个队列，用于辅助BFS进行
     LinkedList<Integer> que = new LinkedList<Integer>();
     for (int i = 0; i < numCourses; i++) {
              if(indeg[i] == 0)
                   que.offer(i);
          }//将初始入度为0的点先入辅助队列
     
     while (!que.isEmpty()) {
              int temp = que.poll(); //从辅助队列中，取任意队首入度为0的节点且加入答案
              result[index++] = temp;
              ArrayList<Integer> tempList =  edges.get(temp); //根据入度为0的节点的索引，从邻接表中查找相关节点
              //并且减少相关节点的入度
              for (Integer integer : tempList) {
                   indeg[integer]--;
                   if(indeg[integer] == 0) //如果入度减少到0，则也直接进辅助队列
                        que.offer(integer);
              }
          }
     
     if(index == numCourses){
          return result;
     }else {//最后通过辅助队列迭代完，若答案数组中元素数量不到num，
          //则说明原有向图中一定有环，导致部分节点入度无法降到0，则说明无合法解
              return new int[0];
          }
    }
}