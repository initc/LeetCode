package com.jie;

import java.util.Arrays;

public class MoveZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int nums[]={ 1,0,2,3,3,6,5,4,8,70,0,1,0,2,0,3};
      moveZeroes(nums);
      System.out.println(Arrays.toString(nums));
	}

	public static void moveZeroes(int[] nums) {

		int num=0;
		for(int i=0; i<nums.length;i++)
		{
			if(nums[i]==0){
				
				num++;
			}else{
				
				nums[i-num]=nums[i];
				
			}
			
			
		}
		for(int i=nums.length-num; i<nums.length;i++){
			
			nums[i]=0;
		}
		
	}
}
