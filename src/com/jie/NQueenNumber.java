package com.jie;

import java.util.LinkedList;
import java.util.List;

public class NQueenNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           System.out.println(totalNQueens(9));
	}

   public static  int totalNQueens(int n) {
       int result =0; 
		if(n<=0){
			
			return 0;
			
		}
		int index[] = new int[n];
		result =dfs(0,n,index);
       
       
        return result;
    }
   public static int dfs(int row,int num,int [] index ){
		if(row==num){
		 
			return 1;
		}
		int result =0;
		for(int i=0;i<num;i++){
			index[row]=i;
			if(check(row,index)){
				
				result+=dfs(row+1,num,index);
			}
			
		}
		return result;
}
   public  static boolean check(int row,int [] index ){
		 for (int i = 0; i < row; i++) {
		        if (index[i] == index[row]
		                || Math.abs(i - row) == Math.abs(index[i] - index[row]))
		            return false;
		    }
		    return true;
		
		
	}
}