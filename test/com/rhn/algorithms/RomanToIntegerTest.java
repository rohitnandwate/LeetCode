package com.rhn.algorithms;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RomanToIntegerTest {

	private RomanToInteger roman;
	private IntegerToRoman intToRoman;
	
	@Before
	public void setup() {
		roman = new RomanToInteger();
		intToRoman = new IntegerToRoman();
	}
	
	@Test
	public void test() {
		for(int i=0; i<4000; ++i) {
			assertEquals(i, roman.romanToInt(intToRoman.intToRoman(i)));
		}
	}

}
