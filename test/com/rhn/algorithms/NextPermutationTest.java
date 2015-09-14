package com.rhn.algorithms;

import java.util.Arrays;

import org.junit.Test;

public class NextPermutationTest {

	private NextPermutation next = new NextPermutation();
	
	@Test
	public void test() {
		int[] nums = {1,2,3};
		next.nextPermutation(nums);
		Arrays.stream(nums).forEach(x -> System.out.print(x+" "));
		System.out.println();
	}

	@Test
	public void test1() {
		int[] nums = {3,2,1};
		next.nextPermutation(nums);
		Arrays.stream(nums).forEach(x -> System.out.print(x+" "));
		System.out.println();
	}
	
	@Test
	public void test2() {
		int[] nums = {1,1,5};
		next.nextPermutation(nums);
		Arrays.stream(nums).forEach(x -> System.out.print(x+" "));
		System.out.println();
	}
	
	@Test
	public void test3() {
		int[] nums = {1,3,2};
		next.nextPermutation(nums);
		Arrays.stream(nums).forEach(x -> System.out.print(x+" "));
		System.out.println();
	}
}
