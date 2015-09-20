package com.rhn.algorithms;

/**
 * https://leetcode.com/problems/search-insert-position/
 * @author rohitnandwate
 *
 */
public class SearchForInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0)
        	return 0;
        return helper(nums, 0, nums.length-1, target);
    }

	private int helper(int[] arr, int start, int end, int target) {
		if(start > end) {
			return -1;
		}
		if(start == end) {
			return target > arr[start] ? start+1 : start;
		}
		int mid = ((end-start)/2)+start;
		if(target == arr[mid]) {
			return mid;
		} else if(start == mid && target < arr[mid]) {
			return mid;
		} else if (target < arr[mid]) {
			return helper(arr, start, mid-1, target);
		} else {
			return helper(arr, mid+1, end, target);
		}
	}
}
