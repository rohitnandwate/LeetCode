package com.rhn.algorithms;

import com.rhn.algorithms.util.ListNode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * @author rohitnandwate
 *
 */
public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sol = null;
        ListNode l3 = null;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int sum =  carry + (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            l1 = l1 != null ? l1.next: l1;
            l2 = l2 != null ? l2.next: l2;
            if(sum >= 10) {
                carry = 1;
                sum = sum % 10;
            }else {
            	carry = 0;
            }
            if(l3 != null) {
                l3.next = new ListNode(sum);
                l3 = l3.next;
            } else {
                l3 = new ListNode(sum);
                sol = l3;
            }
        }
        if(carry == 1)
        	l3.next = new ListNode(1);
        return sol;
    }
}
