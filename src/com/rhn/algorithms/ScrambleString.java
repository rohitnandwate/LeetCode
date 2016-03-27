package com.rhn.algorithms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ScrambleString {

	boolean isScramble(String s1, String s2) {
		if(s1 == null && s2 == null) {
			return true;
		}
		if(s1 == null || s2 == null) {
			return false;
		}
		if(s1.equals(s2)) {
			return true;
		}
		Map<Character, Integer> check = new HashMap<Character, Integer>();
		for(int i=0; i< s1.length(); i++) {
			check.merge(s1.charAt(i), 1, (old, one) -> old+one);
			check.merge(s2.charAt(i), -1, (old, one) -> old+one);
		}
		List<Integer> l = check.values().stream().filter(x -> x != 0).collect(Collectors.toList());
		if(!l.isEmpty()){
			return false;
		}
		int len = s1.length();
		for(int i=1; i<len; i++){
			if(isScramble(s1.substring(0, i), s2.substring(0,i)) 
					&& isScramble(s1.substring(i, len), s2.substring(i, len))) {
				return true;
			} else if(isScramble(s1.substring(0, i), s2.substring(len-i, len)) &&
					isScramble(s1.substring(i, len), s2.substring(0, len-i))) {
				return true;
			}
		}
		return false;
	}
}
