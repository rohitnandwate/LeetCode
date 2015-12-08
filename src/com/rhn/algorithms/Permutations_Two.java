package com.rhn.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations-ii/
 * @author rohitnandwate
 *
 */
public class Permutations_Two {
	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
        List<List<Integer>> ansList = new ArrayList<List<Integer>>();
        boolean[] avail = new boolean[nums.length];
        int[] ans = new int[nums.length];
        Arrays.fill(avail, true);
        permuteUnique(nums, ansList, ans, avail, 0);
        return ansList;
    }

	private void permuteUnique(int[] nums, List<List<Integer>> ansList, int[] ans,
			boolean[] avail, int k) {
		if(k == nums.length) {
			addAns(ansList, ans);
		}
		int i=0; 
		while(i< nums.length) {
			if(avail[i]) {
				avail[i] = false;
				ans[k] = nums[i];
				permuteUnique(nums, ansList, ans, avail, k+1);
				avail[i] = true;
				do {
					i++;
				}while(i< nums.length && nums[i-1] == nums[i]);
			} else {
				++i;
			}
			
		}
	}
	private void addAns(List<List<Integer>> ansList, int[] ans) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i : ans) {
			list.add(i);
		}
		ansList.add(list);
	}

}
