/*
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
*/




/*
Symbol	Value
I	1
V	5
X	10
L	50
C	100
D	500
M	1,000
*/



public class Solution {
    public String intToRoman(int num) {
        String[] table = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] tableval = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String res = "";
        int index = 0;
        while (num > 0) {
            while (num >= tableval[index]) {
                res = res + table[index];
                num = num - tableval[index];
            }
            index++;
        }
        return res;
        
    }
}