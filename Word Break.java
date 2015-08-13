//1 recur, why slow? how to recur and cache
//2 dp
public class Solution {
    //tle
    /*
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (wordDict.contains(s)) return true;
        
        for (int i=0; i< s.length(); i++) {
            String front = s.substring(0, i);
            String tail = s.substring(i, s.length());
            if (wordDict.contains(front)) {
                if (wordBreak(tail, wordDict)) return true;
                else continue;
            }
        }
        
        return false;
    }
    */
    
    //dp
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) return false;
        int n = s.length();

        // dp[i] represents whether s[0...i] can be formed by dict
        boolean[] dp = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                String sub = s.substring(j, i + 1);
                if (dict.contains(sub) && (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n - 1];
    }
}