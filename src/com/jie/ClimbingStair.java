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
	 * ʹ�õĶ�̬�滮 ����Ч�ʼӿ� ��һֱ����Ϊ�Ķ�̬�滮�㷨
	 * 
	 * ����Էǳ��Ĵ������ǰ���������� ��Ϊ����Ҫ�������ڴ�
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
