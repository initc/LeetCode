package com.jie;

import java.util.Arrays;

public class Fastsort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = { 1, 2, 2, 2, 8, 8, 78, 85, 74, 74, 22, 1, 1, 1, 1, 1,
				256, 2333, 2666, 221, 21, 2, 2, 2, 2, 3, 3, 3, 3, 6, 6, 6, 5,
				5, 5, 5, 5, 5, 5, 8 };
		System.out.println(Arrays.toString(fastSort(data, 0, data.length - 1)));
	}

	public static int[] fastSort(int[] data, int begin, int end) {
		if (end - begin < 1)
			return data;

		int da = data[begin];
		int i = begin + 1;
		int j = end;
		while (i < j) {
			while (i < j) {
				if (data[i] < da) {
					i++;
				} else {
					break;
				}
			}
			while (j >= i) {
				if (data[j] > da) {
					j--;
				} else {
					break;
				}

			}

			if (i < j) {
				int temp = data[i];
				data[i] = data[j];
				data[j] = temp;
				i++;
			}

		}
		if (data[begin] > data[j]) {
			data[begin] = data[j];
			data[j] = da;
		}
		fastSort(data, begin, j - 1);
		fastSort(data, i, end);

		return data;
	}

}
