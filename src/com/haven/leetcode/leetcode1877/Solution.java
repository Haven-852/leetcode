package com.haven.leetcode.leetcode1877;

import java.util.Arrays;

public class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int ans=0;
        for (int i = 0; i < n/2; i++) {
            ans=Math.max(ans,nums[i]+nums[n-i-1]);
        }
        return ans;
    }
}
