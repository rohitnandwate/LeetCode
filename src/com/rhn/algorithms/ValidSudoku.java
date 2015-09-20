package com.rhn.algorithms;

/**
 * https://leetcode.com/problems/valid-sudoku/
 * @author rohitnandwate
 *
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
    	for(int i=0; i < 9; ++i) {
    		if(validateRow(i, board) 
    			&& validateColumn(i, board)
    			&& validateBlock(i, board)) {
    			continue;
    		} else {
    			return false;
    		}
    	}
        return true;
    }

    private boolean validateBlock(int block, char[][] board) {
    	int row = block < 3 ? 0 : block < 6 ? 3 : 6;
    	int col = block%3 * 3;
    	boolean[] nums = new boolean[9];
    	for(int i=row; i< row+3; ++i) {
    		for(int j=col; j < col+3; ++j) {
    			if(board[i][j] == '.') {
    				continue;
    			}
    			if(nums[board[i][j] - '0' -1]) {
    				return false;
    			} else {
    				nums[board[i][j] - '0' -1] = true;
    			}
    		}
    	}
    	return true;
    }
    
    private boolean validateRow(int row, char[][] board) {
    	boolean[] nums = new boolean[9];
    	for(int j=0; j< 9; ++j) {
			if(board[row][j] == '.') {
				continue;
			}
			if(nums[board[row][j] - '0' -1]) {
				return false;
			} else {
				nums[board[row][j] - '0' -1] = true;
			}
    	}
    	return true;
    }
    
    private boolean validateColumn(int col, char[][] board) {
    	boolean[] nums = new boolean[9];
    	for(int j=0; j< 9; ++j) {
			if(board[j][col] == '.') {
				continue;
			}
			if(nums[board[j][col] - '0' -1]) {
				return false;
			} else {
				nums[board[j][col] - '0' -1] = true;
			}
    	}
    	return true;
    }
}
