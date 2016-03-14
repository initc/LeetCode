package com.lanqiaobei;

import java.util.Scanner;

public class YangHuiNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("2222");
		System.out.println("12344");
		
		
		
		Scanner in =new Scanner(System.in);
		int n=in.nextInt();
		printNumber(n);
	}

	public static void printNumber(int n){
		
		int []nums=new int[1];
		System.out.println("1");
		nums[0]=1;
		int a=0;
		int b=0;
		
		for(int i=2;i<=n;i++){
			StringBuilder pp=new StringBuilder();
			int []temp=new int[i];
			temp[0]=1;
			pp.append("1");
			for(int j=1;j<i;j++){
				if(j!=i-1){
				a=nums[j-1];
				b=nums[j];
				}else{
					a=nums[j-1];
					b=0;
				}
				temp[j]=a+b;
				pp.append(" "+temp[j]);
				
			}
			System.out.println(pp);
			
			nums=temp;
		}
		
	}
	
}
