package com.rhn.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/multiply-strings/
 * @author rohitnandwate
 *
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
    	
    	List<int[]> multiplyResults = new ArrayList<int[]>();
    	int[] num1Arr = new int[num1.length()];
    	for(int i=0; i< num1.length(); ++i) {
    		num1Arr[i] = num1.charAt(i) - '0';
    	}
    	int z=0; int max=0;
    	for(int i=num2.length()-1; i>=0; --i) {
    		int[] result = multipleSingle(num1Arr, num2.charAt(i)-'0', z);
    		if(result.length > max) {
    			max = result.length;
    		}
    		multiplyResults.add(result);
    		z++;
    	}
    	return addMultipleResults(multiplyResults, max);
    }
    
    String addMultipleResults(List<int[]> multiplyResults, int maxDigits) {
    	long carry = 0;
    	int[] ans = new int[maxDigits];
    	for(int i=0; i< ans.length; ++i) {
    		long sum = carry;
    		for(int[] result : multiplyResults) {
    			if(i >= result.length) {
    				continue;
    			}
    			sum += result[i];
    		}
    		ans[i] = (int)(sum % 10);
    		carry = sum/10;
    	}
    	
    	StringBuilder sb = new StringBuilder(ans.length);
    	if(carry> 0) {
    		sb.append(carry);
    	}
    	int start =0;
    	for(int i=ans.length-1; i>=0; --i) {
    		if(ans[i] > 0) {
    			start = i;
    			break;
    		}
    	}
    	for(int i=start; i>=0; --i) {
    		if(i == ans.length-1 && ans[i] == 0){
    			continue;
    		}
    		sb.append(ans[i]);
    	}
    	return sb.toString();
    }
    
    /**
     * @param num array representing the number to be multiplied
     * @param m multiplier
     * @param z number of zeroes to append to the number
     * @return result of multiplication
     */
    private int[] multipleSingle(int[] num, int m, int z) {
    	int ans[] = new int[num.length+z+1];
    	Arrays.fill(ans, 0, z, 0);
    	int carry = 0;
    	int i=0;
    	int j=0;
    	for(i=z,j=num.length-1; j>=0; ++i, --j) {
    		int t = (carry + (num[j] * m)); 
    		ans[i] = t % 10;
    		carry = t/10;
    	}
    	ans[i] = carry;
    	return ans;
    }
}
