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
		
	}
	
	@Test
	public void testMarkUsed() {
		int[] rmap = {0,0,0,0,0,0,0,0,0};
    	int[] cmap = {0,0,0,0,0,0,0,0,0};
    	int[] bmap = {0,0,0,0,0,0,0,0,0};
    	
//    	markUsed(1,)
	}

	
	@Test
	public void testBits() {
		int bitMask = 1;
		int num = 0;
		
		for(int i=1; i<10; ++i) {
			bitMask = 1;
			bitMask = bitMask << i;
			System.out.println("Bit mask: "+Integer.toBinaryString(bitMask));
			num = num | bitMask;
			System.out.println("Num: "+Integer.toBinaryString(num));
		}
	}
}
