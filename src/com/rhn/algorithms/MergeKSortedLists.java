package com.rhn.algorithms;

import java.util.Arrays;
import java.util.Comparator;

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
    	
    	while(true) {
    		Arrays.sort(lists, listNodeComp);
    		if(lists[0] != null) {
				while(lists[0]!= null) {
					if(lists[1] == null || lists[0].val <= lists[1].val) {
						if(merged == null) {
							merged = lists[0];
						} else {
							mergedItr.next = lists[0];
						}
						mergedItr = lists[0];
						lists[0] = lists[0].next;
					} else {
						break;
					}
				}
    		} else {
    			break;
    		}
    	}
    	return merged;
    }
}
