/**StringReduce.java
 * com.others
 * ���׹ٷ��̳�ĳ��ı�������
 * �ַ�����д
��Ŀ������
���������ַ���ȫ���Ǵ�дӢ����ĸ�������������M����M>=4�������ֵ�˳�����ڵĴ�д��ĸ������дΪ������ĸ-β��ĸ������ʽ
�������룺XYZABCDMMM    �����XYZA-DMMM
 * @author liar
 * 2020��4��1�� ����11:54:46
 * @version 1.0
 */
package com.others;


public class StringReduce {

	/**
	 * @Description: TODO
	 * @para: @param args
	 * @return: void
	 * @throws: @param args
	 * @author: liar
	 * @date: 2020��4��1�� ����11:54:46
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(reduceString("WXYZABCDEMMM"));
		System.out.println(reduceStringSample("WXYZABCDEMMM"));

	}
	
	private static String reduceString(String inputString) {
		int M = 4; //�����ִ���ͳ��
		int count = 1; //����ͳ��������ĸ���ֵĸ���
		int startIndex = 0; //����ָʾ�������ڿ�ʼλ��
		char[] arr = inputString.toCharArray();
		//�ַ����Ĳü���΢�е��鷳����
		//������ѻ����¼��StringBuffer�������ɾ�������滻�����������toString
		StringBuilder tempsb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			tempsb.append(arr[i]);
			if ((i+1 < arr.length) && (arr[i+1] - arr[i] == 1)) {
				//�����ƺ���Ӧ��ֻ��if����Ҫ��while
				count++;//�����ĸ�����������ۼ�count
				startIndex = i;
				//����startIndex�����������ԭʼ��inputString��
				//���Ǻ����sb.delete��ʱ����Ҫʹ�����sb���������Գ�����
				//��������"WXYZABCDEMMM"����Ӧ�÷���"W-ZA-EMMM"�����������
				//"W-ZA-BMMM"
				i++;
				tempsb.append(arr[i]);
				while((i+1 < arr.length) && (arr[i+1] - arr[i] == 1)){
					count++;
					i++;
					tempsb.append(arr[i]);
				}//����������һֱѭ��ͳ��count����
				
				if (count >= M) {
					tempsb.delete(startIndex + 1, i);
					//ɾ���ظ��ַ����ٲ���һ��-
					tempsb.insert(tempsb.length() - 1, '-');
					count = 1;
				} else {
					count = 1;
				}	
			}	
			
		}
		
		return tempsb.toString();
	}

	
	private static String reduceStringSample(String inputString) {
		int len = inputString.length();
		int pos = 0;
		//ע�⵽ʾ���Ľⷨ��ֱ�Ӷ����ض���OJ����°������ӡ�˳���
		//����뷵�ر��κ󴮻��ǵ�ʹ��Sb����
		StringBuilder sBuilder = new StringBuilder(); 
		while (pos < len) {
			int next;
//			for (next = pos + 1; next < len; ++next) {//����ʾ�����������õ���++next����next++��ʲô�����أ�
			for (next = pos + 1; next < len; next++) {	
				//������Ĵ����߼��ƺ�������++next�ĺô��ˣ�����Ҫ�������ж�next + 1 < len??�����
				if (inputString.charAt(next) - inputString.charAt(next - 1) != 1) {
					break;
				}
			}
			
			if (next - pos >= 4) {
				//printf("%c-%c", str[pos], str[next - 1]); //OJд��
				sBuilder.append(inputString.charAt(pos) + "-" + inputString.charAt(next - 1));
			} else {
				for (int i = pos; i < next; i++) {
					//putchar(str[i])  //OJд��
					sBuilder.append(inputString.charAt(i));
				}
			}
			pos = next;
		}
				
				
		return sBuilder.toString();
	}
}
