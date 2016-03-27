package com.rhn.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScrambleStringTest {

	private ScrambleString s = new ScrambleString();
	
	@Test
	public void test() {
		assertTrue(s.isScramble("rohit", "tihor"));
		assertFalse(s.isScramble("rohit", "rhit1"));
		assertFalse(s.isScramble("rfhit", "rhitf"));
	}
	
	@Test
	public void test1() {
		char[] c = {'0', '0', '0', '0','1', '1', '0'};
		System.out.println(Integer.valueOf(String.valueOf(c), 2));
	}

}
