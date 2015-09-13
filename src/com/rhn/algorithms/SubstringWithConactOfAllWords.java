package com.rhn.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 * @author rohitnandwate
 *
 */
public class SubstringWithConactOfAllWords {
    public List<Integer> findSubstringNoRep(String s, String[] words) {
        List<Integer> ans = new ArrayList<Integer>();
        if(s == null) {
        	return ans;
        }
        Set<String> available = new HashSet<String>();
        Set<String> used = new HashSet<String>();
        available = Arrays.stream(words).collect(Collectors.toSet());
        int wordSize = 0;
        if(words.length > 0) {
        	wordSize = words[0].length();
        }
        int i=0;
        while(i < s.length()) {
        	available.addAll(used);
        	used.clear();
        	int j=i;
        	while(!available.isEmpty() && j < s.length() - wordSize){
        		String t = s.substring(j, j+wordSize);
        		if(available.contains(t)) {
        			used.add(t);
        			j += wordSize;
        			available.remove(t);
        		} else {
        			break;
        		}
        	}
        	if(available.isEmpty()) {
        		ans.add(i);
        	}
        	i++;
        }
        return ans;
    }
    
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> res = new ArrayList<>();
        if (L.length == 0) {
            return res;
        }
        int len = L[0].length();
        int num = L.length;
        if (len * num > S.length()) {
            return res;
        }

        //histogram of words in L
        HashMap<String, Integer> dic = new HashMap<>();
        for (String s : L) {
            if (dic.containsKey(s)) {
                dic.put(s, dic.get(s) + 1);
            } else {
                dic.put(s, 1);
            }
        }

        //the word that starts from i in S
        String[] sDic = new String[S.length() - len + 1];
        for (int i = 0; i < sDic.length; i++) {
            String sub = S.substring(i, i + len);
            if (dic.containsKey(sub)) {
                sDic[i] = sub;
            } else {
                sDic[i] = "";
            }
        }

        //traverse in order of 0,0+len,...,1,1+len,...len-1,len-1+len...therefore it is O(n) despite of two loops
        for (int i = 0; i < len; i++) {

            //start of concatenation
            int start = i;
            //number of words found
            int found = 0;
            //dynamic word histogram of words in substring(start,j);
            HashMap<String, Integer> tempDic = new HashMap<>();
            for (int j = i; j <= S.length() - len; j = j + len) {
                String word = sDic[j];
                if (word.equals("")) {
                    tempDic = new HashMap<>();
                    start = j + len;
                    found = 0;
                    continue;
                } else {
                    if (!tempDic.containsKey(word)) {
                        tempDic.put(word, 1);
                    } else {
                        tempDic.put(word, tempDic.get(word) + 1);
                    }
                    found++;
                }
                //if we over-count a word, delete the first word in front. Also delete the words before that.
                if (tempDic.get(word) > dic.get(word)) {
                    while (!sDic[start].equals(word)) {
                        tempDic.put(sDic[start], tempDic.get(sDic[start]) - 1);
                        start += len;
                        found--;
                    }
                    tempDic.put(word, tempDic.get(word) - 1);
                    start += len;
                    found--;
                }
                if (found == num) {
                    res.add(start);
                }

            }

        }
        return res;
    }
    
    
    public List<Integer> findSubstringSlow(String s, String[] words) {
        List<Integer> ans = new ArrayList<Integer>();
        if(s == null) {
        	return ans;
        }
        Map<String, Integer> available = new HashMap<String, Integer>();
        Map<String, Integer> used = new HashMap<String, Integer>();
        int wordSize = 0;
        if(words.length > 0) {
        	wordSize = words[0].length();
        }
        for(String word: words) {
        	available.compute(word, (k,v) -> v == null ? 1 : v+1);
        }
        String[] subStringPresent = new String[s.length()-wordSize+1];
        for(int i=0; i<subStringPresent.length; ++i) {
        	String sub = s.substring(i, i+wordSize);
        	subStringPresent[i] = available.containsKey(sub) ? sub : null;
        }
        
        for(int i=0;i < wordSize; ++i) {
        	int cnt = 0;
        	int start = i;
        	used.clear();
        	for(int j = i;j <= s.length() - wordSize; j += wordSize){
        		String word = subStringPresent[j];
        		System.out.println("checking:"+word+" at j="+j+" and start = "+start);
        		if(word != null) {
        			used.compute(word, (k,v) -> v == null ? 1 : v+1);
        			cnt++;
        		} else {
        			cnt = 0;
        			used.clear();
        			start = j + wordSize;
        			continue;
        		}
        		while(used.get(word) > available.get(word)) {
        			String temp = subStringPresent[start];
        			System.out.println("deleting:"+temp+ " at start = "+start);
        			used.compute(temp, (k,v) -> v-1);
        			start += wordSize;
        			cnt--;
        		}
        		
        		if(cnt == words.length) {
            		ans.add(start);
            	}
        	}
        }
        return ans;
    }

}
