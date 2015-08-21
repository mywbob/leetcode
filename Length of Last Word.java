/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
*/


public class Solution {
    //when last word does not exist? all white..
    public int lengthOfLastWord(String s) {
        String[] arr = s.split("\\s+");
        int res=0;
        for (int i=0; i< arr.length; i++) {
            if (arr[i].length() != 0) res = arr[i].length();
        }
        return res;
    }
}