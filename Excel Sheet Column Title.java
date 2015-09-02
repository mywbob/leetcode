/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
*/

public class Solution {
	
    public String convertToTitle(int n) {
        int bit;
        StringBuilder sb = new StringBuilder();
        while(n != 0) {
            bit = (n - 1) % 26;
            sb.insert(0, (char)('A' + bit));
            n = (n - 1) / 26;
        }
        return sb.toString();
    }
}