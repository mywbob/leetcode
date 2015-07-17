/*
/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/


public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1) return true;
        int max = nums[0];
        int index = max;
        for (int i=1; i< nums.length;) {
            for (int j = i; j<= max; j++) {
                max = Math.max(max, j+nums[j]);
                if (max >= nums.length - 1) return true;
            }
            
            if (index == max) return false;//cannot find new max
            i = index + 1;
            index = max;
        }
        return false;
    }
}
*/

public class Solution {
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) return false;
        if (A.length == 1) return true;
        int max = A[0];

        for (int j = 0; j <= max; j++) {//we can update the end condition in for loop
                
            if (j + A[j] >= A.length - 1) {
                return true;
            }
            max = Math.max(max, A[j] + j);
                
        }

        
        return false;
        
    }
}