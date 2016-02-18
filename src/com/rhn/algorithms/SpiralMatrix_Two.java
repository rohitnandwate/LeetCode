package com.rhn.algorithms;

/**
 * https://leetcode.com/problems/spiral-matrix-ii/
 * @author rohitnandwate
 *
 */
public class SpiralMatrix_Two {
    public int[][] generateMatrix(int n) {
        if(n == 0) {
        	return null;
        }
        int[][] matrix = new int[n][n];
        helper(n, n, 1, 0, matrix);
        return matrix;
    }

	private void helper(int m, int n, int start, int k, int[][] matrix) {
		if(n == 0){
			return;
		}
		if(n == 1) {
			matrix[k][k] = start;
			return;
		}
		for(int i=0; i<n; ++i) {
			matrix[k][i+k] = start+i;
			matrix[i+k][m-k-1] = start + i + n-1;
			matrix[m-k-1][m-k-1-i] = start + i + 2*(n-1);
			if(i < n-1) {
				matrix[m-k-1-i][k] = start + i + 3*(n-1);
			}
		}
		helper(m, n-2, 4*(n-1)+start, k+1, matrix);
	}
	
	public void print(int[][] matrix) {
		int n = matrix[0].length;
		
		for(int i=0; i<n; ++i) {
			for(int j=0; j<n; ++j) {
				System.out.print(matrix[i][j]+", ");
			}
			System.out.println();
		}
	}
}
