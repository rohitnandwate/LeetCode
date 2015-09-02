package com.rhn.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 * https://leetcode.com/problems/3sum-closest/
 * @author rohitnandwate
 *
 */
public class ThreeSum {
	
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int closest = 0;
		if(nums.length >= 3) {
			closest = nums[nums.length-1] + nums[nums.length-2] + nums[nums.length-3];
		}
		int sum = 0;
		for(int i=0;i<nums.length-2; ++i) {
			for(int j=i+1; j<nums.length-1; ++j) {
				for(int k=j+1; k<nums.length; ++k) {
					sum = nums[i] + nums[j] + nums[k];
					System.out.println("i="+ i+", j="+j+", k="+k);
					if(isCloser(target, closest, sum)){
						closest = sum;
					} 
					if(target == closest){
						return closest;
					}
				}
			}
		}
		return closest;
    }
	
	boolean isCloser(int target, int closest, int sum) {
		System.out.println("target:"+ target+", closest="+closest+", sum="+sum);
		try {
			return Math.abs(Math.subtractExact(target, sum)) < Math.abs(Math.subtractExact(target, closest));
		} catch(ArithmeticException e) {
			return true;
		}
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int i=0;
        int j=0;
        int k=0;
        Arrays.sort(nums);
        boolean added_i = false;
        boolean added_j = false;
        while(i < nums.length -2) {
        	if(nums[i] > 0){
        		return ans;
        	}
        	if(added_i && nums[i-1] == nums[i]) {
        		i++;
        		continue;
        	}
        	added_i = added_j = false;
        	j = i+1;
        	while(j < nums.length-1) {
        		if(added_j && nums[j-1] == nums[j]) {
            		j++;
            		continue;
            	}
            	added_j = false;
        		k = j+1;
        		while(k < nums.length) {
        			int sum = nums[i] + nums[j] + nums[k];
        			if(sum == 0){
        				added_i = added_j = true;
        				addAns(nums[i], nums[j], nums[k], ans);
        				break;
        			}
        			k++;
        		}
        		j++;
        	}
        	i++;
        }
        return ans;
    }

	private void addAns(int i, int j, int k, List<List<Integer>> ans) {
		List<Integer> l = new ArrayList<Integer>();
		l.add(i);
		l.add(j);
		l.add(k);
		ans.add(l);
	}
}
