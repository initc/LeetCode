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
		// ��̬�滮 kk��ʾ�ڴ˿̵�λ�� ÿһ�����������Դ��ڵĴ���
		// ���� 1λ���Ļ� 4���ƵĻ� ˵�� 0���Դ���0�� ӦΪ0������Ͳ������� �� 1���Դ���1�Ρ�����
		// kk��ʾ������nλ��ʱ�� ÿһ�������Դ��ڵĴ��� ���� �ڱ仯��nλʱ ������Ϊ�����С�������������n-1
		// λ������
		kk[0] = 0;
		temp[0] = 0;
		for (int i = 1; i < k; i++) {

			kk[i] = temp[i] = 1;

		}
		for (int i = 2; i <= l; i++) {
			// ���ڵڼ�����
			for (int j = 0; j < k; j++) {
				// n-1�ε����ֶ��г���
				for (int m = 0; m < k; m++) {

					if (j < m - 1 || j > m + 1) {
						// ����n-1λ�� m���� ֻҪ��ǰ����������Ϳ���
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
