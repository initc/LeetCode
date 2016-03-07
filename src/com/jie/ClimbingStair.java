package com.jie;

public class ClimbingStair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * You are climbing a stair case. It takes n steps to reach to the top.
	 * 
	 * Each time you can either climb 1 or 2 steps. In how many distinct ways
	 * can you climb to the top?
	 * 
	 * 使用的动态规划 运行效率加快 我一直所认为的动态规划算法
	 * 
	 * 在面对非常的大的数字前还是无力的 因为它需要大量的内存
	 * 
	 */
	public int climbStairs(int n) {
		if (n < 4)
			return n;
		int[] nums = new int[n + 1];
		nums[1] = 1;
		nums[2] = 2;
		nums[3] = 3;
		for (int i = 4; i <= n; i++) {
			nums[i] = nums[i - 1] + nums[i - 2];
		}
		return nums[n];
	}
}
