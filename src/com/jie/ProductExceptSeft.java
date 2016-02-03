package com.jie;

import java.util.Arrays;

public class ProductExceptSeft {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { 1, 2, 3, 4 };
		System.out.println(Arrays.toString(productExceptSelf2(nums)));
	}

	public static int[] productExceptSelf(int[] nums) {

		int len = nums.length;
		int[] pas = new int[len - 1];
		int[] neg = new int[len - 1];
		pas[0] = nums[0];
		neg[0] = nums[len - 1];
		for (int i = 1; i < len - 1; i++) {
			pas[i] = pas[i - 1] * nums[i];
		}
		
		for (int i = 1; i < len - 1; i++) {
			neg[i] = neg[i - 1] * nums[len - i - 1];
		}
		
		nums[0] = neg[len - 2];
		nums[len - 1] = pas[len - 2];
		for (int i = 1; i < len - 1; i++) {

			nums[i] = pas[i - 1] * neg[len - i - 2];

		}

		return nums;
	}
	public static int[] productExceptSelf2(int[] nums) {
		int len = nums.length ;
		int one[] = new int [len];
		one[len-1]=1;
		for(int i=len -2;i>=0;i--){
			one[i]=one[i+1]*nums[i+1];
		}
		int left=1;
        for(int i=0;i<len;i++){
        	
        	one[i]=left*one[i];
        	left*=nums[i];
        }
		
		return    one;
	}
}
