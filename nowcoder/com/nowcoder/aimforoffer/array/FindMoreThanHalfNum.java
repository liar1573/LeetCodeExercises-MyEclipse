/**FindMoreThanHalfNum.java
 * com.nowcoder.aimforoffer.array
 * TODO-复习题目
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 如果不存在则输出0。
 * @author liar
 * 2020年6月19日 上午9:19:19
 * @version 1.0
 */
package com.nowcoder.aimforoffer.array;


public class FindMoreThanHalfNum {
	public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0)  return 0;
		int result = array[0];
		int times = 1;
		//官方示例result初始值赋值-1，times初始值为0，这样可以减少特殊情况判断
		//其实效果也差不多了
		
		
		// 遍历每个元素，并记录次数；若与前一个元素相同，则次数加1，否则次数减1
		for (int i = 1; i < array.length; i++) {
			if(times == 0){
				// 更新result的值为当前元素，并置次数为1
				result = array[i];
				times = 1;
			} //else if (array[i] == result ) {//注意到这里原始的逻辑层次好像有点问题。
			else {
				if (array[i] == result )
					times++;//相同时计数+1
				else 
					times--;
			}
		}
		
		//这里为什么又进行了第二次遍历？？讲道理第一轮遍历之后结果不应该已经在result中了吗？
		//后来想了想上面的一轮遍历只能保证最终result中存放的是出现次数最多的，
		//但是无法保证出现次数大于数组长度的一半（中间夹杂其他数字的时候times会减少)
		times = 0;
		for (int i = 0; i < array.length; i++) {
			if(result == array[i])  times++;
		}
		
		return (times > array.length / 2) ? result : 0;
    }
}
