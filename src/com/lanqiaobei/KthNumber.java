package com.lanqiaobei;

import java.util.Arrays;
import java.util.Scanner;

public class KthNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int len=in.nextInt();
		int []nums= new int [len];
		for(int i=0;i<len;i++){
			nums[i]=in.nextInt();
		}
		int count=in.nextInt();
		for(;count>0;count--){
			
			int l=in.nextInt();
			int m=in.nextInt();
			int k=in.nextInt();
			int [] temp=Arrays.copyOfRange(nums, l-1, m);
			Arrays.sort(temp);
			System.out.println(temp[m-l-k+1]);
		}
	}

	
}
