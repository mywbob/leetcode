/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/




public class Solution {
    public int search(int[] nums, int target) {
        return bs(0, nums.length-1, nums, target);
    }
    
    public int bs(int s, int e, int[] nums, int target) {
        if (s>e) return -1;
        int mid = (s+e)/2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] >= nums[s]) {//left sorted
            if (nums[s] <= target && nums[mid] >= target) {//in left
                return bs(s, mid-1, nums, target);
            } else {//in right
                return bs(mid+1, e, nums, target);
            }
        } else {//right sorted
            if (nums[mid] <= target && nums[e] >= target) {//in right
                return bs(mid+1, e, nums, target);
            } else {//in left
                return bs(s, mid-1, nums, target);
            }
        }
    }
}