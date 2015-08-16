package com.rhn.algorithms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.rhn.algorithms.FindMedian;

public class FindMedianTest {

	@Test
	public void testFindMedian() {
		int arr1[] = {1,2,3,4,5,6,7};
		int arr2[] = {2,3,4};
		testHelper(3.5, arr1, arr2);
	}
	@Test
	public void testFindMedian_1() {
		int arr1[] = {1,2,3,4,5,6};
		int arr2[] = {2,3,4};
		testHelper(3, arr1, arr2);
	}
	@Test
	public void testFindMedian_2() {
		int arr1[] = {};
		int arr2[] = {3};
		testHelper(3, arr1, arr2);
		
		int arr3[] = {};
		int arr4[] = {3,6,7,11,11,13};
		testHelper(9, arr3, arr4);
		
		int arr5[] = {};
		int arr6[] = {3,6,7,11,11};
		testHelper(7, arr5, arr6);
	}
	@Test
	public void testFindMedian_3() {
		int arr1[] = {2};
		int arr2[] = {3};
		testHelper(2.5, arr1, arr2);
	}
	@Test
	public void testFindMedian_4() {
		int arr1[] = {2,2,2,2,2};
		int arr2[] = {3,3,3,3};
		testHelper(2, arr1, arr2);
		
		int arr3[] = {2,2,2,2,};
		int arr4[] = {3,3,3,3,3};
		testHelper(3, arr3, arr4);
		

		int arr5[] = {2,2};
		int arr6[] = {3,3};
		testHelper(2.5, arr5, arr6);
	}
	@Test
	public void testFindMedian_5() {
		int arr1[] = {2, 5, 7};
		int arr2[] = {13,31,55,350};
		testHelper(13, arr1, arr2);
	}
	
	private void testHelper(double expectedAns, int[] a, int[] b) {
		assertEquals(expectedAns, FindMedian.findMedianSortedArrays(a, b), 0.00001);
		assertEquals(expectedAns, FindMedian.findMedianSortedArrays(b, a), 0.00001);

		assertEquals(expectedAns, FindMedian.findMedianSortedArrays_fast(a, b), 0.00001);
		assertEquals(expectedAns, FindMedian.findMedianSortedArrays_fast(b, a), 0.00001);
	}
}
