/**
 * 
 */
package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liar-pc
 *
 */
public class Combine {
	
	LinkedList<Integer> temp = new LinkedList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> combine(int n, int k) {
//    	backtrack(0, n, k);
    	backtrack(1, n, k);
    	return this.ans;
    }
    
    public void backtrack(int index, int n, int k) {
    	//�����߼���ʾ��ǰ�����г��ȣ�����ʣ�����󳤶�Ҳ�޷�����Ŀ�곤�ȣ����Ժ���ľͲ���Ҫ�����˿���ֱ�ӷ���
    	if(n - index + 1 + temp.size() < k)
    	  return;
    	//����������֦�ж�֮��ʱ�������ǳ����ԣ���
    	//�Ӽ򻯴���ĽǶȣ�n��k�о����Ը��Ƹ���ĳ�Ա�������ٺ�������
    	if(temp.size() == k){
    		this.ans.add(new LinkedList<Integer>(temp));
			return;
    	}//�о��б����ݸ�ʽ��Ҫ�������±������ж�
    		
		if(index == (n+1)){
			return;
		}
		
		this.temp.add(index);
		backtrack(index + 1, n, k);
		//����һ��ʼ��Ϊ��Ҫʲô������ж����������ǲο���һ��LC78�Ľ�𣬲�����Ҫʲô�����ж�����
		temp.removeLast();
		backtrack(index + 1, n, k);
	}
	
    


        public List<List<Integer>> combineBit(int n, int k) {
        	//����λ����Ľⷨ���Ժ��л����ٿ���
            List<Integer> temp = new ArrayList<Integer>();
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            // ��ʼ��
            // �� temp �� [0, k - 1] ÿ��λ�� i ����Ϊ i + 1���� [0, k - 1] �� [1, k]
            // ĩβ��һλ n + 1 ��Ϊ�ڱ�
            for (int i = 1; i <= k; ++i) {
                temp.add(i);
            }
            temp.add(n + 1);
            
            int j = 0;
            while (j < k) {
                ans.add(new ArrayList<Integer>(temp.subList(0, k)));
                j = 0;
                // Ѱ�ҵ�һ�� temp[j] + 1 != temp[j + 1] ��λ�� t
                // ������Ҫ�� [0, t - 1] �����ڵ�ÿ��λ�����ó� [1, t]
                while (j < k && temp.get(j) + 1 == temp.get(j + 1)) {
                    temp.set(j, j + 1);
                    ++j;
                }
                // j �ǵ�һ�� temp[j] + 1 != temp[j + 1] ��λ��
                temp.set(j, temp.get(j) + 1);
            }
            return ans;
        }

}
