package com.rhn.algorithms;

import com.rhn.algorithms.util.ListNode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 
 * @author rohitnandwate
 *
 */
public class RemoveNthNodeFromList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(n<1 || head == null) {
			return null;
		}
		ListNode itr = head;
		ListNode nth = head;
		ListNode prev = null;
		int cnt = 1;
		while(itr.next != null) {
			if(cnt >= n) {
				prev = nth;
				nth = nth.next;
			}
			itr = itr.next;
			cnt++;
		}
		if(nth == head) {
			head = nth.next;
		} else {
			prev.next = nth.next;
		}
		nth.next = null;
		return head;
	}
}
