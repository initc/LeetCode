package com.jie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElement2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] re = {1,1,1,3,3,2,2,2};
		   System.out.println(majorityElement(re));
	}

	public static List<Integer> majorityElement(int[] nums) {

		List<Integer> list = new ArrayList<Integer>();
		int l=nums.length ;
		if(l<1)
			return list;
		if(l<3){
			list.add(nums[0]);
			if(l<2){
				return list;
			}
			if(nums[1]!=nums[0])
			list.add(nums[1]);
			return list;
		}
		
		Arrays.sort(nums);
		int index=1;
		int len= l /3;
		for(int i=0;i<nums.length-1 ;i++){
			if(nums[i+1]==nums[i]){
				if(++index>len){
				if(!list.contains(nums[i]))
				list.add(nums[i]);
				index=1;
				}
			}else{
				index=1;
			}
			
		}
		
		return  list;
		
	}
	 public List<Integer> majorityElement2(int[] nums) {
		    if (nums == null || nums.length == 0)
		        return new ArrayList<Integer>();
		    List<Integer> result = new ArrayList<Integer>();
		    int number1 = nums[0], number2 = nums[0], count1 = 0, count2 = 0, len = nums.length;
		    for (int i = 0; i < len; i++) {
		        if (nums[i] == number1)
		            count1++;
		        else if (nums[i] == number2)
		            count2++;
		        else if (count1 == 0) {
		            number1 = nums[i];
		            count1 = 1;
		        } else if (count2 == 0) {
		            number2 = nums[i];
		            count2 = 1;
		        } else {
		            count1--;
		            count2--;
		        }
		    }
		    count1 = 0;
		    count2 = 0;
		    for (int i = 0; i < len; i++) {
		        if (nums[i] == number1)
		            count1++;
		        else if (nums[i] == number2)
		            count2++;
		    }
		    if (count1 > len / 3)
		        result.add(number1);
		    if (count2 > len / 3)
		        result.add(number2);
		    return result;
		}
}
