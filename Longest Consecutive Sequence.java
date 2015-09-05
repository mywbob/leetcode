/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/


public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int max=0;
        int cur=0;
        for (int i : nums) {
            set.add(i);
        }
        
        for (int i=0; i< nums.length; i++) {
            if (set.contains(nums[i])) {
                cur = 0;
                int forward = nums[i]+1;
                int backward = nums[i]-1;
                cur++;
                //forward
                while (set.contains(forward)) {
                    cur++;
                    set.remove(forward);
                    forward++;
                }
                    
                //backward
                while (set.contains(backward)) {
                    cur++;
                    set.remove(backward);
                    backward--;
                }
                    
                max = Math.max(max, cur);
            } 
        }
        
        return max;
    }
}