package com.rhn.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class FirstMissingPositiveTest {

	private FirstMissingPositive missing = new FirstMissingPositive();
	
	@Test
	public void test() {
		int[] nums = {-5,0,1,4,2,-4,3,6};
		assertEquals(5, missing.firstMissingPositive(nums));
		
		int[] nums1 = {-5,5,1,4,2,-4,3,6};
		assertEquals(7, missing.firstMissingPositive(nums1));
		
		int[] nums2 = {-5,5,4,2,-4,3,6};
		assertEquals(1, missing.firstMissingPositive(nums2));

		int[] nums3 = {6};
		assertEquals(1, missing.firstMissingPositive(nums3));
		
		int[] nums4 = {1,1};
		assertEquals(2, missing.firstMissingPositive(nums4));
		
		int[] nums5 = {2,1};
		assertEquals(3, missing.firstMissingPositive(nums5));
		
		int[] nums6 = {1,2,2,1,3,1,0,4,0};
		assertEquals(5, missing.firstMissingPositive(nums6));
		
		int[] nums7 = {1,100};
		assertEquals(2, missing.firstMissingPositive(nums7));
	}

}
