package com.rhn.algorithms;

import org.junit.Before;
import org.junit.Test;

public class IntegerToRomanTest {

	private IntegerToRoman roman;
	
	@Before
	public void setup() {
		roman = new IntegerToRoman();
	}
	
	@Test
	public void test() {
		for(int i=0; i< 4000; ++i)
			System.out.println(i+" = "+roman.intToRoman(i));
	}

//	@Test
//	public void test_1() {
//		int i=5;
//		System.out.println(i+" = "+roman.intToRoman(i));
//	}
}
