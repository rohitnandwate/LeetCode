package com.rhn.algorithms;

import java.util.Stack;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 * @author rohitnandwate
 *
 */
public class LongestValidParentheses {
	private static String open = "(";
    private static String close = ")";
    public int longestValidParentheses(String s) {
        Stack<String> st = new Stack<String>();
        char[] arr = s.toCharArray();
        
        for(int i=0; i<arr.length; ++i) {
        	if(arr[i] == '('){
        		st.push(open);
        	} else if(st.isEmpty()) {
        		st.push(close);
        	} else {
        		String top = st.pop();
        		if(!isABrace(top) && !st.isEmpty() && open.equals(st.peek())) {
        			st.pop();
        			int num = Integer.parseInt(top);
        			num += 2;
        			st.push(String.valueOf(num));
        		} else if(open.equals(top)) {
        			st.push("2");
        		} else {
        			st.push(top);
        			st.push(close);
        		}
        	}
        	int num = 0;
        	while( !st.isEmpty() && !isABrace(st.peek())) {
        		num += Integer.parseInt(st.pop());
        	}
        	if(num != 0) {
        		st.push(String.valueOf(num));
        	}        	
        }
        int max = 0;
        for(String sTop : st) {
        	if(!isABrace(sTop)) {
        		int num = 	Integer.parseInt(sTop);
        		max = num > max ? num : max;
        	}
        }
        return max;
    }
	private boolean isABrace(String top) {
		return open.equals(top) || close.equals(top);
	}
	
	
    public int longestValidParenthesesInt(String s) {
        Stack<Integer> st = new Stack<Integer>();
        char[] arr = s.toCharArray();
        Integer op = -1;
        Integer cl = -2;
        for(int i=0; i<arr.length; ++i) {
        	if(arr[i] == '('){
        		st.push(op);
        	} else if(st.isEmpty()) {
        		st.push(cl);
        	} else {
        		int top = st.pop();
        		if(top > 0 && !st.isEmpty() && op.equals(st.peek())) {
        			st.pop();
        			st.push(top+2);
        		} else if(op.equals(top)) {
        			st.push(2);
        		} else {
        			st.push(top);
        			st.push(cl);
        		}
        	}
        	int num = 0;
        	while( !st.isEmpty() && st.peek() > 0) {
        		num += st.pop();
        	}
        	if(num != 0) {
        		st.push(num);
        	}        	
        }
        int max = 0;
        for(Integer sTop : st) {
        	if(sTop > 0) {
        		int num = sTop;
        		max = num > max ? num : max;
        	}
        }
        return max;
    }
	
}
