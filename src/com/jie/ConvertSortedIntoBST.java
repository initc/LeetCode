package com.jie;

public class ConvertSortedIntoBST {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root = sortedArrayToBST(new int[] { 3, 4 });
	}

	// Given an array where elements are sorted in ascending order, convert it
	// to a height balanced BST.
	public static TreeNode sortedArrayToBST(int[] nums) {
		int begin = 0;
		int end = nums.length - 1;
		int mid = (begin + end) / 2;
		if (end < 0)
			return null;
		TreeNode root = new TreeNode(nums[mid]);

		root.left = ArrayIntoTreeNode(nums, begin, mid - 1);
		root.right = ArrayIntoTreeNode(nums, mid + 1, end);

		return root;
	}

	public static TreeNode ArrayIntoTreeNode(int[] nums, int begin, int end) {

		if (begin > end)
			return null;
		int mid = (begin + end) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = ArrayIntoTreeNode(nums, begin, mid - 1);
		root.right = ArrayIntoTreeNode(nums, mid + 1, end);
		return root;
	}
}
