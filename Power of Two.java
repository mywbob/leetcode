/*
Given an integer, write a function to determine if it is a power of two.
*/


public class Solution {
	
	//1:use mask, 1, 10, 100, check mask ^ n == 0  in a loop
    //2:clear rightmore bit
    //overflow, or use n > 0
    public boolean isPowerOfTwo(int n) {
        if (n==0) return false;
        long t = n;
        return (t & (t-1)) == 0;
    }
	
	//old
    //1: bit operation
    //2: power of 2 numbers: 10, 100, 1000
    //3: turn off the right most 1 bit of n -> n & (n-1)
    public boolean isPowerOfTwo(int n) {
        return (n>0) && ((n & (n-1)) == 0);
    }
	
}
