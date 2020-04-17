/*
 * LC 300 最长上升子序列
 * 有一个N*N的dp解法，和一个nlogn的借助二分查找维护最长上升子序列的解法
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
//	    	//这里应该是一开始自己尝试但是结果错误的方法，一直忘了注释掉了。。
//	    	if (nums.length <= 0) {
//	    		//应该不可能小于0最多等于0
//				return 0;
//			}
//	    	
////	        int tempMax = nums[0];
//	    	//结果异常后想了下，由于是递增序列，可能记录的不应该是max而应该是min才对！！
//	    	int result = 1; //对于非空序列，返回值最小是1
//	    	int tempMin = nums[0];
//	    	
//	    	//能否再建立一个临时变量，存放上升序列中的最大值？？
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
//						//这里需要再分出来另一种情况，即nums[i] <= lastMax，但是比Min要大
//					} 
//					//这里尝试再添加一种可能情况分支
//					//这里似乎是一种特殊情况，dp不能加一而要保持原样
//					else if (nums[i] > tempMin){
//						//dpArr[i] = dpArr[i-1] + 1;
//						dpArr[i] = dpArr[i-1];
//						lastMax = tempMin;
//					}
//					else {
//						dpArr[i] = dpArr[i-1];
//					}
//					result = (dpArr[i] > result)?dpArr[i]:result;
//				} else if (nums[i] < tempMin) {//这里不带等号可能会少一些情况
//					tempMin = nums[i];
//					dpArr[i]= 1; // 最小值更新时，需要将dp重置位1
//					//被报错后反映到Min更新的时候，lastMax也需要更新
//					lastMax = nums[i];
//				}
//				
//			}
//	        
//	    	return result;
//	    }
	
	
	    public int lengthOfLISExample(int[] nums) {
	    	if (nums.length <= 0 || null == nums) {
	    		//示例代码加了个更稳妥的判断，即判断nums非null
	    		//应该不可能小于0最多等于0
				return 0;
			}
			
			int result = 1;
			int[] dp = new int[nums.length];
			//示例代码中对dp全部付初值1了，以后后面可能会用到dp[i]的大小比较
			for (int i = 0; i < dp.length; i++) {
				dp[i] = 1; 
			}
			
			//i感觉从1开始更好
			for (int i = 1; i < dp.length; i++) {
				for (int j = 0; j < i; j++) {
					if (nums[i]> nums[j] ) {
						//注意到这里的判断式子稍微有一些细节上的区别
						dp[i] = (dp[i] >= dp[j] + 1)? dp[i] : dp[j] + 1;  
					}
					//记录dp全局最大值是必须的，例如如果nums[n-1]是一个非常小的值，
					//则dp[n-1]就会等于1，即无法使用dp的最后一个值作为答案返回
					//result = (result >= dp[i]) ? result : dp[i];
					//再回顾时发现了一个小bug，result的更新应该是放在i循环中而不是j循环中
				}
				//对result的更新可以移出到i循环中的每更新一轮dp[i]再更新result，节省了很多没必要的比较
				result = (result >= dp[i]) ? result : dp[i];
			}
			
			return result;
		}

	    public static int arrayListBinarySearch(ArrayList<Integer> arrayList, int serachValue){
	    	if(serachValue > arrayList.get(arrayList.size() - 1)){
	    		return arrayList.size();
	    	}
	    	//由于本次要求没查到的且新元素比所有元素都大的时候，会返回长度size，所以不能简单照搬常规二分搜索的代码
	    	//这里的high可能就需要设置为size(正常情况下需要返回越界值)
//	    	int high = arrayList.size();
//	    	如果调整high = size（原文实现high=size-1），有的情况下会出现mid = size，从而导致arr[mid]下标越界。。
//	    	能否把越界的情况特殊判断直接返回size，其他情况high = size-1？？
	    	int low = 0;
	    	int high = arrayList.size() - 1;
	    	
//	        while (low < high) {
	        while (low <= high) {
	        	//后来经过了一些实例测试，发现这里等号需要带上，即low<=high
	            int mid = (low + high)/2;
	            int midVal = arrayList.get(mid);
	            if (midVal < serachValue)
	                low = mid + 1;
	            else if (midVal > serachValue)
	                high = mid - 1;
	            else
	                return mid; // key found
	        }
	    	
	        //这里最后的判断时，low+1和high-1导致的结果都是一样的，即low = high
	        //所以最后返回low或者high理论上都是可以的
	    	return low;
	    	//为什么第一次修改完之后，一直返回0？？
	    	//这里的high可能就需要设置为size(正常情况下需要返回越界值)
//	    	return high;
	    }
	    



		public static int lengthOfLISLogN(int[] nums) {
	    	if (nums.length <= 0 || null == nums) {
	    		//示例代码加了个更稳妥的判断，即判断nums非null
	    		//应该不可能小于0最多等于0
				return 0;
			}
	    	
	    	ArrayList<Integer> lis = new ArrayList<Integer>();
	    	lis.add(nums[0]);
	    	
	    	for (int i = 1; i < nums.length; i++) {
				int index = arrayListBinarySearch(lis, nums[i]);
//				System.out.println(index);
				if (lis.size() == index) {//新元素最大，直接加入队列最后
					lis.add(nums[i]);
				} else {//新元素比队列已有元素要小，替换适当的元素
					lis.set(index, nums[i]);
				}
				
			}
	    	
	    	return lis.size();
		}
	

		//前期漏洞百出的二分查找算法
//	    public static int arrayListBinarySearch(ArrayList<Integer> arrayList, int serachValue){
//			//注意本题需要用到的二分查找并不是找到刚好相等的值的下标，而是要找到第一个小于它的值的下标
//			//即需要arr[index] < value,而arr[index+1] > value
//			//同时这里新的值如果与以前的相等也是不会加入的（要求严格递增）
//			int begin = 0;
//			int end = arrayList.size(); //这里到底是取size还是size-1具体看后面操作方便
//			//C++中的lower_bound()对于没查到符合要求元素的情况，会返回越界下标size
//			int middle = 0;
//			
//			//当size=1时会出现什么？？
//			
//			do {
//				middle = (begin + end)/2; // 这里应该是向下取整保留整数的吧？试了下是的
//				//注意到这里的特殊要求，如果等于就应该直接返回，不需要进行任何操作
//				if (serachValue == arrayList.get(middle)) {
//					return middle;
////					return arrayList.size() + 1;
//					//通过反例[2,2]发现如果找到相同的元素不能简单的返回size，否则还是会加入
//					//可以返回size+1避免这种情况，
//					//或者返回当前坐标替换掉相同的数字（感觉这样是多余无意义操作不太好）
//					//但是为了整体表达式简洁，不添加新的分支，还是返回当前坐标好了
//				} else if (serachValue > arrayList.get(middle)) {
////					begin = middle;
//					begin = middle + 1;
//				} else {
////					end = middle;
//					end = middle-1;
//				}
//				//发现在arrayList.size() == 1的时候，且searchValue < arrayList.get(0)会产生死循环的bug
//				//end会等于begin都等于0
//				
////			} while (end != (begin + 1));把这里判断条件改成end > (begin + 1)试试？
////			} while (end > (begin + 1));
////		} while (end != begin);
//		} while (end > begin);
//			
//			
//			return end;
//		}
	
	
}
