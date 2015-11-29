package com.rhn.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultiplyStringsTest {

	private MultiplyStrings mul = new MultiplyStrings();
	
	@Test
	public void test() {
		assertEquals("24", mul.multiply("12", "2"));
		
		assertEquals("2853008", mul.multiply("1234", "2312"));
		
		assertEquals("9999999999999899999999900000000000001", mul.multiply("99999999999999", "99999999999999999999999"));
	}

}
