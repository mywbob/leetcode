/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/



public class Solution {
    public int[] plusOne(int[] digits) {
        
        int carry = 1;
        for (int i=digits.length-1; i>=0; i--) {
            digits[i] = digits[i] + carry;
            
            carry = digits[i] / 10;
            digits[i] = digits[i] % 10;
            
        }
        
        if (carry == 0) return digits;
        else {
            int[] res = new int[digits.length+1];
            res[0] = 1;
            for (int i=1; i<res.length;i++) {
                res[i] = digits[i-1];
            }
            return res;
        }
    }
}