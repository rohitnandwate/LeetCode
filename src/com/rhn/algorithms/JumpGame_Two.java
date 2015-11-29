package com.rhn.algorithms;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/jump-game-ii/
 * @author rohitnandwate
 *
 */
public class JumpGame_Two {
    public int jump(int[] nums) {
    	if(nums.length == 0) {
    		return 0;
    	}
        int[] min = new int[nums.length];
        Arrays.fill(min, -1);
        for(int i=nums.length-1; i>=0; --i) {
        	min[i] = minJump(i, nums, min);
        }
        return min[0];
    }

	private int minJump(int i, int[] nums, int[] min) {
		if(min[i] >= 0) {
			return min[i];
		}
		if(i == nums.length-1) {
			return 0;
		}
		if(nums[i] >= nums.length-1-i) {
			return 1;
		}
		int m = Integer.MAX_VALUE;
		for(int j=i+nums[i]; j>i; --j) {
			if(min[j] < 0){
				min[j] = minJump(j, nums, min);
			}
			if(min[j] < m) {
				m = min[j];
			}
		}
		if(m == Integer.MAX_VALUE) {
			return m;
		}
		return m+1;
	}
}
