package com.rhn.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/n-queens/
 * @author rohitnandwate
 *
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<List<String>>();
        int[] avail = new int[n];
        Arrays.fill(avail, -1);
        long start = System.currentTimeMillis();
        solve(n, ans, avail, 0);
        System.out.println("Input n= "+n+" Time: "+(System.currentTimeMillis()-start) +" ms. Solutions: "+ans.size());
        return ans;
    }

	private void solve(int n, List<List<String>> ans, int[] avail, int k) {
		if(k==n) {
			addAns(n, ans, avail);
			return;
		}
		for(int i=0; i<n; ++i) {
			avail[k] = i;
			if(isValid(avail, k)) {
				solve(n, ans, avail, k+1);
			}
		}
	}

	private boolean isValid(int[] avail, int k) {
		for(int i=0; i<k; ++i) {
			if(avail[i] == avail[k] || Math.abs(avail[i]-avail[k]) == Math.abs(i-k))
				return false;
		}
		return true;
	}

	private void addAns(int n, List<List<String>> ans, int[] avail) {
		List<String> sol = new ArrayList<String>();
		for(int i=0; i<n; ++i) {
			if(avail[i] == -1) {
				return;
			}
			char[] carr = new char[n];
			Arrays.fill(carr, '.');
			carr[avail[i]] = 'Q';
			sol.add(new String(carr));
		}
		ans.add(sol);
	}
	
	public void print(List<List<String>> ans){
		ans.stream().forEach(x -> {
			System.out.println();
			x.stream().forEach(y -> System.out.println(y));	
		});
		System.out.println("Num of solutions:"+ ans.size());
	}
}