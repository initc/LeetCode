package com.jie;

public class AddDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          System.out.println(addDigit(9 ));
	}

	public  static int addDigits(int num) {
        int result=num;
        while(result/10>0){
        	result=0;
        	while(num!=0){
        		
        		result=result + num%10;
        		num/=10;
        	}
        	num=result;
        }
		
		return result;
	}
  public static  int addDigit(int num){
	
	  return (num - 1) % 9 + 1;
	  
  }
}
