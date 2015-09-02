package com.rhn.algorithms;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class ReverseIntegerTest {

	private ReverseInteger rev;
	@Before
	public void setup() {
		rev = new ReverseInteger();
	}
	
	@Test
	public void test() {
		for(int i=0; i < 1; ++i) {
			System.out.println(rev.reverse(1534236469));
		}
	}

}
