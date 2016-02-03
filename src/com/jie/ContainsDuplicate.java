package com.jie;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = new int[] { 0, 0, 2, 3, 6 };
		System.out.println(containsDuplicate2(nums));
	}

	/*
	 * Given an array of integers, find if the array contains any duplicates.
	 * Your function should return true if any value appears at least twice in
	 * the array, and it should return false if every element is distinct.
	 * beat 55.2%
	 */
	public static boolean containsDuplicate(int[] nums) {

		Set<Integer> set = new HashSet<Integer>();
		for (int ch : nums) {
			if (!set.add(ch)) {
				return true;
			}
		}
		return false;
	}
/**
 * beat 84.32%  
 * 
 * @param nums
 * @return
 */
	public static boolean containsDuplicate2(int[] nums) {

		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1])
				return true;

		}
		return false;

	}
	/**
	 * this is a good solusion innovative
	 * @param nums
	 * @return
	 */
	public boolean containsDuplicate3(int[] nums) {
	    if (nums == null) {
	        return false;
	    }
	    int[] hashTable = new int[nums.length];
	    // Separate residency array to avoid problems with Integer.MIN_VALUE in the input array.twice
	    boolean[] occupied = new boolean[nums.length];
	    for (int i = 0; i < hashTable.length; i++) {
	        occupied[i] = false;
	    }
	    for (int i = 0; i < nums.length; i++) {
	        int h = nums[i] % nums.length;
	        h = h >= 0 ? h : h + nums.length;
	        while (occupied[h]) {
	            if (nums[i] == hashTable[h]) {
	                return true;
	            } else {
	                h = (h + 1) % nums.length;
	            }
	        }
	        hashTable[h] = nums[i];
	        occupied[h] = true;
	    }
	    return false;
	}
}
