package com.jie;

public class SingleNumberTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public int singleNumber(int[] nums) {
	        int [] count = new int[32];
			int result=0;
			for(int i=0;i<32;i++){
				for(int j=0;j<nums.length;j++){
					//循环区得每一位之和   使用无符号向右移
					count[i]+=(nums[j]>>>i)&1;
				}
				//获取那一个只出现了一次的数  因为除了一个每一个数都出现了三次  所以我们出现的数的
				//和肯定是三的倍数   最后一个没有出现的数  要不然是0要不然是1  所以%3即可
				count[i]=count[i]%3==0?0:1;
			}
			//构造最后的结果
			for(int i=0;i<32;i++){
				
				result|=count[i]<<i;
			}
			return result;
	    }
	
}
