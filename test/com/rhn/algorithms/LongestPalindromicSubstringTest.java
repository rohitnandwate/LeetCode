package com.rhn.algorithms;

import org.junit.Before;
import org.junit.Test;

public class LongestPalindromicSubstringTest {

	private LongestPalindromicSubstring lps;
	
	@Before
	public void setup() {
		lps = new LongestPalindromicSubstring();
	}
	
	@Test
	public void test() {
		String t = "abb";
		lps.longestPalindrome(t);
	}

}
