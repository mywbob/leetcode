//1 recur, why slow? how to recur and cache
//2 dp
public class Solution {
	//check http://www.geeksforgeeks.org/dynamic-programming-set-32-word-break-problem/, check how the subproblem overlaps
	//recur and cache
    HashMap<String, Boolean> map = new HashMap<String, Boolean>();
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (wordDict.contains(s)) return true; 
        for (int i=0; i<s.length(); i++) {
            String first = s.substring(0,i);
            String second = s.substring(i,s.length());
            if (wordDict.contains(first)) {
                if (map.containsKey(second)) {
                    if (map.get(second)) return true;
                } else {
                    map.put(second, wordBreak(second, wordDict));
                    if (map.get(second)) return true;
                }
            }
        }
        return false;
    }

	//my bottom up dp
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        if (wordDict.contains(s.substring(0,1))) dp[0] = true;
        for (int i=1; i<s.length(); i++) {
            if (wordDict.contains(s.substring(0,i+1))) {
                dp[i] = true;
                continue;
            }
            for (int j = i-1; j>= 0; j--) {
                if (dp[j] && wordDict.contains(s.substring(j+1, i+1))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()-1];
        
        
    }
	
	
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