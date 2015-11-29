package com.rhn.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuSolverTest {

	private SudokuSolver solver = new SudokuSolver();
	private ValidSudoku validator = new ValidSudoku();
	
	@Test
	public void test() {
		String [] arr = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
		char[][] board = new char[9][9];
		for(int i=0; i<arr.length; ++i) {
			for(int j=0; j<9; j++) {
				board[i][j] = arr[i].charAt(j);
			}
		}
		solver.solveSudoku(board);
		assertTrue(validator.isValidSudoku(board));
		solver.print(board);
	}
}
