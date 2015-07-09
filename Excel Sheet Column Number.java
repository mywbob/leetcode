/*


Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
*/

public class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        int mul = 1;
        for (int i= s.length()-1; i>=0; i--) {
            res = res + (s.charAt(i) - 'A' + 1) * mul;
            mul = mul * 26;
        }
        return res;
    }
}