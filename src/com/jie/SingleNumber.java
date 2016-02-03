package com.jie;

import java.util.Arrays;

public class SingleNumber {

	public static void main(String[] args) {

		int  nums[]={2,2,1};
		System.out.println(singleNumber(nums));
		
	}

	public static int singleNumber(int[] nums) {
		int lenght = nums.length;
		int result = 0;
		if (lenght == 1)
			return nums[0];
		Arrays.sort(nums);
		int i = 1;
		for (; i < lenght - 1; i++) {
			if (nums[i] == nums[i + 1] || nums[i] == nums[i - 1]) {

				continue;
			} else {
				result = nums[i];
				break;
			}
		}
		if (nums[0] != nums[1]) {
				result = nums[0];
		}
		if(nums[lenght-1]!=nums[lenght-2]){
			result = nums[lenght-1];
		}
		return result;
	}

}
