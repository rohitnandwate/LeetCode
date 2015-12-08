package com.rhn.algorithms;

import java.util.List;

import org.junit.Test;

import com.rhn.algorithms.NQueens.Solution;

public class NQueensTest {

	private NQueens nQueens = new NQueens();
	private NQueens.Solution sol = nQueens.new Solution();
	
	@Test
	public void test() {
		List<List<String>> ans = nQueens.solveNQueens(10);
//		nQueens.print(ans);
		
//		long start = System.currentTimeMillis();
//		List<List<String>> ans = sol.solveNQueens(11);
//		System.out.println("Time: "+(System.currentTimeMillis()-start) +" ms");
//		nQueens.print(ans);
		System.out.println(NQueens.calls);
	}

}
