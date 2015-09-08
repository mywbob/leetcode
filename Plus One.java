/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/



public class Solution {
    public int[] plusOne(int[] digits) {
        int[] res = new int[digits.length+1];
        int index = digits.length-1;
        int carry = 1;
        while (index>=0) {
            int bit = (digits[index] + carry) % 10;
            carry = (digits[index] + carry) / 10;
            res[index+1] = bit;
            index--;
        }
        
        if (carry == 0) return Arrays.copyOfRange(res, 1, res.length);
        else {
            res[0] = 1;
            return res;
        }
    }
}