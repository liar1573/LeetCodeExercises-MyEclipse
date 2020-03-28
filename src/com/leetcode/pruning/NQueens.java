
package com.leetcode.pruning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**NQueens.java
 * com.leetcode.pruning
 * LC 51 剪枝算法中的N皇后问题
 * 文件最下方放了一些Python的实现代码
 * @author liar
 * 2020年3月25日 上午9:36:15
 * @version 1.0
 */
public class NQueens {

	/**
	 * @Description: TODO
	 * @para: @param args
	 * @return: void
	 * @throws: @param args
	 * @author: liar
	 * @date: 2020年3月25日 上午9:36:15
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueens testNQ = new NQueens();
		testNQ.solveNQueens(4);
//		testNQ.solveNQueensSample(4);
		
		
	}
	
	public List<List<String>> solveNQueens(int n) {
        if(n < 1){
        	return null;//这里之间返回空，外部再判断好了
        }
        //居然被一个n=1的特例怼了。。，确实n=1也可以做，但是n=2、3都不行
        //把判断改成 n < 1，只不过2、3的时候返回[]
        
        ArrayList<List<String>> result = new ArrayList<List<String>>();
        //注意到这里一次好像只能置换一个子类，不能一次性写出两个ArrayList嵌套否则返回值会报错
        //Java的实例代码也是用数组标志的，这里自己也用数组标志好了
        //示例中用了匿名对象（应该是这么叫的来着，直接在参数里new没有变量名）
        boolean[] cols = new boolean[n];
        //单侧对角线的总数有2n-1个，虽然有几个地方是明显访问不到的，不过先开辟多余的空间免得以后下标越界
        boolean[] pie = new boolean[2*n]; //pie、na这个命名感觉形象容易记
        boolean[] na = new boolean[2*n]; //布尔数组默认初始值是false
        ArrayList<List<Integer>> solve = new ArrayList<List<Integer>>();
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        dfs(n, 0, cols, pie, na, solve, tempList);
//        dfs(n, 0, cols, pie, na, solve, "");
        formatPrint(solve, result);
        
//        printDoubleList(solve);
        printDoubleStringList(result);
        return result;
    }
	
	private void dfs(int n, int row, boolean[] cols, boolean[] pie, boolean[] na, ArrayList<List<Integer>> solve, ArrayList<Integer> tempList) {
//	private void dfs(int n, int row, boolean[] cols, boolean[] pie, boolean[] na, ArrayList<List<Integer>> solve, String tempIntString) {
		//python实现换成java实现的时候还要额外注意一些，因为python中几乎看不到数据类型对齐
		//换成Java实现之后还要进行严格的数据类型检查
		if (n == row) {
			//这里是先处理再增加层数，带入例子试一下就可以确认是n而不是n-1结束
			solve.add((List<Integer>) tempList.clone());
		}
		
		for (int col = 0; col < n; col++) {
			if ((cols[col])||(pie[row + col])||(na[row - col + n])) {
				//这里下标只需要+n就可以保证不会出现负数了
				//同时pie和na的下标并不需要表示太具体的含义，只要能分辨不同斜线即可
				continue;
			}
			
			cols[col] = true; pie[row + col] = true; na[row - col + n] = true;
			//这里应该不会达到数组下标上界2n-1吧，如果达到了之前的空间开辟换成2n就行
			//注意这里没办法把tempList.add直接简写一行放进参数列表里面，本身会返回boolean类型返回值，会导致参数类型不匹配。。
			tempList.add(col);
			dfs(n, row + 1, cols, pie, na, solve, tempList);
			//注意到这里传入boolean数组时，也要在外面进行恢复。。
			//之前有一个很巧妙的python写法好像不需要恢复，不知道java能不能实现。。
			//无效的结果从tempList中移除再试试
			tempList.remove(tempList.size() - 1);//这里如果用LinkedList就可以直接removeLast了
			cols[col] = false; pie[row + col] = false; na[row - col + n] = false;		
		}
	}

	private void formatPrint(ArrayList<List<Integer>> solve, ArrayList<List<String>> result) {
		for (List<Integer> list : solve) {
			ArrayList<String> tempStringList = new ArrayList<String>();
			for (Integer integer : list) {
				StringBuilder tempSb = new StringBuilder();
				//参考代码是使用Arrays工具类和char[]来操作的
				for (int i = 0; i < integer; i++) {
					tempSb.append(".");
				}
				tempSb.append("Q");
				for (int i = integer + 1; i < solve.get(0).size(); i++) {
					tempSb.append(".");
				}
				tempStringList.add(tempSb.toString());
			}
			result.add(tempStringList);
		}
	}
	
	private void printDoubleList(ArrayList<List<Integer>> solve) {
		for (List<Integer> list : solve) {
			System.out.print('[');
			for (Integer integer : list) {
				System.out.print(integer + " ,");
			}
			System.out.println(']');
		}
	}
	
	
	public List<String[]> solveNQueensSample(int n) {//参考代码
		List<String[]> result = new ArrayList<String[]>();
		dfsSample(0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], result, new String[n]);
		printStringList(result);
		return result;
	}
	
	private void dfsSample(int row, boolean[] cols, boolean[] pie, boolean[] na, List<String[]> result, String[] board){
		if (cols.length == row) {
			result.add(board);
			return;
		}
		
		for (int col = 0; col < cols.length; col++) {
			if ((cols[col])||(pie[row + col])||(na[row - col + cols.length])) {
				//这里下标只需要+n就可以保证不会出现负数了
				//同时pie和na的下标并不需要表示太具体的含义，只要能分辨不同斜线即可
				continue;
			}
			
			char[] rowChar = new char[cols.length];
			Arrays.fill(rowChar, '.'); rowChar[col] = 'Q';
			board[row] = new String(rowChar);
			
			cols[col] = true; pie[row + col] = true; na[row - col + cols.length] = true;
			dfsSample(row + 1, cols, pie, na, result, board);
			cols[col] = false; pie[row + col] = false; na[row - col + cols.length] = false;
		}
		
	}
	
	private void printStringList(List<String[]> list) {
		for (String[] strings : list) {
			for (String string : strings) {
				System.out.println(string);
			}
			System.out.println();
		}
	}
	
	private void printDoubleStringList(List<List<String>> showList){
		for (List<String> list : showList) {
			for (String string : list) {
				System.out.println(string);
			}
			System.out.println();
		}
	}
	
}

/*

class Solution(object):
    def solveNQueens(self, n):
        if n < 4:  #N小于4时的皇后问题都是无解的
            return []
        self.result = [] # 最近渐渐的已经见到过很多次直接在函数中声明self变量的了
        # 看起来效果基本等同于声明一个文件全局变量
        # 在函数中声明self变量，pycharm给了一个警告：Instance attribute result defined outside __init__
        # 看来这玩意声明最正规的方法还是要放在对象的初始化方法里面，在任意函数中声明也可以用但是不太正规
        self.cols = set(); self.pie = set(); self.na = set()
        # 这里用三个全局set来记录被攻击到的区域，好处是不需要传参数，而且不用处理负数下标，逻辑比较清晰
        # 坏处set的使用会代来额外的开销（虽然set的插入都是常数时间应该影响也不大），同时使用全局set在递归过程中需要复位标记信息
        self.DFS(n, 0, [])
        return self.generate_result(n)

    def DFS(self, n, row, cur_state):
        # 这里参数cur_state的类型到底是什么？？看起来好像是两层嵌套的list
        # 递归终止判断：达到最底层
        if row == n: # 如果递归达到低层说明前面的条件均满足，把当前解加入集合并返回
            self.result.append(cur_state)
            return

        for col in range(n): # 外层行遍历是通过递归函数参数row实现的，内层只需进行列遍历
            if (col in self.cols) or (row + col in self.pie) or (row - col in self.na):
                #新的Q会被之前的攻击到，当前的方法不可行直接跳过
                # 这里原代码完全没有括号看着很不舒服就不上了
                # 最后一个判断条件是row - col 还是col - row对本题影响不大，首先x、y有一定的对称性，其次set也可以处理负数的下标
                continue

            # 如果通过了上面的判断，需要把新的Q的攻击区域也加入标志区域
            self.cols.add(col)
            self.pie.add(row + col)
            self.na.add(row - col)

            self.DFS(n, row + 1, cur_state + [col]) # +号等价于cur_state.append(col)，不会生成嵌套列表

            self.cols.add(col)
            self.pie.add(row + col)
            self.na.add(row - col)

    def generate_result(self, n):
        board = []
        for res in self.result:
            for i in res:
                board.append("." * i + "Q" + "." * (n - i - 1))
                # 这里python打印格式输出的语法简洁的令人发指。。
        return [board[i: i + n] for i in range(0, len(board), n)]

 */


