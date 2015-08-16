package com.rhn.algorithms;

import java.util.Arrays;

public class LengthOfLongestSubstring {

	public int lengthOfLongestSubstring(String str) {
		int max = 0;
		int start = 0;
		int[] presentAt = new int[256];
		char[] s = str.toCharArray();
		Arrays.fill(presentAt, -1);
		System.out.println("length:"+s.length);
		for(int i=0; i<s.length; ++i) {
			int intVal = (int)s[i];
			System.out.println(intVal+" = " + s[i]);
			if(presentAt[intVal] != -1) {
				start = reset(start, presentAt[intVal], s, presentAt);
			} 
			presentAt[intVal] = i;
			if(i-start+1 > max) {
				max = i-start+1;
			}
		}
		return max;
	}
	
	private int reset(int start, int end, char[] s, int[] presentAt) {
		if(start < end && end < s.length) {
			for(int i=start; i<= end; ++i) {
				int intVal = (int)s[i];
				presentAt[intVal] = -1;
			}
		} 
		return end+1;
	}
	
	public static void main(String args[]) {
		LengthOfLongestSubstring l = new LengthOfLongestSubstring();
//		int max = l.lengthOfLongestSubstring("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ "+
//									  		 "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ "+ 
//									  		 "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ "+
//									  		 "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ "+
//									  		 "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ "+
//									  		 "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ "+
//											 "abcdefghijklmnopqrstuvwxyzABCD");
		
		int max = l.lengthOfLongestSubstring("ejtdfngsdnnkgpkvtigsq");
		System.out.println("max is:"+max);
	}
}
