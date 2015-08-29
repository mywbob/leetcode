/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

public class Solution {
	public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<List<Character>> res = new ArrayList<List<Character>>();
        for (int i=0; i<numRows; i++) {
            res.add(new ArrayList<Character>());
        }
        int index = 0;
        boolean plus = true;
        for (int i=0; i<s.length(); i++) {
            res.get(index).add(s.charAt(i));
            if (index== 0) {
                plus = true;
            }
            
            if (index == numRows-1) {
                plus = false;
            }
            
            if (plus) {
                index++;
            } else {
                index--;
            } 
        }
        
        String t = "";//stringbuilder is better
        for (List<Character> l : res) {
            for (char c : l) {
                t = t+c;
            }
        }
        return t;
    }
	
	
	
	
	
	
	
	//old
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;//care!
        ArrayList<ArrayList<Character>> table = new ArrayList<ArrayList<Character>>();
        for (int i=0; i<numRows; i++) {
            ArrayList<Character> temp = new ArrayList<Character>();
            table.add(temp);
        }
        int index = 0;
        int cnt = 0;
        boolean up = false;
        while (index < s.length()) {
            table.get(cnt).add(s.charAt(index));
            
            if (up) {
                cnt--;
                if (cnt==0) up = !up;
            } else {
                cnt++;
                if (cnt == numRows-1) up = !up;
            }

            index++;
        }
        String res = "";
        for (ArrayList<Character> a : table) {
            for (Character c: a) {
                res = res+c;
            }
        }
        return res;
    }
}