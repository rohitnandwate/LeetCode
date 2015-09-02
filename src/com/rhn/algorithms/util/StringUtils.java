package com.rhn.algorithms.util;

public class StringUtils {
	public static String join(char[] ans) {
		StringBuilder str = new StringBuilder();
		for(char c: ans) {
			str.append(c);
		}
		return str.toString();
	}
}
