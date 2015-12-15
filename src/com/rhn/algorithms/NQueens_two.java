package com.rhn.algorithms;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/n-queens-ii/
 * @author rohitnandwate
 *
 */
public class NQueens_two {

    public int totalNQueens(int n) {
    	int solutions = 0;
    	int[] avail = new int[n];
        Arrays.fill(avail, -1);
        long start = System.currentTimeMillis();
        solutions = solve(n, avail, 0);
        System.out.println("Input n= "+n+" Solutions: "+solutions+" Time: "+(System.currentTimeMillis()-start) +" ms");
    	return solutions;
    }
    
    private int solve(int n, int[] avail, int k) {
		if(k==n) {
			return 1;
		}
		int count = 0;
		for(int i=0; i<n; ++i) {
			avail[k] = i;
			if(isValid(avail, k)) {
				count += solve(n, avail, k+1);
			}
		}
		return count;
	}

	private boolean isValid(int[] avail, int k) {
		for(int i=0; i<k; ++i) {
			if(avail[i] == avail[k] || Math.abs(avail[i]-avail[k]) == Math.abs(i-k))
				return false;
		}
		return true;
	}

}