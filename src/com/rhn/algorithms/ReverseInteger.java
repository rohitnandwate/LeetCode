package com.rhn.algorithms;

/**
 * https://leetcode.com/problems/reverse-integer/
 * @author rohitnandwate
 *
 */
public class ReverseInteger {
	public int reverse(int x) {
		if(x == 0) {
			return 0;
		}
		int[] arr = new int[50];
		int div;
		int i;
		for(i=0, div=1; x != 0; x /= 10, ++i) {
			arr[i] = x % 10;
			if(x/10 != 0) {
				 div *= 10;
			}
			System.out.println("arr["+i+"]:"+arr[i]);
		}
		int revX = 0;
		System.out.println("DIV: "+ div);
		for(int j=0; j < i; ++j, div /= 10) {
			try {
				revX = Math.addExact(revX, Math.multiplyExact(div, arr[j]));
			} catch (ArithmeticException e) {
				return 0;
			}
		}
		return revX;
    }
}
