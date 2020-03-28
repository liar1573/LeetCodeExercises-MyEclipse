
package com.leetcode.pruning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**NQueens.java
 * com.leetcode.pruning
 * LC 51 ��֦�㷨�е�N�ʺ�����
 * �ļ����·�����һЩPython��ʵ�ִ���
 * @author liar
 * 2020��3��25�� ����9:36:15
 * @version 1.0
 */
public class NQueens {

	/**
	 * @Description: TODO
	 * @para: @param args
	 * @return: void
	 * @throws: @param args
	 * @author: liar
	 * @date: 2020��3��25�� ����9:36:15
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueens testNQ = new NQueens();
		testNQ.solveNQueens(4);
//		testNQ.solveNQueensSample(4);
		
		
	}
	
	public List<List<String>> solveNQueens(int n) {
        if(n < 1){
        	return null;//����֮�䷵�ؿգ��ⲿ���жϺ���
        }
        //��Ȼ��һ��n=1��������ˡ�����ȷʵn=1Ҳ������������n=2��3������
        //���жϸĳ� n < 1��ֻ����2��3��ʱ�򷵻�[]
        
        ArrayList<List<String>> result = new ArrayList<List<String>>();
        //ע�⵽����һ�κ���ֻ���û�һ�����࣬����һ����д������ArrayListǶ�׷��򷵻�ֵ�ᱨ��
        //Java��ʵ������Ҳ���������־�ģ������Լ�Ҳ�������־����
        //ʾ����������������Ӧ������ô�е����ţ�ֱ���ڲ�����newû�б�������
        boolean[] cols = new boolean[n];
        //����Խ��ߵ�������2n-1������Ȼ�м����ط������Է��ʲ����ģ������ȿ��ٶ���Ŀռ�����Ժ��±�Խ��
        boolean[] pie = new boolean[2*n]; //pie��na��������о��������׼�
        boolean[] na = new boolean[2*n]; //��������Ĭ�ϳ�ʼֵ��false
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
		//pythonʵ�ֻ���javaʵ�ֵ�ʱ��Ҫ����ע��һЩ����Ϊpython�м����������������Ͷ���
		//����Javaʵ��֮��Ҫ�����ϸ���������ͼ��
		if (n == row) {
			//�������ȴ��������Ӳ���������������һ�¾Ϳ���ȷ����n������n-1����
			solve.add((List<Integer>) tempList.clone());
		}
		
		for (int col = 0; col < n; col++) {
			if ((cols[col])||(pie[row + col])||(na[row - col + n])) {
				//�����±�ֻ��Ҫ+n�Ϳ��Ա�֤������ָ�����
				//ͬʱpie��na���±겢����Ҫ��ʾ̫����ĺ��壬ֻҪ�ֱܷ治ͬб�߼���
				continue;
			}
			
			cols[col] = true; pie[row + col] = true; na[row - col + n] = true;
			//����Ӧ�ò���ﵽ�����±��Ͻ�2n-1�ɣ�����ﵽ��֮ǰ�Ŀռ俪�ٻ���2n����
			//ע������û�취��tempList.addֱ�Ӽ�дһ�зŽ������б����棬����᷵��boolean���ͷ���ֵ���ᵼ�²������Ͳ�ƥ�䡣��
			tempList.add(col);
			dfs(n, row + 1, cols, pie, na, solve, tempList);
			//ע�⵽���ﴫ��boolean����ʱ��ҲҪ��������лָ�����
			//֮ǰ��һ���������pythonд��������Ҫ�ָ�����֪��java�ܲ���ʵ�֡���
			//��Ч�Ľ����tempList���Ƴ�������
			tempList.remove(tempList.size() - 1);//���������LinkedList�Ϳ���ֱ��removeLast��
			cols[col] = false; pie[row + col] = false; na[row - col + n] = false;		
		}
	}

	private void formatPrint(ArrayList<List<Integer>> solve, ArrayList<List<String>> result) {
		for (List<Integer> list : solve) {
			ArrayList<String> tempStringList = new ArrayList<String>();
			for (Integer integer : list) {
				StringBuilder tempSb = new StringBuilder();
				//�ο�������ʹ��Arrays�������char[]��������
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
	
	
	public List<String[]> solveNQueensSample(int n) {//�ο�����
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
				//�����±�ֻ��Ҫ+n�Ϳ��Ա�֤������ָ�����
				//ͬʱpie��na���±겢����Ҫ��ʾ̫����ĺ��壬ֻҪ�ֱܷ治ͬб�߼���
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
        if n < 4:  #NС��4ʱ�Ļʺ����ⶼ���޽��
            return []
        self.result = [] # ����������Ѿ��������ܶ��ֱ���ں���������self��������
        # ������Ч��������ͬ������һ���ļ�ȫ�ֱ���
        # �ں���������self������pycharm����һ�����棺Instance attribute result defined outside __init__
        # ��������������������ķ�������Ҫ���ڶ���ĳ�ʼ���������棬�����⺯��������Ҳ�����õ��ǲ�̫����
        self.cols = set(); self.pie = set(); self.na = set()
        # ����������ȫ��set����¼�������������򣬺ô��ǲ���Ҫ�����������Ҳ��ô������±꣬�߼��Ƚ�����
        # ����set��ʹ�û��������Ŀ�������Ȼset�Ĳ��붼�ǳ���ʱ��Ӧ��Ӱ��Ҳ���󣩣�ͬʱʹ��ȫ��set�ڵݹ��������Ҫ��λ�����Ϣ
        self.DFS(n, 0, [])
        return self.generate_result(n)

    def DFS(self, n, row, cur_state):
        # �������cur_state�����͵�����ʲô��������������������Ƕ�׵�list
        # �ݹ���ֹ�жϣ��ﵽ��ײ�
        if row == n: # ����ݹ�ﵽ�Ͳ�˵��ǰ������������㣬�ѵ�ǰ����뼯�ϲ�����
            self.result.append(cur_state)
            return

        for col in range(n): # ����б�����ͨ���ݹ麯������rowʵ�ֵģ��ڲ�ֻ������б���
            if (col in self.cols) or (row + col in self.pie) or (row - col in self.na):
                #�µ�Q�ᱻ֮ǰ�Ĺ���������ǰ�ķ���������ֱ������
                # ����ԭ������ȫû�����ſ��źܲ�����Ͳ�����
                # ���һ���ж�������row - col ����col - row�Ա���Ӱ�첻������x��y��һ���ĶԳ��ԣ����setҲ���Դ��������±�
                continue

            # ���ͨ����������жϣ���Ҫ���µ�Q�Ĺ�������Ҳ�����־����
            self.cols.add(col)
            self.pie.add(row + col)
            self.na.add(row - col)

            self.DFS(n, row + 1, cur_state + [col]) # +�ŵȼ���cur_state.append(col)����������Ƕ���б�

            self.cols.add(col)
            self.pie.add(row + col)
            self.na.add(row - col)

    def generate_result(self, n):
        board = []
        for res in self.result:
            for i in res:
                board.append("." * i + "Q" + "." * (n - i - 1))
                # ����python��ӡ��ʽ������﷨�������˷�ָ����
        return [board[i: i + n] for i in range(0, len(board), n)]

 */


