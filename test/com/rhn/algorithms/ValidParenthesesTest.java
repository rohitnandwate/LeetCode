package com.rhn.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidParenthesesTest {
	
	private ValidParentheses paren = new ValidParentheses();

	@Test
	public void test() {
		assertTrue(paren.isValid("()()()()()()"));

		assertTrue(paren.isValid("()({([{}])})(()(({[]})))()()[]{}"));
		
		assertFalse(paren.isValid("()()()()()("));
		
		assertTrue(paren.isValid(""));
		
		assertFalse(paren.isValid("("));
		assertFalse(paren.isValid(")"));
		
		assertFalse(paren.isValid("{"));
		assertFalse(paren.isValid("}"));

		assertFalse(paren.isValid("["));
		assertFalse(paren.isValid("]"));

		assertFalse(paren.isValid("()({([{}])}(()(({[]})))()()[]{}"));
		assertFalse(paren.isValid("()({([{}])})(()(({[]}))()()[]{}"));
	}

}
