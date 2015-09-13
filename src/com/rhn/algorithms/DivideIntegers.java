package com.rhn.algorithms;

/**
 * https://leetcode.com/problems/divide-two-integers/
 * @author rohitnandwate
 *
 */
public class DivideIntegers {
    public int divideSlow(int dividend, int divisor) {
        if(divisor == 0)
        	return Integer.MAX_VALUE;
        if(divisor == 1)
        	return dividend;
        int sign = 0;
        if((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)){
        	sign = 1;
        } else {
        	sign = -1;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int ans = 0;
        while(dividend >= divisor) {
        	dividend -= divisor;
        	ans++;
        }
        return ans * sign;
    }
    
    public int divide(int dividend, int divisor) {
    	if(divisor == 0)
    		return Integer.MAX_VALUE;
    	if(dividend == Integer.MIN_VALUE)
    		return Integer.MAX_VALUE;
    	int pDividend = Math.abs(dividend);
    	int pDivisor = Math.abs(divisor);
    	int result = 0;
    	
    	while(pDividend >= pDivisor) {
    		int numOfShifts = 0;
    		while((pDivisor<<numOfShifts) >= 0 && pDividend >= (pDivisor<<numOfShifts) ) {
    			numOfShifts++;
    		}
    		result += 1<<(numOfShifts-1);
    		pDividend -= (pDivisor<<(numOfShifts-1));
    	}
    	
    	if((dividend < 0 && divisor < 0) 
    			|| (dividend > 0 && divisor > 0)) {
    		return result;
    	} else {
    		return -result;
    	}
    }
}
