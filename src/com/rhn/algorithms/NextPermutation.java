package com.rhn.algorithms;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/next-permutation/
 * @author rohitnandwate
 *
 */
public class NextPermutation {
	public void nextPermutation(int[] nums) {
		int i=0;
        for(i=nums.length-1;i>0;--i){
        	if(nums[i] > nums[i-1]) {
        		int j = swapCandidate(i-1, nums);
        		System.out.println("swap candidate is:"+j);
        		int temp = nums[j];
        		nums[j] = nums[i-1];
        		nums[i-1] = temp;
        		break;
        	}
        }
        System.out.println("sorting from index:"+i);
        Arrays.sort(nums, i, nums.length);
    }

	private int swapCandidate(int i, int[] nums) {
		int smallest = i+1;
		int j=i+1;
		for(j = i+1; j< nums.length; j++) {
			if(nums[j] < nums[smallest] && nums[j]> nums[i]){
				smallest = j;
			}
		}
		return smallest;
	}
}
