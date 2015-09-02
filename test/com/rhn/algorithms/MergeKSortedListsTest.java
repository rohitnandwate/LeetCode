package com.rhn.algorithms;

import org.junit.Test;

import com.rhn.algorithms.util.ListNode;

public class MergeKSortedListsTest {

	private MergeKSortedLists mergeK = new MergeKSortedLists();
	private MergeTwoSortedLists merge2 = new MergeTwoSortedLists();
	
	@Test
	public void test() {
		
		ListNode n = new ListNode(0);
		n.next = new ListNode(2);
		n.next.next = new ListNode(5);
		
		
		ListNode n1 = new ListNode(-4);
		n1.next = new ListNode(3);
		n1.next.next = new ListNode(4);
		
		
		ListNode n2 = new ListNode(-5);
		n2.next = new ListNode(-4);
		n2.next.next = new ListNode(-3);
		
		ListNode[] lists = {n, n1, n2};
		ListNode merged = mergeK.mergeKLists(lists);
		System.out.println(merged);
	}

}
