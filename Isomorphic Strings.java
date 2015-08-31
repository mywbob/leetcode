/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.
*/


public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length()==0 && t.length()==0) return true;
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for (int i=0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) return false;
            } else {
                for (Character c: map.keySet()) {
                    char value = map.get(c);
                    if (t.charAt(i) == value) {//has been matched
                        return false;
                    }
                }
                map.put(s.charAt(i), t.charAt(i));//has not been matched
                //containsValue method
                /*
                if(map.containsValue(t.charAt(i))) return false;
                else map.put(s.charAt(i), t.charAt(i));
                */
            }
        }
        
        return true;
    }
}