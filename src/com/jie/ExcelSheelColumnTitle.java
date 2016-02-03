package com.jie;


public class ExcelSheelColumnTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertToTitle2(26 + 26 * 26));
		//System.out.println(1>>>12);
		
		
		
	}
 
	/*
	 * Given a positive integer, return its corresponding column title as appear
	 * in an Excel sheet.
	 * 
	 * For example:
	 * 
	 * 1 -> A 2 -> B 3 -> C ... ... ... 26 -> Z 27 -> AA 28 -> AB
	 */
	/**
	 * 如何求解 可以把n分解成 n1+n1*26+n2*26.... 所以我们需要求解 n1。。nn
	 * 首先需要知道的是n1的范围是1-26所以我们可以n--;得到 0-25 再次是n%26获取n1 每一次循环再来使n/26 这次过后
	 * n1依然是1-26
	 * 
	 * @param n
	 * @return
	 */
	public static String convertToTitle(int n) {
		StringBuilder str = new StringBuilder();
		char A = 'A';
		do {

			n--;
			str.insert(0, (char) (A + n % 26));
			n /= 26;
		} while (n != 0);

		return str.toString();
	}
	public static String convertToTitle2(int n) {
		char A = 'A';
		int n1 = n;
		int index=0;
		do {
			n1--;
			index++;
			n1 /= 26;
		} while (n1 != 0);
		char [] chs=new char[index];
        for(int i=index-1;i>=0;i--){
        	n--;
        	chs[i]=(char) (A + n % 26);
        	n/=26;
        }
		

		return new String(chs);
	}
}
