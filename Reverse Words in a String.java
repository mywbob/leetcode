/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.
*/

/*
how split() works?
s+ and s diff

remeber a b split by space = "a", "b"
so " a" split by space = "", "a"
termite at the deli or end of the string = > substring(somewhere, deli or end(not including)), then start from deli+1...
*/


public class Solution {
	public String reverseWords(String s) {
        String[] sarr = s.split("\\s+");
        String res = "";
        for (int i=sarr.length-1; i>=0; i--) {
            res = res + " " + sarr[i];
        }
        
        return res.trim();
    }
	
	//old
    public String reverseWords(String s) {
        String[] strs = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i=strs.length-1; i>= 0; i--) {
            sb.append(strs[i]);
            sb.append(" ");
        }
        
        return sb.toString().trim();
    }
}