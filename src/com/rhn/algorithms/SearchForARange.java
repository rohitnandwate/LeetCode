package com.rhn.algorithms;

/**
 * https://leetcode.com/problems/search-for-a-range/
 * @author rohitnandwate
 *
 */
public class SearchForARange {
    public int[] searchRangeHelper(int[] arr,int start, int end, int target) {
    	int[] ans = {-1,-1};
    	if(start > end) {
    		return ans;
    	} 
    	int mid = ((end-start)/2)+start;
    	if(target == arr[mid]) {
    		int left = findRange(arr, start, mid-1, target, true);
    		if(left == -1){
    			left = mid;
    		}
    		int right = findRange(arr, mid+1, end, target, false);
    		if(right == -1){
    			right = mid;
    		}
    		ans[0] = left;
    		ans[1] = right;
    		return ans;
    	} else  if(target > arr[mid]) {
    		return searchRangeHelper(arr, mid+1, end, target);
    	} else {
    		return searchRangeHelper(arr, start, mid-1, target);
    	}
    }

	private int findRange(int[] arr, int start, int end, int target, boolean dir) {
		if(start > end)
			return -1;
		int mid = ((end-start)/2)+start;
		if(target == arr[mid]) {
			int range = dir ? findRange(arr, start, mid-1, target, dir) 
							: findRange(arr, mid+1, end, target, dir);
			if(range == -1){
				return mid;
			} else {
				return range;
			}
		} else {
			return dir ? findRange(arr, mid+1, end, target, dir)
						:findRange(arr, start, mid-1, target, dir);
		}
	}
    
    
}
