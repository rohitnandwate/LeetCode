package com.rhn.algorithms;

/**
 * https://leetcode.com/problems/container-with-most-water/
 * @author rohitnandwate
 *
 */
public class ContainerWithMaxWater {
	public int maxArea(int[] height) {
		int max = 0;
		int start = 0;
		int end = height.length-1;
		while(start < end) {
			max = Math.max(max, (end-start)* Math.min(height[start], height[end]));
			if(height[start] > height[end]) {
				end--;
			} else {
				start++;
			}
		}
		return max;
    }
}
