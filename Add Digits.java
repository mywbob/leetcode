/*
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
*/


public class Solution {
    //1, bf
    //2, o(1), no idea
    public int addDigits(int num) {
        int newres = 0;
        while (true) {
            if (num >=0 && num <= 9) break;
            while (num != 0) {
                int bit = num % 10;
                newres = newres + bit;
                num = num / 10;
            }
            num = newres;
            newres = 0;
            
        }
        
        return num;
        
    }
}