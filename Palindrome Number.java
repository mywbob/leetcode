/*
Determine whether an integer is a palindrome. Do this without extra space.
*/

public class Solution {
    //1 convert it to string, compare start and end
    //2 reverse integer
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        int start = 0;
        int end = s.length() - 1;
        while(start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}