/*
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.
*/

public class Solution {
    //char array to string
    //1 new String(charry)
    //2 String.valueOf(charry)
    public List<String> anagrams(String[] strs) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        List<String> res = new ArrayList<String>();
        for (int i=0; i< strs.length; i++) {
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String sorted = String.valueOf(temp);
            if (!map.containsKey(sorted)) map.put(sorted, 1);
            else {map.put(sorted, map.get(sorted) + 1);}
        }
        for (int i=0; i< strs.length; i++) {
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String sorted = String.valueOf(temp);
            if (map.get(sorted) > 1) res.add(strs[i]);
                
        }
        return res;
    }
}