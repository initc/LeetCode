package com.jie;

public class ExcelSheetColumnnNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(titleToNumber("ZZABGF"));
	}

	public static int titleToNumber(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			result = result * 26 + s.charAt(i) - 'A' + 1;

		}
		return result;
	}
}
