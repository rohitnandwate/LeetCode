package com.rhn.algorithms;

public class PowerOf {

	 public double pow(double x, int n) {
	        if (n < 0) {
	            n = -n;
	            x = 1 / x;
	        }
	        double result = 1;
	        for (double f = x; n > 0; n = n >> 1) {
	        	System.out.println("Result="+result+" F="+f+" N="+n);
	            if (n % 2 == 1) {
	                result *= f;
	            }
	            f = f * f;
	        }
	        return result;
    }
}