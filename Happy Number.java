/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
*/


public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(n);
        int newnum;
        newnum = bitsqrproduction(n);
        while (newnum != 1) {
            if (set.contains(newnum)) return false;
            set.add(newnum);
            newnum = bitsqrproduction(newnum);
        }
        return true;
    }
    
    public int bitsqrproduction(int n) {
        int num = 0;
        int bit;
        while (n > 9) {
            bit = n % 10;
            num = num + bit * bit;
            n = n / 10;
        }
        num = num + n*n;
        return num;
    }
}