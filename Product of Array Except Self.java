/*
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
*/

public class Solution {
    //1: no divide, get product before i and after i, then mul them, use 2n space
    //1.1: we can use var so only n space
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        //product before i
        int productBefore = 1;
        for (int i=0; i<res.length; i++) {
            res[i] = productBefore;
            productBefore = productBefore*nums[i];
        }
        
        //mul product after i
        int productAfter = 1;
        for (int i= res.length-1; i>=0; i--) {
            res[i] = res[i] * productAfter;
            productAfter = productAfter*nums[i];
        }
        

        
        return res;
        
    }
    
    /*
    //2: use division, cases: no 0, one 0, more than one 0
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int zero = 0;
        for (int i=0; i< nums.length; i++) {
            if (nums[i] == 0) zero++;
        }
        
        if (zero == 0) {
            int product = 1;
            for (int i=0; i< nums.length; i++) {
                product = product * nums[i];
            }
            for (int i=0; i< res.length; i++) {
                res[i] = product / nums[i];
            }
            
        } else if (zero == 1) {
            int product = 1;
            int index = 0;
            for (int i=0; i< res.length; i++) {
                if (nums[i] != 0) {
                    product = product * nums[i];
                } else {
                    index = i;
                }
            }
            res[index] = product;
        } else {
            return res;
        }
        

        
        return res;
        
    }
    */
}