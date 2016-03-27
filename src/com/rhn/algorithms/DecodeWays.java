package com.rhn.algorithms;

public class DecodeWays {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int[] decodeWays = new int[s.length()];
        if(s.charAt(0) == '0'){
            return 0;
        } 
        decodeWays[0] = 1;
        boolean clubbed = false;
        boolean prevZero = false;
        for(int i=1; i < s.length(); ++i) {
            if(s.charAt(i) == '0' && prevZero) {
                return 0;
            } else if(s.charAt(i) == '0') {
                decodeWays[i] = clubbed ? decodeWays[i-1] -1 : decodeWays[i-1];
                prevZero = true;
            } else if(prevZero) {
                decodeWays[i] = decodeWays[i-1];
                clubbed = false;
                prevZero = false;
                continue;
            } else {
                int val = Integer.valueOf(s.substring(i-1, i+1));
                if( val >= 10 && val <= 26) {
                    decodeWays[i] = decodeWays[i-1]+1;
                    clubbed = true;
                } else {
                    decodeWays[i] = decodeWays[i-1];
                    clubbed = false;
                }
            }
        }
        return decodeWays[s.length()-1];
    }
}