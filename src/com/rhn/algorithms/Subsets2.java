package com.rhn.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ansSets = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int[] selected = new int[nums.length];
        for(int k=0; k<=nums.length; ++k) {
            helper(nums, ansSets, selected, 0, k, 0);
        }
//        return new ArrayList<List<Integer>>(ansSets);
        return ansSets; 
    }
    
    private void helper(int[] nums, List<List<Integer>> ansSets, int[] selected, int cnt, int k, int start) {
        if(cnt  == k) {
            addToAns(ansSets, selected, k);
            return;
        }
        for(int i=start; i<nums.length; ++i) {
        	if(i != start && nums[i] == nums[i-1]) {
                continue;
            }
            selected[cnt] = nums[i];
            helper(nums, ansSets, selected, cnt+1, k, i+1);
            if(k-cnt > nums.length-i-1) {
                //helper(nums, ansSets, selected, cnt, i+1, k);
                break;
            }
        }
    }
    
    private void addToAns(List<List<Integer>> ansSets, int[] selected, int k) {
        List<Integer> subset = new ArrayList<Integer>();
        for(int i=0; i< k; ++i) {
            subset.add(selected[i]);
        }
        ansSets.add(subset);
    }
}