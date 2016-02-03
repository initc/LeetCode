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
		boolean is = false; // ��ʾһ���Ƿ�ɹ�
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
				// ������¼��һ���ĸ�λ�ӱ�ռ��
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
			if (!is) { // �ɹ����� �������߻���
				// �ж��Ƿ����½���
				if (i != n - 1) {
					stack.push(i + 1);

				} else {
					// ������ ��ʾ�ɹ�һ����

					List<String> li = new LinkedList<String>();
					for (int in = 0; in < n; in++) {
						str.setCharAt(index[in], 'Q');
						li.add(str.toString());
						str.setCharAt(index[in], '.');
					}
					lists.add(li);
					stack.pop();// ����

					ok[i][index[i]] = false;
					index[i] = -1;

				}

			} else {// û�гɹ� ֻ�ܻ��˼�����

				stack.pop();
				ok[i][index[i]] = false;
				index[i] = -1;
			}

		}

		return lists;
	}
}
