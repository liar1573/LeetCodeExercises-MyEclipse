/**Mode3Array.java
 * com.nowcoder
 * 牛客网首页 > 在线编程 > 2019校招真题
 * 网易》被3整除
 * 小Q得到一个神奇的数列: 1, 12, 123,...12345678910,1234567891011...。 
并且小Q对于能否被3整除这个性质很感兴趣。 
小Q现在希望你能帮他计算一下从数列的第l个到第r个(包含端点)有多少个数可以被3整除。 
（题目中没有想想介绍数列扩充的规律，不过大致看起来是每次在数列最后加上了整数i）
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M
 * @author liar
 * 2020年4月2日 上午10:16:59
 * @version 1.0
 */
package com.nowcoder;


public class Mode3Array {

	/**
	 * @Description: TODO
	 * @para: @param args
	 * @return: void
	 * @throws: @param args
	 * @author: liar
	 * @date: 2020年4月2日 上午10:16:59
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mod3Array(2, 5));
	}
	
	private static int mod3Array(int start, int end) {
		//输入包括两个整数l和r(1 <= l <= r <= 1e9)
		//题设给出了输入规则，这里就不额外讨论了
		int count = 0;
		int total = 0;//用于存储累加和
		for(int i = 0; i < start;i++){
			//需要稍微注意一下start和end边界要如何处理,这里start要用<
			//start区间之前的只计算累加和不计数
			total += i;
		}
		
		for (int i = start; i <= end; i++) {
			//这里下标从start开始且end边界需要带等号
			total += i;
			if (0 == total % 3) {
				count++;
			}
			
		}
		
		return count;
	}

}
