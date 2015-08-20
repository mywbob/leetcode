/*
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/



public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() ==0) return 0;
        HashSet<Character> set = new HashSet<Character>();
        int index=0;
        int max=1;
        String longest = s.substring(0,1);
        set.add(s.charAt(0));
        for (int i=1; i< s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                //move index
                while (index < i) {
                    if (s.charAt(index) != s.charAt(i)) {
                        set.remove(s.charAt(index));
                        index++;
                    } else {
                        index++;
                        break;
                    }
                }
            } else {
                set.add(s.charAt(i));
            }

            longest = s.substring(index, i+1);
            if (max < longest.length()) max = longest.length();
            
            
        }
        return max;
    }
}