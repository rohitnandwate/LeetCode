package com.rhn.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 * @author rohitnandwate
 *
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<List<Integer>>();
        boolean[] avail = new boolean[nums.length];
        int[] ans = new int[nums.length];
        Arrays.fill(avail, true);
        permute(nums, ansList, ans, avail, 0);
        return ansList;
    }

	private void permute(int[] nums, List<List<Integer>> ansList, int[] ans,
			boolean[] avail, int k) {
		if(k == nums.length) {
			addAns(ansList, ans);
		}
		for(int i=0; i< nums.length; ++i) {
			if(avail[i]) {
				avail[i] = false;
				ans[k] = nums[i];
				permute(nums, ansList, ans, avail, k+1);
				avail[i] = true;
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
