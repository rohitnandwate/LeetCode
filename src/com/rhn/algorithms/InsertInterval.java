package com.rhn.algorithms;

import java.util.ArrayList;
import java.util.List;

import com.rhn.algorithms.util.Interval;

/**
 * https://leetcode.com/problems/insert-interval/
 * @author rohitnandwate
 *
 */
public class InsertInterval {	// Definition for an interval.
	
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	List<Interval> ans = new ArrayList<Interval>();
    	if(intervals == null || intervals.size() == 0) {
    		ans.add(newInterval);
    		return ans;
    	}
    	boolean done = false;
    	int i=0;
    	Interval curr = null;
    	int start, end;
    	while (i < intervals.size()) {
    		curr = intervals.get(i);
    		if(curr.start > newInterval.end){
    		    if(!done) {
    		    	ans.add(new Interval(newInterval.start, newInterval.end));
    		    }
    		    ans.add(new Interval(curr.start, curr.end));
    			i++;
    			done = true;
    			continue;
    		} else if(newInterval.start > curr.end) {
    			ans.add(new Interval(curr.start, curr.end));
    			i++;
    			continue;
    		}
    		if(curr.start <= newInterval.start){
    			start = curr.start;
    		} else {
    			start = newInterval.start;
    		}
    		Interval prev = null;
    		while(i < intervals.size() && newInterval.end >= curr.start) {
    			prev = curr;
    			i++;
    			if(i < intervals.size()){
    				curr = intervals.get(i);
    			}
    		}
    		curr = prev;
			if(newInterval.end >= curr.end) {
    			end = newInterval.end;
    		} else if (newInterval.end >= curr.start && newInterval.end < curr.end) {
    			end = curr.end;
    		} else {
    		    end = newInterval.end;
    		    ans.add(new Interval(start, end));
    		    ans.add(new Interval(curr.start, curr.end));
    		    done = true;
    		    continue;
    		}
    		ans.add(new Interval(start, end));
    		done = true;
    	}
    	if(!done){
    	    ans.add(new Interval(newInterval.start, newInterval.end));    
    	}
    	return ans;
    }
}