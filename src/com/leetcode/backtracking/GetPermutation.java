/**
 * LC60.�������С�����һ��������n��һ�����k������[1,2,...,n]���ɵ�ȫ�����У��������еĵ�k������
 */
package com.leetcode.backtracking;
import java.util.*;

public class GetPermutation {
	List<Integer> tempList = new ArrayList<Integer>();
	List<Integer> ansList;
	int count = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetPermutation test = new GetPermutation();
		System.out.println(test.getPermutationOverTime(5, 119));
	}
	
	public String getPermutationOverTime(int n, int k) {
		
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++)
			nums[i] = i + 1; 
		
		dfs(nums, k);
		
		char[] charArr = new char[ansList.size()];
		for (int i = 0; i < charArr.length; i++){
			int tempInt = ansList.get(i);
//			charArr[i] = (char) tempInt;
			charArr[i] = (char) (tempInt + 48);
		}
		return new String(charArr);
//		return new String((int[])tempList.toArray());
    }
	
   public void dfs(int[] nums, int k) {
        if(tempList.size() == nums.length){
            count++;
            return;
        }       
        //if (count == k)	return;//�о���һ���жϷ��ص�λ�ó�������
  
        //ʹ����list.contains���ж��Ƿ�������ظ���Ԫ�ء�
        for (int i = 0; i < nums.length; i++) {
//        	if (count == k)  return;
            if(tempList.contains(nums[i]))
                continue;
            tempList.add(nums[i]);
            dfs(nums, k);
            if (count == k){
            	ansList = new ArrayList<Integer>(tempList);
            	return;
            }
            tempList.remove(tempList.size() - 1);
        }
    }
	
   //�ٷ��������е���ѧ���ʵĽⷨ
   public String getPermutationExample(int n, int k) {
       int[] factorial = new int[n];
       factorial[0] = 1;
       for (int i = 1; i < n; ++i) {
           factorial[i] = factorial[i - 1] * i;
       }//�������ȫ��������


       --k;
       StringBuffer ans = new StringBuffer();
       int[] valid = new int[n + 1];
       Arrays.fill(valid, 1);
       for (int i = 1; i <= n; ++i) {
           int order = k / factorial[n - i] + 1;
           for (int j = 1; j <= n; ++j) {//�����¼Ԫ���Ƿ�ʹ�ù���valid��������ι������أ�
               order -= valid[j]; //���������ʲô��˼����
               	//�������������е�ע�͸㶮�ˣ�ԭ�������order�Ǳ�ʾ��ǰԪ�ش��ڵ�ǰʣ������1,2,...n�еĵڼ�����λ��
               //���ڻ�һֱ��1,2,...,n�����ж�̬ȡ�����֣��������ֵ�λ�ò����Ǹ�����ֵһ����ȵ�
               //��������[3,4,5]����Ȼ��һ��Ԫ��ֵΪ3���������ڵ�ǰ�������ǵ�һ����������order=1��������������о��ǳ�����
               //����Ԥ��ʹ��ArrayList��������Ҳ���Դﵽ���ƵĶ�̬������ȥ��Ч��
               if (order == 0) {
                   ans.append(j);
                   valid[j] = 0;
                   break;
               }
           }
           k %= factorial[n - i];
       }
       return ans.toString();
   }
   
   public String getPermutationOther(int n, int k) {
	   //���ڵ�������getNext�ķ���
	   int[] nums = new int[n];
	   for (int i = 0; i < nums.length; i++)
		   nums[i] = i+1; 
		
	   while (k > 1) {
		 nextPermutation(nums);  
		 k--;
	   }
	   char[] chars = new char[n];
	   for (int i = 0; i < chars.length; i++)
		   chars[i] = (char) (nums[i] + 48); 
		
	   return new String(chars);
   }

   public void nextPermutation(int[] nums) {
		if(nums.length <= 1)
			return;
		
		int small = 0;
		for (int i = nums.length - 2; i >= 0 ; i--) { //ע�⵽������Ȼ������for������ÿһ�㶼��break�����Ը��Ӷ���ΪN
			if(nums[i] < nums[i+1]){
				for (int j = nums.length - 1; j > i ; j--) {
					if(nums[j] > nums[i]){
						swap(nums, i, j);
						break;
					}
				}
				small = i+1;
				break;
			}
		}
		reverseArray(nums, small, nums.length - 1);
   }
	
	public void reverseArray(int[] nums, int left, int right) {
		int len = right - left + 1;

		for (int i = 0; i < len / 2; i++) {
			int temp = nums[left + i];
			nums[left + i] = nums[right - i];
			nums[right - i] = temp; 
		}
	}
	

	
	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}//JDK���õ�Collections.swap(array, j, i);����ʵ�ֽ��������������Լ�дһ��Ҳ����
}
