package com.rhn.algorithms;

import org.junit.Test;

import com.rhn.algorithms.util.ListNode;

public class ReverseNodesInKGroupsTest {

	private ReverseNodesInKGroups revK = new ReverseNodesInKGroups();
	@Test
	public void test() {
		ListNode n = new ListNode(1);
		ListNode h = n;
		for(int i=2;i<10; ++i) {
			n.next = new ListNode(i);
			n = n.next;
		}
		System.out.println(h);
		System.out.println(revK.reverseKGroup(h, 2));
	}

}
