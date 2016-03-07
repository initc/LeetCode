package com.jie;

public class KthBST {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {

	}

	/**
	 * Given a binary search tree, write a function kthSmallest to find the kth
	 * smallest element in it.
	 * 
	 * 
	 * 坑爹的题目 这道题是很不严谨的 这个算法是在假设所有的元素都是唯一的 但是一个搜索二叉树会有重复的元素的 一般的来说 重复的数字会是在元素的右边
	 * 即大数边的
	 * 
	 * @param root
	 * @param k
	 * @return
	 */
	public static int kthSmallest(TreeNode root, int k) {
		if (root == null)
			return 0;
		int leftCount = countBT(root.left);
		if (leftCount + 1 == k)
			return root.val;
		if (leftCount + 1 > k)
			return kthSmallest(root.left, k);
		else {

			return kthSmallest(root.right, k - 1 - leftCount);
		}

	}

	public static int countBT(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + countBT(root.left) + countBT(root.right);

	}
}
