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
	 * �ӵ�����Ŀ ������Ǻܲ��Ͻ��� ����㷨���ڼ������е�Ԫ�ض���Ψһ�� ����һ�����������������ظ���Ԫ�ص� һ�����˵ �ظ������ֻ�����Ԫ�ص��ұ�
	 * �������ߵ�
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
