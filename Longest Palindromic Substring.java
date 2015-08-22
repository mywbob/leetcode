/*
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/


public class Solution {
    //1: bf, o(n3)
    //2: two way check, o(n2)
    public String longestPalindrome(String s) {
        String max = "";
        for (int i=0; i<s.length(); i++) {
            
            String temp = twoWay(i,i,s);
            String temp1 = twoWay(i,i+1,s);
            
            int templen = temp.length();
            int temp1len = temp1.length();
            String t = "";
            if (templen >= temp1len) t = temp;
            else t = temp1;
            
            if (max.length() < t.length()) max = t;
        }
        return max;
    }
    
    public String twoWay(int l, int r, String s) {
        while (l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        if (l == r-1) return "";
        return s.substring(l+1,r);
    }
}