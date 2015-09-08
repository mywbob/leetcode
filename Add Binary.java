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
	
	
	
	public String addBinary(String a, String b) {
        if (a.length() == 0) return b;
        if (b.length() == 0) return a;
        if (a.length() < b.length()) {
            String t = a;
            a = b;
            b = t;
        }
        String res ="";
        int carry = 0;
        int indexa = a.length() -1;
        int indexb = b.length() -1;
        while (indexb >=0) {
            int bit = ((int)(b.charAt(indexb) - '0') + (int)(a.charAt(indexa) - '0') + carry) % 2;
            carry = ((int)(b.charAt(indexb) - '0') + (int)(a.charAt(indexa) - '0') + carry) / 2;
            res = bit + res;
            indexa--;
            indexb--;
        }
        
        if (carry == 0) {
            return a.substring(0, indexa+1) + res;
        } else {
            while (indexa >=0) {
                int bit = ((int)(a.charAt(indexa) - '0') + carry) % 2;
                carry = ((int)(a.charAt(indexa) - '0') + carry) / 2;
                res = bit + res;
                indexa--;
            }
            
            if (carry == 0) return res;
            else return "1" + res;
        }
        
    }
}