package com.rhn.algorithms;

public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        boolean[] present = new boolean[512];
        int[] charCnt = new int[512];
        int cnt = t.length();
        if(cnt == 0 || cnt > s.length()) {
            return "";
        }
        
        char[] sarr = s.toCharArray();
        for(char c :  t.toCharArray()) {
            present[c] = true;
            charCnt[c]++;
        }
        String min = null;
        int start = -1;
        int end = -1;
        for(int i=0; i<sarr.length; ++i) {
            if(present[sarr[i]]) {
                if(start == -1) {
                    start = i;
                }
                end = i;
                charCnt[sarr[i]]--;
                if(charCnt[sarr[i]] >= 0) {
                    cnt--;
                }
            }
            if(cnt == 0) {
                if(min == null || end-start+1 < min.length()) {
                    min = s.substring(start, end+1);
                }
                do {
                    if(charCnt[sarr[start]] == 0) {
                        cnt++;    
                    }
                    charCnt[sarr[start]]++;
                    start++;
                    while(start < end && !present[sarr[start]]) {
                        start++;
                    }
                } while(start < end && charCnt[sarr[start]] < 0);
                if(cnt == 0 && start <= end && (min == null || end-start+1 < min.length())) {
                    min = s.substring(start, end+1);
                }
            }
        }
        return min == null ? "" : min;
    }
}

