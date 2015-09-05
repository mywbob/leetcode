/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/
/*
I can use an extra point as init, assume dp[0] = 1, check if fullfil the condition, yes, so i can use dp[0] = 1
4 cases
for indexi i
if last two can be decoded, if last can be decoded
00: 0
01: dp(i-1)
10: dp(i-2)
11: dp(i-1) + dp(i-2)
*/


public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length()==0) return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] =1;
        
        if (s.charAt(0) == '0') dp[1] = 0;
        else dp[1] = 1;
        if (s.length() == 1) return dp[1];
        
        for (int i=2; i< dp.length; i++) {
            if (s.charAt(i-1)== '0' && ((Integer.parseInt(s.substring(i-2, i)) >= 0) && (Integer.parseInt(s.substring(i-2, i)) <=9)) || (Integer.parseInt(s.substring(i-2, i)) > 26) && s.charAt(i-1)== '0') {
                dp[i] = 0;
            } else if (Integer.parseInt(s.substring(i-2, i)) >= 0 && Integer.parseInt(s.substring(i-2, i)) < 10 && s.charAt(i-1) != '0' || Integer.parseInt(s.substring(i-2, i)) > 26 && s.charAt(i-1) != '0') {
                dp[i] = dp[i-1];
            } else if (s.charAt(i-1) == '0' && Integer.parseInt(s.substring(i-2, i)) <= 26 && Integer.parseInt(s.substring(i-2, i)) >= 10) {
                dp[i] = dp[i-2];
            } else {
                dp[i] = dp[i-2] + dp[i-1];
            }
        }
        
        return dp[dp.length-1];
        
    }
}