package com.rhn.algorithms.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinarySearchUtilTest {

	@Test
	public void testBinSearch() {
		int[] arr = {1,3,4,5,6,8,12,13,54};
		for(int i=0; i<arr.length; ++i) {
			assertEquals(i, BinarySearchUtil.binSearch(arr, 0, arr.length-1, arr[i]));
		}
	}
	
	@Test
	public void testRotationPoint() {
		int[] arr = {1};
		assertEquals(0, BinarySearchUtil.findRotationPoint(arr, 0, 0));
	}

	@Test
	public void testRotationPoint1() {
		int[] arr = {1,2,3,4,5,6,7,8};
		assertEquals(0, BinarySearchUtil.findRotationPoint(arr, 0, 7));
	}
	
	@Test
	public void testRotationPoint2() {
		int[] arr = {10,11,14,15,16,1,2,3,4,5,6};
		assertEquals(5, BinarySearchUtil.findRotationPoint(arr, 0, 10));
	}
	
	@Test
	public void testRotationPoint3() {
		int[] arr = {2,3,4,5,6,1};
		assertEquals(5, BinarySearchUtil.findRotationPoint(arr, 0, 5));
	}
	
	@Test
	public void testRotationPoint4() {
		int[] arr = {6,1,2,3,4,5};
		assertEquals(1, BinarySearchUtil.findRotationPoint(arr, 0, 5));
	}
	
	@Test
	public void testRotationPoint5() {
		int[] arr = {1,6};
		assertEquals(0, BinarySearchUtil.findRotationPoint(arr, 0, 1));
	}
}
