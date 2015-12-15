package com.rhn.algorithms;

/**
 * https://leetcode.com/problems/jump-game/
 * @author rohitnandwate
 *
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        if(nums.length <= 1)
            return true;
        boolean[] cr = new boolean[nums.length];
       // Arrays.fill(cr, false);
        for(int i=nums.length-2; i>=0; --i) {
            if(i+nums[i] >= nums.length-1){
                cr[i] = true;
                continue;
            }
            int k=1; 
            while(k <= nums[i]) {
                if(cr[i+k]) {
                    cr[i] = true;
                    break;
                } else if(nums[i+k] >= nums[i]-k) {
                    break;
                }
                ++k;
            }
        }
        return cr[0];
    }
}