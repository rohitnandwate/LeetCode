package com.rhn.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	List<List<String>> groupAnagrams(String[] strs) {
		Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		List<List<String>> ans = new ArrayList<List<String>>();
		for(String s : strs){
			char[] carr = s.toCharArray();
			Arrays.sort(carr);
			Integer hash = new String(carr).hashCode(); 
			if(!map.containsKey(hash)) {
				map.put(hash, new ArrayList<String>());
			}
			map.get(hash).add(s);
		}
		
		for(List<String> groups : map.values()) {
			Collections.sort(groups);
			ans.add(groups);
		}
		return ans;
	}
}
