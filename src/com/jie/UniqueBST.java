package com.jie;

public class UniqueBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       /* long time =System.currentTimeMillis();
		System.out.println(numTrees(20));*/
		long  time1=System.currentTimeMillis();
		//System.out.println("------one  pass "+(time1-time));
		System.out.println(numTrees2(19));
		long time2=System.currentTimeMillis();
		System.out.println("------two  pass "+(time2-time1));
	}
    //由于一些重复的计算   导致重复递归   不如我们把所有的计算好
	public static int numTrees(int n) {
           if(n==0)
        	   return 1;
		if(n==1)
			return 1;
		int result =0;
		for(int i=1;i<=n;i++){
			result +=numTrees(n-i)*numTrees(i-1);
			
		}
		return result;
	}
	public static int numTrees2(int n) {
		
        if(n==0)
     	   return 1;
		if(n==1)
			return 1;
		int [] nums= new int [n+1];
		nums[0]=1;
		nums[1]=1;
		nums[2]=2;
		for(int i=3;i<=n;i++){
			
			for(int j=1;j<=i;j++){
				
				nums[i]+=nums[j-1]*nums[i-j];
			}
		}
		
		return nums[n];
	}
}
