package com.rhn.algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.rhn.algorithms.util.ListNode;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * @author rohitnandwate
 *
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
    	if(lists.length == 0)
    		return null;
    	if(lists.length == 1) {
    		return lists[0];
    	}
    	ListNode merged = null;
    	ListNode mergedItr = null;
    	Comparator<ListNode> listNodeComp = new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if(o1 != null && o2 != null) {
					return Integer.compare(o1.val, o2.val);
				} 
				if(o1 != null) {
					return -1;
				} 
				if (o2 != null) {
					return 1;
				}
				return 0;
			}
    	};
    	
    	PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(listNodeComp);
    	for(ListNode n : lists) {
    		if(n != null) {
    			minHeap.add(n);
    		}
    	}
    	
    	while(!minHeap.isEmpty()) {
    		ListNode smallest = minHeap.remove();
    		if(smallest == null) {
    			continue;
    		} else {
    			if(merged == null) {
    				merged = smallest;
    			} else {
    				mergedItr.next = smallest;
    			}
    			mergedItr = smallest;
    		}
    		if(smallest.next != null) {
    			minHeap.add(smallest.next);
    		}
    	}
    	return merged;
    }
}
