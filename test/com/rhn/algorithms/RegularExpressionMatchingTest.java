package com.rhn.algorithms;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RegularExpressionMatchingTest {
	
	private RegularExpressionMatching regEx;
	
	@Before
	public void setup() {
		regEx = new RegularExpressionMatching();
	}
	
	@Test
	public void test() {
		String pattern = ".*ab*";
		assertTrue(regEx.isMatch("a", pattern));
		assertTrue(regEx.isMatch("ab", pattern));
		assertTrue(regEx.isMatch("aab", pattern));
		assertTrue(regEx.isMatch("bab", pattern));
		assertTrue(regEx.isMatch("abacda", pattern));
		assertTrue(regEx.isMatch("322sdfs$^%faaada", pattern));
		assertTrue(regEx.isMatch("322sdfs$^%faaadabbbbb", pattern));
		
		assertFalse(regEx.isMatch("b", pattern));
		assertFalse(regEx.isMatch("123dsb", pattern));
	}

	
	@Test
	public void test_1() {
//		assertFalse(regEx.isMatch("aaaab", "a*c"));
		assertFalse(regEx.isMatch("aaba", "ab*a*c*a"));
	}
}
