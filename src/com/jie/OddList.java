package com.jie;

public class OddList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		three.next=null;
		one.next=two;
		two.next=three;
		oddEvenList(one);
		
		while(one!=null){
			System.out.println(one.val);
			one=one.next;
		}
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode oddEvenList(ListNode head) {

		ListNode node = head;
		if (head == null || head.next == null)
			return head;
		ListNode _node = head.next;
		int num = 1;
		ListNode first = head.next.next;
		ListNode tail = head.next;
		for (; first != null; num++) {
			if (num % 2 == 1) {

				node.next = first;
				node = first;
			} else {

				_node.next = first;
				_node = first;
			}
			first = first.next;

		}
		_node.next=null;
		node.next = tail;
		return head;

	}

}
