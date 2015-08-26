/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/


public class Solution {
	//find all, use set. how to use set for list
    //find and skip dup
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        for (int i=0; i<nums.length-2; ) {
            int start = i+1;
            int end=nums.length-1;
            while (start < end) {
                temp.clear();
                if (nums[i] + nums[start] + nums[end] == 0) {
                    temp.add(nums[i]);
                    temp.add(nums[start]);
                    temp.add(nums[end]);
                    res.add(new ArrayList<Integer>(temp));
                    
                    //move start and end, skip dup
                    int ss = start+1;
                    while (ss < nums.length && nums[ss] == nums[start]) {
                        ss++;
                    }
                    start = ss;
                    
                    int ee = end-1;
                    while (ee >= 0 && nums[ee] == nums[end]) {
                        ee--;
                    }
                    end = ee;

                } else if (nums[i] + nums[start] + nums[end] < 0) {
                    start++;
                } else {
                    end--;
                }
            }
            //skip i if dup
            int ii = i + 1;
            while (ii < nums.length && nums[ii] == nums[i]) {
                ii++;
            }
            i = ii;
        }
        
        return res;
    }
}