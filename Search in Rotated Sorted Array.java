/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/




public class Solution {
    public int search(int[] nums, int target) {
        return bs(0, nums.length-1, target, nums);
    }
    
    public int bs(int s, int e, int target, int[] nums) {
        int mid = (s + e)/2;
        if (s > e) return -1;//do not forget
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] >= nums[s]) {//left in order
            if (target < nums[mid] && target >= nums[s]) {
                return bs(s, mid-1, target, nums);
            } else {
                return bs(mid+1, e, target, nums);
            }
        } else {//right in order
            if (target > nums[mid] && target <= nums[e]) {
                return bs(mid+1, e, target, nums);
            } else {
                return bs(s, mid-1, target, nums);
            }
        }
    }
}