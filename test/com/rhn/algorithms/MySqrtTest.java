package com.rhn.algorithms;

import org.junit.Test;

public class MySqrtTest {

	private MySqrt sqrt = new MySqrt();
	
	@Test
	public void test() {
		System.out.println(sqrt.mySqrt(2147395600));
	}

	@Test
	public void test1() {
		String s = "/./.././../rohit/nandwate/rohit";
		String[] tokens = s.split("/");
		
		for(String t : tokens) {
			System.out.println(t);
		}
	}
}
