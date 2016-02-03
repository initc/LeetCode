package com.jie;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NQueens_HaveProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> list = solveNQueens(12);
		System.out.println(list.size());
		for (List<String> li : list) {

			for (String s : li) {

				System.out.println(s);
			}

			System.out.println("---------------------------------");
		}
	}

	public static List<List<String>> solveNQueens(int n) {
		List<List<String>> lists = new LinkedList<List<String>>();
		Stack<Integer> stack = new Stack<Integer>();
		boolean ok[][] = new boolean[n][n];
		int[] index = new int[n];
		boolean is = false; // 表示一轮是否成功
		for (int i = 0; i < n; i++) {
			index[i] = -1;
		}
		char[] ch = new char[n];
		for (int i = 0; i < n; i++) {
			ch[i] = '.';
		}
		StringBuilder str = new StringBuilder(new String(ch));
		// System.out.println(str);
		stack.push(0);
		for (; !stack.isEmpty();) {
			int i = stack.peek();
			int num = index[i];
			if (num == n - 1) {
				stack.pop();
				ok[i][index[i]] = false;
				index[i] = -1;
				continue;
			}
				num++;
				if(i==0&&num>0){
					ok[i][num-1]=false;
				}
			
			for (int j = num ; j < n; j++) {
				index[i] = j;
				// 用来记录这一行哪个位子被占了
				if (i == 0) {
					if (j == 0) {
						if (ok[i + 1][j + 1]||ok[i+1][j]) {
							is = true;

							continue;
						}
					} else if (j == n - 1||ok[i+1][j]) {
						if (ok[i + 1][j - 1]) {
							is = true;
							continue;
						}
					} else {
						if (ok[i + 1][j + 1] || ok[i + 1][j - 1]||ok[i+1][j]) {
							is = true;
							continue;
						}
					}
				} else if (i == n - 1) {
					if (j == 0) {
						if (ok[i - 1][j + 1]||ok[i-1][j]) {
							is = true;
							continue;
						}
					} else if (j == n - 1||ok[i-1][j]) {
						if (ok[i - 1][j - 1]) {
							is = true;
							continue;
						}
					} else {
						if (ok[i - 1][j + 1] || ok[i - 1][j - 1]||ok[i-1][j]) {
							is = true;
							continue;

						}

					}
				}

				else {
					if (j == 0) {
						if (ok[i - 1][j + 1] || ok[i + 1][j + 1]||ok[i-1][j]||ok[i+1][j]) {
							is = true;
							continue;
						}

					} else if (j == n - 1) {

						if (ok[i - 1][j - 1] || ok[i + 1][j - 1]||ok[i-1][j]||ok[i+1][j]) {
							is = true;
							continue;
						}

					} else if (ok[i - 1][j + 1] || ok[i - 1][j - 1]
							|| ok[i + 1][j + 1] || ok[i + 1][j - 1]||ok[i-1][j]||ok[i+1][j]) {
						is = true;
						continue;
					}
				}
				ok[i][j] = true;
				is = false;
				break;
			}
			if (!is) { // 成功进行 继续或者回退
				// 判断是否向下进行
				if (i != n - 1) {
					stack.push(i + 1);

				} else {
					// 回退了 表示成功一次了

					List<String> li = new LinkedList<String>();
					for (int in = 0; in < n; in++) {
						str.setCharAt(index[in], 'Q');
						li.add(str.toString());
						str.setCharAt(index[in], '.');
					}
					lists.add(li);
					stack.pop();// 回退

					ok[i][index[i]] = false;
					index[i] = -1;

				}

			} else {// 没有成功 只能回退继续了

				stack.pop();
				ok[i][index[i]] = false;
				index[i] = -1;
			}

		}

		return lists;
	}
}
