package com.jie;

import java.util.LinkedList;
import java.util.List;

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++){
		List<List<String>> list = solveNQueens(i);
		System.out.println("the  number "+i+" result is  "+list.size());
		}
		
	}

	
	public static List<List<String>> solveNQueens(int n) {
		List<List<String>>  lists= new LinkedList<List<String>>();
		if(n<=0){
			
			return lists;
			
		}
		int index[] = new int[n];
		List<String> li=null;
		dfs(0,n,lists,li,index);
		return  lists;
	}
	public static void dfs(int row,int num,List<List<String>> result,List<String> li,int [] index ){
		if(row==num){
		 li = new LinkedList<String>();
			for(int i=0;i<num;i++){
				StringBuilder  sen= new StringBuilder();
				for(int j=0;j<num;j++){
					if(j==index[i]){
						
						sen.append('Q');
					}else {
						sen.append('.');
					}
					
				}
				li.add(sen.toString());
			}
			result.add(li);
			return ;
		}
		for(int i=0;i<num;i++){
			index[row]=i;
			if(check(row,index)){
				
				dfs(row+1,num,result,li,index);
			}
			
		}
		
		
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
