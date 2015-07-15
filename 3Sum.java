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
    /*
    main idea, two pointers, move the pointers to reduce the dup
    sort the array first so the result in non descending order. 
    */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2; ) {
            int start = i+1;
            int end = nums.length-1;
            while (start < end) {
                if (nums[i] + nums[start] + nums[end] == 0) {
                    //add res
                    List<Integer> alist = new ArrayList<Integer>();
                    alist.add(nums[i]);
                    alist.add(nums[start]);
                    alist.add(nums[end]);
                    res.add(alist);
                    while (start+1 < nums.length && nums[start+1] == nums[start]) {
                        start++;
                    }
                    
                    while (end-1 > i && nums[end-1] == nums[end]) {
                        end--;
                    }
                    start++;
                    end--;
                } else if (nums[i] + nums[start] + nums[end] < 0) {
                    start++;
                } else {
                    end--;
                }
            }
            //skip i
            while (i + 1 < nums.length-2  && nums[i+1] == nums[i]) i++; 
            i++;
            
        }
        return res;
    }
}