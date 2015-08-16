package com.rhn.algorithms;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	public static void main(String args[]) {
		TwoSum solution = new TwoSum();
		int[] numbers = new int[]{12, 7, 3, 11, 5, -2};
		int ans[] = solution.twoSum(numbers, 9);
		if(ans != null && ans.length == 2)
			System.out.println(ans[0] +", "+ ans[1]);
		
	}

	public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> numToIndex = mapNumToIndex(numbers);
        int index1 = 0;
        for(int num : numbers) {
            index1++;
            int num2 = target - num;
            if(numToIndex.containsKey(num2)) {
                int index2 =  numToIndex.get(num2);
                if(index2 == index1)
                    continue;
                int[] ans = new int[] {index1, index2};
                return ans;
            }
        }
        return null;
   }
   
   public Map<Integer, Integer> mapNumToIndex(int[] numbers) {
       int i=1;
       Map<Integer, Integer> numToIndex = new HashMap<Integer, Integer>();
       for(int num : numbers) {
           numToIndex.put(num, i++);
       }
       return numToIndex;
   }
}