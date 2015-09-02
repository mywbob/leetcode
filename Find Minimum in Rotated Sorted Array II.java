/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
*/
public class Solution {
    //if both side in order, only left sorted(in right), only right sorted(in left)
    //how to tell if sorted
    public int findMin(int[] nums) {
        return bs(0, nums.length-1, nums);
    }
    
    public int bs(int s, int e, int[] nums) {
        int mid = (s+e)/2;
        if (nums[mid]== nums[s] && nums[mid] == nums[e]) {//cannot tell
            int min=Integer.MAX_VALUE;
            for (int i=s; i<=e;i++) {
                min = Math.min(min, nums[i]);
            }
            return min;
        } else {
            if (nums[mid] >= nums[s] && nums[mid] <= nums[e] || (mid+1) < nums.length && nums[mid] >= nums[s] && nums[mid+1] <= nums[e] || (mid -1) >= 0 && nums[mid] <= nums[e] && nums[mid-1] >= nums[s]) {//both sorted, 
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
}