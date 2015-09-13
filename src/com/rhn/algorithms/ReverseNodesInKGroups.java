package com.rhn.algorithms;

import com.rhn.algorithms.util.ListNode;
import com.rhn.algorithms.util.Pair;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * @author rohitnandwate
 *
 */
public class ReverseNodesInKGroups {
    public ListNode reverseKGroup(ListNode head, int k) {
    	if(head == null || head.next == null || k == 1){
    		return head;
    	}
    	System.out.println("Head:"+head.val);
    	Pair<ListNode,ListNode> headTail = reverseKHelper(head, k);
    	System.out.println("New Head:"+headTail.first.val);
    	if(headTail.second != null) {
    		System.out.println("Tail:"+headTail.second .val);
    		head.next = reverseKGroup(headTail.second, k);
    	}
    	return headTail.first;
    }
    
    private Pair<ListNode, ListNode> reverseKHelper(ListNode head, int k) {
    	if(head == null || head.next == null || k == 1){
    		return new Pair<ListNode,ListNode>(head, head);
    	}
    	Pair<ListNode, ListNode> ret;
    	ListNode curr = head;
    	ListNode prev = null;
    	int cnt = 0;
    	while(curr != null && cnt < k) {
    		ListNode temp = curr.next;
    		curr.next = prev;
    		prev = curr;
    		curr = temp;
    		cnt++;
    	}
    	if(cnt < k) {
    		ret = reverseKHelper(prev, cnt);
    	} else {
    		ret = new Pair<ListNode, ListNode>(prev, curr);
    	}
    	return ret;
    }
}
