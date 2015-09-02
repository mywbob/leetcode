/*
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
*/


public class Solution {
    //hashtable
    //xor all, can get x xor y, since x != y, there must be a bit==1 in x xor y. divide all number to two groups, x and y in diff group.
    //xor all number in a group, we can find x and y
    public int[] singleNumber(int[] nums) {
        int xxory = 0;
        for (int i=0; i< nums.length; i++) {
            xxory = xxory^nums[i];
        }
        
        //find a random bit where bit==1; for example, the right most bit where bit ==1
        int mask = 1;
        while ((xxory & mask) == 0) {
            mask = mask << 1;
        }
        
        //divide and find
        int x=0;
        int y=0;
        for (int i=0; i<nums.length; i++) {
            if ((nums[i] & mask) != 0) {
                x = x ^ nums[i];
            } else {
                y = y ^ nums[i];
            }
        }
        
        int[] res = new int[2];
        res[0] = x;
        res[1] = y;
        
        return res;
        
        
    }
}