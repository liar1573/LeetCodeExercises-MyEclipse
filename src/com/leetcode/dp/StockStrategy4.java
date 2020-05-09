/**StockStrategy4.java
 * com.leetcode.dp
 * TODO
 * DP股票买卖问题4，条件为允许购买k次股票，但是同一时刻还是只能拥有一支股票
 * @author liar
 * 2020年5月8日 下午3:25:39
 * @version 1.0
 */
package com.leetcode.dp;



public class StockStrategy4 {
	
	public static void main(String[] args) {
		StockStrategy4 test = new StockStrategy4();
		//int[] prices = {3,2,6,5,0,3};
		int[] prices = {1,2,4,2,5,7,2,4,9,0};
		//System.out.print(test.maxProfitExample(2, prices));
		System.out.print(test.maxProfitUnlimitedTimes(prices));
		
	}
	
    public int maxProfitMLC(int k, int[] prices) {
    	//这个算法对于k、len长度正常情况应该是够用的，但是对于LC的极端案例k=10E的情况内存会溢出
        //是否需要k和prices合法性判断？
    	if(k <= 0 || prices.length <= 1)
    		return 0;
    	
    	k = Math.min(k, prices.length/2);
    	
    	//int[][][] dp = new int[prices.length][k][2];
    	//实际上第二维的取值范围是0-k，故大小应该为k+1
    	int[][][] dp = new int[prices.length][k+1][2];
    	
    	//第一天稍微特殊处理一下，因为第一天只能买入无法卖出
    	dp[0][0][1] = -prices[0];
    	//编程试一下如果只在卖出的时候对k+1看看
    	
    	//这里印象中好像是需要对dp[0][0...k][0-1]都做特殊赋初始值处理的
    	//虽然从实际意义考虑，第一天只能能出现dp[0][0][1]和dp[0][0][0]两种情况
    	
    	//1）直接对dp[0][k][1]这种情况全部赋值-prices[0]如何？？虽然不符合实际，但是可能会对后面的判断起作用
    	for (int i = 0; i <= k; i++) {
			dp[0][i][1] = -prices[0];
		}
    	
    	
    	for (int i = 1; i < dp.length; i++) {
    		//之前购买次数为2的时候，这里都是手动把所有情况都写出来的
    		//本题一下子扩展到k有点不知道如何下手了。。
    		
    		//k=0情况的特殊处理，避免越界为-1
    		dp[i][0][0] = dp[i-1][0][0];
    		dp[i][0][1] = Math.max(dp[i-1][0][1], dp[i-1][0][0] - prices[i]);
    		for (int j = 1; j <= k; j++) {
				//其实有些k的赋值考虑到当前情况可能是无意义的，不过为了统一编程都加进去好了
    			//这里好像还需要一个max函数？？
    			dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j-1][1] + prices[i]);
    			//注意到这里好像要对j=0，j-1的情况做一些特殊处理，否则会越界为-1
    			dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j][0] - prices[i]);
    			
			}
    		
		}
    	
    	
    	int result = 0;
    	for (int i = 0; i <= k; i++)
			result = (result > dp[prices.length - 1][i][0]) ? result : dp[prices.length - 1][i][0];
    	
    	return result;
    }

    public int maxProfitExample(int k, int[] prices) {
    	//评论区一个AC解，笔者使用int length = Math.min(k, prices.length / 2) + 1;
    	//同时优化了迭代空间需求可以通过了
	    	int length = Math.min(k, prices.length / 2) + 1; // caculate the theoretically max transactions we can make
	    	int sell[] = new int[length];
	    	int hold[] = new int[length];
	    	//这里的sell和hold数组就相当于自己的最后一维[1-0]效果是一样的
	    	for(int i = 0; i < length; i++)
	    		hold[i] = Integer.MIN_VALUE;
	    	//这里笔者使用了负最小值赋值其实不一定，只要用-prices[0]赋值就可以了
	    	for(int i = 0; i < prices.length; i++) {
		    	for(int j = length - 1; j >= 1; j--) { // index from high to low since hold[k] depends on sell[k - 1]
		    		//这里j从length-1迭代到1，省掉了特殊情况的判断
		    		sell[j] = Math.max(sell[j], hold[j] + prices[i]);
		    		hold[j] = Math.max(hold[j], sell[j - 1] - prices[i]);
		    	}//其实感觉按照他这个思路，对自己的算法稍作修改一下也可以解
		    	//主要是要减少dp的尺寸以应对极端大情况
	    	}
	    	return sell[length - 1];
    	}
    
    
    public int maxProfitImproved(int k, int[] prices) {
    	//根据评论区大佬解法，应对LC的极端案例k=10E的情况内存会溢出的优化
        //是否需要k和prices合法性判断？
    	if(k <= 0 || prices.length <= 1)
    		return 0;
    	
    	k = Math.min(k, prices.length/2);
    	
    	//int[][][] dp = new int[prices.length][k][2];
    	//实际上第二维的取值范围是0-k，故大小应该为k+1
    	//int[][][] dp = new int[prices.length][k+1][2];
    	int[][][] dp = new int[2][k+1][2];
    	//实际上这里第一位并用不着len，理论上大小为2记录当前和前一天的值就够了
    	//想到以前的一个技巧，利用i%2和(i-1)%2使用循环数组赋值
    	
    	
    	//第一天稍微特殊处理一下，因为第一天只能买入无法卖出
    	dp[0][0][1] = -prices[0];
    	//编程试一下如果只在卖出的时候对k+1看看
    	
    	//这里印象中好像是需要对dp[0][0...k][0-1]都做特殊赋初始值处理的
    	//虽然从实际意义考虑，第一天只能能出现dp[0][0][1]和dp[0][0][0]两种情况
    	
    	//1）直接对dp[0][k][1]这种情况全部赋值-prices[0]如何？？虽然不符合实际，但是可能会对后面的判断起作用
    	for (int i = 0; i <= k; i++) {
			dp[0][i][1] = -prices[0];
		}
    	
    	
    	for (int i = 1; i < prices.length; i++) {
    		//注意到这里降了dp的维度之后，dp的第一维就不在等于prices.length了
    		//之前购买次数为2的时候，这里都是手动把所有情况都写出来的
    		//本题一下子扩展到k有点不知道如何下手了。。
    		
    		//k=0情况的特殊处理，避免越界为-1
    		dp[i % 2][0][0] = dp[(i - 1) % 2][0][0];
    		dp[i % 2][0][1] = Math.max(dp[(i - 1) % 2][0][1], dp[(i - 1) % 2][0][0] - prices[i]);
    		for (int j = 1; j <= k; j++) {
				//其实有些k的赋值考虑到当前情况可能是无意义的，不过为了统一编程都加进去好了
    			//这里好像还需要一个max函数？？
    			dp[i % 2][j][0] = Math.max(dp[(i - 1) % 2][j][0], dp[(i - 1) % 2][j-1][1] + prices[i]);
    			//注意到这里好像要对j=0，j-1的情况做一些特殊处理，否则会越界为-1
    			dp[i % 2][j][1] = Math.max(dp[(i - 1) % 2][j][1], dp[(i - 1) % 2][j][0] - prices[i]);
    			
			}
    		
		}
    	
    	
    	int result = 0;
    	for (int i = 0; i <= k; i++)
			result = (result > dp[(prices.length - 1) % 2][i][0]) ? result : dp[(prices.length - 1) % 2][i][0];
    	
    	return result;
    }

    public int maxProfitBetter(int k, int[] prices) {
    	//参考拉不拉东的解法，对k>n/2的情况，直接套用无限次数的模型解决
    	//同时在for中使用临时变量去掉麻烦的%2操作
    	if(k <= 0 || prices.length <= 1)
    		return 0;
    	
    	if(k >= prices.length / 2)
    		return maxProfitUnlimitedTimes(prices);
    	
    	int[][] dp = new int[k+1][2];
    	for (int i = 0; i <= k; i++) {
			dp[i][1] = -prices[0];
		}
    	
    	for (int i = 1; i < prices.length; i++) {
    		//注意到这里降了dp的维度之后，dp的第一维就不在等于prices.length了
    		//之前购买次数为2的时候，这里都是手动把所有情况都写出来的
    		//本题一下子扩展到k有点不知道如何下手了。。
    		
    		//k=0情况的特殊处理，避免越界为-1
    		
    		//dp[i % 2][0][0] = dp[(i - 1) % 2][0][0];
    		dp[0][1] = Math.max(dp[0][1], dp[0][0] - prices[i]);
    		for (int j = 1; j <= k; j++) {
				//其实有些k的赋值考虑到当前情况可能是无意义的，不过为了统一编程都加进去好了
    			//这里好像还需要一个max函数？？
    			int tempValue = dp[j][0];
    			dp[j][0] = Math.max(dp[j][0], dp[j-1][1] + prices[i]);
    			//注意到这里好像要对j=0，j-1的情况做一些特殊处理，否则会越界为-1
    			dp[j][1] = Math.max(dp[j][1], tempValue - prices[i]);
			}
    		//这里的判断差了一点，好像还有点问题
		}
    	
    	int result = 0;
    	for (int i = 0; i <= k; i++)
			result = (result > dp[i][0]) ? result : dp[i][0];
    	
    	return result;
    	
    }
    
    public int maxProfitUnlimitedTimes(int[] prices){
    	//不限交易次数的解法，使用最高效的贪心解法
    	int profit = 0;

    	for(int i=0; i<prices.length-1; i++){
    	    if(prices[i+1] > prices[i]){
    	        profit += (prices[i+1] - prices[i]);
    	    }
    	}

    	return profit;
    	
    }
}
