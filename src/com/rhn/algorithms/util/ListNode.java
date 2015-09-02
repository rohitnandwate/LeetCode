package com.rhn.algorithms.util;

// Definition for singly-linked list.
public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		ListNode n = this;
		while(n != null) {
			sb.append(n.val);
			sb.append(" > ");
			n = n.next;
		}
		return sb.toString();
	}
}