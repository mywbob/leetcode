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
        if (n == 1) return "1";
        String res = "1";
        for (int i=1; i<n; i++) {
            //cnt and build
            int s = 0;
            int e = 0;
            
            String temp = "";
            while (e<res.length()) {
                int cnt=0;
                while (e<res.length() && res.charAt(s)== res.charAt(e)) {
                    cnt++;
                    e++;
                }
                temp = temp + cnt + res.charAt(s);
                s = e;
            }
            res = temp;
        }
        
        return res;
    }
}