/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
*/


public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return 0;
        int max = nums[0];
        int start = 0;
        int end = max;
        int cnt = 1;
        if (nums[0] >= nums.length-1) return 1;
        
        while (start <= end) {
            
            for (int i=start; i<=end; i++) {
                max = Math.max(max, nums[i] + i);
                if (max >= nums.length - 1) {
                    return ++cnt;
                }
                
            }
            
            start = end+1;
            end = max;
            cnt++;
        }
        

        
        return -1;
        
    }
}