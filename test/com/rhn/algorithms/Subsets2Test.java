package com.rhn.algorithms;

import org.junit.Test;

public class Subsets2Test {

	private Subsets2 s = new Subsets2();
	
	@Test
	public void test() {
		int[] nums = {1, 2};
		System.out.println(s.subsetsWithDup(nums));
	}

	@Test
	public void test1() {
		int[] nums = {1, 1,1,1,1,1};
		System.out.println(s.subsetsWithDup(nums));
	}
}
