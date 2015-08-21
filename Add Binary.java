/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/


public class Solution {
    public String addBinary(String a, String b) {
        if (a != null && b== null) return a;
        if (a== null && b!=null) return b;
        if (a==null && b== null) return null;
        if (a.length() < b.length()) {
            String temp;
            temp = a;
            a = b;
            b = temp;
        }
        
        String res = "";
        int carry = 0;
        int indexa = a.length()-1;
        int indexb = b.length()-1;
        while (indexa >= 0) {
            int temp;
            if (indexb<0) temp = 0;
            else temp = b.charAt(indexb) - '0';
            int bit = (a.charAt(indexa) - '0' + temp + carry) % 2;
            carry = (a.charAt(indexa) - '0' + temp + carry) / 2;
            res = bit + res;
            
            indexa--;
            indexb--;
            
        }
        
        //rest
        if (carry == 1) res = "1" + res;
        
        return res;
        
    }
}