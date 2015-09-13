package com.rhn.algorithms;

/**
 * https://leetcode.com/problems/remove-element/
 * @author rohitnandwate
 *
 */
public class RemoveElementFromArray {
    public int removeElement(int[] nums, int val) {
        int start = 0;
        int end = nums.length;
        while(start < end) {
        	if(nums[start] == val) {
        		while(start<end && nums[end] == val) {
        			end--;
        		}
        		nums[start] = nums[end];
        		end--;
        	}
        	start++;
        }
        return start;
    }

}
