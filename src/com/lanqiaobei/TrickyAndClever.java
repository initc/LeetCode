package com.lanqiaobei;

import java.util.Scanner;

public class TrickyAndClever {

	public static void main(String[] args) {

		
		/*  LUS("abbabab");
		  System.out.println("index="+subIndex+"  first="+subFirst
		  +"  max="+max);*/
		 
		
		Scanner in = new Scanner(System.in);
		String pp = in.nextLine();
		LUS(pp);
		if (subIndex != subFirst + 1) {

			LUSNo(pp.substring(subFirst + 1, subIndex));
			// System.out.println("index="+subMiddle+" max="+max_middle);
			if (0 == subMiddle && subFirst + 1 + max_middle == subIndex) {
				System.out.println("1");
				System.out.println((subFirst + 1 - max + 1) + " "
						+ (subIndex + 2 * max - 1 - subFirst));
				return;
			}
			System.out.println("3");
			System.out.println((subFirst - max + 1 + 1) + " " + max);
			System.out.println((subFirst + max_middle + 1) + " " + max_middle);
			System.out.println((subIndex + 1) + " " + max);

		} else {

			System.out.println("1");
			System.out.println((subFirst + 1 - max + 1) + " "
					+ (subIndex + 2 * max - 1 - subFirst));
		}
		
	}

	private static int subFirst;
	private static int subIndex;
	private static int max;
	private static int subMiddle;
	private static int max_middle;

	public static void LUS(String str) {
		int len = str.length();
		int[] dp = new int[len + 1];

		for (int i = 0; i < len; i++)
			for (int j = 0; j < len; j++) {
				if (j > i && str.charAt(i) == str.charAt(j)) {
					dp[len - j] = dp[len - j - 1] + 1;
				} else {
					dp[len - j] = 0;
				}
				if (dp[len - j] >= max) {
					if (dp[j] == max_middle && subIndex - 1 == subFirst) {
						max = 0;
						subIndex = 0;
						subFirst = 0;
					} else {
						max = dp[len - j];
						subIndex = j;
						subFirst = i;
					}
				}

			}

	}

	public static void LUSNo(String str) {
		int len = str.length();
		int[] dp = new int[len + 1];

		for (int i = 0; i < len; i++)
			for (int j = 0; j < len; j++) {
				if (str.charAt(i) == str.charAt(j)) {
					dp[len-j] = dp[len-j-1] + 1;
				} else {
					dp[len-j] = 0;
				}
				if (dp[len-j] > max_middle) {

					max_middle = dp[len-j];
					subMiddle = j;

				}

			}

	}

}
