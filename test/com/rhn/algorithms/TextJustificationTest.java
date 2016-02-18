package com.rhn.algorithms;

import org.junit.Test;

public class TextJustificationTest {

	private TextJustification justify = new TextJustification();
	@Test
	public void test() {
		String[] words = {"a","b","c","d","e"};
		System.out.println(justify.fullJustify(words, 1));
	}
	
	@Test
	public void test_1() {
		String[] words = {"rohit", "a", "rohit"};
		System.out.println(justify.fullJustify(words, 5));
	}
	
	@Test
	public void test_2() {
		String[] words = {"rohit", "a", "rohit"};
		System.out.println(justify.fullJustify(words, 6));
	}

	@Test
	public void test_3() {
		String[] words = {"rohit", "a", "rohit"};
		System.out.println(justify.fullJustify(words, 7));
	}
}
