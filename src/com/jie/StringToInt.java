package com.jie;

public class StringToInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(myAtoi("   321"));
		System.out.println(Integer.MAX_VALUE + "   " + Integer.MIN_VALUE);
	}

	public static int myAtoi(String str) {
		long result = 0;
		boolean isNeg = false, isPos = false;
		boolean isErro = false;
		long big = 2147483647;
		big++;
		int index = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if (ch > '9' ||ch < '0') {

				if (ch == '-') {
					if (isPos) {
						// 设置了正数 现在又来设置负数 引起错误
						return 0;
					}
					// 两个负数的情况
					if (isNeg)
						return 0;
					isErro = true;
					isNeg = true;
					continue;

				}
				if (ch == '+') {
					if (isNeg) {
						return 0;// 设置了负数又来设置正数 引起错误
					}
					// 兩個正数的情况
					if (isPos)
						return 0;
					isErro = true;
					isPos = true;
					continue;
				}
				if (ch == ' ') {
					if (!isErro)
						continue;
					else
						return 0;
				}
               
				return 0;
			} else {
				index = i;
				break;
			}

		}
		char ch ;
		for (; index < str.length(); index++) {
         ch=str.charAt(index);
			if (ch <= '9' && ch >= '0') {
				long tp = ch - '0';
				result = result * 10 + tp;
				if(isNeg&&result>big){
					result=big;
					break;
				}else 
				if(!isNeg&&result>2147483647){
					
					result=2147483647;
					break;
				}
			}else{
				break;
			}
			
		}
		if (isNeg)
			result = -result;
		return (int) result;
	}
	/*
	 * 1.数字前面有空格 如s=“ 123456” 2.数字前出现了不必要或多于的字符导致数字认证错误，输出0 如s=“ b1234” ，s=“
	 * ++1233” , s=“ +-1121” 3.数字中出现了不必要的字符，返回字符前的数字 如s=“ 12a12” ， s=“ 123 123”
	 * 4.数字越界 超过了范围（-2147483648--2147483647) 若超过了负数的 输出-2147483648
	 * 超过了正数的输出2147483647 在科普一个知识点，倘若某个数超过了2147483647则会变为负数，反过来一样
	 */
	public int myAtoi_2(String str) {
        
		long result = 0;
	boolean isNeg = false, isPos = false;
	boolean isErro = false;
	long  big=2147483647;
	big++;
	for (int i = 0; i < str.length(); i++) {

		char ch = str.charAt(i);
		if (ch == '-') {
			if (isPos) {
				// 设置了正数 现在又来设置负数 引起错误
				return 0;
			}
			if(isNeg)
				return 0;
			isErro = true;
			isNeg = true;
			continue;
		}
		if (ch == '+') {
			if (isNeg) {
				return 0;// 设置了负数又来设置正数 引起错误
			}
			if(isPos)
				return 0;
			isErro = true;
			isPos = true;
			continue;
		}
		if (ch == ' ') {
			if (!isErro)
				continue;
			else
				break;
		}
		if ((ch < '0' || ch > '9')) {
			// 在之前出现了非法字符
			if (!isErro) {
				return 0;

			} else {

				break;

			}

		}
		if (ch <= '9' && ch >= '0') {
			isErro = true;
			long tp = ch - '0';
			result = result * 10 + tp;
			if(isNeg&&result>big){
				
				result=big;
				break;
			}
			if(!isNeg&&result>2147483647){
				
				result=2147483647;
				break;
			}
		}

	}
	if (isNeg)
		result = -result;
	return (int) result;


}
}
