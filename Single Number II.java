/*
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/



public class Solution {
    //1: hashtable
    //2: count each bit and mod 3, the resulting bit is the bit of the single number, but hard to implement without extra space 
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();
        for (int i=0; i< nums.length; i++) {
            if (table.containsKey(nums[i])) {
                table.put(nums[i], table.get(nums[i])+1);
            } else {
                table.put(nums[i], 1);
            }
        }
        
        for (int n : table.keySet()) {
            if (table.get(n) == 1) return n;
        }
        
        return -1;
    }
}