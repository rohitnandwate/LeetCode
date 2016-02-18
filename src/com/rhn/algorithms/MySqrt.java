package com.rhn.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/sqrtx/
 * @author rohitnandwate
 *
 */
public class MySqrt {
    public int mySqrt(int x) {
        if(x < 2) {
            return x;
        }
        return helper(0, x, x);
    }
    
    int helper(int start, int end, int x) {
        int mid = start + ((end-start)/2);
        int midSq = 0;
        int midSq_1 = 0;
        try {
            midSq = Math.multiplyExact(mid, mid);
        } catch(ArithmeticException e) {
            return helper(start, mid, x);
        }
        try {
            midSq_1 = Math.multiplyExact(mid+1, mid+1);
        } catch(ArithmeticException e) {
            return midSq <= x ? mid : helper(start, mid, x);
        }
        
        if(midSq == x || (midSq < x && midSq_1 > x)) {
            return mid;
        } else if(midSq < x) {
            return helper(mid, end, x);
        } else {
            return helper(start, mid, x);
        }
    }
}