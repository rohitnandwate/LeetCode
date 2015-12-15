package com.rhn.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 * @author rohitnandwate
 *
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
        int m = matrix.length;
        if(m == 0)
        	return ans;
        int n = matrix[0].length;
        for(int k=0; k<=(m-1)/2 && k<=(n-1)/2; ++k) {
        	// top
        	for(int i=k; i<n-k; ++i) {
        		ans.add(matrix[k][i]);
        	}
        	
        	// right
        	for(int i=k+1; i<m-k-1; ++i){
        		ans.add(matrix[i][n-k-1]);
        	}
        	
        	// bottom
        	for(int i=n-k-1; i>=k && k<m/2; --i) {
        		ans.add(matrix[m-k-1][i]);
        	}
        	
        	// left
        	for(int i=m-k-2; i>k && k<n/2; --i) {
        		ans.add(matrix[i][k]);
        	}
        }
        return ans;
    }
}
