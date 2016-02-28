package com.jie;

public class SearchInsertPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { 1, 2, 3, 6, 9, 8 };
		System.out.println(searchInsert(nums, 7));
	}

	public static int searchInsert(int[] nums, int target) {
		int min = 0;
		int high = nums.length - 1;
		int result = -1;
		while (min <= high) {
			result = (min + high) / 2;
			// 如果当前节点是目标 就返回目标位置
			if (nums[result] == target)
				break;
			else if (target < nums[result]) {
				// 如果目标比当前的小 我们需要判断是否左边的还小一点
				// 即 如果左边的更小所以我们的插入位置就是当前点 即查完后之后的数要向后移动而已
				if (result == 0 || nums[result - 1] < target)
					break;
				high = result - 1;
			} else {
				// 相同的道理
				// 只不过插入点是我们当前点的右边一个
				// 因为我们知道我们肯定是在右边插入的 所有如果右边没有数了就不用判断了 || 短路特性
				if (result == nums.length - 1 || nums[result + 1] > target) {
					result++;
					break;
				}
				min = result + 1;
			}

		}
		return result;
	}

}
