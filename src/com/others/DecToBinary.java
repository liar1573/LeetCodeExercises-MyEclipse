/**DecToBinary.java
 * com.others
 * TODO
 * @author liar
 * 2020年3月22日 下午5:09:01
 * @version 1.0
 */
package com.others;

import java.util.LinkedList;
import java.util.List;

/**
 * 网上看到的一道米忽悠笔试编程题，这难度应该属于送分题
 * 后来发现自己一开始好像想错了。。。
* 输入一个数输出该数的二进制
* 4   //输入
* 100 //输出
*/
public class DecToBinary {

	/**
	 * @Description: TODO
	 * @para: @param args
	 * @return: void
	 * @throws: @param args
	 * @author: liar
	 * @date: 2020年3月22日 下午5:09:01
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int input = -9;
//		DecToBinary testDecToBinary = new DecToBinary();
//		LinkedList<Integer> result = testDecToBinary.decToBin(input);
//		testDecToBinary.showList(result);
		
		long input = 10;
		DecToBinary testDecToBinary = new DecToBinary();
		//LinkedList<Long> result = testDecToBinary.decToBinUpdate(input);
		LinkedList<Character> result = testDecToBinary.decToBinBit(input);
		testDecToBinary.showList(result);
		
		//测试负数的除法和取余
//		System.out.println(input % 2);
//		System.out.println(input / 2);
		//负数的除法熵和余数都是负的，处理起来稍微有点麻烦
	}

	public LinkedList<Integer> decToBin(int input) {
		//原则上只要不停的对2取模并去掉末尾即可
		//从高效的角度考虑，结合上位运算符可能更好
		//参考案例使用ArrayList来存放结果
		//个人感觉利用Queue或者Stack的性质更方便一些，可以少一些下标转换操作
		LinkedList<Integer> result = new LinkedList<Integer>();
		if (0 == input) {
			result.add(0);
			return result;
		}
		
		//如果是负数不知道是否需要特殊处理一下？？
		//这个逻辑对正数是没问题的
		//题目中没有说明整数的范围。。
		boolean minusFlag = false;//用于处理负数的标志位
		if (input < 0) {
			minusFlag = true;
			input = -input;
			//对于负数直接转换为正数，并在最后输出是把首位再换成负数
		}
		
		
		while (input != 0) {
			int mode = input % 2;
			input /= 2;
			result.add(mode);
		}
		
		if (minusFlag) {
			result.set(result.size() - 1, -(result.getLast()));
		}
		
		return result;
	}
	
	public LinkedList<Long> decToBinUpdate(long input) {
		//注意到示例的数据类型是long，范围更大
		//除以2操作通过位运算符完成效率更高
		//由于这里特定是2进制，取余操作也可以用位运算实现
		
		//同时发现示例的一个bug，即对于输入为0时会返回一个空的链表（实际上应该返回{0}）
		LinkedList<Long> result = new LinkedList<Long>();
		if (0 == input) {
			result.add((long) 0);
			return result;
		}
		
		long binaryFlag = 1;//这个标志是用来做位与运算判断末尾是1还是0的
		
		boolean minusFlag = false;//用于处理负数的标志位
		if (input < 0) {
			minusFlag = true;
			input = -input;
			//对于负数直接转换为正数，并在最后输出是把首位再换成负数
		}
		
		while (input != 0) {
			
//			if ((input&binaryFlag) != 0) {
//				result.add((long) 1);
//			}
//			result.add(0); 原案例的实现逻辑有问题，修改之后就正常了	
			result.add((long) (input&binaryFlag));
			input = input >> 1;
		}
		
		if (minusFlag) {
			result.set(result.size() - 1, -(result.getLast()));
		}
		
		return result;
		
	}
	
	public LinkedList<Character> decToBinBit(long input){
		LinkedList<Character> result = new LinkedList<Character>();
		//搜了下Java long有64位，即[-2^63,2^63-1]这个范围有点太大了一般用不到。。
		//默认高位0不显示好了
		//其实后来想到result里面其实并不储占数值，只是存储0-1二进制符号，并不需要用long类型
		//用最小的数值类型或者用String类型就可以了
		do {
			if (1 == (input & 1)) {
				result.add('1');
			}else {
				result.add('0');
			}
			input = input >>> 1;
			//注意这种算法返回的是二进制补码 ，即负数的符号位一定是1
		} while (input != 0);
		
		return result;
	}
	
	private void showList(LinkedList inputList) {
		while (0 != inputList.size()) {
			System.out.print(inputList.removeLast());
		}
	}
	
}
