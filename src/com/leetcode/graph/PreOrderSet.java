/**
* LC210,207��������Ե���ʽ����һ���ſγ̵�������ϵ��Ҫ�󷵻�����һ���Ϸ��İ���˳����������ںϷ�˳�򣨼�ͼ�д��ڻ����򷵻ؿ����顣
* LC207��210�������⣬ֻ�÷���true��false��ʾ�Ƿ���ڻ����ɡ�
*/
package com.leetcode.graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class PreOrderSet {
    public int[] findOrder(int numCourses, int[][]  prerequisites) {
     //������BFS�Ľⷨ������ⷨ������ܶ࣬Ҳ���������һЩ
     List<ArrayList<Integer>> edges = new  ArrayList<ArrayList<Integer>>();
     //���ڽӱ����ʽ��ʾ����ͼ
     int[] indeg = new int[numCourses];
     //���ڴ�Žڵ���ȵ����飬���Ϊ0��ʾ�ýڵ�û��������ϵ������ֱ�ӷ�������
     int[] result = new int[numCourses];
     //������ս��
     int index = 0;//���ڼ�¼���ս��ʱʹ�õ��±꣬��󻹿������ڸ����ж��Ƿ��л�
     
     for (int i = 0; i < numCourses; i++)
              edges.add(new ArrayList<Integer>());
          
     
     //���ȳ�ʼ���ڽӱ����Ⱦ���
     //ע��ϸ�ڣ���������int[0]����int[1]
     for (int i = 0; i < prerequisites.length; i++) {
              edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
              indeg[prerequisites[i][0]]++;
          }
     
     //���ö��ⴴ��һ�����У����ڸ���BFS����
     LinkedList<Integer> que = new LinkedList<Integer>();
     for (int i = 0; i < numCourses; i++) {
              if(indeg[i] == 0)
                   que.offer(i);
          }//����ʼ���Ϊ0�ĵ����븨������
     
     while (!que.isEmpty()) {
              int temp = que.poll(); //�Ӹ��������У�ȡ����������Ϊ0�Ľڵ��Ҽ����
              result[index++] = temp;
              ArrayList<Integer> tempList =  edges.get(temp); //�������Ϊ0�Ľڵ�����������ڽӱ��в�����ؽڵ�
              //���Ҽ�����ؽڵ�����
              for (Integer integer : tempList) {
                   indeg[integer]--;
                   if(indeg[integer] == 0) //�����ȼ��ٵ�0����Ҳֱ�ӽ���������
                        que.offer(integer);
              }
          }
     
     if(index == numCourses){
          return result;
     }else {//���ͨ���������е����꣬����������Ԫ����������num��
          //��˵��ԭ����ͼ��һ���л������²��ֽڵ�����޷�����0����˵���޺Ϸ���
              return new int[0];
          }
    }
}