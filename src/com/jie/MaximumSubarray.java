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
			 * 如果即将要加的数是一个负数的话  我们就会明白加一个负数是对结果会有很大的影响的
			 * 所以我们需要对即将的负数进行一些必要的判断
			 * 1：如果当前index是一个负数  说明我们之前肯定加过了 只需把这个负数加到下一个 
			 * 并且我们不需要进行判断是否会有下一个index 因为既然有这个负数  肯定会有下一个index
			 * 2:如果当前index没有被占有  所以我们只需利用当前的index就好了 但是需要判断下一个index是否可以
			 * 被使用   
			 * 3：这一层逻辑就是我们知道是一盒负数 并且我们index也被使用过了 所以我们需要判断这个负数
			 * 是否应该被夹到下一层中 
			 *     一 ：如果这个负数与当前index想加是小于0的数字  那么就没有任何必要吧当前的index
			 *     相加到下一层  直接跟新下一个 index的值为当前负数
			 *     二 ：如果想加是不小于0的数 那么当前的负数是有实际意义的  我们需要把当前index与负数想加的
			 *     和赋值给下一个index中
			 * 
			 * 如果当前的数为正数的话  就直接跟新当前的数就好了
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
	 * 一个更加简便的方法 
	 * 如果想加当前的数之后   如果我们发现想加之后我们的数比当前想加的数还小了  那么也就是说之前的数都要抛弃
	 * 因为没有任何的意义  只需要记住当前的数字就好了	 
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
