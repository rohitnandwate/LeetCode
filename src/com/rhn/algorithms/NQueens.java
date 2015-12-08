package com.rhn.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
	public static long calls = 0;
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<List<String>>();
        int[] avail = new int[n];
        Arrays.fill(avail, -1);
        long start = System.currentTimeMillis();
        solve(n, ans, avail, 0);
        System.out.println("Time: "+(System.currentTimeMillis()-start) +" ms");
        return ans;
    }

	private void solve(int n, List<List<String>> ans, int[] avail, int k) {
		calls++;
		if(k==n) {
			addAns(n, ans, avail);
			return;
		}
		for(int i=0; i<n; ++i) {
			if(avail[i] != -1) {
				continue;
			}
			if(k > 0) {
				if(i == 0 & n > 1 && avail[i+1] == k-1) {
					continue;
				}
				if(i > 0 && i < n-1 && (avail[i+1] == k-1 || avail[i-1] == k-1)) {
					continue;
				}
				if(i == n-1 && avail[i-1] == k-1) {
					continue;
				}
			}
			avail[i] = k;
			solve(n, ans, avail, k+1);
			avail[i] = -1;
		}
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