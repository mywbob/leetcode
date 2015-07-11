/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        st.push('t');//temp value
        
        for (int i = 0; i< s.length() ; i++) {
            if (!(st.peek() == '(' && s.charAt(i) == ')' || st.peek() == '[' && s.charAt(i) == ']' || st.peek() == '{' && s.charAt(i) == '}')) st.push(s.charAt(i));
            else st.pop();
        }
        
        return st.peek() == 't';
        
    }
}