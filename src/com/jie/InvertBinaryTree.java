package com.jie;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InvertBinaryTree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {

		// .*/D*
		
		
	}
	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		for (; !stack.isEmpty();) {
			TreeNode node = stack.peek();
			TreeNode temp = node.left;
			node.left = node.right;
			node.right = temp;
			stack.pop();
			if (node.right != null)
				stack.push(node.right);
			if (node.left != null)
				stack.push(node.left);
		}
		return root;
	}
}
