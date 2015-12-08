package com.rhn.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 * @author rohitnandwate
 *
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ansList = new ArrayList<List<Integer>>();
        if(candidates.length == 0)
        	return ansList;
        Arrays.sort(candidates);
        int[] select = new int[candidates.length];
        Arrays.fill(select, 0);
        helper(candidates, target, ansList, select, 0, 0);
        return ansList;
    }

	private void helper(int[] candidates, int target, List<List<Integer>> ansList, int[] select, int sum, int startWith) {
		if(sum == target){
			ansList.add(createAns(select, candidates));
			return;
		}
		for(int i=startWith; i<candidates.length; ++i) {
			if(sum+candidates[i] > target) {
				return;
			}
			select[i]++;
			helper(candidates, target, ansList, select, sum+candidates[i], i);
			select[i]--;
		}
	}

	private List<Integer> createAns(int[] select, int[] candidates) {
		List<Integer> ans = new ArrayList<Integer>();
		for(int i=0; i<candidates.length; ++i) {
			for(int j=0; j<select[i]; ++j) {
				ans.add(candidates[i]);
			}
		}
		return ans;
	}
}