package com.rhn.algorithms;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PalindromeNumberTest {
	
	private PalindromeNumber p;
	
	@Before
	public void setup() {
		p = new PalindromeNumber();
	}
	
	@Test
	public void test() {
		assertFalse(p.isPalindrome(1000021));
		assertTrue(p.isPalindrome(10022001));
		assertTrue(p.isPalindrome(100001));
	}

}
