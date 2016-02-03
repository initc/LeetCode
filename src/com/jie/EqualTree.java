package com.jie;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class EqualTree {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<TreeNode> stack= new Stack<TreeNode>();
		stack.push(null);
		System.out.println(stack.pop());
		Queue<TreeNode> queue= new LinkedList<TreeNode>();
		boolean is=queue.offer(null);
		queue.offer(null);
		queue.offer(null);
		System.out.println(is+""+queue.poll()+""+queue.poll()+""+queue.size());
	}

	/*
	 * Given two binary trees, write a function to check if they are equal or
	 * not.
	 * 
	 * Two binary trees are considered equal if they are structurally identical
	 * and the nodes have the same value.
	 * 
	 * Subscribe to see which companies asked this question
	 */

	public static boolean isSameTree(TreeNode p, TreeNode q) {

		if (p == null && q == null)
			return true;
		if (p != null && q != null) {

			if (p.val == q.val) {

				return isSameTree(p.left, q.left)
						&& isSameTree(p.right, q.right) ? true : false;
			} else {

				return false;
			}

		}
		return false;
	}

}
