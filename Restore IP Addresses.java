/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/


public class Solution {
    List<String> res = new ArrayList<String>();
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return res;
        dfs(0, "", s);
        return res;
    }
    
    public void dfs(int cnt, String temp, String s) {
        if (cnt == 4 && s.length() == 0) {
            res.add(temp.substring(0, temp.length()-1));//remove last "."
            return;
        }
        
        if (cnt > 4) return;
        
        for (int i=0; i<=s.length(); i++) {
            String ss = s.substring(0,i);
            if (ss.length()>1 && ss.charAt(0)=='0') continue;
            if (ss.length() > 0 && Long.parseLong(ss) >=0 && Long.parseLong(ss) <= 255) {
                //temp = temp + ss + '.';
                dfs(cnt+1, temp + ss + '.', s.substring(i, s.length()));
            }
        }
    }
}