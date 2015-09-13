package com.rhn.algorithms;

/**
 * https://leetcode.com/problems/implement-strstr/
 * @author rohitnandwate
 *
 */
public class NeedleInAHaystack {
    public int strStr(String haystack, String needle) {
    	int i=0;
    	if(haystack.length() == 0 && needle.length() == 0)
    		return 0;
    	while(i < haystack.length()) {
        	int k = i;
        	int j = 0;
        	if(haystack.length()-i < needle.length()) {
        		return -1;
        	}
        	System.out.println("out");
        	while(k<haystack.length() && j<needle.length()
        			&& haystack.charAt(k) == needle.charAt(j)) {
        		k++;
        		j++;
        		System.out.println("in");
        	}
        	if(j == needle.length()) {
        		return i;
        	} else {
        		i++;
        		System.out.println("i="+i);
        	}
        }
        return -1;
    }
}
