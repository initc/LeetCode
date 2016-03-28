package com.lanqiaobei;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int nums[]={0,1,2,3,4,5,6,7,8,9};
		change(nums,0);
		//System.out.println(check((nums)));
		System.out.println(sum);
	}
static int sum;
	public static void change(int []nums,int begin){
		
		int len = nums.length;
		if(begin==len-1){
			
			if(check(nums)){
				sum++;
				System.out.println(Arrays.toString(nums));
			}
			
			return ;
		}
		int temp=nums[begin];
		for(int i=begin;i<len;i++){
			
			nums[begin]=nums[i];
			nums[i]=temp;
			change(nums,begin+1);
			nums[i]=nums[begin];
			nums[begin]=temp;
		}
		
		
	}
	
	public static boolean check(int []nums){
		if(nums[0]>nums[1]||nums[0]>nums[2]){
			return false;
		}
		if(nums[1]>nums[3]||nums[1]>nums[4]||nums[2]>nums[4]||nums[2]>nums[5]){
			return false;
		}
		if(nums[3]>nums[6]||nums[3]>nums[7]||nums[4]>nums[7]||nums[4]>nums[8]||nums[5]>nums[8]||nums[5]>nums[9]){
			return false;
		}
		return true;
	}
	
	
}
