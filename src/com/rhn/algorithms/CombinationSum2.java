package com.rhn.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CombinationSum2 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Set<List<Integer>> ansList = new HashSet<List<Integer>>();
		if (candidates.length == 0)
			return ansList.stream().collect(Collectors.toList());
		Arrays.sort(candidates);
		boolean[] select = new boolean[candidates.length];
		helper(candidates, target, ansList, select, 0, 0);
		return ansList.stream().collect(Collectors.toList());
	}

	private void helper(int[] candidates, int target,
			Set<List<Integer>> ansList, boolean[] select, int sum, int k) {
		// System.out.println("Current state: sum="+sum+" k="+k);
		// print(select, candidates);
		if (sum == target) {
			// System.out.println("####### FOUND ANSWER ############");
			ansList.add(createAns(select, candidates));
			return;
		}
		if (k == candidates.length) {
			// System.out.println("K has reached the end");
			return;
		}

		if (sum + candidates[k] > target) {
			// System.out.println("Sum greater than target "+target);
			return;
		}
		select[k] = true;
		helper(candidates, target, ansList, select, sum + candidates[k], k + 1);
		select[k] = false;
		helper(candidates, target, ansList, select, sum, k + 1);
	}

	private List<Integer> createAns(boolean[] select, int[] candidates) {
		List<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < candidates.length; ++i) {
			if (select[i]) {
				// System.out.print(candidates[i]+" ");
				ans.add(candidates[i]);
			}
		}
		// System.out.println();
		return ans;
	}

	private void print(boolean[] select, int[] c) {
		Arrays.stream(c).forEach(x -> System.out.print(x + " "));
		System.out.println();
		for (boolean s : select) {
			System.out.print((s ? "T " : "F "));
		}
		System.out.println();
	}
}