package com.rhn.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/wildcard-matching/
 * @author rohitnandwate
 *
 */
public class WildcardMatching {
	
	private Map<String, Boolean> map = new HashMap<String, Boolean>();
	private int[] remainP;
	
    public boolean isMatch(String s, String p) {
    	map.clear();
    	p = p.replaceAll("\\*+", "*");
    	remainP = new int[p.length()];
    	int cnt = 0;
    	for(int i=p.length()-1; i>=0; --i) {
    		remainP[i] = cnt;
    		if(p.charAt(i) != '*') {
    			cnt++;
    		}
    	}
        return isMatchGreedy(s, p, 0, 0);
    }

	private boolean isMatchGreedy(String s, String p, int i, int j) {
		int a = i;
		int b = j;
		
		if(map.containsKey(a+","+b) && map.get(a+","+b) != null){
			return map.get(a+","+b);
		} else {
			map.put(a+","+b, null);
		}
		if(i < 0 || j < 0) {
			return false;
		}
		if(i == s.length() && j == p.length()-1 && p.charAt(j) == '*'){
			map.put(a+","+b, true);
			return true;
		}
		if(i == s.length() && j == p.length()) {
			map.put(a+","+b, true);
			return true;
		}else if(i == s.length() || j ==p.length()) {
			map.put(a+","+b, false);
			return false;
		}
		while(i < s.length() && j < p.length()) {
			if(s.charAt(i) == p.charAt(j) || p.charAt(j) =='?') {
				i++;
				j++;
			} else if(p.charAt(j) == '*') {
				int curr = i;
				i = s.length()-remainP[j] < curr ? curr : s.length()-remainP[j];
				while( i >= curr){
					if(isMatchGreedy(s, p, i, j+1)){
						map.put(a+","+b, true);
						return true;
					} else {
						i--;
					}
				}
				map.put(a+","+b, false);
				return false;
			} else {
				map.put(a+","+b, false);
				return false;
			}
		}
		if(i == s.length() && j == p.length()-1 && p.charAt(j) == '*'){
			map.put(a+","+b, true);
			return true;
		}
		if(i == s.length() && j == p.length()) {
			map.put(a+","+b, true);
			return true;
		} else {
			map.put(a+","+b, false);
			return false;
		}
	}

    
//	private boolean isMatchBruteForce(String s, String p, int i, int j) {
//		if(i == s.length() && j == p.length()) {
//			return true;
//		}else if(i == s.length() || j ==p.length()) {
//			return false;
//		}
//		while(i < s.length() && j < p.length()) {
//			if(s.charAt(i) == p.charAt(j) || p.charAt(j) =='?') {
//				i++;
//				j++;
//			} else if(p.charAt(j) == '*') {
//				if(isMatch(s, p, i, j+1)) {
//					return true;
//				} else {
//					i++;
//				}
//			} else {
//				return false;
//			}
//		}
//		if(j < p.length() && p.charAt(j) == '*') {
//			return isMatch(s, p, i, j+1);
//		}
//		return i == s.length() && j == p.length();
//	}
	
}
