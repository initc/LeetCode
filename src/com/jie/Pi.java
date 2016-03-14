package com.jie;

import java.util.Scanner;

public class Pi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		System.out.format("%.7f", Math.PI*n*n);
	}

	
	
}
