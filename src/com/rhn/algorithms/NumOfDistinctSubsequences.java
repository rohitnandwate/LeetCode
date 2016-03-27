package com.rhn.algorithms;

public class NumOfDistinctSubsequences {
	public int numDistinct(String s, String t) {
	    int[] dp = new int[t.length()];
	    for(int i=0; i<s.length(); i++) {
	        for(int j=t.length()-1; j>=0; j--) {
	            if(s.charAt(i) == t.charAt(j)) {
	                dp[j] = ( j==0 ? 1 : dp[j-1]) + dp[j];
	            }
	        }
	        print(dp);
	    }
	    return dp[t.length()-1];
	}
	
	public void print(int[] num) {
		StringBuilder sb = new StringBuilder(num.length);
		for(int i=0; i< num.length; ++i) {
			sb.append(num[i]);
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}
}
