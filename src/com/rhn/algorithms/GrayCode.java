package com.rhn.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GrayCode {
	public List<Integer> grayCode(int n) {
	    List<Integer> result = new ArrayList<Integer>();
	    result.add(0);

	    for(int i=0; i<n; i++){
	        int size = result.size()-1;
	        for(int j=size; j>=0; j--){
	        	int val = result.get(j) | 1<<i;
	        	System.out.println(Integer.toBinaryString(result.get(j)) + " OR with " + Integer.toBinaryString(1 << i));
	        	System.out.println("adding "+ Integer.toBinaryString(val));
	            result.add(val);
	        }
	    }
	    return result;
	}
	
	
    public List<Integer> grayCode1(int n) {
        Set<Integer> ansSet = new HashSet<Integer>();
        List<Integer> ans = new ArrayList<Integer>();
        ansSet.add(0);
        ans.add(0);
        if(n == 0) {
        	return ans;
        }
        char[] arr = new char[n];
        Arrays.fill(arr, '0');
        int num = (int) Math.pow(2, n);
        while(ansSet.size() < num) {
            for(int i=n-1; i>=0; --i) {
                if(arr[i] == '0') {
                    if(addToSet(ans, ansSet, arr, i, '0', '1')){
                    	break;
                    }
                } else {
                    if(addToSet(ans, ansSet, arr, i, '1', '0')) {
                    	break;
                    }
                }
            }
        }
        return ans;
    }
    
    private int getInt(char[] arr) {
        return Integer.valueOf(String.valueOf(arr), 2);
    }
    
    private boolean addToSet(List<Integer> ans, Set<Integer> ansSet, char[] arr, int i, char o, char n) {
        arr[i] = n;
        int val = getInt(arr);
        if(!ansSet.contains(val)) {
            ansSet.add(val);
            ans.add(val);
            return true;
        } else {
            arr[i] = o;
            return false;
        }
    }
}