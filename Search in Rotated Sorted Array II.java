/*
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
*/



public class Solution {
    //trick condition, A[mid] == A[left], cannot tell which part is sorted
    public boolean search(int[] nums, int target) {
        return bs(0, nums.length-1, target, nums);
    }
    
    public boolean bs(int s, int e, int target, int[] nums) {
        int mid = (s + e)/2;
        if (s > e) return false;
        if (nums[mid] == target) return true;
        else if (nums[mid] > nums[s]) {// left sorted
            if (target < nums[mid] && target >= nums[s]) {
                return bs(s, mid-1, target, nums);
            } else {
                return bs(mid+1, e, target, nums);
            }
        } else if (nums[mid] < nums[s]) {// right sorted
            if (target > nums[mid] && target <= nums[e]) {
                return bs(mid+1, e, target, nums);
            } else {
                return bs(s, mid-1, target, nums);
            }
        } else {//cannot tell, sort both parts
            return bs(s, mid-1, target, nums) || bs(mid+1, e, target, nums);
        }
    }
}