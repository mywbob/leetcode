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
    //sort string arr, or sort the list
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        List<List<String>> res = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) return res;
        Arrays.sort(strs);//important
        for (int i=0; i<strs.length; i++) {
            char[] chararr = strs[i].toCharArray();
            Arrays.sort(chararr);
            String ss = new String(chararr);
            if (map.containsKey(ss)) {
                List<String> temp = map.get(ss);
                temp.add(strs[i]);
                map.put(ss, temp);
            } else {
                List<String> temp = new ArrayList<String>();
                temp.add(strs[i]);
                map.put(ss, temp);
            }
        }
        
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        
        return res;
    }
}