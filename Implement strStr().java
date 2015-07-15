/*
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/


public class Solution {
    //1:bf
    //2:kmp, but i dont know
    public int strStr(String haystack, String needle) {
        if (haystack == null) return -1;
        if (needle == null || needle.length() == 0) return 0;
        if (haystack.length() < needle.length()) return -1;
        
        int index = 0;
        for (int i=0; i<= haystack.length() - needle.length(); i++) {
            for (int j = 0; j< needle.length(); j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) break;
                if (j == needle.length() - 1) return i;
            }
        }
        return -1;
    }
}