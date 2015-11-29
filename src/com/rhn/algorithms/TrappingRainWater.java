package com.rhn.algorithms;

import java.util.List;
import java.util.Stack;

import com.rhn.algorithms.util.Pair;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 * @author rohitnandwate
 *
 */
public class TrappingRainWater {
	List<Pair<Integer, Integer>> getBuckets(int[] h) {
		Stack<Pair<Integer, Integer>> buckets =  new Stack<Pair<Integer, Integer>>();
		boolean needsEnd = false;
		int start = -1;
		
		for(int i=1; i< h.length; ++i) {
			int prev = h[i-1];
			int curr = h[i];
			
			if(start == -1 && prev <= curr) {
				 System.out.println("first time rising at i:"+i);
				start = i;
			} else if (start == -1 && prev > curr) {
				 System.out.println("first direct decline at i="+i);
				start = i-1;
			} else if(prev <= curr && !needsEnd) {
				 System.out.println("started rising after going down at i="+i);
				needsEnd = true;
			} else if (prev > curr && needsEnd) {
				 System.out.println("reached top and needsEnd at i="+i);
				addBucket(buckets, start, i-1, h);
				start = i-1;
				needsEnd = false;
			}
 		}
		addBucket(buckets, start, h.length-1, h);
		return buckets;
	}
	
	private void addBucket(Stack<Pair<Integer, Integer>> buckets, int start, int end, int[] h) {
		if(start >= end || start < 0 || end >= h.length){
			return;
		}
		System.out.println("Adding bucket :"+start+", "+end);
		while (!buckets.isEmpty()) {
			Pair<Integer, Integer> top = buckets.peek();
			if(h[top.first] >= h[start] && h[top.second] <= h[end]) {
				top = buckets.pop();
				System.out.println("MERGING "+top+ " with "+start+", "+end);
				start = top.first;
			} else  {
					buckets.push(new Pair<Integer, Integer>(start, end));
				return;
			}
		}
		if(buckets.isEmpty()) {
			buckets.push(new Pair<Integer, Integer>(start, end));
		}
	}

	public int trap(int[] height) {
        List<Pair<Integer, Integer>> buckets = getBuckets(height);
        int capacity = 0;
        System.out.println("Buckets are: "+buckets);
        for(Pair<Integer, Integer> b : buckets) {
        	int ht = Integer.min(height[b.first], height[b.second]);
        	System.out.println(b + " height:"+ht);
        	for(int i=b.first+1; i<b.second; ++i) {
        		if(ht - height[i] > 0) {
        			System.out.println("Adding capacity of "+ (ht - height[i]));
        			capacity += ht - height[i];
        		}
        	}
        }
        return capacity;
    }
}
