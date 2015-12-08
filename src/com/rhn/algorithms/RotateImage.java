package com.rhn.algorithms;

/**
 * https://leetcode.com/problems/rotate-image/
 * @author rohitnandwate
 *
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
    	for(int st=0; st< (matrix.length/2); st++) {
    		helper(matrix, st);
    	}
    }

	private void helper(int[][] mat, int st) {
		int end = mat.length - 1 - st;
		System.out.println("start="+st);
		System.out.println("end="+end);
		System.out.println("count="+(end-st-1));
		for(int i=0; i<end-st; ++i) {
			int temp = mat[st][st+i];
			
			mat[st][st+i] = mat[end-i][st];
			mat[end-i][st] = mat[end][end-i];
			mat[end][end-i] = mat[st+i][end];
			mat[st+i][end] = temp;
		}
	}
	
	public void print(int[][] mat) {
		for(int i=0; i<mat.length; ++i) {
			for(int j=0; j< mat[i].length; ++j) {
				System.out.print(mat[i][j] + ", ");
			}
			System.out.println();
		}
	}
}
