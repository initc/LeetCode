package com.jie;

import java.util.Arrays;

public class NumberComputer {
	public static int N =21;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(Long.MAX_VALUE);
		byte[] data = new byte[N];
		for (int u = 0; u < N; u++)
			data[u] = 0;
		// pri(data);
		comp(Arrays.copyOf(data, data.length), 0, 0, 0);

	}

	public static void comp(byte[] data, int pos, double sum_n, double sum_s) {

		// for(int i=pos;i<N;i++){
		if (pos == N)
			return;
		for (int j = 0; j < 10; j++) {
			if (pos == 0 && j == 0) {
				continue;
			}

			/*if (data[2] == 6 && data[1] == 3) {

				int o = 0;
				System.out.println(o);
			}*/

			int s = data[pos];
			data[pos] = (byte) j;
			sum_n = sum_n - sumNum(s, N) + sumNum(j, N);
			sum_s = sum_s - s * sumNum(10, N - pos - 1) + ((int) j)
					* sumNum(10, N - pos - 1);
			if (sum_n == sum_s) {
				pri(data);
			}
			comp(data, pos + 1, sum_n, sum_s);

		}
		data[pos]=0;
		// }
		//Arrays.copyOf(data, data.length)
	}

	public static void pri(byte[] data) {
		StringBuffer bu = new StringBuffer();
		for (int i = 0; i < N; i++) {
			bu.append(data[i]);
			// System.out.print(data[i]);

		}
		System.out.println(bu);
	}

	public static double sumNum(int num, int n) {
        
		double result = 1;
		for (int i = 0; i < n; i++) {
			result *= num;
		}
		return result;

	}

}
