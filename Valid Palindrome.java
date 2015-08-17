/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/




public class Solution {
    public boolean isPalindrome(String s) {
        //null
        if (s == null) return true;
        //empty
        if (s.equals("")) return true;
        
        int start = 0;
        int end = s.length() - 1;
        
        while (start < end) {
            while (start < s.length() && !isAlphanumeric(s.charAt(start))) {
                start++;
            }
            
            while (end >= 0 && !isAlphanumeric(s.charAt(end))) {
                end--;
            }
            
            if (start > end) return true;
            if (!(s.charAt(start) - s.charAt(end) == 0 || Math.abs(s.charAt(start) - s.charAt(end)) == Math.abs('a' - 'A'))) return false;
            start++;
            end--;
        }
        
        return true;
    }
    
    public boolean isAlphanumeric(char c) {
        if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9') return true;
        return false;
    }
}