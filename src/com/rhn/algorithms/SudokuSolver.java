package com.rhn.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/sudoku-solver/
 * @author rohitnandwate
 *
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
    	int[] rmap = {0,0,0,0,0,0,0,0,0};
    	int[] cmap = {0,0,0,0,0,0,0,0,0};
    	int[] bmap = {0,0,0,0,0,0,0,0,0};
    	
    	int cnt = 0;
    	
    	for(int i=0; i<9; ++i) {
    		for(int j=0; j<9; ++j) {
    			if(board[i][j] != '.') {
    				int num = board[i][j]-'0';
    				markUsed(num, i, j, rmap, cmap, bmap);
    				cnt++;
    			}
    		}
    	}
    	helper(board, rmap, cmap, bmap, 0, cnt);
    }
    
	private boolean helper(char[][] board, int[] rmap, int[] cmap, int[] bmap,
			int cellNum, int cnt) {
    	if(cnt == 81) {
    		return true;
    	}
    	
    	for(int i=cellNum/9; i < 9; ++i) {
    		for(int j=cellNum%9; j < 9; ++j) {
    			if(board[i][j] != '.') {
    				cellNum++;
    				continue;
    			}
    			List<Integer> availableNums = getAvailableNums(i, j, rmap, cmap, bmap);
    			if(availableNums.isEmpty()) {
    				return false;
    			}
    			for(Integer num : availableNums) {
    				board[i][j] = (char) (num+'0');
    				markUsed(num, i, j, rmap, cmap, bmap);
    				if(helper(board, rmap, cmap, bmap,cellNum+1, cnt+1)){
    					return true;
    				} else {
    					board[i][j] = '.';
    					markUnUsed(num, i, j, rmap, cmap, bmap);
    				}
    			}
    			return false;
    		}
    	}
    	return true;
	}

    private List<Integer> getAvailableNums(int row, int col, int[] rmap, int[]cmap, int[]bmap) {
    	int blockNum = getBlockNum(row, col);
    	List<Integer> avail = new ArrayList<Integer>();
    	int num = rmap[row] | cmap[col] | bmap[blockNum];
    	for(int i = 1; i < 10; ++i) {
    		int bitMask = (1 << i);
    		if((num & bitMask) == 0) {
    			avail.add(i);
    		}
    	}
    	return avail;
    }
    
	private void markUsed(int num, int row, int col, int[] rmap, int[]cmap, int[]bmap) {
    	int bitSetMask = 1 << num;
    	int blockNum = getBlockNum(row, col);
    	rmap[row] = rmap[row] | bitSetMask;
    	cmap[col] = cmap[col] | bitSetMask;
    	bmap[blockNum] = bmap[blockNum] | bitSetMask;
    }
    
  	private void markUnUsed(int num, int row, int col, int[] rmap, int[]cmap, int[]bmap) {
    	int bitResetMask = 1 << num;
    	int blockNum = getBlockNum(row, col);
    	rmap[row] = rmap[row] ^ bitResetMask;
    	cmap[col] = cmap[col] ^ bitResetMask;
    	bmap[blockNum] = bmap[blockNum] ^ bitResetMask;
    }

  	private int getBlockNum(int row, int col) {
  		return (3*(row/3))+(col/3);
  	}
  	
  	void print(char[][] board) {
  		for(int i=0; i<9; ++i) {
			for(int j=0; j<9; j++) {
				System.out.print(board[i][j] +" ");
			}
			System.out.println();
		}
  	}
}
