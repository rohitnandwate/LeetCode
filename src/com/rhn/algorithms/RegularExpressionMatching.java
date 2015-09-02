package com.rhn.algorithms;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 * @author rohitnandwate
 *
 */
public class RegularExpressionMatching {
	
	public boolean isMatch(String s, String p) {
		return helper(s, p, 0, 0);
    }

	private boolean helper(String s, String p, int i, int j) {
		if(i == s.length() && j ==p.length()) {
			return true;
		}
		if(j == p.length() && i != s.length()) {
			return false;
		}
		
		if(isNextStar(p, j)){
			if(helper(s, p, i, j+2)) {
				return true;
			}
			for(int k=1; k<=s.length()-i; ++k) {
				if(!isSame(s, p, i+k-1, j)) {
					return false;
				}
				if(helper(s, p, i+k, j+2)) {
					return true;
				}
			}
		} else if(isSame(s, p, i, j)) {
			return helper(s, p, i+1, j+1);
		}
		return false;
	}

	private boolean isSame(String s, String p, int i, int j) {
		if(i == s.length() || j == p.length()) {
			return false;
		}
		return p.charAt(j) == '.' ? true : s.charAt(i) == p.charAt(j); 
	}

	private boolean isNextStar(String p, int j) {
		if(j+1 == p.length()) {
			return false;
		}
		return p.charAt(j+1) == '*';
	}
	
	String ij(int i, int j) {
		return "i = " + i + ", j = "+j;
	}
}
