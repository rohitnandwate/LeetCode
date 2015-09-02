package com.rhn.algorithms;

import java.util.ArrayList;
import java.util.List;

import com.rhn.algorithms.util.StringUtils;

/**
 * https://leetcode.com/problems/generate-parentheses/
 * @author rohitnandwate
 *
 */
public class GenerateParentheses {

	public List<String> generateParenthesis(int n) {
		List<String> combos = new ArrayList<String>();
		char[] ans = new char[2*n];
		helper(0,0,0,0,combos, ans, n);
		return combos;
    }

	private void helper(int openUsed, int closeUsed, int unmatched, int k, List<String> combos,
			char[] ans, int n) {
		if(k == 2*n) {
			combos.add(StringUtils.join(ans));
			return;
		}
		if(openUsed < n) {
			ans[k] = '(';
			helper(openUsed+1, closeUsed, unmatched+1, k+1, combos, ans, n);
		}
		if(unmatched > 0 && closeUsed < n) {
			ans[k] = ')';
			helper(openUsed, closeUsed+1, unmatched-1, k+1, combos, ans, n);
		}
	}
}
