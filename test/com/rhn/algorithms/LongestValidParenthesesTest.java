package com.rhn.algorithms;

import org.junit.Test;

public class LongestValidParenthesesTest {

	private LongestValidParentheses valid = new LongestValidParentheses();
	@Test
	public void test() {
		System.out.println(valid.longestValidParentheses("(((((())()((()()()()((("));
		System.out.println(valid.longestValidParentheses("((((()())())())())))()()()(())()(())((((()))))()(((((((((((((()))))))))))))()()(()()"));
		System.out.println(valid.longestValidParentheses("())"));
		System.out.println(valid.longestValidParentheses("()(())"));
	}
	
	@Test
	public void test1() {
		System.out.println("With int:");
		System.out.println(valid.longestValidParenthesesInt("(((((())()((()()()()((("));
		System.out.println(valid.longestValidParenthesesInt("((((()())())())())))()()()(())()(())((((()))))()(((((((((((((()))))))))))))()()(()()"));
		System.out.println(valid.longestValidParenthesesInt("())"));
		System.out.println(valid.longestValidParenthesesInt("()(())"));
	}

	@Test
	public void test2() {
		System.out.println(valid.longestValidParentheses("(((((())()((()()()()((("));
		System.out.println(valid.longestValidParentheses("((((()())())())())))()()()(())()(())((((()))))()(((((((((((((()))))))))))))()()(()()"));
		System.out.println(valid.longestValidParentheses("())"));
		System.out.println(valid.longestValidParentheses("()(())"));
	}
}
