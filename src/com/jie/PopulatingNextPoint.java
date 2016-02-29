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
	 * ���ǰ������ ��ͬ����һ���node�ʹ�����
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
				// ������Ҫ����count-1�� ��Ϊ���ǵ����һ��Ԫ��Ӧ��ָ��null
				first = queue.poll();

				// ����һ���node�����ȥ ������Ҫע����� ��һ�����Ŀ�����null

				queue.offer(first.left);
				queue.offer(first.right);

				// ָ��ͬһ�����һ��
				first.next = queue.peek();
				count--;
			}
			// ����ѭ�� �����һ��Ԫ��ָ��null ���ҰѼ���������Ϊ��һ�������
			//�����������Ҫǿ��ȥ����Ϊnull��  ��Ϊһ��ʼ��Υnull
			first = queue.poll();
			queue.offer(first.left);
			queue.offer(first.right);
			//first.next=null;
			//�ж���һ��Ԫ���Ƿ���null���Ϊnull�Ļ�˵����һ����null�� ����ѭ����
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
