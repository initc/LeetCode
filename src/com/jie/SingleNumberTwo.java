package com.jie;

public class SingleNumberTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public int singleNumber(int[] nums) {
	        int [] count = new int[32];
			int result=0;
			for(int i=0;i<32;i++){
				for(int j=0;j<nums.length;j++){
					//ѭ������ÿһλ֮��   ʹ���޷���������
					count[i]+=(nums[j]>>>i)&1;
				}
				//��ȡ��һ��ֻ������һ�ε���  ��Ϊ����һ��ÿһ����������������  �������ǳ��ֵ�����
				//�Ϳ϶������ı���   ���һ��û�г��ֵ���  Ҫ��Ȼ��0Ҫ��Ȼ��1  ����%3����
				count[i]=count[i]%3==0?0:1;
			}
			//�������Ľ��
			for(int i=0;i<32;i++){
				
				result|=count[i]<<i;
			}
			return result;
	    }
	
}
