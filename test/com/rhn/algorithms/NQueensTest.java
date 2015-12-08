package com.rhn.algorithms;

import java.util.List;

import org.junit.Test;

public class NQueensTest {

	private NQueens nQueens = new NQueens();
	
	@Test
	public void test() {
		nQueens.solveNQueens(5);
	}

}
