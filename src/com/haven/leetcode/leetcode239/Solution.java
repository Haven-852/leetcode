package com.haven.leetcode.leetcode239;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int [] ans=new int[nums.length-k+1];
        for (int i = 0; i < nums.length-k+1; i++) {
            int [] subnums=new int[k];
            for (int j = 0; j < k; j++) {
                subnums[j]=nums[i+j];
            }
            ans[i]=findMaxArray(subnums);
        }
        return ans;
    }
    public int findMaxArray(int [] subnums){
        int max=Integer.MIN_VALUE;
        for (int i = 0; i <subnums.length ; i++) {
            max=Math.max(max,subnums[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int [] nums={1,3,-1,-3,5,3,6,7};
        int k=3;
        Solution solution = new Solution();
        int [] ans=solution.maxSlidingWindow(nums,k);
        for (int i = 0; i <nums.length-k+1 ; i++) {
            System.out.println(ans[i]);
        }
    }
}
