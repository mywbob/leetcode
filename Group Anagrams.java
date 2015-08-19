/*
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
For the return value, each inner list's elements must follow the lexicographic order.
All inputs will be in lower-case.
*/



public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Arrays.sort(strs);
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (int i=0; i<strs.length; i++) {
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);
            
            if (map.containsKey(key))  {
                ArrayList<String> t = map.get(key);
                t.add(strs[i]);
                map.put(key, t);
            } else {
                ArrayList<String> n = new ArrayList<String>();
                n.add(strs[i]);
                map.put(key, n);
            }
        }
        
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        
        
        return res;
    }
}