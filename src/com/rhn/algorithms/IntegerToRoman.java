package com.rhn.algorithms;

/**
 * https://leetcode.com/problems/integer-to-roman/
 * @author rohitnandwate
 *
 */
public class IntegerToRoman {

	private static final int[] arr = {1,5,10,50,100,500,1000};
	private static final String[] map = {"I", "V", "X", "L", "C", "D", "M"};
	
	public String intToRoman(int num) {
		return helper(num, arr.length-1);
	}
    
	public String helper(int num, int i) {
		if(num == 0 || i < 0)
        	return "";
        int j = -1;
        while(i >= 0) {
        	if(num >= arr[i]) {
        		break;
        	} 
        	if(i % 2 == 0 && i-2>=0 && num >= arr[i] - arr[i-2]) {
        		j = i-2;
        		break;
        	}
        	if(i % 2 != 0 && i-1 >= 0 && num >= arr[i] - arr[i-1]) {
        		j = i-1;
        		break;
        	}
        	--i;
        }
        if(j != -1) {
        	num = num - (arr[i] - arr[j]);
        	return map[j] + map[i] + helper(num, i);
        }
        num = num - arr[i];
        return map[i] + helper(num, i);
    }
}
