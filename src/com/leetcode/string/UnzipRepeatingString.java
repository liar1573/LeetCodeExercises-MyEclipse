/**
 * ��Ѷ2020У԰��Ƹ-��̨20200919
 * ����СQ������һ��ѹ���㷨���ַ������ظ��Ĳ��ֽ�����ѹ���������ַ�����������m����ͬ�ַ���S����ѹ��Ϊ[m|S](mΪһ��������1<=m<=100)��
 * �����ַ���ABCABCABC���ᱻѹ��Ϊ[3|ABC]������СQ��ͬѧ�յ���СQ���͹������ַ��������ܰ��������н�ѹ��ô�� 
 */
package com.leetcode.string;


public class UnzipRepeatingString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(('3' - '0') == 3);
		UnzipRepeatingString test = new UnzipRepeatingString();
//		System.out.println(test.dfs("HG[3|B[2|CA]]F"));
//		System.out.println("input".substring(6, 6));
		System.out.println(test.unzipString("HG[3|B[2|CA]]F"));
	}
	
	//������һ�ѵ���֮�����������ȷ����ˣ�������
	//֮����Ե���һ��IO��ȥOJ��������
	public String unzipString(String input) {
		String result = input;
		while (result.indexOf('|') >= 0) //ע�⵽���ﲻ����[]�жϣ�ֻ����|
			result = unzip(result);
		
		return result;
	}
	
	public String unzip(String input) {
		//���ص��ν�ѹ�Ľ������û��ʹ�õݹ�
		StringBuilder sBuilder = new StringBuilder();
		
		int start = input.lastIndexOf('[');
		int end = input.indexOf(']');
		int seperatorIndex = input.lastIndexOf('|');	
		//�µķָ�ģʽ�£�ÿһ�ε����϶���ͬʱ����[]��|
		
		int times = 0, bit = 1;			
		for (int i = seperatorIndex - 1; i > start; i--) {
			times += bit * (input.charAt(i) - '0');
			bit *= 10;
		}
		
		//���������
		sBuilder.append(input.substring(0, start));
		sBuilder.append(repeatString(times,input.substring(seperatorIndex + 1, end)));
		sBuilder.append(input.substring(end + 1, input.length()));

		return sBuilder.toString();
	}
	
	
	
	//��һ��ʧ�ܵĵݹ鷽������
	public String dfs(String input) {
		if(input.indexOf('|') == -1){
			return input;
		}
		
		int start = input.indexOf('[');
		int end = input.lastIndexOf(']');
		int seperatorIndex = input.indexOf('|');
		int times = 0, bit = 1;
		int numIndex = (start > seperatorIndex)? -1 : start;			
		for (int i = seperatorIndex - 1; i > numIndex; i--) {
			times += bit * (input.charAt(i) - '0');
			bit *= 10;
		}
		//��������ʱ������start����end = -1�����
		
		if(start < 0){
			return repeatString(times, dfs(input.substring(seperatorIndex + 1, input.length())));
		}else{
		return input.substring(0, start) + 
			repeatString(times, dfs(input.substring(start + 1, end)) )
		+ input.substring(end + 1, input.length());
		//�������һ���ֵ�substring�о�end+1��length�п��ܻ�Խ�硣��
		}
	}
	
//	public String dfs(String input) {
//		if(input.indexOf('[') == -1){
//			if(input.indexOf('|') > 0){
//				int seperatorIndex = input.indexOf('|');
//				int times = 0, bit = 1;
//				for (int i = seperatorIndex - 1; i >= 0; i--) {
//					times += bit * (input.charAt(i) - '0');
//					bit *= 10;
//				}
//				return repeatString(times, input.substring(seperatorIndex + 1, input.length())); 
//			}else {
//				return input;
//			}
//		}
//		
//		int start = input.indexOf('[');
//		int end = input.lastIndexOf(']');
////		int seperatorIndex = input.indexOf('|');
////		int times = 0, bit = 1;
////		for (int i = seperatorIndex - 1; i > start; i--) {
////			times += bit * (input.charAt(i) - '0');
////			bit *= 10;
////		}
//		
//		
//		return input.substring(0, start) + 
//			dfs(input.substring(start + 1, end)) 
//		+ input.substring(end + 1, input.length());
//		//�������һ���ֵ�substring�о�end+1��length�п��ܻ�Խ�硣��
//	}
//	
	public String repeatString(int times, String input) {
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i < times; i++) 
			sBuilder.append(input);
		return sBuilder.toString();
	}
	
}
