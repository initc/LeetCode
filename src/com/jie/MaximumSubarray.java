package com.jie;

public class MaximumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// {-2,1,-3,4,-1,2,1,-5,4};
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4 };
		System.out.println(maxSubArray2(nums));
	}

	public static int maxSubArray(int[] nums) {
		int size = nums.length;
		boolean[] isCouped = new boolean[size];
		int[] result = new int[size];
		int index = 0;
		for (int i = 0; i < size; i++) {
			/**
			 * 
			 * �������Ҫ�ӵ�����һ�������Ļ�  ���Ǿͻ����׼�һ�������ǶԽ�����кܴ��Ӱ���
			 * ����������Ҫ�Լ����ĸ�������һЩ��Ҫ���ж�
			 * 1�������ǰindex��һ������  ˵������֮ǰ�϶��ӹ��� ֻ�����������ӵ���һ�� 
			 * �������ǲ���Ҫ�����ж��Ƿ������һ��index ��Ϊ��Ȼ���������  �϶�������һ��index
			 * 2:�����ǰindexû�б�ռ��  ��������ֻ�����õ�ǰ��index�ͺ��� ������Ҫ�ж���һ��index�Ƿ����
			 * ��ʹ��   
			 * 3����һ���߼���������֪����һ�и��� ��������indexҲ��ʹ�ù��� ����������Ҫ�ж��������
			 * �Ƿ�Ӧ�ñ��е���һ���� 
			 *     һ �������������뵱ǰindex�����С��0������  ��ô��û���κα�Ҫ�ɵ�ǰ��index
			 *     ��ӵ���һ��  ֱ�Ӹ�����һ�� index��ֵΪ��ǰ����
			 *     �� ���������ǲ�С��0���� ��ô��ǰ�ĸ�������ʵ�������  ������Ҫ�ѵ�ǰindex�븺����ӵ�
			 *     �͸�ֵ����һ��index��
			 * 
			 * �����ǰ����Ϊ�����Ļ�  ��ֱ�Ӹ��µ�ǰ�����ͺ���
			 * 
			 */
			if (nums[i] <= 0) {
				if (result[index] < 0) {
					result[++index] = nums[i];
					isCouped[index] = true;
					if (index < size - 1)
						index++;
					continue;
				} else if (!isCouped[index]) {

					result[index] = nums[i];
					isCouped[index] = true;
					if (index < size - 1)
						index++;
					continue;
				} else {
					
					if (result[index] + nums[i] <= 0) {
						result[index + 1] = nums[i];
						isCouped[++index] = true;
						if (index < size - 1)
							index++;
						continue;
					} else {
						result[index + 1] = result[index] + nums[i];
						isCouped[++index] = true;
						continue;
					}
				}

			}
			result[index ] = result[index] + nums[i];
			isCouped[index] = true;
			
		}
		int max=result[0];
		for(int i=0;i<=index;i++){
			if(result[i]>max&&isCouped[i]){
				max=result[i];
			}
		}
		
		return max;
	}
	/**
	 * һ�����Ӽ��ķ��� 
	 * �����ӵ�ǰ����֮��   ������Ƿ������֮�����ǵ����ȵ�ǰ��ӵ�����С��  ��ôҲ����˵֮ǰ������Ҫ����
	 * ��Ϊû���κε�����  ֻ��Ҫ��ס��ǰ�����־ͺ���	 
	 * 
	 * @param nums
	 * @return
	 */
	public static int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++){
            sum += nums[i];
            if (sum > nums[i]){
                sum = sum;
            }
            else {
                sum = nums[i];
            }

            if (sum > max){
                max = sum;
            }
        }
        return max;
    }
	
}
