package com.rhn.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.rhn.algorithms.util.Interval;

public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
    	if(intervals == null || intervals.size() <= 1)
    		return intervals;
    	Comparator<Interval> intervalComparator =  new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				return a.start < b.start 
						? -1 
						: (a.start==b.start ? 0 : 1);
			}
    		
		};
 
        List<Interval> ans = new ArrayList<Interval>();
        Collections.sort(intervals, intervalComparator);
        int i = 0;
        for(Interval in : intervals) {
        	if(ans.isEmpty()) {
        		ans.add(new Interval(in.start, in.end));
        		continue;
        	}
        	Interval curr = ans.get(i);
        	if(curr.end >= in.start) {
        		if(curr.end < in.end) {
        			curr.end = in.end;
        		}
        	} else {
        		ans.add(new Interval(in.start, in.end));
        		i++;
        	}
        }
        return ans;
    }
	
}
