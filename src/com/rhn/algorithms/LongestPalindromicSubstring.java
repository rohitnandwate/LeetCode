package com.rhn.algorithms;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * @author rohitnandwate
 *
 */
public class LongestPalindromicSubstring {

	public String longestPalindrome(String s) {
		String longest = "";
		for(int i=0; i< s.length(); ++i) {
			String l = expandAroundMid(i, i, s);
			if(l.length() > longest.length()) {
				longest = l;
			}
			if(i < s.length()-1) {
				l = expandAroundMid(i, i+1, s);
				if(l.length() > longest.length()) {
					longest = l;
				}
			}
		}
		return longest;
	}

	private String expandAroundMid(int l, int r, String s) {
		while(l>=0 && r<s.length()) {
			if(s.charAt(l) == s.charAt(r)) {
				l--;
				r++;
			} else {
				break;
			}
		}
		return l+1 > r-1 ? "" : s.substring(l+1, r);
	}
}
