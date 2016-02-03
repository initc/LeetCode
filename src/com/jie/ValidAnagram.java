package com.jie;

public class ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isAnagram("aapcc", "acaoc"));
	}

	/*
	 * Given two strings s and t, write a function to determine if t is an
	 * anagram of s.
	 * 
	 * For example, s = "anagram", t = "nagaram", return true. s = "rat", t =
	 * "car", return false.
	 * 
	 * Note: You may assume the string contains only lowercase alphabets.
	 */
	// 一开始我使用了两个数组来充当箱子  效率beat 50%   百度后才写了下面这个算法   beat 64.45%
	// 只要记录两个字符串中字符出现的次数就好
	public static boolean isAnagram(String s, String t) {

		if (s.length() != t.length())
			return false;
		int one[] = new int[26];
		for (int i = 0; i < s.length(); i++) {
			one[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < t.length(); i++) {
			if (--one[t.charAt(i) - 'a'] < 0)
				return false;
		}

		return true;
	}

}
