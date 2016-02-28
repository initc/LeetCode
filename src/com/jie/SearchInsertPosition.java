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
			// �����ǰ�ڵ���Ŀ�� �ͷ���Ŀ��λ��
			if (nums[result] == target)
				break;
			else if (target < nums[result]) {
				// ���Ŀ��ȵ�ǰ��С ������Ҫ�ж��Ƿ���ߵĻ�Сһ��
				// �� �����ߵĸ�С�������ǵĲ���λ�þ��ǵ�ǰ�� �������֮�����Ҫ����ƶ�����
				if (result == 0 || nums[result - 1] < target)
					break;
				high = result - 1;
			} else {
				// ��ͬ�ĵ���
				// ֻ��������������ǵ�ǰ����ұ�һ��
				// ��Ϊ����֪�����ǿ϶������ұ߲���� ��������ұ�û�����˾Ͳ����ж��� || ��·����
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
