package com.lanqiaobei;

import java.util.Scanner;

public class GoodK {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		int l = in.nextInt();
		long sum = 0;
		int[] kk = new int[101];
		int[] temp = new int[101];
		// 动态规划 kk表示在此刻的位数 每一个进制数可以存在的次数
		// 比如 1位数的话 4进制的话 说明 0可以存在0次 应为0这个数就不是数了 此 1可以存在1次。。。
		// kk表示的是在n位的时候 每一个数可以存在的次数 就是 在变化第n位时 他可以为的数有。。。是依赖于n-1
		// 位的数字
		kk[0] = 0;
		temp[0] = 0;
		for (int i = 1; i < k; i++) {

			kk[i] = temp[i] = 1;

		}
		for (int i = 2; i <= l; i++) {
			// 对于第几数字
			for (int j = 0; j < k; j++) {
				// n-1次的数字都列出来
				for (int m = 0; m < k; m++) {

					if (j < m - 1 || j > m + 1) {
						// 对于n-1位的 m数字 只要当前的数字满足就可了
						temp[j] += kk[m];

					}

				}

			}

			for (int p = 0; p < k; p++) {
				kk[p] = temp[p] % 1000000007;
			}

		}
		for (int i = 0; i < k; i++) {
			sum += kk[i];
			sum %= 1000000007;
		}
		System.out.println(sum);
	}

	public static int getK(int n, int k, int l) {
		if (l == 0) {
			int su = 0;
			for (int i = n + 2; i < k; i++) {
				su += 1;

			}
			for (int i = n - 2; i >= 0; i--) {
				su += 1;
			}
			return su;
		}
		int sum = 0;
		for (int i = n + 2; i < k; i++) {
			sum += getK(i, k, l - 1);
			sum %= 1000000007;
		}
		for (int i = n - 2; i >= 0; i--) {
			sum += getK(i, k, l - 1);
			sum %= 1000000007;
		}
		return sum;
	}
}
