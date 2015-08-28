/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/


public class Solution {
	
	//bs return index. when s>e, s is the insert position. s belongs [0, len_array]
    public int searchInsert(int[] nums, int target) {
        return bs(0, nums.length-1, nums, target);
    }
    
    public int bs(int s, int e, int[] nums, int target) {
        if (s > e) return s;
        int mid = s + (e-s)/2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return bs(mid+1, e, nums, target);
        } else {
            return bs(s, mid-1, nums, target);
        }
    }

    
    public int searchInsert(int[] nums, int target) {
        int s = 0;
        int e = nums.length-1;
        while (s<=e) {
            int mid = s + (e-s)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        
        return s;
    }
	
	
	//old
	//bs return index. when s>e, s is the insert position. s belongs [0, len_array]
    public int searchInsert(int[] nums, int target) {
        return bs(0, nums.length-1, target, nums);
    }
    
    public int bs(int s, int e, int target, int[] nums) {
        int mid = (s + e) / 2;
        if (s > e) {//trick, not very clear, think all the cases, why s > e, do not mean s=e before!
            if (e < 0) return 0;
            if (s > nums.length) return nums.length;
            if (target > nums[e]) return s;
            if (target < nums[s]) return s;
        }
        if (target == nums[mid]) {
            return mid;
        } else if (target > nums[mid]) {
            return bs(mid+1, e, target, nums);
        } else {
            return bs(s, mid-1, target, nums);
        }
    }
}