package com.rhn.algorithms;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
        if(x/10 == 0)
        	return true;
        if(x < 0) {
        	x = -1*x;
        }
        int n = x;
        int mul = 1;
        while(n/10 != 0) {
        	n /= 10;
        	mul *= 10;
        }
        return helper(x, mul);
    }
	private boolean helper(int x, int mul) {
		if(x/10 == 0 && (mul == 1 || mul == 0))
			return true;
		return (x/mul == x%10) ? helper((x-(x/mul) * mul)/10, mul/100) : false;
	}
}
