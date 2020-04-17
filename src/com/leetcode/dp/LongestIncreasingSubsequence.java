/*
 * LC 300 �����������
 * ��һ��N*N��dp�ⷨ����һ��nlogn�Ľ������ֲ���ά������������еĽⷨ
 */

package com.leetcode.dp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int a = 2;
//		int b = 1;
//		int c = (a + b)/2;
//		System.out.println(c);
		
		ArrayList<Integer> testArrayList = new ArrayList<Integer>();
		testArrayList.add(1);
		testArrayList.add(2);
		testArrayList.add(4);
		testArrayList.add(5);
		

//		System.out.println(arrayListBinarySearch(testArrayList, 3));
//		int[] test = {10,9,2,5,3,7,101,18};
		int[] test = {4,10,4,3,8,9};

		
		System.out.println(lengthOfLISLogN(test));
//		Arrays.binarySearch(test, 0);

	}
	
	

		
		//[10,9,2,5,3,7,101,18]
		
//	    public int lengthOfLIS(int[] nums) {
//	    	//����Ӧ����һ��ʼ�Լ����Ե��ǽ������ķ�����һֱ����ע�͵��ˡ���
//	    	if (nums.length <= 0) {
//	    		//Ӧ�ò�����С��0������0
//				return 0;
//			}
//	    	
////	        int tempMax = nums[0];
//	    	//����쳣�������£������ǵ������У����ܼ�¼�Ĳ�Ӧ����max��Ӧ����min�Ŷԣ���
//	    	int result = 1; //���ڷǿ����У�����ֵ��С��1
//	    	int tempMin = nums[0];
//	    	
//	    	//�ܷ��ٽ���һ����ʱ������������������е����ֵ����
//	    	int lastMax = nums[0];
//	    	
//	        int dpArr[] = new int[nums.length];
//	        dpArr[0] = 1;
//	        for (int i = 1; i < nums.length; i++) {
//				if (nums[i] > tempMin) {
////					if(nums[i] > nums[i-1]){
//					if(nums[i] > lastMax){
//						dpArr[i] = dpArr[i-1] + 1;
//						lastMax = nums[i];
//						//������Ҫ�ٷֳ�����һ���������nums[i] <= lastMax�����Ǳ�MinҪ��
//					} 
//					//���ﳢ�������һ�ֿ��������֧
//					//�����ƺ���һ�����������dp���ܼ�һ��Ҫ����ԭ��
//					else if (nums[i] > tempMin){
//						//dpArr[i] = dpArr[i-1] + 1;
//						dpArr[i] = dpArr[i-1];
//						lastMax = tempMin;
//					}
//					else {
//						dpArr[i] = dpArr[i-1];
//					}
//					result = (dpArr[i] > result)?dpArr[i]:result;
//				} else if (nums[i] < tempMin) {//���ﲻ���Ⱥſ��ܻ���һЩ���
//					tempMin = nums[i];
//					dpArr[i]= 1; // ��Сֵ����ʱ����Ҫ��dp����λ1
//					//�������ӳ��Min���µ�ʱ��lastMaxҲ��Ҫ����
//					lastMax = nums[i];
//				}
//				
//			}
//	        
//	    	return result;
//	    }
	
	
	    public int lengthOfLISExample(int[] nums) {
	    	if (nums.length <= 0 || null == nums) {
	    		//ʾ��������˸������׵��жϣ����ж�nums��null
	    		//Ӧ�ò�����С��0������0
				return 0;
			}
			
			int result = 1;
			int[] dp = new int[nums.length];
			//ʾ�������ж�dpȫ������ֵ1�ˣ��Ժ������ܻ��õ�dp[i]�Ĵ�С�Ƚ�
			for (int i = 0; i < dp.length; i++) {
				dp[i] = 1; 
			}
			
			//i�о���1��ʼ����
			for (int i = 1; i < dp.length; i++) {
				for (int j = 0; j < i; j++) {
					if (nums[i]> nums[j] ) {
						//ע�⵽������ж�ʽ����΢��һЩϸ���ϵ�����
						dp[i] = (dp[i] >= dp[j] + 1)? dp[i] : dp[j] + 1;  
					}
					//��¼dpȫ�����ֵ�Ǳ���ģ��������nums[n-1]��һ���ǳ�С��ֵ��
					//��dp[n-1]�ͻ����1�����޷�ʹ��dp�����һ��ֵ��Ϊ�𰸷���
					//result = (result >= dp[i]) ? result : dp[i];
					//�ٻع�ʱ������һ��Сbug��result�ĸ���Ӧ���Ƿ���iѭ���ж�����jѭ����
				}
				//��result�ĸ��¿����Ƴ���iѭ���е�ÿ����һ��dp[i]�ٸ���result����ʡ�˺ܶ�û��Ҫ�ıȽ�
				result = (result >= dp[i]) ? result : dp[i];
			}
			
			return result;
		}

	    public static int arrayListBinarySearch(ArrayList<Integer> arrayList, int serachValue){
	    	if(serachValue > arrayList.get(arrayList.size() - 1)){
	    		return arrayList.size();
	    	}
	    	//���ڱ���Ҫ��û�鵽������Ԫ�ر�����Ԫ�ض����ʱ�򣬻᷵�س���size�����Բ��ܼ��հ᳣����������Ĵ���
	    	//�����high���ܾ���Ҫ����Ϊsize(�����������Ҫ����Խ��ֵ)
//	    	int high = arrayList.size();
//	    	�������high = size��ԭ��ʵ��high=size-1�����е�����»����mid = size���Ӷ�����arr[mid]�±�Խ�硣��
//	    	�ܷ��Խ�����������ж�ֱ�ӷ���size���������high = size-1����
	    	int low = 0;
	    	int high = arrayList.size() - 1;
	    	
//	        while (low < high) {
	        while (low <= high) {
	        	//����������һЩʵ�����ԣ���������Ⱥ���Ҫ���ϣ���low<=high
	            int mid = (low + high)/2;
	            int midVal = arrayList.get(mid);
	            if (midVal < serachValue)
	                low = mid + 1;
	            else if (midVal > serachValue)
	                high = mid - 1;
	            else
	                return mid; // key found
	        }
	    	
	        //���������ж�ʱ��low+1��high-1���µĽ������һ���ģ���low = high
	        //������󷵻�low����high�����϶��ǿ��Ե�
	    	return low;
	    	//Ϊʲô��һ���޸���֮��һֱ����0����
	    	//�����high���ܾ���Ҫ����Ϊsize(�����������Ҫ����Խ��ֵ)
//	    	return high;
	    }
	    



		public static int lengthOfLISLogN(int[] nums) {
	    	if (nums.length <= 0 || null == nums) {
	    		//ʾ��������˸������׵��жϣ����ж�nums��null
	    		//Ӧ�ò�����С��0������0
				return 0;
			}
	    	
	    	ArrayList<Integer> lis = new ArrayList<Integer>();
	    	lis.add(nums[0]);
	    	
	    	for (int i = 1; i < nums.length; i++) {
				int index = arrayListBinarySearch(lis, nums[i]);
//				System.out.println(index);
				if (lis.size() == index) {//��Ԫ�����ֱ�Ӽ���������
					lis.add(nums[i]);
				} else {//��Ԫ�رȶ�������Ԫ��ҪС���滻�ʵ���Ԫ��
					lis.set(index, nums[i]);
				}
				
			}
	    	
	    	return lis.size();
		}
	

		//ǰ��©���ٳ��Ķ��ֲ����㷨
