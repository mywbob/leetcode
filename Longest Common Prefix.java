/*
Write a function to find the longest common prefix string amongst an array of strings.
*/



public class Solution {
	public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        for (int e = 0; e<strs[0].length(); e++) {
            for (int i=0; i<strs.length;i++) {
                if (e<strs[i].length() && strs[0].charAt(e) != strs[i].charAt(e) || e>=strs[i].length()) {
                    return strs[0].substring(0,e);
                }
            }
        }
        
        return strs[0];
    }
}