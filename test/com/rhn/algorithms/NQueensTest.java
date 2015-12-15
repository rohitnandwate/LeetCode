package com.rhn.algorithms;

import org.junit.Test;

public class NQueensTest {

	private NQueens nQueens = new NQueens();
	private NQueens_two nQueens_two = new NQueens_two();
	
	@Test
	public void test() {
		nQueens.solveNQueens(10);
		nQueens_two.totalNQueens(4);
		nQueens_two.totalNQueens(10);
	}

}
