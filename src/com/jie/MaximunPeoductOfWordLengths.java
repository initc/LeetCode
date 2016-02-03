package com.jie;

import java.util.LinkedList;
import java.util.Stack;

public class MaximunPeoductOfWordLengths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
      
		String[] strs = { "abcw", "baz", "foo", "bar", "xtfn", "abcdef",
				"abcw", "baz", "foo", "bar", "xtfn", "abcdef", "abcw", "baz",
				"foo", "bar", "xtfn", "abcdef" };
		System.out.println(maxProduct2(strs));
	}

	/*
	 * Given a string array words, find the maximum value of length(word[i]) *
	 * length(word[j]) where the two words do not share common letters. You may
	 * assume that each word will contain only lower case letters. If no such
	 * two words exist, return 0.
	 * 
	 * Example 1:
	 * 
	 * Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"] Return 16 The two
	 * words can be "abcw", "xtfn".
	 * 
	 * Example 2:
	 * 
	 * Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"] Return 4 The two words
	 * can be "ab", "cd".
	 * 
	 * Example 3:
	 * 
	 * Given ["a", "aa", "aaa", "aaaa"] Return 0 No such pair of words.
	 */
	// beat 7% not good
	public static int maxProduct(String[] words) {
		int nums[] = new int[words.length];
		boolean notCommom = false;
		int index = 0;
		int max = 0;
		for (int i = 0; i < words.length; i++) {
			int chs[] = new int[26];
			index = 0;

			while (index < words[i].length()) {
				chs[words[i].charAt(index) - 'a'] = 1;
				index++;
			}
			for (int j = i + 1; j < words.length; j++) {
				index = 0;
				max = 0;
				notCommom = false;
				while (index < words[j].length()) {

					if (chs[words[j].charAt(index) - 'a'] == 1) {
						notCommom = true;
						break;
					}
					index++;
				}
				if (!notCommom) {
					max = words[i].length() * words[j].length();
					if (max > nums[i])
						nums[i] = max;
				}

			}
		}
		max = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max)
				max = nums[i];
		}
		return max;
	}

	// beat 44%
	/**
	 * �ĵã� �Ա������ַ�����ʱ�� ����ʹ��λ�������ҿ��ٶ� �÷�������һ���ַ�����˵
	 *��ֻ��Сд����Сд����ʹ��long64λ)���ĸ���Ҳֻ��26λ
	 * ��ȫ����ʹ��һ��int������¼����ÿһ���ַ��Ƿ���ֹ� �������һ����abc����˵ ��
	 * �� ʹ��int��ǰ��λ����¼�� ������λ111����Ϊһ��һλ�����˾Ͱ�����Ӧ��Ϊ��һ��
	 * ������ǶԱ����е���ʱ��ֻҪ����Ϳ����ˣ� �������ͬ��ĳһλ����1��û�оͶ�
	 * Ϊ0.
	 * 
	 * @param words
	 * @return
	 */

	public static int maxProduct2(String[] words) {
		int len = words.length;
		int[] mark = new int[len];
		int[] leng = new int[len];
		for (int i = 0; i < len; i++) {
			int k = words[i].length();
			leng[i] = k;
			for (int j = 0; j < k; j++) {
				int p = (int) (words[i].charAt(j) - 'a');
				p = 1 << p;
				mark[i] = mark[i] | p;
			}
		}
		int ans = 0;
		for (int i = 0; i < len; i++)
			for (int j = i + 1; j < len; j++)
				if ((mark[i] & mark[j]) == 0)
					if (ans < leng[i] * leng[j])
						ans = leng[i] * leng[j];
		return ans;
	}
}
