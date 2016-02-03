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
	 * ������ ���԰�n�ֽ�� n1+n1*26+n2*26.... ����������Ҫ��� n1����nn
	 * ������Ҫ֪������n1�ķ�Χ��1-26�������ǿ���n--;�õ� 0-25 �ٴ���n%26��ȡn1 ÿһ��ѭ������ʹn/26 ��ι���
	 * n1��Ȼ��1-26
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
