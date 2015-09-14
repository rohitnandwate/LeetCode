package com.rhn.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchForARangeTest {
	private SearchForARange searchRange = new SearchForARange();
	
	@Test
	public void test() {
		int[] arr = {1,2,3,4,5,6,6,6,6,6,6,7,7,7,8};
		int[] ans = searchRange.searchRangeHelper(arr, 0, arr.length-1, 6);
		int[] expected = {5, 10};
		assertArrayEquals(expected, ans);
	}
	
	@Test
	public void test1() {
		int[] arr = {1,2,3,4,5,6,6,6,6,6,6,7,7,7,8};
		int[] ans = searchRange.searchRangeHelper(arr, 0, arr.length-1, 7);
		int[] expected = {11, 13};
		assertArrayEquals(expected, ans);
	}

	@Test
	public void test2() {
		int[] arr = {1,1,1,1,1,1,1,1,1,1,1};
		int[] ans = searchRange.searchRangeHelper(arr, 0, arr.length-1, 1);
		int[] expected = {0, arr.length-1};
		assertArrayEquals(expected, ans);
	}
	
	@Test
	public void test3() {
		int[] arr = {1,1,1,1,1,1,1,1,1,1,1};
		int[] ans = searchRange.searchRangeHelper(arr, 0, arr.length-1, 3);
		int[] expected = {-1, -1};
		assertArrayEquals(expected, ans);
	}
	
	@Test
	public void test4() {
		int[] arr = {1,2,3,4,5,6,6,6,6,6,6,7,7,7,8};
		int[] ans = searchRange.searchRangeHelper(arr, 0, arr.length-1, 9);
		int[] expected = {-1,-1};
		assertArrayEquals(expected, ans);
	}

}
