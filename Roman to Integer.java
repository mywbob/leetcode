/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
*/


/*
Symbol	Value
I	1
V	5
X	10
L	50
C	100
D	500
M	1,000
*/


public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        int res = map.get(s.charAt(s.length()-1));
        for (int i=s.length()-1; i > 0; i--) {
            if (map.get(s.charAt(i)) > map.get(s.charAt(i-1))) {
                res = res - map.get(s.charAt(i-1));
            } else {
                res = res + map.get(s.charAt(i-1));
            }
        }
        
        return res;
        
    }
}