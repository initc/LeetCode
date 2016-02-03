package com.jie;

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] re = {3,2,3};
   System.out.println(majorityElement(re));
	}

	/*
	 * Given an array of size n, find the majority element. The majority element
	 * is the element that appears more than ⌊ n/2 ⌋ times.
	 * 
	 * You may assume that the array is non-empty and the majority element
	 * always exist in the array.
	 */
	//beat 29.84%
	public static int majorityElement(int[] nums) {
		int index = 0;
		int len = nums.length / 2 + 1;
		int[] re = new int[len];
		int num[] = new int[len];
		boolean isO[] = new boolean[len];
		for (int i = 0; i < nums.length ; i++) {
			index = nums[i] % len;
			index = index >= 0 ? index : index + len;
			while (isO[index]) {
				if (nums[i] == re[index]) {
					
					break;
				}
               index=++index%len;
			}
			re[index] = nums[i];
			num[index]++;
			isO[index] = true;
		}
		index = 0;
		
		for (int i = 1; i < len; i++) {
			if (num[i] > num[index])
				index =i;
		}
		return re[index];
	}
	/**
	 * the better answer
	 * @param nums
	 * @return
	 */
	//beat 61.16%
	public int majorityElement2(int[] nums) {
	    int majority = nums[0], t = 0;
	    for (int i : nums) {
	        if (i == majority) 
	            ++t;
	        else if (t > 0)
	            --t;
	        else {
	            majority = i;
	            t = 1;
	        }
	    }
	    return majority;
	}
	
	
	
	
	
	
}
