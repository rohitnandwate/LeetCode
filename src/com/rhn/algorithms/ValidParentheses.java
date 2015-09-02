package com.rhn.algorithms;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * @author rohitnandwate
 *
 */
public class ValidParentheses {
	
	private boolean isOpen(char c) {
		return c == '(' || c =='{' || c == '[';
	}
	
	private boolean isMatch(Character open, Character close) {
		if(open == null || close == null) {
			return false;
		}
		switch(open) {
		case '(':
			return close == ')';
		case '{':
			return close == '}';
		case '[':
			return close == ']';
		}
		return false;
	}
	public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); ++i) {
        	if(isOpen(s.charAt(i))) {
        		stack.push(s.charAt(i));
        	} else if(stack.isEmpty() || !isMatch(stack.pop(), s.charAt(i))){
        		return false;
        	}
        }
        return stack.isEmpty();
    }
	
}
