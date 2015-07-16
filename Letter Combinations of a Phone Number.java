/*
Given a digit string, return all possible letter combinations that the number could represent.
*/


public class Solution {
    List<String> res = new ArrayList<String>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return res;
        String[] table = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs(digits, "", 0, table);
        return res;
    }
    
    public void dfs(String digits, String temp, int index, String[] table) {
        if (temp.length() == digits.length()) {
            res.add(temp);
            return;
        }
        for (int i=0; i<table[digits.charAt(index) - '0'].length(); i++) {
            temp = temp + table[digits.charAt(index) - '0'].charAt(i);
            dfs(digits, temp, index+1, table);
            temp = temp.substring(0, temp.length() - 1);
        }
    }
}