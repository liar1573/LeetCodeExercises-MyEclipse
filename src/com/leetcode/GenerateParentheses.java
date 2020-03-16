package com.leetcode;
import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	ArrayList<Integer> myArrayList;
	static int count = 0;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		function();
		
		generateParenthesis(3);
	}
	
	static void function(){
		char[] charArray = new char[6];
		
		recursion(charArray, 0);
		
		System.out.println("总共有" + count + "种方法");
	}
	
	static void recursion(char[] inputArray, int index){
		//当index=len-1的时候表示递归完成，打印结果
		//这里参数不知道是用数组好，还是新生成的字符串好。。
		//一开始以为需要传入新的字符串的，没想到一直用char数组结果是对的
		if (6 == index) {
//			System.out.println(inputArray.toString());
			//字符串数组无法直接通过toString方法转换到String
			for (char c : inputArray) {
				System.out.print(c);
			}
			System.out.println();
			count++;
			return;
		}
		
		inputArray[index] = '(';
		recursion(inputArray, index+1);
		
		inputArray[index] = ')';
		recursion(inputArray, index+1);
	}

    public static List<String> generateParenthesis(int n) {
        if(n <= 0){
        	return new ArrayList<String>();
        }
        
        List<String> result = new ArrayList<String>();
        //尝试使用StringBuilder做形参看看效果会不会好些
        //理论上内存用量会减小，但是额外调用方法可能时间会增加
        StringBuilder sBuilder = new StringBuilder(); 
        genP(result, "", n, n);
        return result;
    }
    
    static void genP(List<String> resultList,String str, int left, int right){
    	//左右括号的计数由n递减到0好了看着舒服些
    	if ((0 == left)&&(0 == right)) {//之前老师没说都没发现，if关键词后面，左右括号后面其实都有一个空格
    		//老师提到标准缩进风格是2空格（谷歌java标准），不过平时好像用的都是4空格的。
    		System.out.println(str);
			resultList.add(str);
			return;
		}
    	
    	if (left > 0) {
			genP(resultList, str + "(", left - 1, right);
		}
    	
    	if ((left < right)&&(right > 0)) {//如果计数递减的话，（剩的一定要比）小
//    	if (left < right) {	
    		//这里第二种java写法没加right > 0 ，是否是必须的呢？
    		//是否会出现left减到负数的情况？？
    		//也有可能，由于中止条件要满足&&，有可能出现6个左括号，left=-3的情况，加上right>0可以修剪无效情况更快结束
    		genP(resultList, str + ")", left, right - 1);
		}
    	
    }
	
}
