package com.jie;

import java.util.Arrays;

public class SingleNumber3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int  nums[]={1,2,2,3,3,4};
       System.out.println(Arrays.toString(singleNumber(nums)));
	}

	/*
	 * Given an array of numbers nums, in which exactly two elements appear only
	 * once and all the other elements appear exactly twice. Find the two
	 * elements that appear only once.
	 * 
	 * For example:
	 * 
	 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5]
	 */

	/*
	 * Note:
	 * 
	 * The order of the result is not important. So in the above example, [5, 3]
	 * is also correct. Your algorithm should run in linear runtime complexity.
	 * Could you implement it using only constant space complexity?
	 */
	public static int[] singleNumber(int[] nums) {
		int re[] = new int[2];
		re[0]=0;
		re[1]=0;
		if (nums.length == 2) {
			return nums;
		}
		int oneRe = nums[0];
		for (int i = 1; i < nums.length; i++) {

			oneRe ^= nums[i];
		}
		
		int xIndex = 0;
		int xRe = 1;
		while (xIndex < 32) {
			xRe <<= xIndex;
			if ((oneRe & xRe) == xRe) {

				break;
			}
			xIndex++;
		}
		
        for(int i=0;i<nums.length ;i++){
        	
        	if((nums[i]&xRe)==xRe){
        		re[0]^=nums[i];
        		
        	}else {
        		
        		re[1]^=nums[i];
        	}
        		
        }
		
		
		
		return re;
	}

}
