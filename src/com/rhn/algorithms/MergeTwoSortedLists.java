package com.rhn.algorithms;

import com.rhn.algorithms.util.ListNode;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * @author rohitnandwate
 *
 */
public class MergeTwoSortedLists {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode m = null;
        
        while(l1 != null || l2 != null) {
            ListNode s = null;
            if(l1 != null && l2 != null) {
                if(l1.val < l2.val) {
                    s = l1;
                    l1 = l1.next;
                } else {
                    s = l2;
                    l2 = l2.next;
                }
            } else if(l1 != null) {
                s = l1;
                l1 = l1.next;
            } else if(l2 != null) {
                s = l2;
                l2 = l2.next;
            }
            if(head  == null) {
                head = s;
                m = s;
            } else {
                m.next = s;
                m = s;
            }
        }
        return head;
    }
}
