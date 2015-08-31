/*
After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/

public class Solution {
    //two cases: rob the first, or not, then combine the org solution
    public int rob(int[] nums) {
        if (nums == null || nums.length==0) return 0;
        //rob first
        int robFirst = rob1(nums);
        int noFirst = rob2(nums);
        return Math.max(robFirst, noFirst);
    }
    
    public int rob1(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return nums[0];
        int[] dp = new int[nums.length-1];
        dp[0] = nums[0];
        dp[1] = nums[0];
        for (int i=2; i<dp.length; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        
        return dp[dp.length-1];
    }
    
    public int rob2(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums.length == 2) return nums[1];
        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = nums[1];
        for (int i=2; i<dp.length; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        
        return dp[dp.length-1];
    }
}