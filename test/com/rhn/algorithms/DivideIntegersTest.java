package com.rhn.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class DivideIntegersTest {

	private DivideIntegers d = new DivideIntegers();

	@Test
	public void test() {
		assertEquals(8, d.divide(25, 3));
		assertEquals(17, d.divide(17, 1));
		assertEquals(-8, d.divide(-25, 3));
		assertEquals(-17, d.divide(17, -1));
		assertEquals(10, d.divide(1024, 100));
		assertEquals(11, d.divide(35, 3));
		assertEquals(-83, d.divide(-250, 3));
	}
	
	@Test
	public void test_1() {
		System.out.println("MIN: "+Integer.MIN_VALUE);
		System.out.println("MAX: "+Integer.MAX_VALUE);
		assertEquals(1073741823, d.divide(Integer.MAX_VALUE, 2));
		assertEquals(Integer.MAX_VALUE, d.divide(Integer.MAX_VALUE, 1));
		assertEquals(Integer.MAX_VALUE,d.divide(Integer.MIN_VALUE, 2));
		assertEquals(Integer.MAX_VALUE,d.divide(Integer.MIN_VALUE, -1));
	}
	
	@Test
	public void test_2() {
		System.out.println(d.divide(127, 4));
	}

}