//	    public static int arrayListBinarySearch(ArrayList<Integer> arrayList, int serachValue){
//			//ע�Ȿ����Ҫ�õ��Ķ��ֲ��Ҳ������ҵ��պ���ȵ�ֵ���±꣬����Ҫ�ҵ���һ��С������ֵ���±�
//			//����Ҫarr[index] < value,��arr[index+1] > value
//			//ͬʱ�����µ�ֵ�������ǰ�����Ҳ�ǲ������ģ�Ҫ���ϸ������
//			int begin = 0;
//			int end = arrayList.size(); //���ﵽ����ȡsize����size-1���忴�����������
//			//C++�е�lower_bound()����û�鵽����Ҫ��Ԫ�ص�������᷵��Խ���±�size
//			int middle = 0;
//			
//			//��size=1ʱ�����ʲô����
//			
//			do {
//				middle = (begin + end)/2; // ����Ӧ��������ȡ�����������İɣ��������ǵ�
//				//ע�⵽���������Ҫ��������ھ�Ӧ��ֱ�ӷ��أ�����Ҫ�����κβ���
//				if (serachValue == arrayList.get(middle)) {
//					return middle;
////					return arrayList.size() + 1;
//					//ͨ������[2,2]��������ҵ���ͬ��Ԫ�ز��ܼ򵥵ķ���size�������ǻ����
//					//���Է���size+1�������������
//					//���߷��ص�ǰ�����滻����ͬ�����֣��о������Ƕ��������������̫�ã�
//					//����Ϊ��������ʽ��࣬������µķ�֧�����Ƿ��ص�ǰ�������
//				} else if (serachValue > arrayList.get(middle)) {
////					begin = middle;
//					begin = middle + 1;
//				} else {
////					end = middle;
//					end = middle-1;
//				}
//				//������arrayList.size() == 1��ʱ����searchValue < arrayList.get(0)�������ѭ����bug
//				//end�����begin������0
//				
////			} while (end != (begin + 1));�������ж������ĳ�end > (begin + 1)���ԣ�
////			} while (end > (begin + 1));
////		} while (end != begin);
//		} while (end > begin);
//			
//			
//			return end;
//		}
	
	
}
