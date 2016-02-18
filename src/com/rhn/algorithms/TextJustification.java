package com.rhn.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/text-justification/
 * @author rohitnandwate
 *
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        if(words.length == 0) {
            return new ArrayList<String>();
        }
        List<List<String>> lines = new ArrayList<List<String>>();
        List<Integer> lineCharLen = new ArrayList<Integer>();
        int lineCharCnt = 0;
        int availableChars = maxWidth;
        List<String> line = new ArrayList<String>();
        int k;
        for(k=0; k<words.length; ++k) {
            if(availableChars - words[k].length() < 0) {
                lines.add(line);
                lineCharLen.add(lineCharCnt);
                line = new ArrayList<String>();
                lineCharCnt = 0;
                availableChars = maxWidth;
            }
            availableChars -= (words[k].length()+1);
            line.add(words[k]);
            lineCharCnt += words[k].length();
        }
        // add the last line of words
        lines.add(line);
        lineCharLen.add(lineCharCnt);
    
        List<String> ans = new ArrayList<String>();
        
        for(int i=0; i< lines.size()-1; ++i) {
            List<String> currLine = lines.get(i);
            int totSpaces = maxWidth - lineCharLen.get(i);
            int evenSpaces = currLine.size() == 1 ? totSpaces : (totSpaces > 0 ? totSpaces / (currLine.size()-1) : 0);
            int extraSpaces = (totSpaces > 0 && currLine.size() > 1) ? totSpaces % (currLine.size()-1) : 0;
            
            StringBuilder sbLine = new StringBuilder(maxWidth);
            for(int j=0; j<currLine.size()-1; ++j) {
                sbLine.append(currLine.get(j));
                addSpaces(sbLine, evenSpaces);
                if(extraSpaces > 0) {
                    addSpaces(sbLine, 1);
                    extraSpaces--;
                }
            }
            sbLine.append(currLine.get(currLine.size()-1));
            if(currLine.size() == 1) {
            	addSpaces(sbLine, evenSpaces);
            }
            
            ans.add(sbLine.toString());
        }
        StringBuilder lastLine = new StringBuilder(maxWidth);
        
        for(String word : lines.get(lines.size()-1)) {
            lastLine.append(word);
            if(lastLine.length() < maxWidth) {
                addSpaces(lastLine, 1);
            }
        }
        if(lastLine.length() < maxWidth) {
            addSpaces(lastLine, maxWidth-lastLine.length());
        }
        ans.add(lastLine.toString());
        return ans;
    }
    
    void addSpaces(StringBuilder sb, int cnt) {
        for(int i=0; i< cnt; ++i) {
            sb.append(" ");
        }
    }
}
