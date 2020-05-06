/**RotateArrayMin.java
 * com.nowcoder.aimforoffer
 * TODO
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输出旋转数组的最小元素
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * @author liar
 * 2020年5月5日 上午11:20:04
 * @version 1.0
 */
package com.nowcoder.aimforoffer;


public class RotateArrayMin {
	public static void main(String[] args) {
		RotateArrayMin test = new RotateArrayMin();
		int[] testArr = test.generateArray(8, 6);
		System.out.print(test.minNumberInRotateArray(testArr));
		
	}
	
	public int minNumberInRotateArrayBruteForce(int [] array) {
		//这题如果没有做任何限制的情况下，直接用时间为N的遍历应该也是没问题的吧。。
		//直接遍历是AC了，不过看上去效率不咋地都259ms了
        if(array.length == 0)
            return 0;
        int min = array[0];
        for(int i = 0;i < array.length;i++)
            min = (min < array[i])? min: array[i];
        
        return min;
    }

	public int minNumberInRotateArrayImprove1(int[] array){
		//使用a[i+1] < a[i]改进的提升几乎可以忽略不计的算法，复杂度仍为N
		if(array.length == 0)
            return 0;
		
		//特殊情况：全部元素都相等，此时可以对min直接赋值初始值array[array.length - 1];
		int min = array[array.length - 1];
		
		for (int i = 0; i < array.length-1; i++) {
			if(array[i + 1] < array[i]){
				min = array[i+1]; break;
			}
		}
		
		return min;
	}
	
	public int minNumberInRotateArray(int[] array){
		//尝试使用二分查找的思想优化
		if(array.length == 0)
            return 0;
		int left = 0,right = array.length - 1;

		while(left <= right){
			int mid = (left + right)/2;
			if(array[mid] >= array[0]){
			//此时说明分界点扔在终点的右方
			  left = mid + 1;
			} else{
			//此时说明分界点就为mid或者在mid的左边
			  right = mid - 1;
			}
		}
		
		return array[left];
		
		//这里一开始直接用array[right+1]被报越界了。。
		//加个范围判断好了
//		if(right + 1 == array.length)
//			return right;
//		
//		return (array[right] < array[right+1])? array[right]: array[right+1];
		
	}
	
	public int[] generateArray(int length, int index) {
		//用于生成测试用的数组
		//数组长度为length，元素从0开始逐一递增，并且在index位置发生翻转
		int[] result = new int[length];
		
		for (int i = 0; i < index; i++) {
			result[i] = length - index + i; 
		}
		
		for (int i = index; i < result.length; i++) {
			result[i] = i - index; 
		}
		
		return result;
	}
}
