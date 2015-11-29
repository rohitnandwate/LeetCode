package com.rhn.algorithms;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/first-missing-positive/
 * @author rohitnandwate
 *
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
    	if(nums.length == 1) {
    		return nums[0] == 1 ? 2 : 1;
    	} else if(nums.length == 0) {
    		return 1;
    	}
    	for(int i=0; i<nums.length; ++i) {
    		if(nums[i] == i || nums[i] <= 0 || nums[i] >= nums.length){
    			continue;
    		} 
    		while(nums[i] != i 
    				&& nums[i] > 0 
    				&& nums[i] < nums.length 
    				&& nums[i] != nums[nums[i]]) {
    			swap(i, nums[i], nums);
    		}
    	}
    	
//    	System.out.println("After swapping:");
//    	Arrays.stream(nums).forEach(x -> System.out.print(x+" "));
//    	System.out.println();
    	
    	int max =0;
    	int i = 0;
    	for(i=0; i<nums.length; ++i) {
    		if(max < nums[i]) {
    			max = nums[i];
    		}
    		if(i == nums[i]) {
    			
    			continue;
    		} else if(i>0) {
    			return i;
    		}
    	}
    	return nums[0] == nums.length ? max+1 : i;
    	
//    	int last =1;
//    	boolean numsLengthNumPresent = false;
//    	for(int i=1; i<nums.length; ++i) {
//    		if(nums[i] <=0 || nums[i] >= nums.length) {
//    			if(nums[i] == nums.length){
//    				numsLengthNumPresent= true;
//    			}
//    			continue;
//    		} else if (nums[i] != last +1) {
//    			return last+1;
//    		}
//    		last = nums[i];
//    	}
//    	return (numsLengthNumPresent && last + 1 == nums.length ) ? last+2 : last +1;
    }

	private void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
