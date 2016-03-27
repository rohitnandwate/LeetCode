package com.rhn.algorithms;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<String>();
        int[] nums = new int[4];
        helper(s, ans, 0, 0, nums);
        return ans;
    }
    
    private void helper(String s, List<String> ans, int pos, int cnt, int[] nums) {
        if(pos == s.length()) {
            if(cnt == nums.length) {
                addToAns(ans, nums);
            }
            return;
        }
        int minDigits = nums.length-cnt;
        int maxDigits = (nums.length-cnt) * 3;
        int avail = s.length()-pos;
        if(avail < minDigits || avail > maxDigits) {
            System.out.println("invalid length: pos="+ pos+" cnt="+cnt+" avail="+avail+" min="+minDigits+" max="+maxDigits);
            return;
        }
        
        nums[cnt] = Integer.valueOf(s.substring(pos, pos+1));
        helper(s, ans, pos+1, cnt+1, nums);
        
        if(pos+1 < s.length() && s.charAt(pos) != '0') {
            nums[cnt] = Integer.valueOf(s.substring(pos, pos+2));
            helper(s, ans, pos+2, cnt+1, nums);
        }
        if(pos+2 < s.length() && s.charAt(pos) != '0') {
            nums[cnt] = Integer.valueOf(s.substring(pos, pos+3));
            if(nums[cnt] <= 255){
                helper(s, ans, pos+3, cnt+1, nums);
            }
        }
    }
    
    private void addToAns(List<String> ans, int[] nums) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<nums.length; ++i) {
            sb.append(nums[i]);
            if(i < nums.length-1) {
                sb.append(".");
            }
        }
        ans.add(sb.toString());
    }
}