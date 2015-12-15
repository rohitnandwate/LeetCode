package com.rhn.algorithms;

/**
 * https://leetcode.com/problems/maximum-subarray/
 * @author rohitnandwate
 *
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0)
        	return 0;
        int start = 0;
        int max = nums[0];
        int tot = max;
        for(int i=1; i<nums.length; ++i) {
        	tot += nums[i];
        	if(tot > max) {
        		max = tot;
        	}
        	while(start < i && (tot < 0 || tot-nums[start] >= tot)) {
        		tot -= nums[start];
        		start++;
        	}
        	if(tot > max) {
        		max = tot;
        	}
        }
        return max;
    }
}