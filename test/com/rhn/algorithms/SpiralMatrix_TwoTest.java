package com.rhn.algorithms;

import org.junit.Test;

public class SpiralMatrix_TwoTest {

	private SpiralMatrix_Two spiral = new SpiralMatrix_Two();
	
	@Test
	public void test() {
		for(int i=3; i< 15; ++i) {
			System.out.println("Matrix of size "+i+" : ");
			spiral.print(spiral.generateMatrix(i));
		}
	}

}
