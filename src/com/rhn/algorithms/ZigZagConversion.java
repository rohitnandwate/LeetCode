package com.rhn.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 * @author rohitnandwate
 *
 */
public class ZigZagConversion {
	 
	public String convert(String s, int numRows) {
		if(numRows <= 1) {
			return s;
		}
		List<StringBuilder> rows = new ArrayList<StringBuilder>(numRows);
		for(int i=0; i<numRows; ++i) {
			rows.add(new StringBuilder());
		}
		int count = 0;
		boolean direction = false;
		for(int i=0; i<s.length(); ++i) {
			rows.get(count).append(s.charAt(i));
			if(count == 0 || count == numRows-1) {
				direction = !direction; 
			}
			if(direction) {
				count++;
			} else {
				count--;
			}
		}
		StringBuilder finalAns = new StringBuilder(s.length());
		for(StringBuilder row : rows) {
			finalAns.append(row);
		}
		return finalAns.toString();
	}
}
