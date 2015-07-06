/*
Given an integer, write a function to determine if it is a power of two.
*/


public class Solution {
    //1: bit
    //2: 10, 100, 1000
    //3: turn off the right most 1 bit of n -> n*(n-1)
    public boolean isPowerOfTwo(int n) {
        return (n>0) && ((n & (n-1)) == 0);
    }
}