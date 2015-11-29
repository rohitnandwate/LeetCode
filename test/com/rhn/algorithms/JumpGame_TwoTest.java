package com.rhn.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class JumpGame_TwoTest {

	private JumpGame_Two j = new JumpGame_Two();
	@Test
	public void test() {
		int[] nums = {2,3,1,1,4};
		assertEquals(2, j.jump(nums));
	}

	@Test
	public void test1() {
		int[] nums = {2,3,1,1,4,2,3,4,51,2,3};
		assertEquals(4, j.jump(nums));
	}

	@Test
	public void test2() {
		int[] nums = {2,0,0,0,0,0,0,9};
		assertEquals(Integer.MAX_VALUE, j.jump(nums));
	}

	@Test
	public void test3() {
		int[] nums = {3,0,0,2,3,1,9};
		assertEquals(3, j.jump(nums));
	}
}

