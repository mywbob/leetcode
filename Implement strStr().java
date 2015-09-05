/*
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/


public class Solution {
    //1:bf
    //2:kmp, but i dont know
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) return -1;
        if (needle.length() == 0) return 0;
        for (int i=0; i<= haystack.length() - needle.length(); i++) {
            if (needle.charAt(0) == haystack.charAt(i)) {
                int j = 0;
                for (j=0; j<needle.length();j++) {
                    if (needle.charAt(j) != haystack.charAt(i+j)) break;
                }
                if (j == needle.length()) return i;
            }
        }
        
        return -1;
    }
}