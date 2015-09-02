/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/



public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if (nums == null || nums.length == 0) return res;
        int left = bsL(0, nums.length-1, target, nums);
        int right = bsR(0, nums.length-1, target, nums);
        res[0] = left;
        res[1] = right;
        return res;
    }
    
    public int bsL(int s, int e, int target, int[] nums) {
        if (s > e) return -1;
        int mid = (s + e) / 2;
        if (nums[mid] == target) {
            if (mid == 0) return mid;
            if (nums[mid - 1] != target) return mid;
            else return bsL(s, mid-1, target, nums);
        } else if (nums[mid] < target) {
            return bsL(mid+1, e, target, nums);
        } else {
            return bsL(s, mid-1, target, nums);
        }
    }
    
    public int bsR(int s, int e, int target, int[] nums) {
        if (s > e) return -1;
        int mid = (s + e) / 2;
        if (nums[mid] == target) {
            if (mid == nums.length-1) return mid;
            if (nums[mid + 1] != target) return mid;
            else return bsR(mid + 1, e, target, nums);
        } else if (nums[mid] < target) {
            return bsR(mid+1, e, target, nums);
        } else {
            return bsR(s, mid-1, target, nums);
        }
    }
}