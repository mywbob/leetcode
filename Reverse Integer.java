/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
*/


public class Solution {
    //sign
    //overflow
    public int reverse(int x) {
        long newnum = 0;
        int bit = 0;
        boolean isNeg = false;
        if (x < 0) {x = -x; isNeg = true;}
        while (x > 0) {
            bit = x % 10;
            newnum = 10 * newnum + bit;
            x = x / 10;
        }
        if (isNeg) {
            if (-newnum < Integer.MIN_VALUE) return 0;
            else return (int)(-newnum);
        } else {
            if (newnum > Integer.MAX_VALUE) return 0;
            else return (int)newnum;
        }
    }
}