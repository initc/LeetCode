package com.jie;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextPoint {
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Populate each next pointer to point to its next right node. If there is
	 * no next right node, the next pointer should be set to NULL.
	 * 
	 * Initially, all next pointers are set to NULL.
	 * 
	 * 
	 * 就是按层遍历 把同属于一层的node就存起来
	 */
    //leetcode  6ms 
	public void connect(TreeLinkNode root) {

		if (root == null)
			return;
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.offer(root);
		TreeLinkNode first = null;
		TreeLinkNode second = null;
		int count = 1;
		int size = 1;
		boolean isStop = false;
		while (!queue.isEmpty()) {
			isStop = false;
			while (count > 1) {
				// 我们需要遍历count-1次 因为我们的最后一个元素应该指向null
				first = queue.poll();

				// 把下一层的node加入进去 但是需要注意的是 下一层加入的可能是null

				queue.offer(first.left);
				queue.offer(first.right);

				// 指向同一层的下一个
				first.next = queue.peek();
				count--;
			}
			// 出来循环 吧最后一个元素指向null 并且把计数器设置为上一层的两倍
			//额。。。好像不需要强制去设置为null了  因为一开始久违null
			first = queue.poll();
			queue.offer(first.left);
			queue.offer(first.right);
			//first.next=null;
			//判断下一个元素是否是null如果为null的话说明下一层是null的 不在循环了
			if(queue.peek()==null){
				return ;
			}
			size *=2;
		    count =size; 
		}

	}
    // leetcode 1ms
	public void connect2(TreeLinkNode root) {
        if(root==null) return;
        while(root.left!=null){
            TreeLinkNode tmp = root;
            while(tmp!=null){
                tmp.left.next = tmp.right;
                if(tmp.next!=null) tmp.right.next = tmp.next.left;
                tmp = tmp.next;
            }
            root = root.left;
        }
    }
	
}
