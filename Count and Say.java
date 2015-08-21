/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/





public class Solution {
    public String countAndSay(int n) {
        String res = "1";
        String temp;
        if (n == 1) return "1";
        for (int i=2; i<=n; i++) {
            temp = new String(res);
            res = "";
            int cnt = 0;
            char bit = temp.charAt(0);
            for (int j=0; j<temp.length(); j++) {
                if (bit == temp.charAt(j)) {
                    cnt++;
                    
                } else {
                    res = res + cnt + bit;
                    bit = temp.charAt(j);
                    cnt = 1;
                }
            }
            res = res + cnt + bit;
        }
        
        return res;
    }
}