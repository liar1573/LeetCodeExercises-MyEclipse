package com.leetcode;
/**StockSaling.java
 * 
 * TODO
 * @author liar
 * 2020年2月1日 下午12:54:22
 * @version 1.0
 */

/**
 * @author liar
 *
 */
public class StockSaling {

	/**
	 * @Description: TODO
	 * @para: @param args
	 * @return: void
	 * @throws: @param args
	 * @author: liar
	 * @date: 2020年2月1日 下午12:54:22
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {7,1,5,3,6,4};
		
		System.out.println(profit3d(prices));
		
	}
	
	public static int profit(int[] prices){
		if (prices.length < 2) {
			return 0;
		}
		
		int profit = 0; int min =prices[0];
		
		//最基本问题的非DP递推形式写法
//		for (int i = 1; i < prices.length; i++) {
//			int temp = prices[i]- min;
//			profit = (temp > profit)?temp:profit;
//			min = (min < prices[i] )?min:prices[i];
//		}
		
//		int[][] mp = new int[prices.length][2];
//		mp[0][0] = 0;//第一天没有购买股票时的利润
//		mp[0][1] = -prices[0];//第一天购买了股票时的利润
//		
//		for (int i = 1; i < prices.length; i++) {
//			mp[i][0] = Math.max(mp[i-1][0], mp[i-1][1] + prices[i]);
//			mp[i][1] = Math.max(mp[i-1][1], mp[i-1][0] - prices[i]);
//		}
//		
//		print2dArray(mp);
		
		
		int[][][] mp3=new int[2][3][prices.length];
		//第一维对应是否有股票0-1，第二维对应购买的次数统计
		mp3[0][0][0] = 0;//第一天没有购买股票时的利润
		mp3[1][1][0] = -prices[0];
		
			for (int i = 1; i < prices.length; i++) {
				for (int k = 0; k < 2; k++) {
					//如果k从0开始，k-1肯定会越界为-1的
//				mp3[0][k][i] = Math.max(mp3[0][k][i-1], mp3[1][k-1][i-1] + prices[i]);
//				mp3[1][k][i] = Math.max(mp3[1][k][i-1], mp3[0][k-1][i-1] - prices[i]);
				
				//把k,k-1变成k+1,k试试，同时空间开辟k+1个防止溢出
				mp3[0][k+1][i] = Math.max(mp3[0][k][i-1], mp3[1][k][i-1] + prices[i]);
				mp3[1][k+1][i] = Math.max(mp3[1][k][i-1], mp3[0][k][i-1] - prices[i]);
				
				//示例代码：1-日期；2-购买次数k；3-是否有股票0-1
				//自己的设置：1-是否有股票0-1；2-购买次数；3-日期
				//把k的迭代展开看看
				//当k=0时
				//对比发现自己好像少了一个东西？
				mp3[0][0][i] = mp3[0][0][i-1];//这种没买股票保持不变的情况一开始好像漏掉了。。
				//参考了案例发现自己以前对购买次数k的处理有问题不太严谨
				//而且mp3矩阵的初始化似乎也不太正确
				
				//
				mp3[0][1][i] = Math.max(mp3[0][0][i-1], mp3[1][0][i-1] + prices[i]);
				mp3[1][1][i] = Math.max(mp3[1][0][i-1], mp3[0][0][i-1] - prices[i]);

				
				
			}
			
		}
		
		
		
		//return mp[prices.length-1][0];
		int max = 0;
		for (int i = 0; i < 2; i++) {
			max = (mp3[0][i][prices.length-1] > max)?mp3[0][i][prices.length-1]:max;
		}
		return max;
		
//		return profit;
	}
	
	public static int profit3d(int[] prices){
		//单独列出重新整理三维通用代码解的思路
		if (prices.length < 2) {
			return 0;
		}
		
		int[][][] mp3=new int[3][2][prices.length];
		
		//便于后期答案查看中间数据（java多维数组的快速调用原理），这里维度顺序最好设置为
		//第一维K为购买次数统计；第二维0-1标记是否拥有股票；第三维i对应天数
		
		//示例代码：1-日期；2-购买次数k；3-是否有股票0-1
		
		//示例的初始化方法
		mp3[0][0][0] = 0;//第一天没有购买股票时的利润
		mp3[0][1][0] = -prices[0];//第一天购买了股票的利润
		//按照购买次数的计数，这里不应该是mp3[1][1][0] = -price[0]吗，第一个已经买进了
		//难道买入不计数卖出才计数的？？
		//而mp3[][][0]第一天所对应的所有其他的组合，这里全部初始化为最小负值了
		//这个最小负值的初始化意义何在？？直接默认初始化为0能否可行？
		//示例代码中有mp[1][0][0],mp[1][1][0],mp[2][0][0],mp[2][1][0]均为最小负数
		//
		
		
		
		//第一次运行测试，mp3[0]列的另外四个值默认设置为0看看运行结果是否正常
		//第一次试运行，mp3[0]列的值默认为0时输出结果正常，不过可能也会有特殊情况导致异常的？？
		
		
		
		/************************/
		
