package com.rhn.algorithms;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 * @author rohitnandwate
 *
 */
public class StringToInteger {
	public int myAtoi(String str) {
		if(str.isEmpty()) {
			return 0;
		}
        int ans=0;
        int i=0;
        int sign = 1;
        if(str.charAt(0) == '-') {
        	sign = -1;
        	i++;
        } else if(str.charAt(0) == '+') {
        	i++;
        }
        int[] arr = new int[50];
        int j=0;
        for(; i< str.length(); ++i) {
        	if(isANum(str.charAt(i))) {
        		arr[j++] = getInt(str.charAt(i));
        	} else {
        		return 0;
        	}
        }
        try {
        	int div = 1;
        	for(int k=j-1; k >=0; --k) {
        		ans = Math.addExact(ans, div * arr[k]);
        		div = Math.multiplyExact(div, 10);
        	}
        	return sign * ans;
        } catch (ArithmeticException e) {
        	return 0;
        }
    }
	
	private int getInt(char c) {
		return c - 48;
	}

	boolean isANum(char c) {
		int num = (int)c;
		return num >= 48 && num <= 57;
	}
}
