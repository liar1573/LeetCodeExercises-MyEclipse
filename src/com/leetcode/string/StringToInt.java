/**StringToInt.java
 * com.leetcode.string
 * TODO
 * 8. String to Integer (atoi)
 * 考虑了一大堆特殊情况。。
 * @author liar
 * 2020年5月15日 下午5:57:38
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
		//输入可以为空串，但是null完全没意义
		int startIndex = findStartIndex(str);
		//startIndex为第一个数字或者符号字符的下标
		if(startIndex == -1)
			return 0; //空串也可以包括到这个情况里面
		
		boolean positive = true;//默认符号标记是正
		if(str.charAt(startIndex) == '-'){
			positive = false;
			startIndex++;
		}
		if (str.charAt(startIndex) == '+') {
			startIndex++; //跳过符号或者第一个数字
		}
		
		//因此排除前排无效输入、正负号之后，还要排除多余无用的0
		//最后一位的0不能删掉，要保持数值
//		for(;startIndex < str.length() - 1;startIndex++)
//			if(str.charAt(startIndex) != '0')
//				break;
		//这样会把所有的0都删掉了，得留一个。。
		//或者这个放置的位置不对，得换个位置
		
		int endIndex = startIndex;
		for (; endIndex < str.length(); endIndex++) {
			if(!Character.isDigit(str.charAt(endIndex)))
				break;
		}//endIndex为结尾下标，也是第一个非数字字母的下标，最大值为str.length()
		
		for(;startIndex < endIndex - 1;startIndex++)
			if(str.charAt(startIndex) != '0')
				break;
		
		String numericString = str.substring(startIndex, endIndex);
		
		if(numericString.length() > 10){//当数字位数大于10时肯定是溢出了
			if(positive)
				return Integer.MAX_VALUE;
			else 
				return Integer.MIN_VALUE;
		}
			
		Long longValue = Long.parseLong(numericString);
		//还有数字位数等于10时，数值仍可能溢出
		//debug了一下发现这里起始已经去掉符号了，所以边界值的判断需要注意一下考虑到符号
		if(positive && longValue >= Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if(!positive && (longValue - 1 >= Integer.MAX_VALUE))
			return Integer.MIN_VALUE;
		
		//一开始忘了最后也要加正负符号了。。
		if (positive) {
			return Integer.parseInt(numericString);
		} else {
			return -Integer.parseInt(numericString);
		}
        
    }
	
	public int findStartIndex(String str){
		//返回值为-1代表不合法
		int index = 0;
		for (; index < str.length(); index++) {
			if(Character.isDigit(str.charAt(index)))//数字，合法情况
				return index;
			if((str.charAt(index) == '+' || str.charAt(index) == '-') //符号+数字，合法情况
					&& (index + 1 < str.length()) && Character.isDigit(str.charAt(index + 1)))
				return index;//这里返回值设为index好了，主函数中还需要确认正负号
			if (str.charAt(index) == ' ') { //空白字符，向后移动指针
				continue;
			} else {
				return -1;
			}
		}
		
		return -1; //如果for循环一直没有提前跳出，说明所有的字符都是空字符，此时也返回-1
	}

	   public int myAtoiExample(String str) {
	       //参考讨论区一个大佬的写法，100的时间而且代码确实写的很简洁，逻辑也很清晰
		   int start=0;
	        //跳过前面的无效空格
	        while(start<str.length() && str.charAt(start)==' ') start++;
	        if(start>=str.length()) return 0;  //这里的返回0对应于全空格的字符串
	        char first=str.charAt(start); //此处理论上还是会包含字母等其他非法字符，因为前一步只跳过了空格
	        boolean neg=false;
	        long ans=0;
	        if(first=='-') neg=true;
	        else if(first=='+') ans=0;
	        else if(!Character.isDigit(first)) return 0; //这里排除了其他不合法字符的情况
	        else if(Character.isDigit(first)) ans=first-'0'; //注意到本题是采用逐一字符串操作的方法来确定数值，并没有使用Java内置的Long转换函数
	        for(int i=start+1;i<str.length();i++){
	            if(!Character.isDigit(str.charAt(i))) break;
	            else{
	            if(neg) ans=ans*10-(str.charAt(i)-'0'); //这里大量重复判断符号感觉很冗余 ，不过如果不这样另外写个for循环其实也挺麻烦的。。
	            //有个问题，这里第一位的答案没有取负号不会影响最终结果吗？？
	        //并不会，数值为负的时候第一位并没有计算数值，只是取了负号并移动了指针
	            else ans=ans*10+(str.charAt(i)-'0');
	            }
	            //这里采用逐一比较的方法确认是否越界，不过感觉对于极端情况比如位数特别长的时候，还是直接判断位数更快一些
	            if(ans<Integer.MIN_VALUE) return Integer.MIN_VALUE;
	            if(ans>Integer.MAX_VALUE) return Integer.MAX_VALUE;
	        }
	        return (int)ans; //这里编译器不会报错吗？？之前long转int都被报错了。。
	    }
}
