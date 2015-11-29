package com.rhn.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class WildcardMatchingTest {
	
	private WildcardMatching match = new WildcardMatching();

	@Test
	public void test() {
		assertTrue(match.isMatch("", ""));
		assertTrue(match.isMatch("abc", "abc"));
		assertTrue(match.isMatch("a", "a"));
		assertTrue(match.isMatch("abc", "a?*"));
		assertTrue(match.isMatch("abc", "a?******"));
		assertTrue(match.isMatch("abcac", "a*a?"));
		assertTrue(match.isMatch("ab", "a*****?**"));
		assertTrue(match.isMatch("aaaaaaacvddf", "a*"));
		assertTrue(match.isMatch("aa", "*"));
		assertTrue(match.isMatch("aa", "a*"));
		assertTrue(match.isMatch("ab", "?*"));
		assertTrue(match.isMatch("aa","aa"));
		assertTrue(match.isMatch("","****"));
		assertTrue(match.isMatch("a","a****"));
		assertTrue(match.isMatch("c","**?*"));
		assertTrue(match.isMatch("ba","*a*"));
		assertTrue(match.isMatch("bbaa","*a*?"));
		
		assertFalse(match.isMatch("abcac", "a*a?*?"));
		assertFalse(match.isMatch("ab", "a"));
		assertFalse(match.isMatch("ab", "a"));
		assertFalse(match.isMatch("ab", "a*****?**?"));
		assertFalse(match.isMatch("aa","a"));
		assertFalse(match.isMatch("aaa","aa"));
		assertFalse(match.isMatch("aab", "c*a*b"));
		assertFalse(match.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba","a*******b"));
		assertFalse(match.isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb","**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
	}
}
