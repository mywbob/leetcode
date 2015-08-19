/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/


public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        dfs(0,0, n, "",res);
        return res;
    }
    
    public void dfs(int l, int r, int n, String s, List<String> res) {
        if (r == n) {
            res.add(new String(s));
            return;
        }
        
        if (l<n) {
            s = s + "(";
            dfs(l+1, r, n, s, res);
            s = s.substring(0, s.length()-1);
        }
        
        if (r<l) {
            s = s+ ")";
            dfs(l, r+1, n, s, res);
            s = s.substring(0, s.length()-1);
        }
    }
}