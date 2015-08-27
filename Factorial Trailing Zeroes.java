/*
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
*/

public class Solution {
	public int trailingZeroes(int n) {
        int res = 0;
        while (n != 0) {
            int numofnumwith5 = n/5;
            res = res + numofnumwith5;
            n = n / 5;
        }
        return res;
    }
	
	//old
    //o(logn), pairs of factors of 2 and 5 in the prime factorization of n! generate trailing zeros, find how many 5s
    public int trailingZeroes(int n) {
        int rs = 0;
        while (n != 0) {
            rs += (n / 5);
            n /= 5;
        }
        return rs;
    }
	
}