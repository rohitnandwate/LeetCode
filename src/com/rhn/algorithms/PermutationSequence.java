package com.rhn.algorithms;

import java.util.Arrays;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        boolean[] avail = new boolean[n];
        Arrays.fill(avail, true);
        char[] ans = new char[n];
        helper(n,k,avail,ans,0,0);
        return new String(ans);
    }
    
    int helper(int n, int k, boolean[] avail, char[] ans, int cnt, int m) {
        if(m == n) {
            return cnt+1;
        }
        for(int i=0; i<n; ++i) {
            if(avail[i]) {
                avail[i] = false;
                ans[m] = (char) ('0' + (i+1));
                cnt = helper(n,k,avail,ans,cnt,m+1);
                if(cnt == k) {
                    return cnt;
                }
                avail[i] = true;
            }
        }
        return cnt;
    }
}