/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
*/


public class Solution {
    List<List<String>> res = new ArrayList<List<String>>();
    List<String> ares = new ArrayList<String>();
    public List<List<String>> partition(String s) {
        if (s==null || s.length()==0) return res;
        dfs(s);
        return res;
    }
    
    public void dfs( String s) {
        if (s.length() == 0) {//find
            res.add(new ArrayList<String>(ares));
            return;
        }
        
        for (int i=0; i<=s.length(); i++) {
            String temp = s.substring(0, i);
            String rest = s.substring(i, s.length());
            if (isPal(temp)) {
                ares.add(temp);
                dfs(rest);
                ares.remove(ares.size()-1);
            }
        }
    }
    
    public boolean isPal(String str) {
        if (str == null || str.length() == 0) return false;
        int s=0;
        int e=str.length()-1;
        while (s<=e) {
            if (str.charAt(s) != str.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}