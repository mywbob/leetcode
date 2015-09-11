/*
After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/

public class Solution {
    //two cases: rob the first, or not, then combine the org solution
    public int rob(int[] nums) {
        if (nums.length==0) return 0;
        if (nums.length==1) return nums[0]; 
        //rob first
        int case1 = robIt(Arrays.copyOfRange(nums, 0, nums.length-1));
        //do not rob first
        int case2 = robIt(Arrays.copyOfRange(nums, 1, nums.length));
        
        return Math.max(case1, case2);
    }
    
    public int robIt(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i= 2; i<dp.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        return dp[dp.length-1];
    }
}