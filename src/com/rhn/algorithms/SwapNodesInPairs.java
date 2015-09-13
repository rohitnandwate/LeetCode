package com.rhn.algorithms;

import com.rhn.algorithms.util.ListNode;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * @author rohitnandwate
 *
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode a = head;
        ListNode b = head.next;
        ListNode c = head.next.next;
        b.next = a;
        a.next = swapPairs(c);
        return b;
    }
}
