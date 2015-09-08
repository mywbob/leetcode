/*
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
*/


public class Solution {
    //1, bf
    //2, o(1), no idea
    //bf
    public int addDigits(int num) {
        if (num < 10) return num;
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                int bit = num % 10;
                num = num / 10;
                sum = sum + bit;
            } 
            num = sum;
        }
        return num;
    }
}