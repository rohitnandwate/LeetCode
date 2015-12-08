package com.rhn.algorithms;

import org.junit.Test;

public class NQueensTest {

	private NQueens nQueens = new NQueens();
	
	@Test
	public void test() {
		nQueens.solveNQueens(5);
	}

}
