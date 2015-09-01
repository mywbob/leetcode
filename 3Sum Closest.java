/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length==0) return 0;
        Arrays.sort(nums);
        int sum=0;
        int res=0;
        int minDiff = Integer.MAX_VALUE;
        for (int i=0; i< nums.length-2; i++) {
            int s = i+1;
            int e=nums.length-1;
            while (s<e) {
                int diff = Math.abs(nums[i] + nums[s] + nums[e] - target);
                if (diff < minDiff) {
                    minDiff = diff;
                    res = nums[i] + nums[s] + nums[e];
                }
                    
                if (nums[i] + nums[s] + nums[e] == target) return target;
                else if (nums[i] + nums[s] + nums[e] < target) {
                    s++;
                } else {
                    e--;
                }
                
            }
        }
        
        return res;
    }
}