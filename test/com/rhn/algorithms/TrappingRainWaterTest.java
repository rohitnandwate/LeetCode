package com.rhn.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrappingRainWaterTest {

	private TrappingRainWater water = new TrappingRainWater();
	
	@Test
	public void test() {
		int[] h = {0,1,0,2,1,0,1,3,2,1,2,1};
		assertEquals(6, water.trap(h));
	}

	@Test
	public void test1() {
		int[] h = {0};
		assertEquals(0, water.trap(h));
	}
	
	@Test
	public void test2() {
		int[] h = {5,4,1,2};
		assertEquals(1, water.trap(h));
	}
	@Test
	public void test3() {
		int[] h = {5,2,1,2,1,5};
		assertEquals(14, water.trap(h));
	}
	
	@Test
	public void test4() {
		int[] h = {6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3};
		assertEquals(83, water.trap(h));
	}
	
	@Test
	public void test5() {
		int[] h = {8,8,1,5,6,2,5,3,3,9};
		assertEquals(31, water.trap(h));
	}
}
