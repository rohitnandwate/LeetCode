package com.rhn.algorithms;

import java.util.ArrayList;
import java.util.List;

import com.rhn.algorithms.util.StringUtils;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * @author rohitnandwate
 *
 */
public class LetterCombinationsOfPhoneNumber {

	private static final String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
	public List<String> letterCombinations(String digits) {
		List<String> combos = new ArrayList<String>();
		if(digits.isEmpty()) {
			return combos;
		}
		List<String> input = new ArrayList<String>();
		digits.chars().forEach(c -> {
			input.add(map[c-'0']);
		});
		
		char ans[] = new char[digits.length()];
		helper(0, input, combos, ans);
		return combos;
    }

	private void helper(int k, List<String> input, List<String> combos, char[] ans) {
		if(k == ans.length) {
			combos.add(StringUtils.join(ans));
			return;
		}
		int j=0;
		while(j < input.get(k).length()){
			ans[k] = input.get(k).charAt(j);
			helper(k+1, input, combos, ans);
			++j;
		}
	}


	
}
