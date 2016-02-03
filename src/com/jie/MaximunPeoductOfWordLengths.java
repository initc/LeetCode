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
	 * 心得： 对比两个字符串的时候 可以使用位运算来家快速度 用法：对于一个字符串来说
	 *（只有小写，大小写可以使用long64位)他的个数也只是26位
	 * 完全可以使用一个int子来记录他的每一个字符是否出现过 假如对于一个“abc”来说 我
	 * 门 使用int的前三位来记录他 即后三位111，都为一哪一位出现了就把其相应的为置一，
	 * 最后我们对比所有的数时，只要想与就可以了， 如果有相同即某一位会变成1，没有就都
	 * 为0.
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