		//示例的迭代方法
		
		for (int i = 1; i < prices.length; i++) {
		mp3[0][0][i] = mp3[0][0][i-1];//这里不带任何判断的赋值有什么意义？？
		mp3[0][1][i] = Math.max(mp3[0][1][i-1],mp3[0][0][i-1]-prices[i]);
		//理论上这里有一次买入，交易次数k应该要+1才对，但是这里的次数则保持不变
		//可能是为了处理越界问题或者是保持整体符合规则而违背局部规则的一个特殊处理
		
		//第i次购买，目前手头没有股票
		//这里的迭代是符合之前的分析k次数的变化
		mp3[1][0][i] = Math.max(mp3[1][0][i-1],mp3[0][1][i-1]+prices[i]);
		
		//第1次购买，目前手头有股票
		//这里的迭代次数k保持不变？？不符合之前的分析k次数的变化
		mp3[1][1][i] = Math.max(mp3[1][1][i-1],mp3[1][0][i-1]-prices[i]);
		
		//第2次卖出手头没股票的情况，不知道为什么只设置了一个迭代情况
		//是否考虑到购买次数最大为2，而且次数为2的时候一定是手上没有股票的时候利润最大所以只设置了这一种情况
		mp3[2][0][i] = Math.max(mp3[2][0][i-1],mp3[1][1][i-1]+prices[i]);
		
		
		}
		/************************/
		
		
		//第一次失败的尝试，结果与正确结果不吻合
		/*
			for (int i = 1; i < prices.length; i++) {
				for (int k = 0; k < 2; k++) {
					//如果k从0开始，k-1肯定会越界为-1的
//				mp3[0][k][i] = Math.max(mp3[0][k][i-1], mp3[1][k-1][i-1] + prices[i]);
//				mp3[1][k][i] = Math.max(mp3[1][k][i-1], mp3[0][k-1][i-1] - prices[i]);
				
				//把k,k-1变成k+1,k试试，同时空间开辟k+1个防止溢出
				mp3[0][k+1][i] = Math.max(mp3[0][k][i-1], mp3[1][k][i-1] + prices[i]);
				mp3[1][k+1][i] = Math.max(mp3[1][k][i-1], mp3[0][k][i-1] - prices[i]);
	
				}
			}
			*/
		
		
		print3dArray(mp3);
		
		int maxProfit = 0;
		for (int i = 0; i < mp3.length; i++) {
			maxProfit = (maxProfit > mp3[i][0][prices.length-1])?maxProfit:mp3[i][0][prices.length-1];
		}
		
		
		return maxProfit;
	}
	
	
	static void print2dArray(int[][] arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i][0] + "   ");
		}
		System.out.println();
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i][1] + "   ");
		}
		
	}
	
	static void print3dArray(int[][][] arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.println("第" + i + "次购买");		
			for (int j = 0; j < arr[0].length; j++) {
				for (int k = 0; k < arr[0][0].length; k++) {
					System.out.print(arr[i][j][k] + "   ");	
				}	
				System.out.println();
			}		
		}	
	}
	
	
	

}
