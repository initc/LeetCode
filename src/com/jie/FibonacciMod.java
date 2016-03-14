package com.jie;

import java.util.Scanner;

public class FibonacciMod {

	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		System.out.println(fibonacciMod(n));
		
	}

	public static int fibonacciMod(int n){
		
		int [] nums=new int[n+1];
		
		if(n<3){
		
			return 1;
		}
		nums[1]=1;
		nums[2]=1;
		for (int i=3;i<=n;i++){
			
			nums[i]=(nums[i-1]%10007+nums[i-2]%10007)%10007;
			
		}
		
	return nums[n];
	
}
}