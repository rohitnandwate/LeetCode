package com.rhn.algorithms;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.rhn.algorithms.BinarySearch;

public class BinarySearchTest {
	
	@Before
	public void setup() {
	}
	
	@Test
	public void testLargestNumLessThanOrEqualsToKey() {
		int[] arr = {0,1,2,3,4,5,6,7,8,9};
		for(int i=0; i<arr.length; ++i)
			assertEquals(i, BinarySearch.largestNumLessThanOrEqualsToKey(arr, i));
		
		int[] arr1 = {3,3,3,3,3,3,3,3,3,3};
		assertEquals(arr1.length-1, BinarySearch.largestNumLessThanOrEqualsToKey(arr1, 3));
		assertEquals(arr1.length-1, BinarySearch.largestNumLessThanOrEqualsToKey(arr1, 4));
		assertEquals(arr1.length-1, BinarySearch.largestNumLessThanOrEqualsToKey(arr1, 5));
		assertEquals(arr1.length-1, BinarySearch.largestNumLessThanOrEqualsToKey(arr1, 6));
		assertEquals(-1, BinarySearch.largestNumLessThanOrEqualsToKey(arr1, 2));
		assertEquals(-1, BinarySearch.largestNumLessThanOrEqualsToKey(arr1, 1));
		
		int[] arr2 = {5};
		assertEquals(-1, BinarySearch.largestNumLessThanOrEqualsToKey(arr2, 1));
		assertEquals(0, BinarySearch.largestNumLessThanOrEqualsToKey(arr2, 5));
		assertEquals(0, BinarySearch.largestNumLessThanOrEqualsToKey(arr2, 54));
		
		int[] arr3 = {4,6};
		assertEquals(-1, BinarySearch.largestNumLessThanOrEqualsToKey(arr3, 1));
		assertEquals(0, BinarySearch.largestNumLessThanOrEqualsToKey(arr3, 5));
		
		int[] arr4 = {4,6,7,11,23,23,35,41,55,55};
		assertEquals(-1, BinarySearch.largestNumLessThanOrEqualsToKey(arr4, -12));
		assertEquals(-1, BinarySearch.largestNumLessThanOrEqualsToKey(arr4, 1));
		assertEquals(-1, BinarySearch.largestNumLessThanOrEqualsToKey(arr4, 2));
		assertEquals(0, BinarySearch.largestNumLessThanOrEqualsToKey(arr4, 4));
		assertEquals(0, BinarySearch.largestNumLessThanOrEqualsToKey(arr4, 5));
		assertEquals(1, BinarySearch.largestNumLessThanOrEqualsToKey(arr4, 6));
		assertEquals(2, BinarySearch.largestNumLessThanOrEqualsToKey(arr4, 7));
		assertEquals(2, BinarySearch.largestNumLessThanOrEqualsToKey(arr4, 8));
		assertEquals(2, BinarySearch.largestNumLessThanOrEqualsToKey(arr4, 9));
		assertEquals(2, BinarySearch.largestNumLessThanOrEqualsToKey(arr4, 10));
		assertEquals(3, BinarySearch.largestNumLessThanOrEqualsToKey(arr4, 11));
		assertEquals(3, BinarySearch.largestNumLessThanOrEqualsToKey(arr4, 12));
		assertEquals(3, BinarySearch.largestNumLessThanOrEqualsToKey(arr4, 22));
		assertEquals(5, BinarySearch.largestNumLessThanOrEqualsToKey(arr4, 23));
		assertEquals(arr4.length-1, BinarySearch.largestNumLessThanOrEqualsToKey(arr4, 55));
		assertEquals(arr4.length-1, BinarySearch.largestNumLessThanOrEqualsToKey(arr4, 56));
		assertEquals(arr4.length-1, BinarySearch.largestNumLessThanOrEqualsToKey(arr4, 106));
	}

	@Test
	public void testFindInsertionPoint() {
		int[] arr = {0,1,2,3,4,5,6,7,8,9};
		for(int i=0; i<arr.length; ++i)
			assertEquals(i, BinarySearch.findInsertionPoint(arr, i));
		
		int[] arr1 = {3,3,3,3,3,3,3,3,3,3};
		assertEquals(arr1.length-1, BinarySearch.findInsertionPoint(arr1, 3));
		assertEquals(arr1.length-1, BinarySearch.findInsertionPoint(arr1, 4));
		assertEquals(arr1.length-1, BinarySearch.findInsertionPoint(arr1, 5));
		assertEquals(arr1.length-1, BinarySearch.findInsertionPoint(arr1, 6));
		assertEquals(-1, BinarySearch.findInsertionPoint(arr1, 2));
		assertEquals(-1, BinarySearch.findInsertionPoint(arr1, 1));
		
		int[] arr2 = {5};
		assertEquals(-1, BinarySearch.findInsertionPoint(arr2, 1));
		assertEquals(0, BinarySearch.findInsertionPoint(arr2, 5));
		assertEquals(0, BinarySearch.findInsertionPoint(arr2, 54));
		
		int[] arr3 = {4,6};
		assertEquals(-1, BinarySearch.findInsertionPoint(arr3, 1));
		assertEquals(0, BinarySearch.findInsertionPoint(arr3, 5));
		
		int[] arr4 = {4,6,7,11,23,23,35,41,55,55};
		assertEquals(-1, BinarySearch.findInsertionPoint(arr4, -12));
		assertEquals(-1, BinarySearch.findInsertionPoint(arr4, 1));
		assertEquals(-1, BinarySearch.findInsertionPoint(arr4, 2));
		assertEquals(0, BinarySearch.findInsertionPoint(arr4, 4));
		assertEquals(0, BinarySearch.findInsertionPoint(arr4, 5));
		assertEquals(1, BinarySearch.findInsertionPoint(arr4, 6));
		assertEquals(2, BinarySearch.findInsertionPoint(arr4, 7));
		assertEquals(2, BinarySearch.findInsertionPoint(arr4, 8));
		assertEquals(2, BinarySearch.findInsertionPoint(arr4, 9));
		assertEquals(2, BinarySearch.findInsertionPoint(arr4, 10));
		assertEquals(3, BinarySearch.findInsertionPoint(arr4, 11));
		assertEquals(3, BinarySearch.findInsertionPoint(arr4, 12));
		assertEquals(3, BinarySearch.findInsertionPoint(arr4, 22));
		assertEquals(5, BinarySearch.findInsertionPoint(arr4, 23));
		assertEquals(arr4.length-1, BinarySearch.findInsertionPoint(arr4, 55));
		assertEquals(arr4.length-1, BinarySearch.findInsertionPoint(arr4, 56));
		assertEquals(arr4.length-1, BinarySearch.findInsertionPoint(arr4, 106));		
		
		int[] arr5 = {};
		assertEquals(-1, BinarySearch.findInsertionPoint(arr5, 0));
		
	}
	
}
