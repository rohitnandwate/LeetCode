package com.rhn.algorithms;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 * @author rohitnandwate
 *
 */
public class LongestCommonPrefix {
	
	public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
        	return "";
        if(strs.length == 1)
        	return strs[0];
        StringBuilder prefix = new StringBuilder();
        for(int i=0; i < strs[0].length(); ++i) {
        	if(!present(i, strs)) {
        		break;
        	}
        	prefix.append(strs[0].charAt(i));
        }
        return prefix.toString();
    }
	
	boolean present(int i, String[] strs) {
		char c = strs[0].charAt(i);
		for(int j = 1; j< strs.length; ++j) {
			if(i == strs[j].length() || c != strs[j].charAt(i)) {
				return false;
			}
		}
		return true;
	}
}
