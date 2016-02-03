package com.jie;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Inorder {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		t1.left = null;
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.right = t2;
		t2.right = null;
		t2.left = t3;
		t3.right = null;
		System.out.println(inorderTraversal(t1));
	}

	// 二叉树前序算法  需要考虑的是一个节点的左节点是否已经被添加进stack中了  
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
		if (root == null)
			return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode tmp = root;
		while (!stack.isEmpty() || tmp != null) {
			while (tmp != null) {
				stack.push(tmp);
				tmp = tmp.left;
			}
			if (!stack.isEmpty()) {
				tmp = stack.pop();
				list.add(tmp.val);
				tmp = tmp.right;
			}

		}

		return list;

	}

}
