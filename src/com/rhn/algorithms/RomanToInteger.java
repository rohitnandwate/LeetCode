package com.rhn.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/
 * @author rohitnandwate
 *
 */
public class RomanToInteger {
	static Map<Character, Integer> map = new HashMap<Character, Integer>();
    public RomanToInteger() {
        map.put('i', 1);
        map.put('v', 5);
        map.put('x', 10);
        map.put('l', 50);
        map.put('c', 100);
        map.put('d', 500);
        map.put('m', 1000);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
    public int romanToInt(String s) {
        if(s.isEmpty())
        	return 0;
        int ans = 0;
        char prev = ' ';
        for(int i=0; i< s.length(); ++i) {
        	if(map.containsKey(s.charAt(i))) {
        		ans += map.get(s.charAt(i));
        		if (prev != ' ' && map.get(prev) < map.get(s.charAt(i))) {
        			ans -= map.get(prev)*2;
        		}
        		prev = s.charAt(i);
        	}
        }
        return ans;
    }
}
