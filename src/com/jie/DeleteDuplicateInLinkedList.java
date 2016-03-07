package com.jie;

public class DeleteDuplicateInLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Given a sorted linked list, delete all duplicates such that each element
	 * appear only once.
	 * 
	 * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return
	 * 1->2->3.
	 * 
	 * @param head
	 * @return
	 * 
	 *         Your runtime beats 25.39% of java submissions.
	 */
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;
		ListNode first = head;
		ListNode temp = head.next;
		while (temp != null) {
			if (temp.val == first.val) {
				temp = temp.next;
				first.next = temp;
			} else {
				first = temp;
				temp = temp.next;
			}

		}
		return head;
	}
}
