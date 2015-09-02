/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
*/


public class Solution {
    //3 cases, bath sides in order, left in order, right in order
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return bs(0, nums.length-1, nums);
    }
    
    public int bs(int s, int e, int[] nums) {
        //must be a res, so no s> e
        int mid = (s+e)/2;
        
        if (nums[mid] >= nums[s] && nums[mid] <= nums[e] || (mid+1) < nums.length && nums[mid] >= nums[s] && nums[mid+1] <= nums[e] || (mid -1) >= 0 && nums[mid] <= nums[e] && nums[mid-1] >= nums[s]) {//both in order(tricky, 3,1,2 case), return min
            if (nums[mid] >= nums[s] && nums[mid] <= nums[e]) return nums[s];
            else if ((mid+1) < nums.length && nums[mid] >= nums[s] && nums[mid+1] <= nums[e]) return nums[mid+1];
            else return nums[mid];
        } else if (nums[mid] >= nums[s]) {//left in order
            return bs(mid+1, e, nums);
        } else {//right in order
            return bs(s, mid-1, nums);
        }
		
    }
}