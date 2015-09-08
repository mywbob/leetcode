/*
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/


public class Solution {
    //1: bf, o(n3)
    //2: two way check, o(n2)
    public String longestPalindrome(String s) {
        String max = "";
        for (int i=0; i<s.length(); i++) {
            String strOnNum = twoWayExt(i,i, s);
            String strOnInter = twoWayExt(i, i+1,s);
            //update
            if (strOnNum.length() > strOnInter.length()) {
                if (strOnNum.length() > max.length()) max = strOnNum;
            } else {
                if (strOnInter.length() > max.length()) max = strOnInter;
            }   
        }
        
        return max;
    }
    
    public String twoWayExt(int i, int j, String s) {
        while (i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i+1, j);
    }
}