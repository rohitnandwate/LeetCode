package com.rhn.algorithms;

import org.junit.Test;

public class PermutationsTest {

	private Permutations p = new Permutations();
	@Test
	public void test() {
		int[] nums = {1,2,3};
		System.out.println(p.permute(nums));
	}

	@Test
	public void test1() {
		int[] nums = {1,2,1};
		System.out.println(p.permute(nums));
	}

	@Test
	public void test2() {
		int[] nums = {1,1,1};
		System.out.println(p.permute(nums));
	}
	
}
