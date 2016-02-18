package com.rhn.algorithms;

import org.junit.Test;

public class LargestRectangleInHistogramTest {

	private LargestRectangleInHistogram hist = new LargestRectangleInHistogram();
	
	@Test
	public void test() {
		int[] height = {2,1,5,6,2,3};
		System.out.println(hist.largestRectangleArea(height));
	}

}
