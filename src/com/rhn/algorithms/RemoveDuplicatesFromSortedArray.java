package com.rhn.algorithms;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * @author rohitnandwate
 *
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums.length <=1) {
            return nums.length;
        }
        
        int i=0;
        int j=0;
        while(j<nums.length) {
            while(j<nums.length-1 && nums[j] == nums[j+1]) {
                j++;
            }
            nums[i] = nums[j];
            ++i;
            ++j;
        }
        return i;
    }
}
