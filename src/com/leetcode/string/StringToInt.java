/**StringToInt.java
 * com.leetcode.string
 * TODO
 * 8. String to Integer (atoi)
 * ������һ��������������
 * @author liar
 * 2020��5��15�� ����5:57:38
 * @version 1.0
 */
package com.leetcode.string;

/**
 * @author liar
 *
 */
public class StringToInt {
	
	public static void main(String[] args) {
		StringToInt test = new StringToInt();
//		String input = "100000000000000000000000000000000000000000000000000";
		String input = "   -42";
		System.out.println(test.myAtoi(input));
	}
	
	
	public int myAtoi(String str) {
		//�������Ϊ�մ�������null��ȫû����
		int startIndex = findStartIndex(str);
		//startIndexΪ��һ�����ֻ��߷����ַ����±�
		if(startIndex == -1)
			return 0; //�մ�Ҳ���԰���������������
		
		boolean positive = true;//Ĭ�Ϸ��ű������
		if(str.charAt(startIndex) == '-'){
			positive = false;
			startIndex++;
		}
		if (str.charAt(startIndex) == '+') {
			startIndex++; //�������Ż��ߵ�һ������
		}
		
		//����ų�ǰ����Ч���롢������֮�󣬻�Ҫ�ų��������õ�0
		//���һλ��0����ɾ����Ҫ������ֵ
//		for(;startIndex < str.length() - 1;startIndex++)
//			if(str.charAt(startIndex) != '0')
//				break;
		//����������е�0��ɾ���ˣ�����һ������
		//����������õ�λ�ò��ԣ��û���λ��
		
		int endIndex = startIndex;
		for (; endIndex < str.length(); endIndex++) {
			if(!Character.isDigit(str.charAt(endIndex)))
				break;
		}//endIndexΪ��β�±꣬Ҳ�ǵ�һ����������ĸ���±꣬���ֵΪstr.length()
		
		for(;startIndex < endIndex - 1;startIndex++)
			if(str.charAt(startIndex) != '0')
				break;
		
		String numericString = str.substring(startIndex, endIndex);
		
		if(numericString.length() > 10){//������λ������10ʱ�϶��������
			if(positive)
				return Integer.MAX_VALUE;
			else 
				return Integer.MIN_VALUE;
		}
			
		Long longValue = Long.parseLong(numericString);
		//��������λ������10ʱ����ֵ�Կ������
		//debug��һ�·���������ʼ�Ѿ�ȥ�������ˣ����Ա߽�ֵ���ж���Ҫע��һ�¿��ǵ�����
		if(positive && longValue >= Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if(!positive && (longValue - 1 >= Integer.MAX_VALUE))
			return Integer.MIN_VALUE;
		
		//һ��ʼ�������ҲҪ�����������ˡ���
		if (positive) {
			return Integer.parseInt(numericString);
		} else {
			return -Integer.parseInt(numericString);
		}
        
    }
	
	public int findStartIndex(String str){
		//����ֵΪ-1�����Ϸ�
		int index = 0;
		for (; index < str.length(); index++) {
			if(Character.isDigit(str.charAt(index)))//���֣��Ϸ����
				return index;
			if((str.charAt(index) == '+' || str.charAt(index) == '-') //����+���֣��Ϸ����
					&& (index + 1 < str.length()) && Character.isDigit(str.charAt(index + 1)))
				return index;//���ﷵ��ֵ��Ϊindex���ˣ��������л���Ҫȷ��������
			if (str.charAt(index) == ' ') { //�հ��ַ�������ƶ�ָ��
				continue;
			} else {
				return -1;
			}
		}
		
		return -1; //���forѭ��һֱû����ǰ������˵�����е��ַ����ǿ��ַ�����ʱҲ����-1
	}

	   public int myAtoiExample(String str) {
	       //�ο�������һ�����е�д����100��ʱ����Ҵ���ȷʵд�ĺܼ�࣬�߼�Ҳ������
		   int start=0;
	        //����ǰ�����Ч�ո�
	        while(start<str.length() && str.charAt(start)==' ') start++;
	        if(start>=str.length()) return 0;  //����ķ���0��Ӧ��ȫ�ո���ַ���
	        char first=str.charAt(start); //�˴������ϻ��ǻ������ĸ�������Ƿ��ַ�����Ϊǰһ��ֻ�����˿ո�
	        boolean neg=false;
	        long ans=0;
	        if(first=='-') neg=true;
	        else if(first=='+') ans=0;
	        else if(!Character.isDigit(first)) return 0; //�����ų����������Ϸ��ַ������
	        else if(Character.isDigit(first)) ans=first-'0'; //ע�⵽�����ǲ�����һ�ַ��������ķ�����ȷ����ֵ����û��ʹ��Java���õ�Longת������
	        for(int i=start+1;i<str.length();i++){
	            if(!Character.isDigit(str.charAt(i))) break;
	            else{
	            if(neg) ans=ans*10-(str.charAt(i)-'0'); //��������ظ��жϷ��Ÿо������� �������������������д��forѭ����ʵҲͦ�鷳�ġ���
	            //�и����⣬�����һλ�Ĵ�û��ȡ���Ų���Ӱ�����ս���𣿣�
	        //�����ᣬ��ֵΪ����ʱ���һλ��û�м�����ֵ��ֻ��ȡ�˸��Ų��ƶ���ָ��
	            else ans=ans*10+(str.charAt(i)-'0');
	            }
	            //���������һ�Ƚϵķ���ȷ���Ƿ�Խ�磬�����о����ڼ����������λ���ر𳤵�ʱ�򣬻���ֱ���ж�λ������һЩ
	            if(ans<Integer.MIN_VALUE) return Integer.MIN_VALUE;
	            if(ans>Integer.MAX_VALUE) return Integer.MAX_VALUE;
	        }
	        return (int)ans; //������������ᱨ���𣿣�֮ǰlongתint���������ˡ���
	    }
}
