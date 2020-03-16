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
		
		System.out.println("�ܹ���" + count + "�ַ���");
	}
	
	static void recursion(char[] inputArray, int index){
		//��index=len-1��ʱ���ʾ�ݹ���ɣ���ӡ���
		//���������֪����������ã����������ɵ��ַ����á���
		//һ��ʼ��Ϊ��Ҫ�����µ��ַ����ģ�û�뵽һֱ��char�������ǶԵ�
		if (6 == index) {
//			System.out.println(inputArray.toString());
			//�ַ��������޷�ֱ��ͨ��toString����ת����String
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
        //����ʹ��StringBuilder���βο���Ч���᲻���Щ
        //�������ڴ��������С�����Ƕ�����÷�������ʱ�������
        StringBuilder sBuilder = new StringBuilder(); 
        genP(result, "", n, n);
        return result;
    }
    
    static void genP(List<String> resultList,String str, int left, int right){
    	//�������ŵļ�����n�ݼ���0���˿������Щ
    	if ((0 == left)&&(0 == right)) {//֮ǰ��ʦû˵��û���֣�if�ؼ��ʺ��棬�������ź�����ʵ����һ���ո�
    		//��ʦ�ᵽ��׼���������2�ո񣨹ȸ�java��׼��������ƽʱ�����õĶ���4�ո�ġ�
    		System.out.println(str);
			resultList.add(str);
			return;
		}
    	
    	if (left > 0) {
			genP(resultList, str + "(", left - 1, right);
		}
    	
    	if ((left < right)&&(right > 0)) {//��������ݼ��Ļ�����ʣ��һ��Ҫ�ȣ�С
//    	if (left < right) {	
    		//����ڶ���javaд��û��right > 0 ���Ƿ��Ǳ�����أ�
    		//�Ƿ�����left�����������������
    		//Ҳ�п��ܣ�������ֹ����Ҫ����&&���п��ܳ���6�������ţ�left=-3�����������right>0�����޼���Ч����������
    		genP(resultList, str + ")", left, right - 1);
		}
    	
    }
	
}
