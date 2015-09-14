package com.rhn.algorithms;

import static com.rhn.algorithms.util.BinarySearchUtil.*;
/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * @author rohitnandwate
 *
 */
public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums.length == 0) {
        	return -1;
        }
        int rotationPoint = findRotationPoint(nums, 0, nums.length-1);
        int leftSearch = binSearch(nums, 0, rotationPoint-1, target);
        if(leftSearch == -1) {
        	return binSearch(nums, rotationPoint, nums.length-1, target);
        }
        return leftSearch;
    }
}
