package com.rhn.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class RotateImageTest {

	private RotateImage r = new RotateImage();
	
	@Test
	public void test() {
		int[][] mat = {	{1,2,3,4,5,6},
						{1,2,3,4,5,6},
						{1,2,3,4,5,6},
						{1,2,3,4,5,6},
						{1,2,3,4,5,6},
						{1,2,3,4,5,6}};
		r.print(mat);
		r.rotate(mat);
		System.out.println("Rotated 90 degrees clockwise:"); 
		r.print(mat);
	}

	@Test
	public void test_1() {
		int[][] mat = 	{{2,29,20,26,16,28},{12,27,9,25,13,21},{32,33,32,2,28,14},{13,14,32,27,22,26},{33,1,20,7,21,7},{4,24,1,6,32,34}};
		r.print(mat);
		r.rotate(mat);
		System.out.println("Rotated 90 degrees clockwise:"); 
		r.print(mat);
	}
	

}
